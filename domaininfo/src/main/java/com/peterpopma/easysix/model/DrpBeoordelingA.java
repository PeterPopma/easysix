package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_BEOORDELING_A database table.
 * 
 */
@Entity
@Table(name="DRP_BEOORDELING_A")
@NamedQuery(name="DrpBeoordelingA.findAll", query="SELECT d FROM DrpBeoordelingA d")
public class DrpBeoordelingA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(nullable=false, length=1)
	private String actie;

	private Object beoordelingsdatum;

	@Column(name="BOG_ID", precision=12)
	private BigDecimal bogId;

	@Column(name="GBR_ID", precision=12)
	private BigDecimal gbrId;

	@Column(length=255)
	private String reden;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="TOG_CODE", length=20)
	private String togCode;

	@Column(name="TOT_CODE", length=20)
	private String totCode;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(name="USER_ID", length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	public DrpBeoordelingA() {
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

	public Object getBeoordelingsdatum() {
		return this.beoordelingsdatum;
	}

	public void setBeoordelingsdatum(Object beoordelingsdatum) {
		this.beoordelingsdatum = beoordelingsdatum;
	}

	public BigDecimal getBogId() {
		return this.bogId;
	}

	public void setBogId(BigDecimal bogId) {
		this.bogId = bogId;
	}

	public BigDecimal getGbrId() {
		return this.gbrId;
	}

	public void setGbrId(BigDecimal gbrId) {
		this.gbrId = gbrId;
	}

	public String getReden() {
		return this.reden;
	}

	public void setReden(String reden) {
		this.reden = reden;
	}

	public BigDecimal getTicketnummer() {
		return this.ticketnummer;
	}

	public void setTicketnummer(BigDecimal ticketnummer) {
		this.ticketnummer = ticketnummer;
	}

	public String getTogCode() {
		return this.togCode;
	}

	public void setTogCode(String togCode) {
		this.togCode = togCode;
	}

	public String getTotCode() {
		return this.totCode;
	}

	public void setTotCode(String totCode) {
		this.totCode = totCode;
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