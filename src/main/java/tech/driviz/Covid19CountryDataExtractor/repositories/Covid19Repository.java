package tech.driviz.Covid19CountryDataExtractor.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tech.driviz.Covid19CountryDataExtractor.models.CountryCasesData;

@Repository
public interface Covid19Repository extends CrudRepository<CountryCasesData, Long>{

}
