package com.blog.model.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.blog.model.Article;
import com.blog.model.dao.IArticleDAO;

public interface IArticleService {

	public IArticleDAO getArticleDAO();

	public void setArticleDAO(IArticleDAO articleDAO);
	

	
	public boolean saveArticle(Article article);
	
	public List loadArticles();
}
