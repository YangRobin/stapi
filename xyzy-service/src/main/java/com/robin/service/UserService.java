package com.robin.service;

import com.robin.bean.UserBean;

public interface UserService {
	

	/**
	 * @author robin
	 * @param name
	 * @param password
	 * @return userBean
	 */
	UserBean queryUserByNameAndPassword(String name,String password);
	
	/**
	 * 
	 * @param userBean
	 * @return id
	 * @author robin
	 */
	int registerUser(UserBean userBean);
	
	/**
	 * @author robin
	 * @param userBean
	 * @return id
	 */
	int updateUser(UserBean userBean);
	
	/**
	 * @author robin
	 * @param id
	 * @return userBean
	 */
	UserBean queryUserById(int id);
	

}
