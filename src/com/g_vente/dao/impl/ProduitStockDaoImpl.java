package com.g_vente.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.g_vente.dao.ProduitSDao;
import com.g_vente.entity.ProduitS;

@Repository
public class ProduitStockDaoImpl  implements ProduitSDao {

	@Autowired
	@Qualifier( value="sessionFactory2")
	SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProduitS> findAll() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from ProduitS").list();
	}


	@Override
	public void save(ProduitS ps) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(ps);
	}


	@Override
	public ProduitS findByName(String name) {
		// TODO Auto-generated method stub
		return (ProduitS) this.sessionFactory.getCurrentSession().createQuery("from ProduitS ps where ps.nomPdt= :name")
				.setParameter("name", name)
				.getSingleResult();
	}


	@Override
	public void update(ProduitS ps) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(ps);
	}

}
