package com.la.service;

import javax.validation.Valid;

import com.github.pagehelper.PageInfo;
import com.la.beans.Collect;


/**
 * 
 * @ClassName: CollectService 
 * @Description: 收藏
 * @author:liAng
 * @date: 2019年11月24日 下午7:46:44
 */
public interface CollectService {

	/**
	 * 
	 * @param collect
	 * @return
	 */
	int add(Collect collect);
	/**
	 * 
	 * @param page
	 * @return
	 */
	PageInfo list(int userId,int page);
	/**
	 * 
	 * @param id
	 * @return
	 */
	int delete(int id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Collect get(int id);
	
	/**
	 * 
	 * @param collect
	 * @return
	 */
	int update( Collect collect);

}
