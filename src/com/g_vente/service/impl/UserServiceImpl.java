package com.g_vente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.g_vente.dao.UserDao;
import com.g_vente.entity.User;
import com.g_vente.service.UserService;

@Service("userService")
@Transactional(value = "transactionManager")
@EnableTransactionManagement
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public void addUser(User u) {
		// TODO Auto-generated method stub
		userDao.saveUser(u);

	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		userDao.saveUser(u);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User getCurrentUser(String email, String pass) {
		// TODO Auto-generated method stub
		return userDao.getCurrentUser(email, pass);
	}
	
	
	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findByName(name);
	}

	
	@Override
	public void removeUser(User u) {
		// TODO Auto-generated method stub
		this.userDao.removeUser(u);
		
	}

}
