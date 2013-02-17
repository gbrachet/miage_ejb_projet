package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-02-17T09:50:02.311+0100")
@StaticMetamodel(Groupe.class)
public class Groupe_ {
	public static volatile SingularAttribute<Groupe, Integer> idGroupe;
	public static volatile SingularAttribute<Groupe, Float> prix;
	public static volatile SingularAttribute<Groupe, String> statut;
	public static volatile SingularAttribute<Groupe, String> titre;
	public static volatile ListAttribute<Groupe, Article> articles;
	public static volatile ListAttribute<Groupe, LigneCommande> ligneCommandes;
}
