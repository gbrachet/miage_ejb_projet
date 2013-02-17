package ejb.implementation;

import javax.ejb.Remote;

import entity.Utilisateur;

@Remote
public interface GestionUtilisateurRemote {
	/**
	 * Méthode permettant d'ajouter/modifier un utilisateur
	 * @param (Utilisateur) utilisateur : l'utilisateur à ajouter/modifier
	 */
	public void save(Utilisateur utilisateur);
}
