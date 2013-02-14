package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LigneCommande database table.
 * 
 */
@Entity
public class LigneCommande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idLigneCommande;

	private float prix;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="article")
	private Article articleBean;

	//bi-directional many-to-one association to Commande
	@ManyToOne
	@JoinColumn(name="commande")
	private Commande commandeBean;

	//bi-directional many-to-one association to Groupe
	@ManyToOne
	@JoinColumn(name="groupe")
	private Groupe groupeBean;

	public LigneCommande() {
	}

	public int getIdLigneCommande() {
		return this.idLigneCommande;
	}

	public void setIdLigneCommande(int idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Article getArticleBean() {
		return this.articleBean;
	}

	public void setArticleBean(Article articleBean) {
		this.articleBean = articleBean;
	}

	public Commande getCommandeBean() {
		return this.commandeBean;
	}

	public void setCommandeBean(Commande commandeBean) {
		this.commandeBean = commandeBean;
	}

	public Groupe getGroupeBean() {
		return this.groupeBean;
	}

	public void setGroupeBean(Groupe groupeBean) {
		this.groupeBean = groupeBean;
	}

}