package model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-02-17T15:17:17.658+0100")
@StaticMetamodel(Article.class)
public class Article_ {
	public static volatile SingularAttribute<Article, Integer> idArticle;
	public static volatile SingularAttribute<Article, String> corps;
	public static volatile SingularAttribute<Article, Timestamp> miseAJour;
	public static volatile SingularAttribute<Article, Float> prix;
	public static volatile SingularAttribute<Article, Timestamp> publication;
	public static volatile SingularAttribute<Article, String> resume;
	public static volatile SingularAttribute<Article, String> statut;
	public static volatile SingularAttribute<Article, String> titre;
	public static volatile ListAttribute<Article, Groupe> groupes;
	public static volatile SingularAttribute<Article, Utilisateur> utilisateurBean;
	public static volatile ListAttribute<Article, LigneCommande> ligneCommandes;
	public static volatile ListAttribute<Article, Tag> tags;
}
