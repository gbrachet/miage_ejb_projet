package gestionnaire;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import local.GestionnaireUtilisateurLocal;
import model.Utilisateur;
import remote.GestionnaireUtilisateurRemote;

/**
 * Session Bean implementation class GestionnaireUtilisateur
 */
@Stateless
@LocalBean
public class GestionnaireUtilisateur implements GestionnaireUtilisateurLocal, GestionnaireUtilisateurRemote {

	/* Attributs */
	
	/* Constructeur */
    
	public GestionnaireUtilisateur() {
    }
	
	/* Méthodes */
	
	@Override
	public void create(Utilisateur utilisateur) {
		Mysql.queryI(
			"INSERT INTO `Utilisateur`(`idUtilisateur`, `identifiant`, `motPasse`, `statut`) " +
			"VALUES (NULL,'"+utilisateur.getIdentifiant()+"','"+utilisateur.getMotPasse()+"','"+utilisateur.getStatut()+"')"
		);
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
