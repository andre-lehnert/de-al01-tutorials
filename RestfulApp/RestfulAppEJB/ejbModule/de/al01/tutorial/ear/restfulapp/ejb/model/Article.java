package de.al01.tutorial.ear.restfulapp.ejb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Article implements Serializable 
{
	private static final long serialVersionUID = 1L;
	

	public Article() {
		System.out.println("Article created!");
	}
	
	public Article(long id, String name) 
	{
		this.id = id;
		this.name = name;
		System.out.println("Article created!");
	}
	
	@Id
	private long id;
	
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
