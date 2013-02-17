package remote;

import java.util.*;

import javax.ejb.Remote;

import modelWithoutJPA.*;

@Remote
public interface GestionnaireArticlesRemote {
	public List<Article> getListing();
}
