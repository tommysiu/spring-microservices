package microservices.demo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import microservices.demo.model.Account;

@Service
public class AccountService {
	private static Logger logger = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(threadPoolKey = "demoPool", fallbackMethod = "getFallbackAccount", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value ="10000")})
	public Account getAccount(long userId) {
		logger.info("getAccount() has been called");
		return this.restTemplate.getForObject("http://account-service/accounts/{userId}", Account.class,
				userId);
	}

	public Account getFallbackAccount(long userId) {
		logger.info("getFallbackAccount() has been called");
		Account account = new Account("Fallback User", "GBP", BigDecimal.valueOf(1000000));
		account.setId(0);

		return account;
	}
}
