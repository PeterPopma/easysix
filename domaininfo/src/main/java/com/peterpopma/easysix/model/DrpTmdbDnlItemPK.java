package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DRP_TMDB_DNL_ITEM database table.
 * 
 */
@Embeddable
public class DrpTmdbDnlItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CREATION_DATETIME", unique=true, nullable=false)
	private String creationDatetime;

	@Column(unique=true, nullable=false, length=127)
	private String dnl;

	public DrpTmdbDnlItemPK() {
	}
	public String getCreationDatetime() {
		return this.creationDatetime;
	}
	public void setCreationDatetime(String creationDatetime) {
		this.creationDatetime = creationDatetime;
	}
	public String getDnl() {
		return this.dnl;
	}
	public void setDnl(String dnl) {
		this.dnl = dnl;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DrpTmdbDnlItemPK)) {
			return false;
		}
		DrpTmdbDnlItemPK castOther = (DrpTmdbDnlItemPK)other;
		return 
			this.creationDatetime.equals(castOther.creationDatetime)
			&& this.dnl.equals(castOther.dnl);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.creationDatetime.hashCode();
		hash = hash * prime + this.dnl.hashCode();
		
		return hash;
	}
}