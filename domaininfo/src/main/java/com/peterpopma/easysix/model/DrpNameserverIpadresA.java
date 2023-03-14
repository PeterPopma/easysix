package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_NAMESERVER_IPADRES_A database table.
 * 
 */
@Entity
@Table(name="DRP_NAMESERVER_IPADRES_A")
@NamedQuery(name="DrpNameserverIpadresA.findAll", query="SELECT d FROM DrpNameserverIpadresA d")
public class DrpNameserverIpadresA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(length=39)
	private String adres;

	@Column(name="NSR_ID", precision=12)
	private BigDecimal nsrId;

	@Column(name="NSS_ID", precision=12)
	private BigDecimal nssId;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="TNP_CODE", length=10)
	private String tnpCode;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(name="USER_ID", length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	public DrpNameserverIpadresA() {
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

	public String getAdres() {
		return this.adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public BigDecimal getNsrId() {
		return this.nsrId;
	}

	public void setNsrId(BigDecimal nsrId) {
		this.nsrId = nsrId;
	}

	public BigDecimal getNssId() {
		return this.nssId;
	}

	public void setNssId(BigDecimal nssId) {
		this.nssId = nssId;
	}

	public BigDecimal getTicketnummer() {
		return this.ticketnummer;
	}

	public void setTicketnummer(BigDecimal ticketnummer) {
		this.ticketnummer = ticketnummer;
	}

	public String getTnpCode() {
		return this.tnpCode;
	}

	public void setTnpCode(String tnpCode) {
		this.tnpCode = tnpCode;
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

}