package com.la.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.la.beans.Channel;

public interface ChannelMapper {

	@Select("SELECT * FROM cms_channel ORDER BY id")
	public List<Channel> list();

}
