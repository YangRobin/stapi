package com.robin.utils;

import org.springframework.util.DigestUtils;

public class Utils {

	public static boolean Md5Utils(String a, String b) {

		return DigestUtils.md5DigestAsHex(a.getBytes()).equals(b);
	}
}
