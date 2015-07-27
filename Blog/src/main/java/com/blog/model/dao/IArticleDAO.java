package com.blog.model.dao;

import java.util.List;

import com.blog.model.Article;

public interface IArticleDAO {

	public void submitBlog(Article article);
	
	
	public List loadArticles();
	
	public void deleteBlog(Article article);
}
