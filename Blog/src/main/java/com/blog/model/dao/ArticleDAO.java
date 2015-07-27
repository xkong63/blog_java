package com.blog.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.model.Article;


@Repository("articleDAO")
@Transactional
public class ArticleDAO implements IArticleDAO{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void submitBlog(Article article) {
		
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().saveOrUpdate(article);
		tx.commit();
		sessionFactory.getCurrentSession().close();
	}
	
	public List loadArticles() {
		
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		List list = sessionFactory.getCurrentSession().createCriteria(Article.class).list();
		sessionFactory.getCurrentSession().close();
		return list;
		
		
	}

	@Override
	public void deleteBlog(Article article) {
		// TODO Auto-generated method stub
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(article);
		tx.commit();
		sessionFactory.getCurrentSession().close();		
	}
	
	
}
