package local;

import javax.ejb.Local;

import modelWithoutJPA.Utilisateur;

@Local
public interface GestionnaireSessionLocal {
	public Utilisateur getUtilisateur();
	public void setUtilisateur(Utilisateur utilisateur);
}
