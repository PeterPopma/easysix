package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_AUTHORITATIEF_NAMESERVER_A database table.
 * 
 */
@Entity
@Table(name="DRP_AUTHORITATIEF_NAMESERVER_A")
@NamedQuery(name="DrpAuthoritatiefNameserverA.findAll", query="SELECT d FROM DrpAuthoritatiefNameserverA d")
public class DrpAuthoritatiefNameserverA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="ANR_ID", precision=12)
	private BigDecimal anrId;

	@Column(name="DNM_ID", precision=12)
	private BigDecimal dnmId;

	@Column(name="NSR_ID", precision=12)
	private BigDecimal nsrId;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(name="USER_ID", length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	@Column(precision=2)
	private BigDecimal volgnummer;

	public DrpAuthoritatiefNameserverA() {
	}

	public long getAudId() {
		return this.audId;
	}

	public void setAudId(long audId) {
		this.audId = audId;
	}

	public String getActie() {
		return this.actie;
	}

	public void setActie(String actie) {
		this.actie = actie;
	}

	public BigDecimal getAnrId() {
		return this.anrId;
	}

	public void setAnrId(BigDecimal anrId) {
		this.anrId = anrId;
	}

	public BigDecimal getDnmId() {
		return this.dnmId;
	}

	public void setDnmId(BigDecimal dnmId) {
		this.dnmId = dnmId;
	}

	public BigDecimal getNsrId() {
		return this.nsrId;
	}

	public void setNsrId(BigDecimal nsrId) {
		this.nsrId = nsrId;
	}

	public BigDecimal getTicketnummer() {
		return this.ticketnummer;
	}

	public void setTicketnummer(BigDecimal ticketnummer) {
		this.ticketnummer = ticketnummer;
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

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVerwijderenJn() {
		return this.verwijderenJn;
	}

	public void setVerwijderenJn(String verwijderenJn) {
		this.verwijderenJn = verwijderenJn;
	}

	public BigDecimal getVolgnummer() {
		return this.volgnummer;
	}

	public void setVolgnummer(BigDecimal volgnummer) {
		this.volgnummer = volgnummer;
	}

}