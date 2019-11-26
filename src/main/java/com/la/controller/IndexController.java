package com.la.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.la.beans.Article;
import com.la.beans.Category;
import com.la.beans.Channel;
import com.la.beans.Link;
import com.la.service.ArticleService;
import com.la.service.CategoryService;
import com.la.service.ChannelService;
import com.la.service.LinkService;
/**
 * 
 * @ClassName: IndexController 
 * @Description: 文章
 * @author:liAng
 * @date: 2019年11月26日 上午8:14:11
 */
@Controller
public class IndexController {

	/**
	 * 注入频道
	 */
	@Autowired
	private ChannelService channelService;
	
	
	@Autowired
	private CategoryService categoryService;
	
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private LinkService linkService;

	
	/**
	 * 
	 * @param request
	 * @param chnId  频道id
	 * @param page  文章页码
	 * @return
	 */
	@RequestMapping( "channel")
	public String channel(HttpServletRequest request, 
			@RequestParam(defaultValue = "1") int chnId,
			@RequestParam(defaultValue = "0") int categoryId,
			@RequestParam(defaultValue = "1") int page) {
		
		
		// 回传参数数值
		request.setAttribute("chnId", chnId);
		request.setAttribute("categoryId", categoryId);
		
		//获取所有的频道
		List<Channel> channels = channelService.list();
		request.setAttribute("channels", channels);
		
		// 获取这个频道下的所有的分类
		List<Category> categories =  categoryService.listByChannelId(chnId);
		request.setAttribute("categories", categories);
		
		PageInfo<Article> articles=  articleService.listByCat(chnId,categoryId,page);
		request.setAttribute("articles", articles);
		
		
		
		return "channelindex";
	
	}
	
	
		
	/**
	 * 
	 * @Title: index 
	 * @Description: 文章列表
	 * @param request
	 * @param reponse
	 * @param page
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = { "index", "/" })
	public String index(HttpServletRequest request,HttpServletResponse reponse, @RequestParam(defaultValue = "1") int page) {

		//获取所有的频道
		List<Channel> channels = channelService.list();
		request.setAttribute("channels", channels);
		
		PageInfo<Article> hotList = articleService.hotList(page);
		
		List<Article> newArticles = articleService.getNewArticles(5);
		
		// 获取最新图片文章
		List<Article> imgArticles = articleService.getImgArticles(10);
		
		// 友情链接
		PageInfo<Link> info=  linkService.list(1);
		List<Link> linkList =  info.getList();

		request.setAttribute("hotList", hotList);
		request.setAttribute("newArticles", newArticles);
		
		request.setAttribute("imgArticles", imgArticles);
		
		request.setAttribute("linkList", linkList);
		
		return "index";
	}

}
