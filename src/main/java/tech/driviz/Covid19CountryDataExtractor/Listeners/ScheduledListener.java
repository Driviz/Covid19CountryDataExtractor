package tech.driviz.Covid19CountryDataExtractor.Listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import tech.driviz.Covid19CountryDataExtractor.Services.CovidDataExtractorService;

@Component
public class ScheduledListener {

	public static final Logger logger = LoggerFactory.getLogger(ScheduledListener.class);

	private final CovidDataExtractorService covidDataExtractorService;

	public ScheduledListener(CovidDataExtractorService covidDataExtractorService) {
		this.covidDataExtractorService = covidDataExtractorService;
	}

	@Scheduled(fixedRate = 10000)
	public void listen() {
		logger.info("intitiating extracting Data");
		covidDataExtractorService.extractData();
	}
}
