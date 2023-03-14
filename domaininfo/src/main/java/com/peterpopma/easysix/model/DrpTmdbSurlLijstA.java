package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_TMDB_SURL_LIJST_A database table.
 * 
 */
@Entity
@Table(name="DRP_TMDB_SURL_LIJST_A")
@NamedQuery(name="DrpTmdbSurlLijstA.findAll", query="SELECT d FROM DrpTmdbSurlLijstA d")
public class DrpTmdbSurlLijstA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="AUD_ID", nullable=false)
	private BigDecimal audId;

	@Column(name="CREATION_DATETIME", nullable=false)
	private Object creationDatetime;

	@Column(name="LAST_IMPORT_DATETIME")
	private Object lastImportDatetime;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(name="\"VERSION\"", nullable=false, precision=12)
	private BigDecimal version;

	public DrpTmdbSurlLijstA() {
	}

	public String getActie() {
		return this.actie;
	}

	public void setActie(String actie) {
		this.actie = actie;
	}

	public BigDecimal getAudId() {
		return this.audId;
	}

	public void setAudId(BigDecimal audId) {
		this.audId = audId;
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

	public String getTransactieId() {
		return this.transactieId;
	}

	public void setTransactieId(String transactieId) {
		this.transactieId = transactieId;
	}

	public Object getTransactieTimestamp() {
		return this.transactieTimestamp;
	}

	public void setTransactieTimestamp(Object transactieTimestamp) {
		this.transactieTimestamp = transactieTimestamp;
	}

	public BigDecimal getVersion() {
		return this.version;
	}

	public void setVersion(BigDecimal version) {
		this.version = version;
	}

}