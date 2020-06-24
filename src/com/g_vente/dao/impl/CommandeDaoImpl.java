package com.g_vente.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.g_vente.dao.CommandeDao;
import com.g_vente.entity.Commande;

@Repository
public class CommandeDaoImpl implements CommandeDao {

	@Autowired
	@Qualifier(value = "sessionFactory")
	SessionFactory sessionFactory;
	
	@Override
	public void addCommand(Commande c) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(c);
	}

	@Override
	public void updateCommand(Commande c) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(c);
	}

	@Override
	public Commande findById(int id) {
		// TODO Auto-generated method stub
		return (Commande) sessionFactory.getCurrentSession().get(Commande.class, id) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commande> findAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Commande").list();
	}

}
