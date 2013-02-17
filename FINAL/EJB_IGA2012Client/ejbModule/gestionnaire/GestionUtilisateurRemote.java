package gestionnaire;
import javax.ejb.Remote;

import model.Utilisateur;

@Remote
public interface GestionUtilisateurRemote {
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
	
	/**
	 * Méthode permettant de connecter un utilisateur
	 * @param (String) identifiant
	 * @param (String) motPasse
	 * @return (Utilisateur)
	 */
	public Utilisateur connection(String identifiant, String motPasse);
	
}
