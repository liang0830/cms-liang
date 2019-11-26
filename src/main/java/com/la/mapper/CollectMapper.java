package com.la.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.la.beans.Collect;


public interface CollectMapper {
	
	/**
	 * 
	 * @param collect
	 * @return
	 */
	@Insert("INSERT INTO cms_collect (userId,url,name,created) "
			+ " VALUES(#{userId},#{url},#{name},now())")
	int add(Collect collect);
	
	/**
	 * 
	 * @return
	 */
	@Select("SELECT * FROM cms_collect "
			+ " WHERE userId=#{userId} "
			+ " ORDER BY created DESC")
	List<Collect> list(int userId);

	/**
	 * 
	 * @param collect
	 * @return
	 */
	@Update("UPDATE cms_collect set url=#{url},name=#{name} "
			+ "	WHERE id=#{id}")
	int  update(Collect collect);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM cms_collect WHERE id=#{value} ")
	Collect get(int id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Delete("DELETE  FROM cms_collect WHERE id=#{value} ")
	int delete(int id);

}
