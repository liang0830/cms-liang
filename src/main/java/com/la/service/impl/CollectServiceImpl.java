package com.la.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.la.beans.Collect;
import com.la.mapper.CollectMapper;
import com.la.service.CollectService;

/**
 * 
 * @ClassName: CollectServiceImpl 
 * @Description: 收藏
 * @author:liAng
 * @date: 2019年11月24日 下午7:46:17
 */
@Service
public class CollectServiceImpl  implements CollectService{
	
	@Autowired
	CollectMapper collectMapper;

	@Override
	public int add(Collect collect) {
		// TODO Auto-generated method stub
		return collectMapper.add(collect);
		
	}

	@Override
	public PageInfo list(int userId,int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,10);
		return new PageInfo<Collect>(collectMapper.list(userId));
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return collectMapper.delete(id);
	}

	@Override
	public Collect get(int id) {
		// TODO Auto-generated method stub
		return collectMapper.get(id);
	}

	@Override
	public int update(Collect collect) {
		// TODO Auto-generated method stub
		return collectMapper.update(collect);
		
	}

}
