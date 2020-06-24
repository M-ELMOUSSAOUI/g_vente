package com.g_vente.service;

import java.util.List;

import com.g_vente.entity.User;

public interface UserService {

	public void addUser(User u);
	public void updateUser(User u);
	public void removeUser(User u);
	public List<User> findAll();
	public User getCurrentUser(String email,String pass);
	public User findByName(String name);
}
