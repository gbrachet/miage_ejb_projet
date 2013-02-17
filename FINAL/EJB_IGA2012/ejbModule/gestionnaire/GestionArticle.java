package gestionnaire;

import gestionnaire.GestionArticleLocal;
import gestionnaire.GestionArticleRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Article;

@Stateless
public class GestionArticle implements GestionArticleLocal, GestionArticleRemote {
	
	/* Attributs */

	@PersistenceContext
	private EntityManager em; 
	
	/* Méthodes */
	
	@Override
	public void create(Article article) {
		this.em.persist(article);
	}
	
	@Override
	public void edit(Article article) {
		this.em.merge(article);
	}
	
	@Override
	public void delete(Article article) {
		this.em.remove(this.em.merge(article));
	}
	
	@Override
	public Article find(long id) {
		return this.em.find(Article.class, id);
	}
}
