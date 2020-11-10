package tech.driviz.Covid19CountryDataExtractor.models.backend;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BackendResponse {
	
	@JsonProperty("Message")
	String message;
	
	@JsonProperty("Countries")
	List<CountryData> countryDataList;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<CountryData> getCountryDataList() {
		return countryDataList;
	}

	public void setCountryDataList(List<CountryData> countryDataList) {
		this.countryDataList = countryDataList;
	}
	
}
