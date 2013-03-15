package de.al01.tutorial.ear.restfulapp.war.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.al01.tutorial.ear.restfulapp.ejb.model.Article;
import de.al01.tutorial.ear.restfulapp.ejb.service.api.ArticleServiceRemote;
import de.al01.tutorial.ear.restfulapp.war.repository.ArticleRepository;

@Stateless
public class ArticleRepositoryBean implements ArticleRepository {
 	
	@EJB(lookup="java:global/RestfulAppEAR/RestfulAppEJB/ArticleService!de.al01.tutorial.ear.restfulapp.ejb.service.api.ArticleServiceRemote")
	ArticleServiceRemote bean;	
	
    @Override
    public List<Article> all() {
    	
    	List<Article> books = new ArrayList<Article>();
    	
    	try { 
			
			books = bean.findAllArticles();    		
    		
			Article a = bean.createArticle(100, "REM");
			
			bean.removeArticle(a.getId());
			
    	} catch (Exception e) {
			e.printStackTrace();
		}		
    	
    	
    	return books;
    }
 
}