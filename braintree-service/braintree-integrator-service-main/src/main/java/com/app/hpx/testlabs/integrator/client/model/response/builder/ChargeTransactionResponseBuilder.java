package com.app.hpx.testlabs.integrator.client.model.response.builder;

import org.springframework.stereotype.Component;

import com.braintreegateway.Transaction;

import com.app.hpx.testlabs.integrator.model.response.ChargeResponseDTO;
import com.app.hpx.testlabs.integrator.model.response.TransactionAuthorizationDetails;

@Component
public class ChargeTransactionResponseBuilder
    implements BraintreeServiceResponseBuilder<Transaction, ChargeResponseDTO> {

    @Override
    public ChargeResponseDTO build(Transaction request) {

        ChargeResponseDTO chargeResponseDTO = new ChargeResponseDTO();
        TransactionAuthorizationDetails authorizationDetails = new TransactionAuthorizationDetails();

        authorizationDetails.setTransactionId(request.getId());
        authorizationDetails.setOrderId(request.getOrderId());

        /* set n/w & processor response codes for future references */
        authorizationDetails.setNetworkTransactionId(request.getNetworkTransactionId());
        authorizationDetails.setProcessorResponseCode(request.getProcessorResponseCode());
        authorizationDetails.setProcessorResponseText(request.getProcessorResponseText());
        authorizationDetails.setPaymentInstrumentType(request.getPaymentInstrumentType());
        authorizationDetails.setAuthorizedTransactionId(request.getAuthorizedTransactionId());

        /* set transaction status */
        authorizationDetails.setTransactionStatus(request.getStatus().name());

        /* set timestamps for transaction */
        authorizationDetails.setCreatedTimestamp(String.valueOf(request.getCreatedAt().getTimeInMillis()));
        authorizationDetails.setUpdatedTimestamp(String.valueOf(request.getUpdatedAt().getTimeInMillis()));

        chargeResponseDTO.setTransactionAuthorizationDetails(authorizationDetails);
        return chargeResponseDTO;
    }
}
