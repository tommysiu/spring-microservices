package microservices.demo;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import microservices.demo.model.Card;

@Service
public class CardService {

	private static final Logger logger = LoggerFactory.getLogger(CardService.class);

	@Autowired
	private DemoConfiguration config;

	public List<Card> getCardsOwnedBy(long userId) {
		logger.info("get cards by userId " + userId);
		RestTemplate restTemplate = new RestTemplate();

		URI targetUri = UriComponentsBuilder.fromUriString(this.config.getCardServiceUrl()).path("/cards")
				.queryParam("userId", userId).build().toUri();
		
		Card[] cards = restTemplate.getForObject(targetUri, Card[].class);
		return Arrays.asList(cards);
	}
}
