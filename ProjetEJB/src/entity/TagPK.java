package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Tag database table.
 * 
 */
@Embeddable
public class TagPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int article;

	private String nom;

	public TagPK() {
	}
	public int getArticle() {
		return this.article;
	}
	public void setArticle(int article) {
		this.article = article;
	}
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TagPK)) {
			return false;
		}
		TagPK castOther = (TagPK)other;
		return 
			(this.article == castOther.article)
			&& this.nom.equals(castOther.nom);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.article;
		hash = hash * prime + this.nom.hashCode();
		
		return hash;
	}
}