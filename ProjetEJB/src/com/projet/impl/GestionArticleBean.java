package com.projet.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Article;

/**
 * Implémentation du gestionnaire d'article
 */
@Stateless(name="GestionArticle")
public class GestionArticleBean {

	/* Attributs */

	@PersistenceContext
	private EntityManager em;

	/* Méthodes */

	public void save(Article article) {
		em.merge(article);
	}

	public void delete(Article article) {
		em.remove(em.merge(article));
	}

	public Article findById(int id) {
		System.out.println(em);
		return em.find(Article.class, id);
	}
	
	public List<Article> findAll() {
		//Instanciation
		List<Article> result = new ArrayList<Article>();
		
		//Parcours du résultat de la requête
		for(Object current : em.createQuery("SELECT object(a) FROM Article AS a").getResultList()){
			//Ajout à la valeur de retour
			result.add((Article) current);
		}
		
		return result;
	}
}
