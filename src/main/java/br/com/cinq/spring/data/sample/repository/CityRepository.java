package br.com.cinq.spring.data.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;

public interface CityRepository extends JpaRepository<City, Long>{

	public City findById(Integer id);
	
	public City findByName(String name);
	
	@Query("Select * from CITY a join Country b Where a.country.id = b.id  ")
	public List<City> findByCountryNameLike(String name);
	
	public List<City> findByCountry(Country country);
	
}
