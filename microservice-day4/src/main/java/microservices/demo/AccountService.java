package microservices.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import microservices.demo.model.Account;

@Service
public class AccountService {

	@Autowired
	private RestTemplate restTemplate;

	public Account getAccount(long userId) {
		return this.restTemplate.getForObject("http://microservice-account-service/accounts/{userId}", Account.class,
				userId);
	}
}
