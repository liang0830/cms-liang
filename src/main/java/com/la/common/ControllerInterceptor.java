package com.la.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @ClassName: ControllerInterceptor 
 * @Description: TODO
 * @author:liAng
 * @date: 2019年11月24日 下午7:42:48
 */
@ControllerAdvice
public class ControllerInterceptor {
	
	@ExceptionHandler(CmcException.class)
	@ResponseBody
	public MsgResult  interceptorException(CmcException excetion) {
		System.out.println(" 错误是 "  + excetion);
		return new MsgResult(100,excetion.getMessage(),null);
	}	
	
	@ExceptionHandler(CmcExceptionHtml.class)
	public ModelAndView  interceptorExceptionHtml(CmcExceptionHtml excetion) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");// 跳转到jsp
		modelAndView.addObject("errorInfo", excetion.getMessage());
		return modelAndView;
	
	}
}
