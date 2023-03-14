package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_TMDB_SMDR_LIJST database table.
 * 
 */
@Entity
@Table(name="DRP_TMDB_SMDR_LIJST")
@NamedQuery(name="DrpTmdbSmdrLijst.findAll", query="SELECT d FROM DrpTmdbSmdrLijst d")
public class DrpTmdbSmdrLijst implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CREATION_DATETIME", unique=true, nullable=false)
	private String creationDatetime;

	@Column(name="LAST_IMPORT_DATETIME")
	private Object lastImportDatetime;

	@Column(name="\"VERSION\"", nullable=false, precision=12)
	private BigDecimal version;

	public DrpTmdbSmdrLijst() {
	}

	public String getCreationDatetime() {
		return this.creationDatetime;
	}

	public void setCreationDatetime(String creationDatetime) {
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