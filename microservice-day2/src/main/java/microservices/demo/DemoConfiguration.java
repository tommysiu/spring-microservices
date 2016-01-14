package microservices.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "configuration")
public class DemoConfiguration {
	private String demoName;
	private String demoVersion;
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

	public String getDemoName() {
		return demoName;
	}

	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}

	public String getDemoVersion() {
		return demoVersion;
	}

	public void setDemoVersion(String demoVersion) {
		this.demoVersion = demoVersion;
	}

}
