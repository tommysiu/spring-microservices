package microservices.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import microservices.demo.model.Account;
import microservices.demo.repository.AccountRepository;

@SpringBootApplication
public class AccountApplication {

	@Bean
	InitializingBean seedDatabase(AccountRepository accountRepo) {
		return () -> {
			accountRepo.save(new Account("Tommy", "USD", BigDecimal.valueOf(123456)));
			accountRepo.save(new Account("David", "USD", BigDecimal.valueOf(1000000)));
			accountRepo.save(new Account("Peter", "USD", BigDecimal.valueOf(81237)));
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
}
