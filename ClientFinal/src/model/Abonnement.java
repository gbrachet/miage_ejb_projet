package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the Abonnement database table.
 */
@Entity
@Table(name="Abonnement")
public class Abonnement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idAbonnement;

	@Column(nullable=false)
	private int nombre;

	@Column(nullable=false)
	private int periode;

	@Column(nullable=false)
	private float prix;

	@Column(nullable=false, length=32)
	private String titre;

	//bi-directional many-to-one association to UtiAbo
	@OneToMany(mappedBy="abonnementBean")
	private List<UtiAbo> utiAbos;

	public Abonnement() {
	}

	public int getIdAbonnement() {
		return this.idAbonnement;
	}

	public void setIdAbonnement(int idAbonnement) {
		this.idAbonnement = idAbonnement;
	}

	public int getNombre() {
		return this.nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getPeriode() {
		return this.periode;
	}

	public void setPeriode(int periode) {
		this.periode = periode;
	}

	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<UtiAbo> getUtiAbos() {
		return this.utiAbos;
	}

	public void setUtiAbos(List<UtiAbo> utiAbos) {
		this.utiAbos = utiAbos;
	}

}