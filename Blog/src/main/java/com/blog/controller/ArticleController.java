package com.blog.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



@ManagedBean
@RequestScoped
public class ArticleController {

	public String addBlog() {
		
		
		return "home";
	}
	
	
}
