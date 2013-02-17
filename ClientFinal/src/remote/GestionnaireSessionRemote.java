package remote;

import javax.ejb.Remote;

import modelWithoutJPA.Utilisateur;

@Remote
public interface GestionnaireSessionRemote {
	public Utilisateur getUtilisateur();
	public void setUtilisateur(Utilisateur utilisateur);
}
