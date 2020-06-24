package com.g_vente.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.g_vente.dao.UserDao;
import com.g_vente.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	@Qualifier(value = "sessionFactory")
	SessionFactory sessionFactory;

	@Override
	public void saveUser(User u) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(u);
		System.out.println(sessionFactory.getCurrentSession());

	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stu
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User getCurrentUser(String email, String pass) {
		// TODO Auto-generated method stub
		try {
			return (User) sessionFactory.getCurrentSession()
					.createQuery("from User u where u.email= :uEmail and u.pass= :uPass")
					.setParameter("uEmail", email)
					.setParameter("uPass", pass)
					.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		try {
			return (User) sessionFactory.getCurrentSession().createQuery("from User u where u.userName= :user_name")
					.setParameter("user_name", name).getSingleResult();

		} catch (Exception e) {
			// e: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void removeUser(User u) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().delete(u);
		
	}

}
