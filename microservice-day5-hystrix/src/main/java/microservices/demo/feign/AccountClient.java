package microservices.demo.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import microservices.demo.model.Account;

@FeignClient("microservice-account-service")
public interface AccountClient {
	@RequestMapping(method = RequestMethod.GET, value = "/accounts/{userId}")
	Account getAccount(@PathVariable("userId") Long userId);
}
