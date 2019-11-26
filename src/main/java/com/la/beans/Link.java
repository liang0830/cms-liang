package com.la.beans;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
/**
 * 
 * @ClassName: Link 
 * @Description: 收藏
 * @author:liAng
 * @date: 2019年11月24日 下午7:40:57
 */
public class Link {
	
	private int  id;
	
	@Length(max=255,min=5,message="长度超出范围")
	//@URL
	private String url;
	
	@Length(max=10,min=2)
	private String name;
	
	private Date created;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

}
