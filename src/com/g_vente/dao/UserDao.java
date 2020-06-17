package com.g_vente.dao;

import java.util.List;

import com.g_vente.model.User;

public interface UserDao {
	
	public void save(User u);
	
	public List<User> findAll();
	
	public User findByName(String userName);
	
	public void updateUser(User u);
	
	public void deleteUser(User u);
	
	

}
