package tech.driviz.Covid19CountryDataExtractor.Services;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import tech.driviz.Covid19CountryDataExtractor.models.CountryCasesData;
import tech.driviz.Covid19CountryDataExtractor.models.backend.BackendResponse;
import tech.driviz.Covid19CountryDataExtractor.transformers.Covid19DataTransformer;

@Service
public class CovidDataExtractorService {

	private static final String SUMMARY = "/summary";

	private final RestTemplate restTemplate;
	private final Covid19DataTransformer covid19DataTransformer;

	private static final Logger logger = LoggerFactory.getLogger(CovidDataExtractorService.class);

	@Value("${base.url}")
	private String baseUrl;

	public CovidDataExtractorService(RestTemplate restTemplate, Covid19DataTransformer covid19DataTransformer) {
		this.restTemplate = restTemplate;
		this.covid19DataTransformer = covid19DataTransformer;
	}

	public List<CountryCasesData> extractData() {
		URI uri = generateURI();
		BackendResponse backendResponse = restTemplate.getForObject(uri, BackendResponse.class);

		logger.info("Response from backend -> " + backendResponse.toString());
		
		List<CountryCasesData> transformedDataList = covid19DataTransformer.transform(backendResponse);
	
		logger.info("Response after transformation -> " + transformedDataList);
		
		return transformedDataList;
	}

	private URI generateURI() {
		StringBuilder sb = new StringBuilder();
		sb.append(baseUrl);
		sb.append(SUMMARY);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(sb.toString());

		return builder.build().encode().toUri();
	}
}
