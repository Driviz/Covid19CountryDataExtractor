package tech.driviz.Covid19CountryDataExtractor.Services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import tech.driviz.Covid19CountryDataExtractor.models.CountryCasesData;
import tech.driviz.Covid19CountryDataExtractor.repositories.Covid19Repository;

@Service
public class CovidDataSavingService {
	
	private final Covid19Repository covid19Repository;

	private static final Logger logger = LoggerFactory.getLogger(CovidDataSavingService.class);
	
	public CovidDataSavingService(Covid19Repository covid19Repository) {
		this.covid19Repository = covid19Repository;
	}
	
	public void save(List<CountryCasesData> dataList) {
		logger.info("saveing Data" + dataList);
		covid19Repository.saveAll(dataList);
	}
}
