package com.blog.model.service;

import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.blog.model.Article;
import com.blog.model.dao.IArticleDAO;

@Transactional(readOnly = true)
public class ArticleService implements IArticleService{

	
	@ManagedProperty("#{ArticleDAO}")
	IArticleDAO articleDAO;

	public IArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(IArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	

	@Transactional(readOnly = false)
	public boolean saveArticle(Article article) {
		
		articleDAO.submitBlog(article);
		return true;
		
	}
	
	public List loadArticles() {
		
		
		return articleDAO.loadArticles();
		
	}

	@Override
	@Transactional(readOnly = false)
	public boolean updateArticle(Article article) {
		// TODO Auto-generated method stub
		articleDAO.submitBlog(article);
		return true;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteArticle(Article article) {
		// TODO Auto-generated method stub
		articleDAO.deleteBlog(article);
		return true;
	}
	
	
}
