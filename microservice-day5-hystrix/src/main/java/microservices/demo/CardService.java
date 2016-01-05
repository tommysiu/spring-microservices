package microservices.demo;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import microservices.demo.model.Card;

@Service
public class CardService {
	private static Logger logger = LoggerFactory.getLogger(CardService.class);

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(threadPoolKey = "demoPool", fallbackMethod = "getFallbackCards", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000") })
	public List<Card> getCardsOwnedBy(long userId) {

		logger.info("getCardsOwnedBy() has been called");

		URI targetUri = UriComponentsBuilder.fromUriString("http://microservice-card-service").path("/cards")
				.queryParam("userId", userId).build().toUri();

		Card[] cards = restTemplate.getForObject(targetUri, Card[].class);
		return Arrays.asList(cards);
	}

	public List<Card> getFallbackCards(long userId) {

		logger.info("getFallbackCards() has been called");

		return new ArrayList<Card>();
	}

}
