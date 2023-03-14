package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_TMDB_DNL_ITEM database table.
 * 
 */
@Entity
@Table(name="DRP_TMDB_DNL_ITEM")
@NamedQuery(name="DrpTmdbDnlItem.findAll", query="SELECT d FROM DrpTmdbDnlItem d")
public class DrpTmdbDnlItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DrpTmdbDnlItemPK id;

	@Column(name="INSERTION_DATETIME", nullable=false)
	private Object insertionDatetime;

	@Column(name="LOOKUP_KEY", nullable=false, length=256)
	private String lookupKey;

	public DrpTmdbDnlItem() {
	}

	public DrpTmdbDnlItemPK getId() {
		return this.id;
	}

	public void setId(DrpTmdbDnlItemPK id) {
		this.id = id;
	}

	public Object getInsertionDatetime() {
		return this.insertionDatetime;
	}

	public void setInsertionDatetime(Object insertionDatetime) {
		this.insertionDatetime = insertionDatetime;
	}

	public String getLookupKey() {
		return this.lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}

}