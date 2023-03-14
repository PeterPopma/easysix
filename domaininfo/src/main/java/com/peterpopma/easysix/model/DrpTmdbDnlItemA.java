package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_TMDB_DNL_ITEM_A database table.
 * 
 */
@Entity
@Table(name="DRP_TMDB_DNL_ITEM_A")
@NamedQuery(name="DrpTmdbDnlItemA.findAll", query="SELECT d FROM DrpTmdbDnlItemA d")
public class DrpTmdbDnlItemA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="AUD_ID", nullable=false)
	private BigDecimal audId;

	@Column(nullable=false, length=127)
	private String dnl;

	@Column(name="INSERTION_DATETIME", nullable=false)
	private Object insertionDatetime;

	@Column(name="LOOKUP_KEY", nullable=false, length=256)
	private String lookupKey;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	public DrpTmdbDnlItemA() {
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

}