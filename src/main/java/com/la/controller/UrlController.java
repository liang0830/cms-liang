package com.la.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.la.beans.Url;
/**
 * 
 * @ClassName: UrlController 
 * @Description: 
 * @author:liAng
 * @date: 2019年11月24日 下午7:45:33
 */
@RequestMapping("url")
@Controller
public class UrlController {
	/**
	 * 
	 * @Title: add 
	 * @Description: 跳转到添加
	 * @param request
	 * @return
	 * @return: String
	 */
	@GetMapping("add")
	public String add(HttpServletRequest request ) {
		request.setAttribute("url",new Url());
		return "url/add";
	}
	/**
	 * 
	 * @Title: add 
	 * @Description: 添加
	 * @param request
	 * @param url
	 * @param result
	 * @return
	 * @return: String
	 */
	@PostMapping("add")
	public String add(HttpServletRequest request, 
			@Validated @ModelAttribute("url") Url url,
			BindingResult result) {
		if(result.hasErrors()) {
			return "url/add";
		}
		
		return "url/list";
	}
}
