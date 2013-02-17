

import gestionnaire.GestionUtilisateurRemote;

import java.io.IOException;
import java.util.Random;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utilisateur;

/**
 * Servlet implementation class Test
 */
@WebServlet("/TestUtilisateur")
public class TestUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TestUtilisateur() {
        super();
    }

	/* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Instanciation
			Utilisateur utilisateur = new Utilisateur();  
			
			//Modification
			utilisateur.setIdentifiant("gautier"+(new Random().nextInt(10)+5));
			utilisateur.setMotPasse("123456");
			utilisateur.setStatut("administrateur"); 
			
			//Gestionnaire utilisateur
			GestionUtilisateurRemote bean = (GestionUtilisateurRemote) new InitialContext().lookup("java:global/EAR_IGA2012/EJB_IGA2012/GestionUtilisateur!gestionnaire.GestionUtilisateurRemote");
			
			//Ajout
//			bean.create(utilisateur);
			
//			Utilisateur u = bean.find(1); 
//			bean.delete(u);
			
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Redirection
		this.doGet(request, response);
	}

}