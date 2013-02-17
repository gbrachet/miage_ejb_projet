package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Groupe database table.
 * 
 */
@Entity
@Table(name="Groupe")
public class Groupe implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idGroupe;
	private float prix;
	private String statut;
	private String titre;
	private List<Article> articles;
	private List<LigneCommande> ligneCommandes;

	public Groupe() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdGroupe() {
		return this.idGroupe;
	}

	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}


	@Column(nullable=false)
	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}


	@Column(nullable=false, length=1)
	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}


	@Column(nullable=false, length=32)
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}


	//bi-directional many-to-many association to Article
	@ManyToMany(mappedBy="groupes")
	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}


	//bi-directional many-to-one association to LigneCommande
	@OneToMany(mappedBy="groupeBean")
	public List<LigneCommande> getLigneCommandes() {
		return this.ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

}