package servlet;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.implementation.GestionUtilisateur;
import ejb.implementation.GestionUtilisateurRemote;
import entity.Utilisateur;

/**
 * Servlet implementation class UtilisateurTest
 */
@WebServlet("/UtilisateurTest")
public class UtilisateurTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UtilisateurTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Instanciation d'un nouvel utilisateur
		Utilisateur utilisateur = new Utilisateur();
		
		//Modification
		utilisateur.setIdentifiant("gautier");
		utilisateur.setMotPasse("123456");
		utilisateur.setStatut("administrateur");
		
		//Initialisation
		GestionUtilisateurRemote service;
		
		try {
			service = (GestionUtilisateurRemote) new InitialContext().lookup("GestionUtilisateur");
			
			//Enregistrement
			service.save(utilisateur);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Redirection
		this.doGet(request, response);
	}

}
