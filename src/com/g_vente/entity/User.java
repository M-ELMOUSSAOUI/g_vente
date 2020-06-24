package com.g_vente.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -856577994637439061L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int codeUser;
	
	@Column
	private String userName;

	@Column
	private String email;
	
	@Column
	private String pass;

	
	public User() {
		super();
	}

	public int getCodeUser() {
		return codeUser;
	}

	public void setCodeUser(int codeUser) {
		this.codeUser = codeUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "User [codeUser=" + codeUser + ", userName=" + userName + ", email=" + email + ", pass=" + pass + "]";
	}
	
	
	
}
