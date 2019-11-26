package com.la.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.la.beans.Article;
import com.la.beans.Category;
import com.la.beans.Comment;
import com.la.beans.Image;
import com.la.beans.TypeEnum;
import com.la.common.CmsAssert;
import com.la.common.MsgResult;
import com.la.service.ArticleService;
import com.la.service.CategoryService;

/**
 * 
 * @ClassName: ArticleController 
 * @Description: TODO
 * @author:liAng
 * @date: 2019年11月24日 下午7:44:39
 */
@RequestMapping("article")
@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CategoryService catService; 
	
	@RequestMapping("showdetail")
	public String showDetail(HttpServletRequest request,Integer id) {
		
		Article article = articleService.getById(id); 
		CmsAssert.AssertTrueHtml(article!=null, "文章不存在");
		
		
		request.setAttribute("article",article);
		if(article.getArticleType()==TypeEnum.HTML)
			return "article/detail";
		else {
			Gson gson = new Gson();
			// 文章内容转换成集合对象
			List<Image> imgs = gson.fromJson(article.getContent(), List.class);
			article.setImgList(imgs);
			return "article/detailimg";
		}
		
	}
	

	@RequestMapping("getCategoryByChannel")
	@ResponseBody
	public MsgResult getCategoryByChannel(int chnId) { 
		List<Category> categories = catService.listByChannelId(chnId);
		return new MsgResult(1, "",  categories);
		
	}
	
	@RequestMapping("commentlist")
	public String commentlist(HttpServletRequest request, int id,
			@RequestParam(defaultValue="1") int page) {
		
		PageInfo<Comment> pageComment =  articleService.commentlist(id,page);
		request.setAttribute("pageComment", pageComment);
		return "article/comments";
	}
	
}
