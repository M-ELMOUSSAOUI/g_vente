package com.g_vente.dao;

import java.util.List;

import com.g_vente.entity.Commande;

public interface CommandeDao  {
	public void addCommand(Commande c);
	public void updateCommand(Commande c);
	public Commande findById(int id);
	public List<Commande> findAll();

}
