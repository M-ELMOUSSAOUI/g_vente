package com.g_vente.service;

import java.util.List;

import com.g_vente.entity.ProduitS;

public interface ProduitSService {
	public List<ProduitS> findAll() ;
	public ProduitS findByName(String name) ;
	public void update(ProduitS p);
	

}
