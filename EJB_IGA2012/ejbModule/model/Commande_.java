package model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-02-17T09:50:02.310+0100")
@StaticMetamodel(Commande.class)
public class Commande_ {
	public static volatile SingularAttribute<Commande, Integer> idCommande;
	public static volatile SingularAttribute<Commande, Timestamp> date;
	public static volatile SingularAttribute<Commande, String> statut;
	public static volatile SingularAttribute<Commande, Utilisateur> utilisateurBean;
	public static volatile ListAttribute<Commande, LigneCommande> ligneCommandes;
}
