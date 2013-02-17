package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Utilisateur database table.
 * 
 */
@Entity
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUtilisateur;

	private String identifiant;

	private String motPasse;

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

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
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