package tech.driviz.Covid19CountryDataExtractor.Services;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import tech.driviz.Covid19CountryDataExtractor.models.backend.BackendResponse;

@Service
public class CovidDataExtractorService {

	private static final String SUMMARY = "/summary";

	private final RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(CovidDataExtractorService.class);

	@Value("${base.url}")
	private String baseUrl;

	public CovidDataExtractorService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void extractData() {
		URI uri = generateURI();
		BackendResponse backendResponse = restTemplate.getForObject(uri, BackendResponse.class);

		logger.info("Response from backend -> " + backendResponse.toString());

	}

	private URI generateURI() {
		StringBuilder sb = new StringBuilder();
		sb.append(baseUrl);
		sb.append(SUMMARY);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(sb.toString());

		return builder.build().encode().toUri();
	}
}
