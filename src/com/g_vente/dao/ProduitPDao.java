package com.g_vente.dao;

import java.util.List;

import com.g_vente.entity.ProduitP;

public interface ProduitPDao {
	
	public void saveProduit(ProduitP p);
	
	public List<ProduitP> findAll();
	
	public void delete(ProduitP p);
	
	public void update(ProduitP p) ;
	
	public ProduitP findBytId(int id);
	

}
