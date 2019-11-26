package com.la.common;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * @ClassName: Md5 
 * @Description: 加密的工具类
 * @author:liAng
 * @date: 2019年11月24日 下午7:42:58
 */
public class Md5 {

	public static String password(String password, String salt) {
		// TODO Auto-generated method stub
		return DigestUtils.md5Hex(password + "::::" +  salt);
	}

	
		
}
