package gestionnaire;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Utilisateur;

@Stateless
public class GestionUtilisateur implements GestionUtilisateurRemote {
	
	/* Attributs */

	@PersistenceContext
	private EntityManager em; 
	
	/* Méthodes */
	
	@Override
	public void create(Utilisateur utilisateur) {
		this.em.persist(utilisateur);
	}
	
	@Override
	public void edit(Utilisateur utilisateur) {
		this.em.merge(utilisateur);
	}
	
	@Override
	public void delete(Utilisateur utilisateur) {
		this.em.remove(this.em.merge(utilisateur));
	}
	
	@Override
	public Utilisateur find(long id) {
		return this.em.find(Utilisateur.class, id);
	}
	
	@Override
	public Utilisateur connection(String identifiant, String motPasse) {
		Query requete = this.em.createNamedQuery("connect");
		requete.setParameter("identifiant", identifiant);
		requete.setParameter("motPasse", motPasse);
		return (Utilisateur) requete.getSingleResult();
	}
	
	
}
