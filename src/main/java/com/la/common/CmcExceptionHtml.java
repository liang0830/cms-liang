package com.la.common;

/** 
 * 
 * @ClassName: CmcExceptionHtml 
 * @Description: 抛出异常  异常在html页面显示
 * @author:liAng
 * @date: 2019年11月24日 下午7:42:06
 */
public class CmcExceptionHtml extends RuntimeException {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 版本号
	 */
	private static final long serialVersionUID = -6762629250308786819L;

	
	public CmcExceptionHtml(String msg) {
		super(msg);
	}

}
