package microservices.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import microservices.demo.model.Account;

@Service
public class AccountService {

	@Autowired
	private DemoConfiguration config;

	public Account getAccount(long userId) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(this.config.getAccountServiceUrl() + "/accounts/{userId}", Account.class,
				userId);
	}
}
