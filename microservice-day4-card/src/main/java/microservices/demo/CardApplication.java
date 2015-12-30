package microservices.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import microservices.demo.model.Card;
import microservices.demo.repository.CardRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class CardApplication {

	@Bean
	InitializingBean seedDatabase(CardRepository cardRepo) {
		return () -> {
			cardRepo.save(new Card(1, "1111", "STD", "HKD"));
			cardRepo.save(new Card(1, "2222", "GOLD", "HKD"));
			cardRepo.save(new Card(2, "3333", "STD", "RMB"));
			cardRepo.save(new Card(3, "4444", "STD", "USD"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CardApplication.class, args);
	}
}
