package microservices.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservices.demo.model.Account;
import microservices.demo.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public Account getAccount(long userId) {
		return accountRepository.findOne(userId);
	}
}
