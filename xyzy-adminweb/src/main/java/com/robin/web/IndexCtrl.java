package com.robin.web;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.robin.bean.ResponseBean;
import com.robin.bean.UserBean;
import com.robin.service.UserService;
import com.robin.utils.Utils;

@Controller
@RequestMapping("/")
public class IndexCtrl {

	@Autowired
	UserService userService;

	@RequestMapping(value = "index")
	public String Test() {
		return "index";
	}

	@RequestMapping(value = "login")
	public String Login() {
		return "login";
	}
	
	@RequestMapping(value = "register")
	public String register() {
		return "register";
	}
	
	@ResponseBody
	@RequestMapping(value = "loginin", method = RequestMethod.POST)
	public ResponseBean login(@RequestBody UserBean users,HttpServletResponse response, HttpSession httpSession)
			throws ServletException, IOException {
		String name =users.getName();
		String password = users.getPassword();
		System.out.println(name);
		ResponseBean responseBean = new ResponseBean();
		if (null != httpSession.getAttribute("name")) {
			responseBean.setIsSuccess(true);
			responseBean.setResult("index");
			return responseBean;
		}
		UserBean userBean = userService.queryUserByNameAndPassword(name,
				DigestUtils.md5DigestAsHex(password.getBytes()));
		if (null != userBean) {
			if (Utils.Md5Utils(password, userBean.getPassword())) {
				httpSession.setAttribute("name", userBean.getName());
				httpSession.setAttribute("password", userBean.getPassword());
				httpSession.setMaxInactiveInterval(30);
				Cookie cookie = new Cookie("name", name);
				response.addCookie(cookie);
				responseBean.setIsSuccess(true);
				responseBean.setResult("index");
				return responseBean;
			} else {
				responseBean.setResult("√‹¥aÂe’`£°");
				responseBean.setIsSuccess(false);
				return responseBean;
			}
		}
		responseBean.setIsSuccess(false);
		responseBean.setResult("error");
		return responseBean;
	}

	@RequestMapping(value = "getUserInfo",method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean getUserInfo(HttpSession httpSession) {
		String name = (String) httpSession.getAttribute("name");
		String password = (String) httpSession.getAttribute("password");
		UserBean userBean = userService.queryUserByNameAndPassword(name, password);
		userBean.setPassword(null);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setIsSuccess(true);
		responseBean.setResult(userBean);
		return responseBean;
	}

}