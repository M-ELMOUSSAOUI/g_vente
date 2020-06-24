package com.g_vente.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.g_vente.dao.ProduitPDao;
import com.g_vente.entity.ProduitP;

@Repository
public class ProduitPDaoImpl implements ProduitPDao {
	
	@Autowired
	@Qualifier(value = "sessionFactory")
	SessionFactory sessionFactory;

	@Override
	public void saveProduit(ProduitP p) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(p);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProduitP> findAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from ProduitP").list();
	}

	@Override
	public void delete(ProduitP p) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(p);
	}

	@Override
	public void update(ProduitP p) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(p);
	}

	@Override
	public ProduitP findBytId(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(ProduitP.class,id);
	}

}
