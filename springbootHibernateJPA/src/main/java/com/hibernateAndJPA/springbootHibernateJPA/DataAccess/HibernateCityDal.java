package com.hibernateAndJPA.springbootHibernateJPA.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernateAndJPA.springbootHibernateJPA.Entities.City;

@Repository
public class HibernateCityDal implements ICityDal{
	
	private EntityManager entityManeger;
	// otomatik injection yapar yani hibernate
	@Autowired
	public HibernateCityDal(EntityManager entityManeger) {
		this.entityManeger = entityManeger;
	}

	@Override
	@Transactional // otomatik try cach açma kapama
	//AOP Aspect Oriented Programming
	public List<City> getAll() {
		Session session = entityManeger.unwrap(Session.class);
		List<City> cities = session.createQuery("from City",City.class).getResultList();
		return cities;
	}

	@Override
	@Transactional 
	public void add(City city) {
		Session session = entityManeger.unwrap(Session.class);
		session.save(city);	
	
	}

	@Override
	@Transactional 
	public void delete(City city) {
		Session session = entityManeger.unwrap(Session.class);
		City deletedCity = session.get(City.class, city.getId());
		session.delete(deletedCity);
		
	}

	@Override
	@Transactional 
	public void update(City city) {
		Session session = entityManeger.unwrap(Session.class);
		session.save(city);;
		
	}

	@Override
	public City getById(int id) {
		Session session = entityManeger.unwrap(Session.class);
		City city = session.get(City.class,id);
		return city;
	}

}
