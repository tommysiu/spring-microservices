package microservices.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import microservices.demo.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
	List<Card> findByCardHolderId(long cardHolderId);
}
