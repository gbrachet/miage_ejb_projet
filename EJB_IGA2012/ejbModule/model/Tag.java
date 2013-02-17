package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Tag database table.
 * 
 */
@Entity
@Table(name="Tag")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;
	private TagPK id;
	private Article articleBean;

	public Tag() {
	}


	@EmbeddedId
	public TagPK getId() {
		return this.id;
	}

	public void setId(TagPK id) {
		this.id = id;
	}


	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="article", nullable=false, insertable=false, updatable=false)
	public Article getArticleBean() {
		return this.articleBean;
	}

	public void setArticleBean(Article articleBean) {
		this.articleBean = articleBean;
	}

}