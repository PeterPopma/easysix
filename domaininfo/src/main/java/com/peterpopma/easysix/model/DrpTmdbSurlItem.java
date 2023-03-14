package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_TMDB_SURL_ITEM database table.
 * 
 */
@Entity
@Table(name="DRP_TMDB_SURL_ITEM")
@NamedQuery(name="DrpTmdbSurlItem.findAll", query="SELECT d FROM DrpTmdbSurlItem d")
public class DrpTmdbSurlItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=127)
	private String dnl;

	@Column(name="INSERTION_DATETIME", nullable=false)
	private Object insertionDatetime;

	public DrpTmdbSurlItem() {
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

}