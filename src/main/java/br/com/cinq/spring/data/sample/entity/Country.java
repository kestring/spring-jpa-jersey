package br.com.cinq.spring.data.sample.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Country implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(mappedBy = "country", cascade = CascadeType.PERSIST)
	private List<City> cityList;

	public void addCity(City city) {
		if (!this.cityList.contains(city)) {
			this.cityList.add(city);
		}
	}

	public void remCity(City city) {
		if (this.cityList.contains(city)) {
			this.cityList.remove(city);
		}
	}

	@JsonIgnore
	@JsonProperty(value = "cityList")
	public List<City> getCities() {
		if (cityList == null) {
			cityList = new ArrayList<>();
		}
		return cityList;
	}

	public void setCities(List<City> cities) {
		this.cityList = cities;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
