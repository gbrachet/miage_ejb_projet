package com.projet.local;

import java.util.List;

import javax.ejb.Local;

import com.projet.entity.Article;

/**
 * Interface décrivant les opérations possibles sur un article
 */
@Local
public interface GestionArticle {
	/**
	 * Méthode permettant d'ajouter un article
	 * @param (Article) article : l'article à ajouter
	 */
	public void save(Article article);
	
	/**
	 * Méthode permettant de supprimer un article
	 * @param (Article) article : l'article à supprimer
	 */
	public void delete(Article article);
	
	/**
	 * Méthode permettant de rechercher un article à partir de son identifiant
	 * @param (int) id : l'identifiant de l'article
	 */
	public Article findById(int id);
	
	/**
	 * Méthode permettant de récupérer tout les articles
	 * @return (List<Article) la liste des articles
	 */
	public List<Article> findAll();
}
