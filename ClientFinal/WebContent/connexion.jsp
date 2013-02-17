<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="remote.GestionnaireSessionRemote"%>
<%@page import="javax.naming.InitialContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connexion</title>
</head>
<body>
	<%
		/* Redirection déjà connecté */
		
		//Gestionnaire de session
		GestionnaireSessionRemote ses = (GestionnaireSessionRemote) new InitialContext().lookup(GestionnaireSessionRemote.class.getName());
	
		out.print((ses.getUtilisateur() != null)? ses.getUtilisateur().toString() : "null");
	
		//Déjà Connecté
		if(ses.getUtilisateur() != null){
			//Redirection
			response.sendRedirect("index.jsp");
		}
	
		/* Message d'erreur */
		if(request.getParameter("erreur") != null){
	%>
		<div class="error" style="font-weight:bold">Identifiant ou mot de passe invalide</div>
	<% } %>
	
	<form method="post" action="ServletConnexion">
		<h2>Connexion</h2>
		<label for="identifiant">Identifiant</label>
		<input type="text" name="identifiant" value="" maxlength="12" id="identifiant"><br>
		<label for="motPasse">Mot de passe</label>
		<input type="password" name="motPasse" value="" maxlength="12" id="motPasse"><br>
		<input type="submit" name="valider" value="OK">
	</form>
</body>
</html>