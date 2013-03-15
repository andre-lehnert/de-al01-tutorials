package de.al01.tutorial.ear.restfulapp.ejb.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import de.al01.tutorial.ear.restfulapp.ejb.model.Article;
import de.al01.tutorial.ear.restfulapp.ejb.service.api.ArticleServiceRemote;

@Stateless
public class ArticleService implements ArticleServiceRemote 
{
  @PersistenceContext(unitName="RestfulAppEJB")
  EntityManager em;

  boolean initialized = false;
  
  public ArticleService() {}
  
  private void init()
  {
	  if (initialized == false)
	  {
		  System.out.println("\n---\n\t\t> ArticleService initialization...\n---");
		  
		  for (int i = 1; i <= 10; i++)
		  {
			  Article article = new Article();
				article.setId(i);
				article.setName("Article "+ i);
				
			    em.persist(article);
			    em.flush();
		  }
		  
		  System.out.println("\n---\n\t\t> ArticleService initialized\n---");
		  
		  initialized = true;
	  }
  }

  public Article createArticle(long id, String name) 
  {
	  	init();
		  
		Article article = new Article();
		article.setId(id);
		article.setName(name);
		
	    em.persist(article);
	    
	    article = findArticle(id);
	    
	    System.out.println("\n\t Inside createArticle() findArticle result: "+article);
	    em.flush();
	    
	    return article;
  }

  public void removeArticle(long id) {
	  
	  	init();
	  
       System.out.println("\n\t Inside removeArticle("+id+")");
       Article emp = findArticle(id);
       if (emp != null) {
          em.remove(emp);
       }
  }

  public Article findArticle(long id) {
	  
	  init();
	  
        System.out.println("\n\t Inside findArticle("+id+")");
        return em.find(Article.class, id);
  }

@SuppressWarnings("unchecked")
public List<Article> findAllArticles() {
	  
	init();
	
        System.out.println("\n\t Inside findAllArticles()");
        Query query = em.createQuery("SELECT e FROM Article e");
        
        return (List<Article>) query.getResultList();
  }

  public void doAction(){
  }


}
