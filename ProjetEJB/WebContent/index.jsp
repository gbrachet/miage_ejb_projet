 <jsp:include page="WEB-INF/templates/entete.jsp" />
	<form class="form-signin" style="width:40%;margin: 0 auto">
		<h2>Connexion</h2>
		
		<input type="text" class="input-block-level" placeholder="Identifiant de connexion" required> 
		
		<input type="password" class="input-block-level" placeholder="Mot de passe" required> 
		
		<label class="checkbox"> 
			<input type="checkbox" value="remember-me">
			Se souvenir de moi
		</label>
		<button class="btn btn-large btn-primary" type="submit">Connexion</button>
	</form>
<jsp:include page="WEB-INF/templates/pied.jsp" />
