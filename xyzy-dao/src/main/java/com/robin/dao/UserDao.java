package com.robin.dao;

import org.apache.ibatis.annotations.Param;

import com.robin.bean.UserBean;

public interface UserDao {
	
	public UserBean queryUserByNameAndPassWord(@Param("name")String name,@Param("password")String password);

	public int registerUser(UserBean userBean);

	public int updateUser(UserBean userBean);

	public UserBean queryUserById(int id);
}
