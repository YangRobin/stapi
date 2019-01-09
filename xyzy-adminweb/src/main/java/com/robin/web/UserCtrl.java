package com.robin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.robin.bean.ResponseBean;
import com.robin.bean.UserBean;
import com.robin.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;


@Api(value="user")
@RestController
@RequestMapping("/user")
public class UserCtrl {

	@Autowired
	UserService userService;

	@ApiOperation(value="根据ID获取用户信息",httpMethod="GET",notes="get user by id",response=ResponseBean.class)
	@ResponseBody
	@RequestMapping(value = "/queryUserByNameAndPassword", method = RequestMethod.GET)
	public ResponseBean queryUserByName(String name, String password) {

		ResponseBean responseBean = new ResponseBean();
		UserBean userBean = userService.queryUserByNameAndPassword(name, password);
		if (null != userBean) {
			responseBean.setIsSuccess(true);
			responseBean.setResult(userBean);
		} else {
			responseBean.setIsSuccess(true);
			responseBean.setResult("no such user!");
		}
		return responseBean;
	}

	@ResponseBody
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public int regiterUser(UserBean user) {
		return userService.registerUser(user);
	}

}
