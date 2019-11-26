package com.la.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.la.beans.Channel;
import com.la.mapper.ChannelMapper;
import com.la.service.ChannelService;

/**
 * 
 * @ClassName: ChannelServiceImpl 
 * @Description: 频道一
 * @author:liAng
 * @date: 2019年11月24日 下午7:46:12
 */
@Service
public class ChannelServiceImpl  implements ChannelService{
	
	@Autowired
	ChannelMapper channelMapper;

	@Override
	public List<Channel> list() {
		// TODO Auto-generated method stub
		return channelMapper.list();
	}

}
