package remote;

import javax.ejb.Remote;
import modelWithoutJPA.*;


@Remote
public interface GestionnaireUtilisateurRemote {
	/**
	 * Méthode permettant d'ajouter un utilisateur
	 * @param (Utilisateur) utilisateur : l'utilisateur à ajouter
	 */
	public void create(Utilisateur utilisateur);
	
	/**
	 * Méthode permettant de modifier un utilisateur
	 * @param (Utilisateur) utilisateur : l'utilisateur à modifier
	 */
	public void edit(Utilisateur utilisateur);
	
	/**
	 * Méthode permettant de supprimer un utilisateur
	 * @param (Utilisateur) utilisateur : l'utilisateur à supprimer
	 */
	public void delete(Utilisateur utilisateur);
	
	/**
	 * Méthode permettant de rechercher un utilisateur
	 * @param (long) id : l'identifiant de l'utilisateur
	 * @return (Utilisateur) l'utilisateur
	 */
	public Utilisateur find(long id);
}
