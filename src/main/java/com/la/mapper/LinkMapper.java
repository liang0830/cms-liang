package com.la.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.la.beans.Link;

/**
 * 
 * @ClassName: LinkMapper 
 * @Description: TODO
 * @author:liAng
 * @date: 2019年11月24日 下午7:47:05
 */
public interface LinkMapper {

	/**
	 * 
	 * @param link
	 * @return
	 */
	@Insert("INSERT INTO cms_link (url,name,created) "
			+ " VALUES(#{url},#{name},now())")
	int add(Link link);
	
	/**
	 * 
	 * @return
	 */
	@Select("SELECT * FROM cms_link ORDER BY created DESC")
	List<Link> list();

	/**
	 * 
	 * @param link
	 * @return
	 */
	@Update("UPDATE cms_link set url=#{url},name=#{name} "
			+ "	WHERE id=#{id}")
	int  update(Link link);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM cms_link WHERE id=#{value} ")
	Link get(int id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Delete("DELETE  FROM cms_link WHERE id=#{value} ")
	int delete(int id);

}
