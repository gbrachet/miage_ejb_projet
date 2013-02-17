package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LigneCommande database table.
 * 
 */
@Entity
@Table(name="LigneCommande")
public class LigneCommande implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idLigneCommande;
	private float prix;
	private Article articleBean;
	private Commande commandeBean;
	private Groupe groupeBean;

	public LigneCommande() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdLigneCommande() {
		return this.idLigneCommande;
	}

	public void setIdLigneCommande(int idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}


	@Column(nullable=false)
	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}


	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="article")
	public Article getArticleBean() {
		return this.articleBean;
	}

	public void setArticleBean(Article articleBean) {
		this.articleBean = articleBean;
	}


	//bi-directional many-to-one association to Commande
	@ManyToOne
	@JoinColumn(name="commande", nullable=false)
	public Commande getCommandeBean() {
		return this.commandeBean;
	}

	public void setCommandeBean(Commande commandeBean) {
		this.commandeBean = commandeBean;
	}


	//bi-directional many-to-one association to Groupe
	@ManyToOne
	@JoinColumn(name="groupe")
	public Groupe getGroupeBean() {
		return this.groupeBean;
	}

	public void setGroupeBean(Groupe groupeBean) {
		this.groupeBean = groupeBean;
	}

}