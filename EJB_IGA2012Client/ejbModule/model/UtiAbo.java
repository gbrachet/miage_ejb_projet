package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the UtiAbo database table.
 * 
 */
@Entity
@Table(name="UtiAbo")
public class UtiAbo implements Serializable {
	private static final long serialVersionUID = 1L;
	private UtiAboPK id;
	private Timestamp achat;
	private int nombre;
	private Abonnement abonnementBean;
	private Utilisateur utilisateurBean;

	public UtiAbo() {
	}


	@EmbeddedId
	public UtiAboPK getId() {
		return this.id;
	}

	public void setId(UtiAboPK id) {
		this.id = id;
	}


	@Column(nullable=false)
	public Timestamp getAchat() {
		return this.achat;
	}

	public void setAchat(Timestamp achat) {
		this.achat = achat;
	}


	@Column(nullable=false)
	public int getNombre() {
		return this.nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}


	//bi-directional many-to-one association to Abonnement
	@ManyToOne
	@JoinColumn(name="abonnement", nullable=false, insertable=false, updatable=false)
	public Abonnement getAbonnementBean() {
		return this.abonnementBean;
	}

	public void setAbonnementBean(Abonnement abonnementBean) {
		this.abonnementBean = abonnementBean;
	}


	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="utilisateur", nullable=false, insertable=false, updatable=false)
	public Utilisateur getUtilisateurBean() {
		return this.utilisateurBean;
	}

	public void setUtilisateurBean(Utilisateur utilisateurBean) {
		this.utilisateurBean = utilisateurBean;
	}

}