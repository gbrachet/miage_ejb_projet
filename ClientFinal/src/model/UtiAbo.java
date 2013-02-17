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

	@EmbeddedId
	private UtiAboPK id;

	@Column(nullable=false)
	private Timestamp achat;

	@Column(nullable=false)
	private int nombre;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="utilisateur", nullable=false, insertable=false, updatable=false)
	private Utilisateur utilisateurBean;

	//bi-directional many-to-one association to Abonnement
	@ManyToOne
	@JoinColumn(name="abonnement", nullable=false, insertable=false, updatable=false)
	private Abonnement abonnementBean;

	public UtiAbo() {
	}

	public UtiAboPK getId() {
		return this.id;
	}

	public void setId(UtiAboPK id) {
		this.id = id;
	}

	public Timestamp getAchat() {
		return this.achat;
	}

	public void setAchat(Timestamp achat) {
		this.achat = achat;
	}

	public int getNombre() {
		return this.nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public Utilisateur getUtilisateurBean() {
		return this.utilisateurBean;
	}

	public void setUtilisateurBean(Utilisateur utilisateurBean) {
		this.utilisateurBean = utilisateurBean;
	}

	public Abonnement getAbonnementBean() {
		return this.abonnementBean;
	}

	public void setAbonnementBean(Abonnement abonnementBean) {
		this.abonnementBean = abonnementBean;
	}

}