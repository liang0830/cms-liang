package com.la.common;

import java.io.Serializable;

/**
 * 
 * @ClassName: MsgResult 
 * @Description: 用于前后端交互的协议
 * @author:liAng
 * @date: 2019年11月24日 下午7:43:07
 */
public class MsgResult implements Serializable {
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 版本号
	 */
	private static final long serialVersionUID = -2294939295941040992L;
	
	int result;
	String errorMsg;
	Object data;
	
	public MsgResult() {
		
	}
	
	public MsgResult(int result, String errorMsg, Object data) {
		super();
		this.result = result;
		this.errorMsg = errorMsg;
		this.data = data;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	
}
