package com.projet.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.projet.entity.Article;
import com.projet.local.GestionArticle;

/**
 * Implémentation du gestionnaire d'article
 */
@Stateless(name="GestionArticle")
public class GestionArticleBean implements GestionArticle {

	/* Attributs */

	@PersistenceContext
	private EntityManager em;

	/* Méthodes */

	@Override
	public void save(Article article) {
		em.merge(article);
	}

	@Override
	public void delete(Article article) {
		em.remove(em.merge(article));
	}

	@Override
	public Article findById(int id) {
		return em.find(Article.class, id);
	}
	
	@Override
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
