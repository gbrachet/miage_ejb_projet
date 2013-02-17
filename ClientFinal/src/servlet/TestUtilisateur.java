package servlet;

import java.io.IOException;
import java.util.Random;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utilisateur;
import remote.GestionnaireUtilisateurRemote;

/**
 * Servlet implementation class TestUtilisateur
 */
@WebServlet("/TestUtilisateur")
public class TestUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Instanciation
			Utilisateur utilisateur = new Utilisateur();
			
			//Modification
			utilisateur.setIdentifiant("gautier"+(new Random().nextInt(10)+15));
			utilisateur.setMotPasse("123456");
			utilisateur.setStatut("administrateur");
			
			//Gestionnaire utilisateur
			GestionnaireUtilisateurRemote bean = (GestionnaireUtilisateurRemote) new InitialContext().lookup("remote.GestionnaireUtilisateurRemote");
			
			//Ajout
			bean.create(utilisateur);
			
//			Utilisateur u = bean.find(1);  
//			bean.delete(u);
			
			 
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
