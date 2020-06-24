package com.g_vente.dao;

import java.util.List;

import com.g_vente.entity.ProduitS;

public interface ProduitSDao {
	
	public void save(ProduitS ps);
	
	public ProduitS findById(int id);
	
	public List<ProduitS> findAll();

}
