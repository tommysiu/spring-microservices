package microservices.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import microservices.demo.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	List<Account> findByNameIgnoreCase(@Param("name") String name);
}
