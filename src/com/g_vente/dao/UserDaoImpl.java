package com.g_vente.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.g_vente.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public void save(User u) {
		Session session =  sessionFactory.getCurrentSession();
			if(checkUser(u)) {
				System.out.println("user aleady exist");
			}
			else {
				try {
					session.save(u);
					System.out.println("new user added :"+u.toString());	
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					session.getTransaction().rollback();
				}
			}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		List<User> userList;
		userList=session.createQuery("from User").list();
		return userList;
		
		
	}

	@Override
	public User findByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		
	}

	boolean checkUser(User u) {
		if(findAll().contains(u)) return true;
		else return false;
	}
}
