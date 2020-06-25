package com.g_vente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.g_vente.dao.ProduitPDao;
import com.g_vente.entity.ProduitP;
import com.g_vente.service.ProduitPService;

@Service("produitPService")
@Transactional(value = "transactionManager")
@EnableTransactionManagement
public class ProduitPServiceImpl implements ProduitPService{

	@Autowired
	ProduitPDao produitPDao;
	

	@Override
	public void save(ProduitP p) {
		// TODO Auto-generated method stub
		produitPDao.saveProduit(p);
		
	}

	
	@Override
	public List<ProduitP> findAll() {
		// TODO Auto-generated method stub
		return produitPDao.findAll();
	}

	
	@Override
	public void delete(ProduitP p) {
		// TODO Auto-generated method stub
		produitPDao.delete(p);
	}


	@Override
	public ProduitP findById(int id) {
		// TODO Auto-generated method stub
		return produitPDao.findBytId(id);
	}


	@Override
	public void update(ProduitP p) {
		// TODO Auto-generated method stub
		this.produitPDao.update(p);
	}

}
