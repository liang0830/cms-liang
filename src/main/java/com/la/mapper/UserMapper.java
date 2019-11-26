package com.la.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.la.beans.User;


public interface UserMapper {

	
	List<User> list(String name);

	User getById(Integer userId);

	@Update("UPDATE cms_user SET locked=${status} WHERE id=${userId}")
	int updateStatus(@Param("userId") Integer userId, 
			@Param("status") int status);

	@Select("SELECT * FROM cms_user "
			+ " WHERE username = #{value} limit 1 ")
	User findByUserName(String username);

	int add(User user);

}
