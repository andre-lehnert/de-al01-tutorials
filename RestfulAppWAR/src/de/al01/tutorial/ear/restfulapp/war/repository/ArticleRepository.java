package de.al01.tutorial.ear.restfulapp.war.repository;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.al01.tutorial.ear.restfulapp.ejb.model.Article;
 
@Path("article")
public interface ArticleRepository {
 
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    List<Article> all();
}
