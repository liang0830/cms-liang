package com.la.service;

import javax.validation.Valid;

import com.github.pagehelper.PageInfo;
import com.la.beans.Link;

/**
 * 
 * @ClassName: LinkService 
 * @Description: TODO
 * @author:liAng
 * @date: 2019年11月24日 下午7:46:37
 */
public interface LinkService {

	int add(Link link);
	PageInfo list(int page);
	int delete(int id);
	Link get(int id);
	int update( Link link);

}
