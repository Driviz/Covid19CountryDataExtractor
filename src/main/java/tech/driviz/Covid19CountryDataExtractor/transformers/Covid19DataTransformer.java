package tech.driviz.Covid19CountryDataExtractor.transformers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import tech.driviz.Covid19CountryDataExtractor.models.CountryCasesData;
import tech.driviz.Covid19CountryDataExtractor.models.backend.BackendResponse;
import tech.driviz.Covid19CountryDataExtractor.models.backend.CountryData;

@Component
public class Covid19DataTransformer {

	private static final Logger logger = LoggerFactory.getLogger(Covid19DataTransformer.class);
	
	public List<CountryCasesData> transform(BackendResponse backendData) {
		List<CountryCasesData> transformedList = null;
		
		try {
			transformedList = getTransformedList(backendData);
		} catch(Exception e) {
			logger.info("Data missing: " + e.getMessage());
			throw e;
		}
		
		return transformedList;
	}

	private List<CountryCasesData> getTransformedList(BackendResponse backendData) {
		List<CountryData> backendCountryList= backendData.getCountryDataList();
		List<CountryCasesData> transformedList = new ArrayList<>();
		for (CountryData countryData : backendCountryList) {
			CountryCasesData transformedData= new CountryCasesData();
			transformedData.setCountry(countryData.getCountry());
			Long confirmed = countryData.getTotalConfirmed();
			Long recovered = countryData.getTotalRecovered();
			Long deaths = countryData.getTotalDeaths();
			
			transformedData.setActiveCases(confirmed-recovered-deaths);
			transformedList.add(transformedData);
		}
		return transformedList;
	}
}
