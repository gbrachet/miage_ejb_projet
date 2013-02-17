package servlet;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelWithoutJPA.Utilisateur;
import remote.GestionnaireSessionRemote;
import remote.GestionnaireUtilisateurRemote;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Gestionnaire utilisateur
			GestionnaireUtilisateurRemote bean = (GestionnaireUtilisateurRemote) new InitialContext().lookup("remote.GestionnaireUtilisateurRemote");
			
			//Connexion
			Utilisateur utilisateur = bean.connect(request.getParameter("identifiant"), request.getParameter("motPasse"));
			
			//Succés
			if(utilisateur != null){
				//Gestionnaire de session
				GestionnaireSessionRemote session = (GestionnaireSessionRemote) new InitialContext().lookup(GestionnaireSessionRemote.class.getName());
				
				//Ajout
				session.setUtilisateur(utilisateur);
				
				//TODO Redirection
				response.getOutputStream().print("Connecté : "+utilisateur.getIdentifiant());
			}
			else{
				//Redirection
				response.sendRedirect("connexion.jsp?erreur=true");
			}
			
			 
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
