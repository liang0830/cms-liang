package com.la.beans;

import java.io.Serializable;

/**
 * 
 * @ClassName: Category 
 * @Description: 分类
 * @author:liAng
 * @date: 2019年11月24日 下午7:40:09
 */
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1723982065292768684L;
	

	private Integer id;
	
	private String name;
	
	/**
	 * 频道id
	 */
	private int channelId;
	
	/**
	 * 频道
	 */
	private Channel channel;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	
	

}
