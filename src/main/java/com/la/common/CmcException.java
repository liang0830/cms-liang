package com.la.common;

public class CmcException extends RuntimeException {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 版本号
	 */
	private static final long serialVersionUID = 6877553253073480792L;

	public CmcException(String msg) {
		super(msg);
	}

}
