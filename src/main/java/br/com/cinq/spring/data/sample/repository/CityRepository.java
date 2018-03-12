package br.com.cinq.spring.data.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;

public interface CityRepository extends JpaRepository<City, Integer>{

	public City findById(Integer id);
	
	public City findByName(String name);
	
	@Query("Select a from City a Where a.country.name like name ")
	public List<City> findByCountryNameLike(String name);
	
	@Query("select c from City c left join fetch c.country ct where ct.id = :#{#country.id}")
	public List<City> findByCountry(@Param("country")Country country);
	
}
