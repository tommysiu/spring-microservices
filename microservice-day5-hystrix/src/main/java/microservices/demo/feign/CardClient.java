package microservices.demo.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import microservices.demo.model.Card;

@FeignClient("microservice-card-service")
public interface CardClient {
	@RequestMapping(method = RequestMethod.GET, value = "/cards")
	List<Card> getCardsOwnedBy(@RequestParam("userId") Long userId);
}
