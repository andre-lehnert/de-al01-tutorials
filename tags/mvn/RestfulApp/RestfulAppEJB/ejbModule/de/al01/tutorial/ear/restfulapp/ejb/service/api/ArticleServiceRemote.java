package de.al01.tutorial.ear.restfulapp.ejb.service.api;

import java.util.List;

import javax.ejb.Remote;

import de.al01.tutorial.ear.restfulapp.ejb.model.Article;

@Remote
public interface ArticleServiceRemote
{
	public void doAction();
	  public Article createArticle(long id, String name);
	  public void removeArticle(long id);
	  public Article findArticle(long id);
	  public List<Article> findAllArticles() ;
}