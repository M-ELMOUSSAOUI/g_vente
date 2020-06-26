package com.g_vente.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.g_vente.dao.ClientDao;
import com.g_vente.entity.Client;

@Repository
public class ClientDaoImpl implements ClientDao {

	@Autowired
	@Qualifier(value = "sessionFactory")
	SessionFactory sessionFactory;  
	
	@Override
	public void add(Client c) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(c);
	}

	@Override
	public void remove(Client c) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().delete(c);
	}

	@Override
	public Client findByName(String name) {
		// TODO Auto-generated method stub
		return (Client) this.sessionFactory.getCurrentSession().createQuery("from Client c where c.nomClt= :name")
				.setParameter("name", name)
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from Client").list();
	}

}
