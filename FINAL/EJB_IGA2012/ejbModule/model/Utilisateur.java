package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the Utilisateur database table.
 */
@Entity
@Table(name="Utilisateur")
@NamedQueries(
	@NamedQuery(name="connect", query="SELECT OBJECT(uti) FROM Utilisateur uti WHERE uti.identifiant = :identifiant AND uti.motPasse = :motPasse")
)
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = -1944784603925949679L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUtilisateur")
	private long idUtilisateur;

	@Column(name="identifiant")
	private String identifiant;

	@Column(name="motPasse")
	private String motPasse;

	@Column(name="statut")
	private String statut;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="utilisateurBean")
	private List<Article> articles;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="utilisateurBean")
	private List<Commande> commandes;

	//bi-directional many-to-one association to UtiAbo
	@OneToMany(mappedBy="utilisateurBean")
	private List<UtiAbo> utiAbos;

	public Utilisateur() {
	}

	public long getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getIdentifiant() {
		return this.identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotPasse() {
		return this.motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public List<UtiAbo> getUtiAbos() {
		return this.utiAbos;
	}

	public void setUtiAbos(List<UtiAbo> utiAbos) {
		this.utiAbos = utiAbos;
	}
}