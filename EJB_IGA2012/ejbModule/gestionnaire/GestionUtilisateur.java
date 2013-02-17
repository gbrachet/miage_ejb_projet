package gestionnaire;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Utilisateur;

@Stateless
public class GestionUtilisateur implements GestionUtilisateurRemote{
	
	/* Méthodes */
	
	@Override
	public void create(Utilisateur utilisateur) {
	}
	
	@Override
	public void edit(Utilisateur utilisateur) {
	}
	
	@Override
	public void delete(Utilisateur utilisateur) {
	}
	
	@Override
	public Utilisateur find(long id) {
		return null;
	}
}

