package com.robin.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robin.bean.UserBean;
import com.robin.dao.UserDao;
import com.robin.service.BaseSearch;
import com.robin.service.UserService;

@Service
public class UserServiceImp extends BaseSearch implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public UserBean queryUserByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		return userDao.queryUserByNameAndPassWord(name, password);
	}

	@Override
	public int registerUser(UserBean userBean) {
		// TODO Auto-generated method stub
		return userDao.registerUser(userBean);
	}

	@Override
	public int updateUser(UserBean userBean) {
		// TODO Auto-generated method stub
		return userDao.updateUser(userBean);
	}

	@Override
	public UserBean queryUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.queryUserById(id);
	}
}
