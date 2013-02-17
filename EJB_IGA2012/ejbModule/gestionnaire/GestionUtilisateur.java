package gestionnaire;

import javax.ejb.Stateless;

import model.Utilisateur;

@Stateless
public class GestionUtilisateur implements GestionUtilisateurRemote{
	
	/* Attributs */

//	@PersistenceContext
//	private EntityManager em; 
	
	/* Méthodes */
	
	@Override
	public void create(Utilisateur utilisateur) {
//		this.em.persist(utilisateur);
	}
	
	@Override
	public void edit(Utilisateur utilisateur) {
//		this.em.merge(utilisateur);
	}
	
	@Override
	public void delete(Utilisateur utilisateur) {
//		this.em.remove(this.em.merge(utilisateur));
	}
	
	@Override
	public Utilisateur find(long id) {
//		return this.em.find(Utilisateur.class, id);
		return null;
	}
}

