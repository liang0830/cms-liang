package com.la.beans;

import java.util.Date;

/**
 * 
 * @ClassName: Comment 
 * @Description: 评论
 * @author:liAng
 * @date: 2019年11月24日 下午7:40:40
 */
public class Comment {
	
	private int id;
	private int articleId;
	private int userId;
	private String content;
	private Date created;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	

}
