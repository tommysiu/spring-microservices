package microservices.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "configuration")
@RefreshScope
public class DemoConfiguration {
	private String demoName;
	private String demoVersion;

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
