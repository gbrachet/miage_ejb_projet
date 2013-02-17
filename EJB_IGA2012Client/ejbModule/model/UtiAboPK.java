package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the UtiAbo database table.
 * 
 */
@Embeddable
public class UtiAboPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int utilisateur;
	private int abonnement;

	public UtiAboPK() {
	}

	@Column(unique=true, nullable=false)
	public int getUtilisateur() {
		return this.utilisateur;
	}
	public void setUtilisateur(int utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Column(unique=true, nullable=false)
	public int getAbonnement() {
		return this.abonnement;
	}
	public void setAbonnement(int abonnement) {
		this.abonnement = abonnement;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UtiAboPK)) {
			return false;
		}
		UtiAboPK castOther = (UtiAboPK)other;
		return 
			(this.utilisateur == castOther.utilisateur)
			&& (this.abonnement == castOther.abonnement);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.utilisateur;
		hash = hash * prime + this.abonnement;
		
		return hash;
	}
}