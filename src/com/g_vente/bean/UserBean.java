package com.g_vente.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.g_vente.entity.User;
import com.g_vente.service.UserService;

@ManagedBean
@SessionScoped
public class UserBean {

	@ManagedProperty("#{userService}")
	UserService userService;

	private int codeUser;
	private String username;
	private String email;
	private String pass;
	
	private List<User> userList ;
	private User theUser = new User();
	
	private String confPassword;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getTheUser() {
		return theUser;
	}

	public void setTheUser(User theUser) {
		this.theUser = theUser;
	}

	public String getConfPassword() {
		return confPassword;
	}

	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public int getCodeUser() {
		return codeUser;
	}

	public void setCodeUser(int codeUser) {
		this.codeUser = codeUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	//Authentication methods
	public String registreUser() {

		FacesContext ctx = FacesContext.getCurrentInstance();
		userList=userService.findAll();
		System.out.println(userList);
		//check if the user already exist
		for (User user : userList) {
			if(user.getEmail().equals(this.email)){
				ctx.addMessage(null, new FacesMessage("this user already exsite"));
				return "register";
			}
		}
		
		//checking matching passwords 
		if(this.pass.equals(this.confPassword)) {
			//adding new user
				theUser.setEmail(email);
				theUser.setPass(pass);
				theUser.setUserName(username);
				userService.addUser(theUser);
				return "accueil";
		}
		else {
			ctx.addMessage(null, new FacesMessage("passwords not match"));
			return "registre" ;
		}
	}
	
	public String loginUser() {
		FacesContext ctx = FacesContext.getCurrentInstance();
			User u = userService.getCurrentUser(email, pass);
			if (u == null) {
				u= new User();
				ctx.addMessage(null, new FacesMessage("email or password incorrects"));
				return "login";
			}	
			else {
				System.out.println(userService.getCurrentUser(email, pass).getUserName());
				return "accueil";
				
			}
	}
	
	public String editPass() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		System.out.println(this.theUser.getEmail());
		//User u = userService.findByName(username);
			if (this.pass.equals(confPassword)) {
				theUser.setPass(pass);
				//userService.removeUser(u);
				userService.updateUser(theUser);
				System.out.println(theUser.toString());
				return "accueil";
			} else {
				ctx.addMessage(null, new FacesMessage("passwords not match"));
				return "edit_password";
			}
	}
}
