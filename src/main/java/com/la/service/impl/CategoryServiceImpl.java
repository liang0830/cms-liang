package com.la.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.la.beans.Category;
import com.la.mapper.CategoryMapper;
import com.la.service.CategoryService;

/**
 * 
 * @ClassName: CategoryServiceImpl 
 * @Description: 频道二
 * @author:liAng
 * @date: 2019年11月24日 下午7:46:04
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryMapper categoryMapper;

	@Override
	public List<Category> listByChannelId(int chnId) {
		// TODO Auto-generated method stub
		return categoryMapper.listByChannelId(chnId);
	}

}
