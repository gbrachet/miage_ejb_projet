package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Commande database table.
 * 
 */
@Entity
@Table(name="Commande")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idCommande;
	private Timestamp date;
	private String statut;
	private Utilisateur utilisateurBean;
	private List<LigneCommande> ligneCommandes;

	public Commande() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}


	@Column(nullable=false)
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}


	@Column(nullable=false, length=1)
	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
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
	@OneToMany(mappedBy="commandeBean")
	public List<LigneCommande> getLigneCommandes() {
		return this.ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

}