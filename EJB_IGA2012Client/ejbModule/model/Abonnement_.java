package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-02-17T15:17:17.657+0100")
@StaticMetamodel(Abonnement.class)
public class Abonnement_ {
	public static volatile SingularAttribute<Abonnement, Integer> idAbonnement;
	public static volatile SingularAttribute<Abonnement, Integer> nombre;
	public static volatile SingularAttribute<Abonnement, Integer> periode;
	public static volatile SingularAttribute<Abonnement, Float> prix;
	public static volatile SingularAttribute<Abonnement, String> titre;
	public static volatile ListAttribute<Abonnement, UtiAbo> utiAbos;
}
