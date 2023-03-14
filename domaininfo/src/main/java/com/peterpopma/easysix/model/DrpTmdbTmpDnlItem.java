package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_TMDB_TMP_DNL_ITEM database table.
 * 
 */
@Entity
@Table(name="DRP_TMDB_TMP_DNL_ITEM")
@NamedQuery(name="DrpTmdbTmpDnlItem.findAll", query="SELECT d FROM DrpTmdbTmpDnlItem d")
public class DrpTmdbTmpDnlItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=127)
	private String dnl;

	@Column(name="INSERTION_DATETIME", nullable=false)
	private Object insertionDatetime;

	@Column(name="LOOKUP_KEY", nullable=false, length=256)
	private String lookupKey;

	public DrpTmdbTmpDnlItem() {
	}

	public String getDnl() {
		return this.dnl;
	}

	public void setDnl(String dnl) {
		this.dnl = dnl;
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