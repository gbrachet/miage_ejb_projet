package gestionnaire;

import java.sql.ResultSet;
import java.util.List;

import modelWithoutJPA.Article;
import remote.*;
import java.util.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class GestionnaireArticles implements GestionnaireArticlesRemote{

	public List<Article> getListing() {
		//appl à la base de données
		//retourn la liste de tous les articles dans la base
		List<Article> retour= new ArrayList<Article>();
		
		ResultSet result=Mysql.query("select * from Article order by publication ASC");
		try{
			while(result.next()){
				//recherche de l'utilisateur
				GestionnaireUtilisateur ga=new GestionnaireUtilisateur();
				Utilisateur util=ga.find(result.getLong(7));
				
				//ajouter des paramtre au constructeur de l'article
				Article article=new Article();
				retour.add(article);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		return retour;
	}
	
}