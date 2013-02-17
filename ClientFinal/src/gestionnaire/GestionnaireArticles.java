package gestionnaire;

import java.sql.ResultSet;
import java.util.List;

import modelWithoutJPA.*;
import remote.*;
import local.*;
import java.util.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class GestionnaireArticles implements GestionnaireArticlesRemote, GestionnaireArticlesLocal{

	public List<Article> getListing() {
		//appl à la base de données
		//retourn la liste de tous les articles dans la base
		List<Article> retour= new ArrayList<Article>();
		
		ResultSet result=Mysql.query("select * from Article order by publication ASC");
		try{
			while(result.next()){
				//recherche de l'utilisateur
				GestionnaireUtilisateur ga=new GestionnaireUtilisateur();
				Utilisateur util=ga.find(result.getLong("utilisateur"));
				
				//int idArticle, String titre, String resume, String corp, String statut, String publication, String miseAJour, Utilisateur utilisateur, double prix
				Article article=new Article(result.getInt("idArticle"), result.getString("titre"), result.getString("resume"), result.getString("corp"), result.getString("statut"), result.getString("publication"), result.getString("miseAJour"), util, result.getInt("prix"));
				retour.add(article);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		return retour;
	}
	
}