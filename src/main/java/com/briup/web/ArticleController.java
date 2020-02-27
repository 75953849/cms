package com.briup.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Article;
import com.briup.bean.Category;
import com.briup.service.IArticleService;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	
	@PutMapping("/saveOrUpdate")
	@ApiOperation("保存或更新一个文章")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="文章id",paramType="query",dataType="int"),
		@ApiImplicitParam(name="title",value="文章标题",paramType="query",dataType="string"),
		@ApiImplicitParam(name="author",value="文章作者",paramType="query",dataType="string"),
		@ApiImplicitParam(name="categoryId",value="栏目id",paramType="query",dataType="int")
	})
	public Message<String> saveOrUpdate(Integer id,String title,String author,String content,Integer categoryId){
		Message<String> message = null;
		try {
			Article article = new Article();
			article.setId(id);
			article.setTitle(title);
			article.setAuthor(author);
			article.setContent(content);
			article.setPublishDate(new Date());
			article.setClickTimes(0);
			Category category = new Category();
			category.setId(categoryId);
			article.setCategory(category);
			articleService.saveOrUpdate(article);
			message = MessageUtil.success("保存成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
	
	@GetMapping("/findById")
	@ApiOperation("根据id查询文章并且关联栏目信息")
	@ApiImplicitParam(name="id",value="文章id",paramType="query",dataType="int")
	public Message<Article> findById(int id){
		Message<Article> message = null;
		try {
			Article article = articleService.findById(id);
			message = MessageUtil.success(article);
		}catch (Exception e) {
			// TODO: handle exception
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
	@GetMapping("/findAll")
	@ApiOperation("查询所有的文章信息")
	public Message<List<Article>> findAll(){
		List<Article> articlelist = articleService.findAll();
		return MessageUtil.success(articlelist);
	}
	
	@DeleteMapping("/deleteById")
	@ApiOperation("根据id删除文章")
	public Message<String> deleteById(int id){
		Message<String> message = null;
		try {
			articleService.deleteById(id);
			message=MessageUtil.success("删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
	
	
}
