package com.hibernateAndJPA.springbootHibernateJPA.business;

import java.util.List;

import com.hibernateAndJPA.springbootHibernateJPA.Entities.City;

public interface IServices {
	List <City> getAll();
	void add(City city);
	void delete(City city);
	void update(City city);
	City getById(int id);
	
}
