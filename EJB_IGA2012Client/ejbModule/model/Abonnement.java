package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Abonnement database table.
 * 
 */
@Entity
@Table(name="Abonnement")
public class Abonnement implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idAbonnement;
	private int nombre;
	private int periode;
	private float prix;
	private String titre;
	private List<UtiAbo> utiAbos;

	public Abonnement() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdAbonnement() {
		return this.idAbonnement;
	}

	public void setIdAbonnement(int idAbonnement) {
		this.idAbonnement = idAbonnement;
	}


	@Column(nullable=false)
	public int getNombre() {
		return this.nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}


	@Column(nullable=false)
	public int getPeriode() {
		return this.periode;
	}

	public void setPeriode(int periode) {
		this.periode = periode;
	}


	@Column(nullable=false)
	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}


	@Column(nullable=false, length=32)
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}


	//bi-directional many-to-one association to UtiAbo
	@OneToMany(mappedBy="abonnementBean")
	public List<UtiAbo> getUtiAbos() {
		return this.utiAbos;
	}

	public void setUtiAbos(List<UtiAbo> utiAbos) {
		this.utiAbos = utiAbos;
	}

}