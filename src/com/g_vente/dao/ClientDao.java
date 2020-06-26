package com.g_vente.dao;

import java.util.List;

import com.g_vente.entity.Client;

public interface ClientDao {
	public void add(Client c);
	public void remove(Client c);
	public Client findByName(String name);
	public List<Client> findAll();

}
