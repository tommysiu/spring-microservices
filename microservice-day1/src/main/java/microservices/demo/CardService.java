package microservices.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservices.demo.model.Card;
import microservices.demo.repository.CardRepository;

@Service
public class CardService {

	@Autowired
	CardRepository cardRepository;

	public List<Card> getCardsOwnedBy(long userId) {
		return cardRepository.findByCardHolderId(userId);
	}
}
