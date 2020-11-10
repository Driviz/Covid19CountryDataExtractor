package tech.driviz.Covid19CountryDataExtractor.Listeners;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import tech.driviz.Covid19CountryDataExtractor.Services.CovidDataExtractorService;
import tech.driviz.Covid19CountryDataExtractor.Services.CovidDataSavingService;
import tech.driviz.Covid19CountryDataExtractor.models.CountryCasesData;

@Component
public class ScheduledListener {

	public static final Logger logger = LoggerFactory.getLogger(ScheduledListener.class);

	private final CovidDataExtractorService covidDataExtractorService;
	private final CovidDataSavingService covidDataSavingService;

	public ScheduledListener(CovidDataExtractorService covidDataExtractorService,
			CovidDataSavingService covidDataSavingService) {
		this.covidDataExtractorService = covidDataExtractorService;
		this.covidDataSavingService = covidDataSavingService;
	}

	@Scheduled(fixedRate = 100000)
	public void listen() {
		logger.info("intitiating extracting Data");
		List<CountryCasesData> dataList = covidDataExtractorService.extractData();
		covidDataSavingService.save(dataList);
		logger.info("data saved to db");
	}
}
