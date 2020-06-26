package com.g_vente.service;

import java.util.List;

import com.g_vente.entity.Client;

public interface ClientService {
	public void add(Client c);
	public void remove(Client c);
	public Client findByName(String name);
	public List<Client> findAll();

}
