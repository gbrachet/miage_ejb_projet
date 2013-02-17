package modelWithoutJPA;

public class Article {
	//attribut idArticle	titre	resume	corps	statut	publication	miseAJour	utilisateur	prix
	private int idArticle;
	private String titre;
	private String resume;
	private String corp;
	private String statut;
	private String publication;
	private String MiseAJour;
	private Utilisateur utilisateur;
	private double prix;
	
	//constructeur
	public Article(int idArticle, String titre, String resume, String corp, String statut, String publication, String miseAJour, Utilisateur utilisateur, double prix) {
		super();
		this.idArticle = idArticle;
		this.titre = titre;
		this.resume = resume;
		this.corp = corp;
		this.statut = statut;
		this.publication = publication;
		MiseAJour = miseAJour;
		this.utilisateur = utilisateur;
		this.prix = prix;
	}
	
	
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getCorp() {
		return corp;
	}
	public void setCorp(String corp) {
		this.corp = corp;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public String getMiseAJour() {
		return MiseAJour;
	}
	public void setMiseAJour(String miseAJour) {
		MiseAJour = miseAJour;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	
}
