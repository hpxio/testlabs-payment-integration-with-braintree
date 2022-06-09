package com.app.hpx.testlabs.integrator.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.hpx.testlabs.integrator.client.config.BraintreeGatewayConfig;
import com.braintreegateway.Customer;
import com.braintreegateway.CustomerRequest;
import com.braintreegateway.PaymentMethod;
import com.braintreegateway.PaymentMethodRequest;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;

@Deprecated
@Controller
@RequestMapping("/app/braintree/instrument/v1")
public class GenerateNonceController {

    private static final Logger LOG = LoggerFactory.getLogger(GenerateNonceController.class);

    private final BraintreeGatewayConfig braintreeGatewayConfig;

    @Autowired
    public GenerateNonceController(BraintreeGatewayConfig braintreeGatewayConfig) {
        this.braintreeGatewayConfig = braintreeGatewayConfig;
    }

    @GetMapping(value = "/init")
    public String checkout(Model model) {
        String clientToken = braintreeGatewayConfig.getBraintreeGatewayInstance().clientToken().generate();

        LOG.debug("Client Token : {}", clientToken);

        model.addAttribute("clientToken", clientToken);
        return "checkouts/new";
    }

    @ResponseBody
    @PostMapping(value = "/checkouts")
    public String postForm(
        @RequestParam("amount") String amount,
        @RequestParam("payment_method_nonce") String nonce
    ) {
        try {
            BigDecimal decimalAmount = new BigDecimal(amount);

            /* Receive nonce & amount from BTS-DropIn-UI */
            LOG.info("Payment Nonce : {}", nonce);
            LOG.info("\nPayment Amount : ${}", amount);

            /* Create new customer entity in BTS Vault */
            CustomerRequest customerRequest = new CustomerRequest().firstName("Yin").lastName("Juan");

            /* Call customer.create() and receive BT customer-id */
            Result<Customer> customerResult =
                braintreeGatewayConfig.getBraintreeGatewayInstance().customer().create(customerRequest);

            String customerId;
            if (customerResult.isSuccess()) {
                customerId = customerResult.getTarget().getId();
                LOG.info("Customer ID : {}", customerId);
            } else {
                LOG.error(customerResult.getErrors().toString());
                throw new RuntimeException("Failed to create Customer!");
            }

            /* Create permanent payment token from payment-nonce
             * this will help in stored-card billing or pay-later trx */
            PaymentMethodRequest paymentMethodRequest =
                new PaymentMethodRequest().customerId(customerId).paymentMethodNonce(nonce).options().makeDefault(true)
                    .done();

            /* Call payment.create()
             * Notice that we only added the instrument.
             * Actual transaction is still not registered.*/
            Result<? extends PaymentMethod> paymentMethodResult =
                braintreeGatewayConfig.getBraintreeGatewayInstance().paymentMethod().create(paymentMethodRequest);

            /* Fetch permanent payment token - direct transactable entity */
            String permanentPaymentToken = paymentMethodResult.getTarget().getToken();
            LOG.info("Payment Token : {}", permanentPaymentToken);

            /* Register a payment and fetch the transaction status */
            TransactionRequest transactionRequest =
                new TransactionRequest().amount(decimalAmount).paymentMethodToken(permanentPaymentToken);

            /* we will just authorize the transaction
            and submit for settlement later */
            Result<Transaction> salesResult =
                braintreeGatewayConfig.getBraintreeGatewayInstance().transaction().sale(transactionRequest);

            String id = salesResult.getTransaction().getId();
            braintreeGatewayConfig.getBraintreeGatewayInstance().transaction().refund(id);

            /*String orderId = salesResult.getTarget().getOrderId();*/


            if (salesResult.isSuccess()) {
                LOG.info("Sales successful : {}-{}",
                    salesResult.getTarget().getProcessorAuthorizationCode(),
                    salesResult.getTarget().getProcessorResponseCode());
                LOG.info("Sales Status : {}", salesResult.getTarget().getStatus());
            } else {
                LOG.error("Sales failed : {}", salesResult.getErrors().toString());
                throw new RuntimeException(
                    "Sales failed due to : " + salesResult.getTarget().getProcessorResponseCode());
            }

            /* Submit the sales-transaction for settlement */
            String transactionId = salesResult.getTarget().getId();
            Result<Transaction> submitForSettlementResult =
                braintreeGatewayConfig.getBraintreeGatewayInstance().transaction().submitForSettlement(transactionId);

            if (submitForSettlementResult.isSuccess()) {
                LOG.info("Submitted for Settlement : {}", submitForSettlementResult.getMessage());
                LOG.info("Sales Status : {}", submitForSettlementResult.getTarget().getStatus());

            } else {
                LOG.error("Submit for Settlement Failed : {}", submitForSettlementResult.getErrors().toString());
                throw new RuntimeException("Submit for settlement failed!");
            }

            return "success";
        } catch (NumberFormatException e) {
            LOG.error("Exception occurred while reading Nonce : {}", e.getMessage());
        }
        return "";
    }
}
