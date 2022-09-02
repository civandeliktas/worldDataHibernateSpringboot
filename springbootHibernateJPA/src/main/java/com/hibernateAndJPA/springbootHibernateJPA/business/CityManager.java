package com.hibernateAndJPA.springbootHibernateJPA.business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernateAndJPA.springbootHibernateJPA.DataAccess.ICityDal;
import com.hibernateAndJPA.springbootHibernateJPA.Entities.City;

//is katmanı
@Service
public class CityManager implements IServices {
	// Data access ten veri alma injection
	private ICityDal cityDal;
	
	@Autowired
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	@Transactional 
	public List<City> getAll() {
	
		return this.cityDal.getAll();
	}

	@Override
	@Transactional 
	public void add(City city) {
		this.cityDal.add(city);		
	}

	@Override
	@Transactional 
	public void delete(City city) {
		this.cityDal.delete(city);
		
	}

	@Override
	@Transactional 
	public void update(City city) {
		this.cityDal.update(city);
		
	}

	@Override
	public City getById(int id) {
		return this.cityDal.getById(id);
		
	}

}
