package gestionnaire;
import javax.ejb.Remote;

import model.Article;

@Remote
public interface GestionArticleRemote {
	/**
	 * Méthode permettant d'ajouter un article
	 * @param (Article) article : l'article à ajouter
	 */
	public void create(Article article);
	
	/**
	 * Méthode permettant de modifier un article
	 * @param (Article) article : l'article à modifier
	 */
	public void edit(Article article);
	
	/**
	 * Méthode permettant de supprimer un article
	 * @param (Article) article : l'article à supprimer
	 */
	public void delete(Article article);
	
	/**
	 * Méthode permettant de rechercher un article
	 * @param (long) id : l'identifiant de l'article
	 * @return (Article) l'article
	 */
	public Article find(long id);
	
	
}
