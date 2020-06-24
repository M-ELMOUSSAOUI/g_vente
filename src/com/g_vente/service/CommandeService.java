package com.g_vente.service;

import java.util.List;

import com.g_vente.entity.Commande;

public interface CommandeService {
	public void addCommand(Commande c);
	public void updateCommand(Commande c);
	public Commande findById(int id);
	public List<Commande> findAll();
}
