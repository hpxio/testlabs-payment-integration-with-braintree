package com.app.hpx.testlabs.integrator.client.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "braintree.gateway")
public class BraintreeApiGatewayConfig {

	private static final Logger LOG = LoggerFactory.getLogger(BraintreeApiGatewayConfig.class);

	private String environment;

	private String merchantId;

	private String privateKey;

	private String publicKey;

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	@Override
	public String toString() {
		return "BraintreeApiGatewayConfig{" +
				"environment='" + environment + '\'' +
				", merchantId='" + merchantId + '\'' +
				", privateKey='" + privateKey + '\'' +
				", publicKey='" + publicKey + '\'' +
				'}';
	}

	@PostConstruct
	protected void printBraintreeGatewayConfig() {
		LOG.info("Braintree Config : {}", this);
	}
}
