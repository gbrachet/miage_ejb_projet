package local;

import java.util.*;

import javax.ejb.Local;
import javax.ejb.Remote;

import modelWithoutJPA.*;

@Local
public interface GestionnaireArticlesLocal {
	public List<Article> getListing();
}
