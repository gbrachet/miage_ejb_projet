<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="modelWithoutJPA.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>CABA</title>
		<link rel="stylesheet" media="screen" type="text/css" title="Design" href="css/style.css">
	</head>
	<body>
		<header>
			<h1>Bienvenu sur CABA</h1>
		</header>
		<section class='corps'>
			<%
				List<Article> articles=(List<Article>)request.getAttribute("articles");
				System.out.println(articles);
				for(Article article:articles){
					String html="<article><header><h2>"+article.getTitre()+"</h2></header>";
					html+=article.getResume()+"<br/>";
					html+="Auteur : "+article.getUtilisateur().getIdentifiant()+" - publication : "+article.getPublication()+"- m-a-j : "+article.getMiseAJour()+"</article>";
					out.print(html);
					System.out.println(html);
				}
			%>
		</section>
		<aside>
			Si l'utilisateur est connécté oon affie le menu utilisateur<br/>
			sinon on affiche un formulaire de connection
		</aside>
	</body>
</html>