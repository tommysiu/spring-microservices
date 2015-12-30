package microservices.demo;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import microservices.demo.model.Card;
import microservices.demo.repository.CardRepository;

@RestController
public class CardController {
	private static final Logger logger = LoggerFactory.getLogger(CardController.class);
	
	@Autowired
	CardRepository cardRepository;

	@RequestMapping("/cards")
	public List<Card> getCardsOwnedBy(@RequestParam("userId") Optional<Long> userId) {
		logger.info("Cards request has been received: userId = " + userId);
		
		if (userId.isPresent()) {
			return cardRepository.findByCardHolderId(userId.get());
		} else {
			return cardRepository.findAll();
		}
	}
}
