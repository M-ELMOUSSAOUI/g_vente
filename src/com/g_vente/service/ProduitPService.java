package com.g_vente.service;

import java.util.List;

import com.g_vente.entity.ProduitP;

public interface ProduitPService {
	public ProduitP findById(int id);
	public void save(ProduitP p);
	public List<ProduitP> findAll(); 
	public void delete(ProduitP p);
	
}
