package com.blog.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.blog.model.Article;
import com.blog.model.service.ArticleService;
import com.blog.model.service.IArticleService;



@ManagedBean
@SessionScoped
public class ArticleController {
	
	@ManagedProperty(value="#{ArticleService}")
	IArticleService articleService = new ArticleService();
	
	
	private List<Article> articleList = new ArrayList<Article>();
	
	private String blog_content;
	
	private String blog_title;
	
	private Article currentArticle;

	public String addBlog() {
		
		
		return "createBlog";
	}
	
	public String submitBlog() {
		Article article = new Article();
		article.setContent(blog_content);
		article.setTitle(blog_title);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		article.setUpdatedate(ts);
		articleService.saveArticle(article);
		return "index";
	}

	public String getBlog_content() {
		return blog_content;
	}

	public void setBlog_content(String blog_content) {
		this.blog_content = blog_content;
	}

	public IArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	
	@PostConstruct
	public void loadArticles() {
		
		articleList = articleService.loadArticles();
		
		
	}

	public String getBlog_title() {
		return blog_title;
	}

	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}

	public Article getCurrentArticle() {
		return currentArticle;
	}

	public void setCurrentArticle(Article currentArticle) {
		this.currentArticle = currentArticle;
	}

	public void showArticle(ActionEvent event) {
		
		this.currentArticle = (Article)event.getComponent().getAttributes().get("article");
		
		
	}
	
	
	public String editBlog() {
		
		
		return "edit";
	}
	
	public String updateBlog() {
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		currentArticle.setUpdatedate(ts);
		articleService.saveArticle(currentArticle);
		return "index";		
		
	}
	
	public String deleteBlog() {
		

		articleService.deleteArticle(currentArticle);
		loadArticles();
		return "index?faces-redirect=true";		
		
	}
}
