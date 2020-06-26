package com.g_vente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.g_vente.dao.ClientDao;
import com.g_vente.entity.Client;
import com.g_vente.service.ClientService;

@Service(value = "clientService")
@Transactional(value = "transactionManager")
@EnableTransactionManagement
public class ClientserviceImpl  implements ClientService {

	@Autowired
	ClientDao clientDao;
	
	@Override
	public void add(Client c) {
		// TODO Auto-generated method stub
		this.clientDao.add(c);
	}

	@Override
	public void remove(Client c) {
		// TODO Auto-generated method stub
		this.clientDao.remove(c);
	}

	@Override
	public Client findByName(String name) {
		// TODO Auto-generated method stub
		return this.clientDao.findByName(name);
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return this.clientDao.findAll();
	}

}
