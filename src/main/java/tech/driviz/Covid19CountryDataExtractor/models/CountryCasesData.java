package tech.driviz.Covid19CountryDataExtractor.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "COVID19")
public class CountryCasesData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String country;
	
	private Long activeCases;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getActiveCases() {
		return activeCases;
	}

	public void setActiveCases(Long activeCases) {
		this.activeCases = activeCases;
	}

	@Override
	public String toString() {
		return "CountryCasesData [id=" + id + ", country=" + country + ", activeCases=" + activeCases + "]";
	}
	
}
