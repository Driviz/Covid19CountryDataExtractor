package tech.driviz.Covid19CountryDataExtractor.models.backend;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BackendResponse {

	@JsonProperty("Message")
	private String message;

	@JsonProperty("Countries")
	private List<CountryData> countryDataList;

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

	@Override
	public String toString() {
		return "BackendResponse [message=" + message + ", countryDataList=" + countryDataList + "]";
	}

}
