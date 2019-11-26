package com.la.beans;

/**
 * 
 * @ClassName: Image 
 * @Description: 图片
 * @author:liAng
 * @date: 2019年11月24日 下午7:40:48
 */
public class Image {
	
	private String url;
	private String desc;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "Image [url=" + url + ", desc=" + desc + "]";
	}
	
	

}
