package com.hibernateAndJPA.springbootHibernateJPA.DataAccess;
import java.util.List;

import com.hibernateAndJPA.springbootHibernateJPA.Entities.City;

public interface ICityDal {

	List <City> getAll();
	void add(City city);
	void delete(City city);
	void update(City city);
	City getById(int id);
	
}
