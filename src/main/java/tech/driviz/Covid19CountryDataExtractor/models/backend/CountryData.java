package tech.driviz.Covid19CountryDataExtractor.models.backend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryData {

	@JsonProperty("Country")
	private String country;
	
	@JsonProperty("TotalConfirmed")
	private Long totalConfirmed;
	
	@JsonProperty("TotalRecovered")
	private Long totalRecovered;
	
	@JsonProperty("TotalDeaths")
	private Long totalDeaths;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getTotalConfirmed() {
		return totalConfirmed;
	}

	public void setTotalConfirmed(Long totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}

	public Long getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(Long totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public Long getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(Long totalDeaths) {
		this.totalDeaths = totalDeaths;
	}
	
}
