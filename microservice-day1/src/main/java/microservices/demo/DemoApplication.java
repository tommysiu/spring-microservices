package microservices.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import microservices.demo.model.Account;
import microservices.demo.model.Card;
import microservices.demo.repository.AccountRepository;
import microservices.demo.repository.CardRepository;

@SpringBootApplication
public class DemoApplication {

	@Bean
	InitializingBean seedDatabase(AccountRepository accountRepo, CardRepository cardRepo) {
		return () -> {
			long userId1 = accountRepo.save(new Account("Tommy", "USD", BigDecimal.valueOf(123456))).getId();
			long userId2 = accountRepo.save(new Account("David", "USD", BigDecimal.valueOf(1000000))).getId();
			long userId3 = accountRepo.save(new Account("Peter", "USD", BigDecimal.valueOf(81237))).getId();

			cardRepo.save(new Card(userId1, "1111", "STD", "HKD"));
			cardRepo.save(new Card(userId1, "2222", "GOLD", "HKD"));
			cardRepo.save(new Card(userId2, "3333", "STD", "RMB"));
			cardRepo.save(new Card(userId3, "4444", "STD", "USD"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
