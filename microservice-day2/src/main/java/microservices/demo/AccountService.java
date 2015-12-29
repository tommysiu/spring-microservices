package microservices.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import microservices.demo.model.Account;

@Service
public class AccountService {

	public Account getAccount(long userId) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:18081/accounts/{userId}", Account.class, userId);
	}
}
