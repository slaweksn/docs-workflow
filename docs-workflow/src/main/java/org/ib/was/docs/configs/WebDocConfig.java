package org.ib.was.docs.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = { "org.ib.was.docs.repositories" })
public class WebDocConfig {

	public WebDocConfig() {
		
	}

}
