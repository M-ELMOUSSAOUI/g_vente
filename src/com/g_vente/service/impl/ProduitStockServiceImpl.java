package com.g_vente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.g_vente.dao.ProduitSDao;
import com.g_vente.entity.ProduitS;
import com.g_vente.service.ProduitSService;

@Service("stockService")
@Transactional("transactionManager2")
@EnableTransactionManagement
public class ProduitStockServiceImpl implements ProduitSService {
	
	@Autowired
	ProduitSDao stockDao;
	
	@Override
	public List<ProduitS> findAll() {
		// TODO Auto-generated method stub
		return stockDao.findAll();
	}

	@Override
	public ProduitS findByName(String name) {
		// TODO Auto-generated method stub
		return this.stockDao.findByName(name);
	}

	@Override
	public void update(ProduitS p) {
		// TODO Auto-generated method stub
		this.stockDao.update(p);
	}



}
