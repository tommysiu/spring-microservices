package microservices.demo.model;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class Summary extends ResourceSupport {
	private Account account;
	private List<Card> cards;

	public Summary(Account account, List<Card> cards) {
		super();
		this.account = account;
		this.cards = cards;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}
