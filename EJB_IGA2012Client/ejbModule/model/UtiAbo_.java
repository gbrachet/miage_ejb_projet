package model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-02-17T15:17:17.660+0100")
@StaticMetamodel(UtiAbo.class)
public class UtiAbo_ {
	public static volatile SingularAttribute<UtiAbo, UtiAboPK> id;
	public static volatile SingularAttribute<UtiAbo, Timestamp> achat;
	public static volatile SingularAttribute<UtiAbo, Integer> nombre;
	public static volatile SingularAttribute<UtiAbo, Abonnement> abonnementBean;
	public static volatile SingularAttribute<UtiAbo, Utilisateur> utilisateurBean;
}
