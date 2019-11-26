package com.la.beans;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

/**
 * 
 * @ClassName: Collect 
 * @Description: 收藏
 * @author:liAng
 * @date: 2019年11月24日 下午7:40:32
 */

public class Collect {
	
 private int	id;
 
 private int	userId;
 
 @Length(min=2,max=128)
 private String url;
 
 @Length(min=2,max=30)
 private String name;
 
 private Date created;
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
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
