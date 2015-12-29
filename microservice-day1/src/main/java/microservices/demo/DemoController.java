package microservices.demo;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import microservices.demo.model.Summary;

@RestController
public class DemoController {

	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	AccountService accountService;

	@Autowired
	CardService cardService;

	@Value("${demo.name}")
	String appName;

	@Value("${demo.version}")
	String appVersion;

	@RequestMapping(value = "/summary/{userId}", method = RequestMethod.GET)
	public Summary getSummary(@PathVariable long userId) {

		Summary s = new Summary(accountService.getAccount(userId), cardService.getCardsOwnedBy(userId));

		// add HATEOAS feature
		s.add(linkTo(methodOn(DemoController.class).getSummary(userId)).withSelfRel());
		return s;
	}

	@RequestMapping(value = "/app-info", method = RequestMethod.GET, produces = "application/json")
	public Map<String, String> getAppInfo() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAppInfo() is called");
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("name", appName);
		map.put("version", appVersion);
		return map;
	}
}
