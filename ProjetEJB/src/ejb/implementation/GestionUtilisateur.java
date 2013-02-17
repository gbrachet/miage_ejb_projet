package ejb.implementation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Utilisateur;

/**
 * Session Bean implementation class GestionUtilisateur
 */
@Stateless(mappedName = "GestionUtilisateur")
@LocalBean
public class GestionUtilisateur implements GestionUtilisateurRemote, GestionUtilisateurLocal {

    /**
     * Default constructor. 	
     */
    public GestionUtilisateur() {
    }
    
	/* Attributs */

	@PersistenceContext
	private EntityManager em;
	
	/* Méthodes */
	
	@Override
	public void save(Utilisateur utilisateur) {
//		this.em.merge(utilisateur);
		
//		System.out.println(this.em.find(Utilisateur.class, 1));
//		System.out.println(this.em.createQuery("SELECT Utilisateur From Utilisateur").getResultList());
		
		
	}

}
