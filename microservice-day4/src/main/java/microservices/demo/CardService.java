package microservices.demo;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import microservices.demo.model.Card;

@Service
public class CardService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Card> getCardsOwnedBy(long userId) {
		URI targetUri = UriComponentsBuilder.fromUriString("http://card-service").path("/cards")
				.queryParam("userId", userId).build().toUri();
		
		Card[] cards = restTemplate.getForObject(targetUri, Card[].class);
		return Arrays.asList(cards);
	}

}
