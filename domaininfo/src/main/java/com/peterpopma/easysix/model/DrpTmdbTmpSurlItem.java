package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_TMDB_TMP_SURL_ITEM database table.
 * 
 */
@Entity
@Table(name="DRP_TMDB_TMP_SURL_ITEM")
@NamedQuery(name="DrpTmdbTmpSurlItem.findAll", query="SELECT d FROM DrpTmdbTmpSurlItem d")
public class DrpTmdbTmpSurlItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=127)
	private String dnl;

	@Column(name="INSERTION_DATETIME", nullable=false)
	private Object insertionDatetime;

	public DrpTmdbTmpSurlItem() {
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