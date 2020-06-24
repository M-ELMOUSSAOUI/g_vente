package com.g_vente.service;

import java.util.List;

import com.g_vente.entity.ProduitS;

public interface ProduitSService {
	public void save(ProduitS ps) ;
	public List<ProduitS> findAll() ;
	public ProduitS findById(int id) ;
	

}
