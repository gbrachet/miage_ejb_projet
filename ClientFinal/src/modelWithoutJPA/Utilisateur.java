package modelWithoutJPA;

public class Utilisateur {
	//attributs 	idUtilisateur	identifiant	motPasse	statut
	private long idUtilisateur;
	private String identifiant;
	private String statut;
	
	//constructeur
	public Utilisateur(long idUtilisateur, String identifiant, String statut) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.identifiant = identifiant;
		this.statut = statut;
	}
	
	public Utilisateur() {
	}
	
	
	
	public long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
}
