package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Tag database table.
 * 
 */
@Entity
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TagPK id;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="article")
	private Article articleBean;

	public Tag() {
	}

	public TagPK getId() {
		return this.id;
	}

	public void setId(TagPK id) {
		this.id = id;
	}

	public Article getArticleBean() {
		return this.articleBean;
	}

	public void setArticleBean(Article articleBean) {
		this.articleBean = articleBean;
	}

}