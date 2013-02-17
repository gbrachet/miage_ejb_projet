package gestionnaire;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import local.GestionnaireSessionLocal;
import modelWithoutJPA.Utilisateur;
import remote.GestionnaireSessionRemote;

/**
 * Session Bean implementation class GestionnaireSession
 */
@Stateful
@LocalBean
public class GestionnaireSession implements GestionnaireSessionRemote, GestionnaireSessionLocal {
	
	/* Attributs */
	
	private Utilisateur utilisateur;
	
	/* Constructeur */

	public GestionnaireSession() {
    }
   
	/* Get & Set */
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
