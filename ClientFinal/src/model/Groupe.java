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

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idGroupe;

	@Column(nullable=false)
	private float prix;

	@Column(nullable=false, length=1)
	private String statut;

	@Column(nullable=false, length=32)
	private String titre;

	//bi-directional many-to-many association to Article
	@ManyToMany(mappedBy="groupes")
	private List<Article> articles;

	//bi-directional many-to-one association to LigneCommande
	@OneToMany(mappedBy="groupeBean")
	private List<LigneCommande> ligneCommandes;

	public Groupe() {
	}

	public int getIdGroupe() {
		return this.idGroupe;
	}

	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}

	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<LigneCommande> getLigneCommandes() {
		return this.ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

}