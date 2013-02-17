package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-02-17T15:17:17.661+0100")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ {
	public static volatile SingularAttribute<Utilisateur, Integer> idUtilisateur;
	public static volatile SingularAttribute<Utilisateur, String> identifiant;
	public static volatile SingularAttribute<Utilisateur, String> motPasse;
	public static volatile SingularAttribute<Utilisateur, String> statut;
	public static volatile ListAttribute<Utilisateur, Article> articles;
	public static volatile ListAttribute<Utilisateur, Commande> commandes;
	public static volatile ListAttribute<Utilisateur, UtiAbo> utiAbos;
}
