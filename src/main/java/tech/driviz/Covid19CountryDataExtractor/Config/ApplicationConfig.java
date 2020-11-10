package tech.driviz.Covid19CountryDataExtractor.Config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

	@Bean
	RestTemplate restTemplate(RestTemplateBuilder resBuilder) {
		return resBuilder.build();
	}
}
