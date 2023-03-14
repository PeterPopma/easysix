package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_TMDB_DNL_LIJST database table.
 * 
 */
@Entity
@Table(name="DRP_TMDB_DNL_LIJST")
@NamedQuery(name="DrpTmdbDnlLijst.findAll", query="SELECT d FROM DrpTmdbDnlLijst d")
public class DrpTmdbDnlLijst implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CREATION_DATETIME", nullable=false)
	private Object creationDatetime;

	@Column(name="LAST_IMPORT_DATETIME")
	private Object lastImportDatetime;

	@Column(name="\"VERSION\"", nullable=false, precision=12)
	private BigDecimal version;

	public DrpTmdbDnlLijst() {
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