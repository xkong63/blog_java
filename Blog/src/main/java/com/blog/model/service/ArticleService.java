package com.blog.model.service;

import com.blog.model.dao.IArticleDAO;

public class ArticleService implements IArticleService{

	IArticleDAO articleDAO;

	public IArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(IArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	
	
}
