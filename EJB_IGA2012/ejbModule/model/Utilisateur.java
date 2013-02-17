package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Utilisateur database table.
 * 
 */
@Entity
@Table(name="Utilisateur")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idUtilisateur;
	private String identifiant;
	private String motPasse;
	private String statut;
	private List<Article> articles;
	private List<Commande> commandes;
	private List<UtiAbo> utiAbos;

	public Utilisateur() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}


	@Column(nullable=false, length=12)
	public String getIdentifiant() {
		return this.identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}


	@Column(nullable=false, length=32)
	public String getMotPasse() {
		return this.motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}


	@Column(nullable=false, length=1)
	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}


	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="utilisateurBean")
	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}


	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="utilisateurBean")
	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}


	//bi-directional many-to-one association to UtiAbo
	@OneToMany(mappedBy="utilisateurBean")
	public List<UtiAbo> getUtiAbos() {
		return this.utiAbos;
	}

	public void setUtiAbos(List<UtiAbo> utiAbos) {
		this.utiAbos = utiAbos;
	}

}