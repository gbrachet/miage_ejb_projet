package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-02-17T15:17:17.659+0100")
@StaticMetamodel(LigneCommande.class)
public class LigneCommande_ {
	public static volatile SingularAttribute<LigneCommande, Integer> idLigneCommande;
	public static volatile SingularAttribute<LigneCommande, Float> prix;
	public static volatile SingularAttribute<LigneCommande, Article> articleBean;
	public static volatile SingularAttribute<LigneCommande, Commande> commandeBean;
	public static volatile SingularAttribute<LigneCommande, Groupe> groupeBean;
}
