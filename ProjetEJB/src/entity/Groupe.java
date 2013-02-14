package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Groupe database table.
 * 
 */
@Entity
public class Groupe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idGroupe;

	private float prix;

	private String statut;

	private String titre;

	//bi-directional many-to-many association to Article
	@ManyToMany
	@JoinTable(
		name="ArtGro"
		, joinColumns={
			@JoinColumn(name="groupe")
			}
		, inverseJoinColumns={
			@JoinColumn(name="article")
			}
		)
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