package gestionnaire;
import java.sql.*;

public class Mysql {
	
	/* Constante */
	
	private static final boolean DEBUG = false;
	
	/* Attributs */
	
	private static Connection _mysql = null; //Singleton!
	
	public static int		number = 3306;	//Nombre de requête effectué
	private static String	host = "localhost";	//Serveur de la base de données
	private static String	user = "root";	//Nom d'utilisateur
	private static String	pass = "";	//Mot de passe
	private static String	base = "JEE";	//Base de donnée
	
	private static final String driver = "com.mysql.jdbc.Driver";
	
	/* Méthode */

	public static void config(String h, String u, String p, String b){
		//Définition des attributs
		host = h;
		user = u;
		pass = p;
		base = b;
	}
	
	/**
	 * Méthode permettant d'établir ou de récupérer (si elle existe déjà) une connexion à la base de données
	 */
	private static Connection getConnection() throws ClassNotFoundException, SQLException{
		if(_mysql == null){
			//Debug
			if(DEBUG) System.out.println("Debug: "+driver);
			
			//Chargement de la class JDBC et de de l'instance drivermanager
			Class.forName(driver);
			
			//Création de la chaine de connexion
			String connexion = "jdbc:mysql://"+host+"/"+base;
			
			//Debug
			if(DEBUG) System.out.println("Debug: "+connexion);

			//Création de la connexion
			_mysql = DriverManager.getConnection(connexion, user, pass);
		}

		//Retour du résultat
		return _mysql;
	}
	
	/**
	 * Méthode permettant de fermer la connexion à la base de donnée
	 * @throws SQLException 
	 */
	public static void close(){
		if(_mysql != null){
			try{
				_mysql.close();
			} catch(SQLException SE){
				System.out.println("SQLException: "+SE.getMessage());
			}
		}
	}
	
	/**
	 * Méthode permettant d'executer une requête SQL
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static ResultSet query(String query){
		//Augmentation du nombre de requête effectué
		number++;
		
		//Initialisation de la valeur de retour
		ResultSet retour = null;
		
		//Debug
		if(DEBUG) System.out.println("Debug: "+query);
		
		try{
				retour = getConnection().createStatement().executeQuery(query);
		} catch(SQLException SE){
			System.out.println("SQLException: "+SE.getMessage());
		} catch(ClassNotFoundException CNFE){
			System.out.println("ClassNotFoundException: "+CNFE.getMessage());
		}
		
		//Retour du résultat
		return retour;
	}
	
	/**
	 * Méthode permettant d'executer une requête SQL
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static int queryI(String query){
		//Augmentation du nombre de requête effectué
		number++;
		
		//Initialisation de la valeur de retour
		int retour = -1;
		
		//Debug
		if(DEBUG) System.out.println("Debug: "+query);
		
		try{
			retour = getConnection().createStatement().executeUpdate(query);
		} catch(SQLException SE){
			System.out.println("SQLException: "+SE.getMessage());
		} catch(ClassNotFoundException CNFE){
			System.out.println("ClassNotFoundException: "+CNFE.getMessage());
		}
		
		//Retour du résultat
		return retour;
	}
}