package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_TMDB_SURL_LIJST database table.
 * 
 */
@Entity
@Table(name="DRP_TMDB_SURL_LIJST")
@NamedQuery(name="DrpTmdbSurlLijst.findAll", query="SELECT d FROM DrpTmdbSurlLijst d")
public class DrpTmdbSurlLijst implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CREATION_DATETIME", nullable=false)
	private Object creationDatetime;

	@Column(name="LAST_IMPORT_DATETIME")
	private Object lastImportDatetime;

	@Column(name="\"VERSION\"", nullable=false, precision=12)
	private BigDecimal version;

	public DrpTmdbSurlLijst() {
	}

	public Object getCreationDatetime() {
		return this.creationDatetime;
	}

	public void setCreationDatetime(Object creationDatetime) {
		this.creationDatetime = creationDatetime;
	}

	public Object getLastImportDatetime() {
		return this.lastImportDatetime;
	}

	public void setLastImportDatetime(Object lastImportDatetime) {
		this.lastImportDatetime = lastImportDatetime;
	}

	public BigDecimal getVersion() {
		return this.version;
	}

	public void setVersion(BigDecimal version) {
		this.version = version;
	}

}