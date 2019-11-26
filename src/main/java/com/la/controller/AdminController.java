package com.la.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.la.beans.Article;
import com.la.beans.User;
import com.la.common.CmsAssert;
import com.la.common.MsgResult;
import com.la.service.ArticleService;
import com.la.service.UserService;

/**
 * 
 * @ClassName: AdminController 
 * @Description: 管理控制层
 * @author:liAng
 * @date: 2019年11月24日 下午7:43:40
 */
@Controller
@RequestMapping("admin")
public class AdminController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ArticleService  articleService;
	
	
	/**
	 * 
	 * @Title: index
	 * @Description: 管理员界面
	 * @return
	 * @return: String
	 */
	@RequestMapping("index")
	public String index() {
		return "admin/index";
	}
	
	/**
	 * 
	 * @Title: articles 
	 * @Description: 文章审核
	 * @param request
	 * @param status  -1 全部  0 待审核  1 审核通过  2 审核未通过
	 * @param page
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles")
	public String articles(HttpServletRequest request,
			@RequestParam(defaultValue="-1") int status,
			@RequestParam(defaultValue="1") Integer page) {
		
		PageInfo<Article> articlePage =  articleService.getPageList(status,page);
		request.setAttribute("pageInfo", articlePage);
		request.setAttribute("status", status);
		
		return "admin/article/list";
	}
	
	
	
	/**
	 * 
	 * @Title: users 
	 * @Description: 管理员中的用户页面
	 * @param request
	 * @param name
	 * @param page
	 * @return
	 * @return: String
	 */
	@RequestMapping("users")
	public String users(HttpServletRequest request,
			@RequestParam(defaultValue="") String name,
			@RequestParam(defaultValue="1") Integer page) {
		
		PageInfo<User> userPage =  userService.getPageList(name,page);
		request.setAttribute("info", userPage);
		request.setAttribute("name", name);
		
		return "admin/user/list";
	}
	
	/**
	 * 
	 * @Title: lock 
	 * @Description: 用户解禁或封禁用户
	 * @param userId
	 * @param status
	 * @return
	 * @return: MsgResult
	 */
	@RequestMapping("lockuser")
	@ResponseBody
	public MsgResult lock(Integer userId,int status) {

		if(status != 0 && status!=1) {
			return new MsgResult(2,"参数无效",null);
		}
		
		User user  = userService.getUserById(userId);

		if(user == null) {
			return new MsgResult(2,"该用户不存在",null);
		}
		
		if(user.getLocked()==status) {
			return new MsgResult(2,"无需做该操作",null);
		}
		
		int result = userService.updateStatus(userId,status);
		if(result>0) {
			return new MsgResult(1,"恭喜您，处理成功",null);
		}else{
			return new MsgResult(2,"非常抱歉，处理失败，请与管理员联系！",null);
		}
		
	}
	
	@RequestMapping("getArticle")
	@ResponseBody
	public MsgResult getArticle(int id) {
		Article article = articleService.getDetailById(id);
		CmsAssert.AssertTrue(article!=null, "文章不存在");
		return new MsgResult(1,"获取成功",article);
	}
	/**
	 * 
	 * @Title: applyArticle 
	 * @Description: 文章审核
	 * @param id
	 * @param status
	 * @return
	 * @return: MsgResult
	 */
	@RequestMapping("applyArticle")
	@ResponseBody
	public MsgResult applyArticle(int id,int status) {
		Article article = articleService.checkExist(id);
		CmsAssert.AssertTrue(article!=null, "该文已经不存在");
		int result = articleService.apply( id,status);
		if(result>0) {
			return new MsgResult(1,"处理成功",null);
		}else {
			return new MsgResult(2,"处理失败",null);
		}
	}
	
	/**
	 * 
	 * @Title: setArticleHot 
	 * @Description: 设置热门与否
	 * @param id
	 * @param status
	 * @return
	 * @return: MsgResult
	 */
	@RequestMapping("setArticleHot")
	@ResponseBody
	public MsgResult setArticleHot(int id,int status) {
		Article article = articleService.checkExist(id);
		CmsAssert.AssertTrue(article!=null, "该文已经不存在");
		int result = articleService.setHot( id,status);
		if(result>0) {
			return new MsgResult(1,"处理成功",null);
		}else {
			return new MsgResult(2,"处理失败",null);
		}
	}
}
