package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_TMDB_SMDR_ITEM_A database table.
 * 
 */
@Entity
@Table(name="DRP_TMDB_SMDR_ITEM_A")
@NamedQuery(name="DrpTmdbSmdrItemA.findAll", query="SELECT d FROM DrpTmdbSmdrItemA d")
public class DrpTmdbSmdrItemA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="AUD_ID", nullable=false)
	private BigDecimal audId;

	@Column(name="INSERTION_DATETIME", nullable=false)
	private Object insertionDatetime;

	@Column(name="SMDR_ID", nullable=false, length=50)
	private String smdrId;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	public DrpTmdbSmdrItemA() {
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

	public Object getInsertionDatetime() {
		return this.insertionDatetime;
	}

	public void setInsertionDatetime(Object insertionDatetime) {
		this.insertionDatetime = insertionDatetime;
	}

	public String getSmdrId() {
		return this.smdrId;
	}

	public void setSmdrId(String smdrId) {
		this.smdrId = smdrId;
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