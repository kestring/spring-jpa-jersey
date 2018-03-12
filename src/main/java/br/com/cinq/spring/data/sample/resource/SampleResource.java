package br.com.cinq.spring.data.sample.resource;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.repository.CityRepository;

@Path("/cities")
public class SampleResource {

	@Autowired
	private CityRepository cityRepository;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCitiesByCountryName() {
		//@QueryParam("country") @DefaultValue("") String countryName
		//List<City> listCities = this.cityRepository.findByCountryNameLike(countryName);
		List<City> listCities = this.cityRepository.findAll();
		if(listCities != null) {
			return Response.ok().entity(listCities).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/city/{id}")
	public Response getCityById(@QueryParam("id") @DefaultValue("") String countryName) {
		List<City> listCities = this.cityRepository.findByCountryNameLike(countryName);
		if(listCities != null) {
			return Response.ok().entity(listCities).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
}
