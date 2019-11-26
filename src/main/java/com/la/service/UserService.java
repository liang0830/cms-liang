package com.la.service;

import com.github.pagehelper.PageInfo;
import com.la.beans.User;


public interface UserService {

	PageInfo<User> getPageList(String name, Integer page);

	/**
	 * 根据id获取用户信息
	 * @param userId
	 * @return
	 */
	User getUserById(Integer userId);

	/**
	 *  修改用户的状态 也就是解禁和封禁
	 * @param userId
	 * @param status
	 * @return
	 */
	int updateStatus(Integer userId, int status);

	/**
	 * 根据据用户名查找用户
	 * @param username
	 * @return
	 */
	User findByName(String username);

	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	int register(User user);

	/**
	 * 登录
	 * @param user
	 * @return
	 */
	User login(User user);
	

}
