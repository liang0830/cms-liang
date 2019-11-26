package com.la.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.la.beans.Link;
import com.la.common.MsgResult;
import com.la.service.LinkService;
import com.la.utils.StringUtils;


/**
 * 
 * @ClassName: LinkController 
 * @Description: 友情链接
 * @author:liAng
 * @date: 2019年11月24日 下午7:45:23
 */
@Controller
@RequestMapping("link")
public class LinkController {
	
	@Autowired
	private LinkService linkService;
	
	/**
	 * 
	 * @Title: list 
	 * @Description: 友情链接列表
	 * @param request
	 * @param page
	 * @return
	 * @return: String
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request, 
			@RequestParam(defaultValue="1") int page) {
		
		PageInfo info = linkService.list(page);
		request.setAttribute("info", info);
		return "admin/link/list";

	}
	
	/**
	 * 
	 * @Title: add 
	 * @Description: 跳转到添加
	 * @param request
	 * @return
	 * @return: String
	 */
	@GetMapping("add")
	public String add(HttpServletRequest request) {
		request.setAttribute("link", new Link());
		return "admin/link/add";	 
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 跳转到修改
	 * @param request
	 * @param id
	 * @return
	 * @return: String
	 */
	@GetMapping("update")
	public String update(HttpServletRequest request,int id) {
		request.setAttribute("link", linkService.get(id));
		return "admin/link/update";	 
	}
	
	/**
	 * 
	 * @Title: delete 
	 * @Description: 友情链接删除
	 * @param request
	 * @param id
	 * @return
	 * @return: MsgResult
	 */
	@RequestMapping("delete")
	@ResponseBody
	public MsgResult delete(HttpServletRequest request,int id) {
		int result = linkService.delete(id);
		if(result<1)
			return new MsgResult(2,"删除失败",null);
		
		return new MsgResult(1,"删除失败",null);
		
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 友情链接修改
	 * @param request
	 * @param link
	 * @param result
	 * @return
	 * @return: String
	 */
	@PostMapping("update")
	public String update(HttpServletRequest request,
			@Valid  @ModelAttribute("link") Link link,
			BindingResult result
			) {
		
		if(!StringUtils.isHttpUrl(link.getUrl())) {
			result.rejectValue("url", "不是合法的url", "不是合法的url");
		}
		
		// 有错误 还在原来的页面
		if(result.hasErrors()) {
			//request.setAttribute("link", link);
			return "admin/link/update";	
		}
		
		linkService.update(link);
		
		// 没有错误跳转到列表页面
		return "redirect:list";
	}
	
	
	/**
	 * 
	 * @Title: add 
	 * @Description: 友情链接添加
	 * @param request
	 * @param link
	 * @param result
	 * @return
	 * @return: String
	 */
	@PostMapping("add")
	public String add(HttpServletRequest request,
			@Valid  @ModelAttribute("link") Link link,
			BindingResult result
			) {
		
		if(!StringUtils.isHttpUrl(link.getUrl())) {
			result.rejectValue("url", "不是合法的url", "不是合法的url");
		}
		
		// 有错误 还在原来的页面
		if(result.hasErrors()) {
			
			request.setAttribute("link", link);
			return "admin/link/add";	
		}
		linkService.add(link);
		
		// 没有错误跳转到列表页面
		return "redirect:list";
	}
	
	

}
