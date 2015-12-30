package microservices.demo.model;

public class Card {
	private long id;
	private long cardHolderId;
	private String cardNumber;
	private String cardType;
	private String currency;

	Card() {
	}
	
	public Card(long cardHolderId, String cardNumber, String cardType, String currency) {
		super();
		this.cardHolderId = cardHolderId;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.currency = currency;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCardHolderId() {
		return cardHolderId;
	}

	public void setCardHolderId(long cardHolderId) {
		this.cardHolderId = cardHolderId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
