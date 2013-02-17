package local;

import javax.ejb.Local;

import modelWithoutJPA.Utilisateur;

@Local
public interface GestionnaireUtilisateurLocal {
	/**
	 * Méthode permettant d'ajouter un utilisateur
	 * @param (Utilisateur) utilisateur : l'utilisateur à ajouter
	 */
	public void create(Utilisateur utilisateur, String motPasse);
	
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
	
	public Utilisateur find(long id);
	public Utilisateur connect(String identifiant, String motPasse);
}
