package com.g_vente.dao;

import java.util.List;

import com.g_vente.entity.ProduitS;

public interface ProduitSDao {
	
	public void save(ProduitS ps);
	
	public ProduitS findByName(String name);
	
	public List<ProduitS> findAll();
	
	public void update(ProduitS ps);

}
