package com.hibernateAndJPA.springbootHibernateJPA.RestApi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hibernateAndJPA.springbootHibernateJPA.business.IServices;
import com.hibernateAndJPA.springbootHibernateJPA.Entities.City;

// uygulamanın son hali icin annotasyonlar
@RestController
@RequestMapping("/api")
public class CityController {

	private IServices services;
	@Autowired
	public CityController(IServices services) {
		this.services = services;
	}
	// getmapping verileri getirir değişikilk yapmaz
	@GetMapping("/cities")
	public List<City> get(){
		return services.getAll();
	}
	
	// postmapping değişiklik yapar
	@PostMapping("/add")
	//veriyi alacağımız yer requestbody
	public void add(@RequestBody City city) {
		services.add(city);
	}
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
	
		services.delete(city);
	}
	@PostMapping("/update")
	public void update(@RequestBody City city) {
		services.update(city);
	}
	//bir tane id isteyecek
	@GetMapping("/cities/{id}")
	public City get(@PathVariable int id){
		return services.getById(id);
	}
}
