import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.projet.entity.Article;
import com.projet.remote.GestionArticle;

/**
 * Classe de test
 */
public class Main {

	public static void main(String[] args) throws NamingException{
		
		//Définitions des propriétés
		Properties properties = new Properties();
		properties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		properties.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		properties.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
		properties.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		properties.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

		
		InitialContext ic = new InitialContext(/*properties*/);
		
		//Récupération du gestionnaire d'article
		GestionArticle gestionArticle = (GestionArticle) ic.lookup("java:global/ProjetEAR/Projet/GestionArticle, java:global/ProjetEAR/Projet/GestionArticle!com.projet.local.GestionArticle");
		
		//Parcours de tous les articles
		for(Article current : gestionArticle.findAll()){
			//Affichage
			System.out.println(current);
		}
		
	}
}
