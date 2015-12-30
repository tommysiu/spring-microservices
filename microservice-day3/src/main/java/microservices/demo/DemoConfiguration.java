package microservices.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "configuration")
@RefreshScope
public class DemoConfiguration {
	private String accountServiceUrl;
	private String cardServiceUrl;

	public void setAccountServiceUrl(String accountServiceUrl) {
		this.accountServiceUrl = accountServiceUrl;
	}

	public void setCardServiceUrl(String cardServiceUrl) {
		this.cardServiceUrl = cardServiceUrl;
	}

	public String getAccountServiceUrl() {
		return this.accountServiceUrl;
	}

	public String getCardServiceUrl() {
		return this.cardServiceUrl;
	}

}
