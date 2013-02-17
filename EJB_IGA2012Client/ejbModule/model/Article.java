package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Article database table.
 * 
 */
@Entity
@Table(name="Article")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idArticle;
	private String corps;
	private Timestamp miseAJour;
	private float prix;
	private Timestamp publication;
	private String resume;
	private String statut;
	private String titre;
	private List<Groupe> groupes;
	private Utilisateur utilisateurBean;
	private List<LigneCommande> ligneCommandes;
	private List<Tag> tags;

	public Article() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}


	@Lob
	@Column(nullable=false)
	public String getCorps() {
		return this.corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}


	@Column(nullable=false)
	public Timestamp getMiseAJour() {
		return this.miseAJour;
	}

	public void setMiseAJour(Timestamp miseAJour) {
		this.miseAJour = miseAJour;
	}


	@Column(nullable=false)
	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}


	@Column(nullable=false)
	public Timestamp getPublication() {
		return this.publication;
	}

	public void setPublication(Timestamp publication) {
		this.publication = publication;
	}


	@Lob
	@Column(nullable=false)
	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
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


	//bi-directional many-to-many association to Groupe
	@ManyToMany
	@JoinTable(
		name="ArtGro"
		, joinColumns={
			@JoinColumn(name="article", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="groupe", nullable=false)
			}
		)
	public List<Groupe> getGroupes() {
		return this.groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}


	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="utilisateur", nullable=false)
	public Utilisateur getUtilisateurBean() {
		return this.utilisateurBean;
	}

	public void setUtilisateurBean(Utilisateur utilisateurBean) {
		this.utilisateurBean = utilisateurBean;
	}


	//bi-directional many-to-one association to LigneCommande
	@OneToMany(mappedBy="articleBean")
	public List<LigneCommande> getLigneCommandes() {
		return this.ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}


	//bi-directional many-to-one association to Tag
	@OneToMany(mappedBy="articleBean")
	public List<Tag> getTags() {
		return this.tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}