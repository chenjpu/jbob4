package com.jbob.user;

import org.springframework.beans.factory.InitializingBean;

import com.jbob.user.dao.UserDao;

/**
 * Hello world!
 *
 */
public class App implements InitializingBean{
	
	private UserDao userDao;
	
	public App(UserDao userDao){
		this.userDao = userDao;
		//userDao.insert(new User());
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Hello World!");
		//userDao.insert(new User());
	}
}
