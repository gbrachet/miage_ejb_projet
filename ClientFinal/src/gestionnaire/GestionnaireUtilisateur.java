package gestionnaire;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import local.GestionnaireUtilisateurLocal;
import modelWithoutJPA.Utilisateur;
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
	public void create(Utilisateur utilisateur, String motPasse) {
		Mysql.queryI(
			"INSERT INTO `Utilisateur`(`idUtilisateur`, `identifiant`, `motPasse`, `statut`) " +
			"VALUES (NULL,'"+utilisateur.getIdentifiant()+"','"+motPasse+"','"+utilisateur.getStatut()+"')"
		);
	}
	
	@Override
	public void edit(Utilisateur utilisateur) {
		//TODO UseLess?
	}
	
	@Override
	public void delete(Utilisateur utilisateur) {
		Mysql.queryI("DELETE FROM `Utilisateur` WHERE `idUtilisateur` = '"+utilisateur.getIdUtilisateur()+"' LIMIT 1')");
	}
	
	public Utilisateur find(long id){
		Utilisateur retour = null;
		ResultSet result = Mysql.query("SELECT * FROM `Utilisateur` WHERE `idUtilisateur` = '"+id+"' LIMIT 1");
		if(result != null){
			try {
				while(result.next()){
					retour = new Utilisateur(result.getLong("idIdentifiant"), result.getString("identifiant"), result.getString("statut"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retour;
	}
	
	@Override
	public Utilisateur connect(String identifiant, String motPasse) {
		Utilisateur retour = null;
		ResultSet result = Mysql.query("SELECT * FROM `Utilisateur` WHERE `identifiant` = '"+identifiant+"' AND `motPasse` = '"+motPasse+"' LIMIT 1");
		if(result != null){
			try {
				while(result.next()){
					retour = new Utilisateur(result.getLong("idUtilisateur"), result.getString("identifiant"), result.getString("statut"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retour;
	}
    
    

}
