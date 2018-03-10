package br.com.cinq.spring.data.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.repository.CityRepository;

@RestController
@RequestMapping("/cities")
public class SampleResource {

	@Autowired
	private CityRepository cityRepository;
	
	//@GetMapping(produces="application/json")
	@RequestMapping("/{countryName}")
	public @ResponseBody List<City> getCountryByName(@PathVariable(value="countryName") String countryName) {
		//aqui vou receber as credenciais do usuário criptografada(não sei) e retornar um token??
		return cityRepository.findByCountryNameLike(countryName);
	}
	
}
