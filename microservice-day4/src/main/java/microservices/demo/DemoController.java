package microservices.demo;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import microservices.demo.model.Summary;

@RestController
public class DemoController {

	@Autowired
	AccountService accountService;

	@Autowired
	CardService cardService;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private DemoConfiguration config;

	@RequestMapping("/summary/{userId}")
	public Summary getSummary(@PathVariable long userId) {
		// get the summary by invoking account service and card service
		// respectively
		Summary s = new Summary(accountService.getAccount(userId), cardService.getCardsOwnedBy(userId));

		// add HATEOAS feature
		s.add(linkTo(methodOn(DemoController.class).getSummary(userId)).withSelfRel());
		return s;
	}

	@RequestMapping(value = "/app-info", method = RequestMethod.GET, produces = "application/json")
	public Map<String, String> getAppInfo() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", this.config.getDemoName());
		map.put("version", this.config.getDemoVersion());
		return map;
	}

	@RequestMapping(value = "/services", produces = "text/plain")
	public String displayServices() {
		StringBuffer sb = new StringBuffer(512);

		// check the discovery client
		for (String service : discoveryClient.getServices()) {
			discoveryClient.getInstances(service)
					.forEach(inst -> sb.append(String.format("Eureka service[%s] - %s %s:%s\n", service,
							inst.getServiceId(), inst.getHost(), inst.getPort())));
		}

		return sb.toString();
	}
}
