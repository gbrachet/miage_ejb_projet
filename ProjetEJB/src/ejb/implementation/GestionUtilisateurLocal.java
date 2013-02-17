package ejb.implementation;

import javax.ejb.Local;

import entity.Utilisateur;

@Local
public interface GestionUtilisateurLocal {
	/**
	 * Méthode permettant d'ajouter/modifier un utilisateur
	 * @param (Utilisateur) utilisateur : l'utilisateur à ajouter/modifier
	 */
	public void save(Utilisateur utilisateur);
}
