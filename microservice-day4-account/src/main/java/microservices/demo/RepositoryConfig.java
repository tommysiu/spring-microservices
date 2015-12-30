package microservices.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import microservices.demo.model.Account;

/**
 * By default, Spring Data REST will not serialize the entity id in JSON
 * response. This configuration is needed if we want to include id in the
 * response entity.
 */
@Configuration
public class RepositoryConfig extends RepositoryRestMvcConfiguration {

	@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Account.class);
	}
}
