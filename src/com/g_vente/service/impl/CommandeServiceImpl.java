package com.g_vente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.g_vente.dao.CommandeDao;
import com.g_vente.entity.Commande;
import com.g_vente.service.CommandeService;

@Service(value = "commandeService")
@Transactional("transactionManager")
@EnableTransactionManagement
public class CommandeServiceImpl implements CommandeService {
	
	@Autowired
	CommandeDao cmdDao;

	@Override
	public void addCommand(Commande c) {
		// TODO Auto-generated method stub
		cmdDao.addCommand(c);
	}

	@Override
	public void updateCommand(Commande c) {
		// TODO Auto-generated method stub
		cmdDao.updateCommand(c);
	}

	@Override
	public Commande findById(int id) {
		// TODO Auto-generated method stub
		return cmdDao.findById(id);
	}

	@Override
	public List<Commande> findAll() {
		// TODO Auto-generated method stub
		return cmdDao.findAll();
	}

}
