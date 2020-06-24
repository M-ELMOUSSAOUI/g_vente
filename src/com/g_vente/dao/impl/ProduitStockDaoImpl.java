package com.g_vente.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.g_vente.dao.ProduitSDao;
import com.g_vente.entity.ProduitS;

@Repository
public class ProduitStockDaoImpl  implements ProduitSDao {

	@Autowired
	@Qualifier( value="sessionFactory2")
	SessionFactory sessionFactory;
	
	@Override
	public ProduitS findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


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

}
