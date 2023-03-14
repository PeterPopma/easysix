package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_BEPERKING_A database table.
 * 
 */
@Entity
@Table(name="DRP_BEPERKING_A")
@NamedQuery(name="DrpBeperkingA.findAll", query="SELECT d FROM DrpBeperkingA d")
public class DrpBeperkingA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="BPG_ID", precision=12)
	private BigDecimal bpgId;

	@Column(length=255)
	private String dossiernr;

	private Object ingangsdatum;

	@Column(name="ISE_CODE", length=40)
	private String iseCode;

	@Column(length=255)
	private String reden;

	@Column(name="TBG_CODE", length=50)
	private String tbgCode;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	private Object uitgangsdatum;

	@Column(name="USER_ID", length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	public DrpBeperkingA() {
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

	public BigDecimal getBpgId() {
		return this.bpgId;
	}

	public void setBpgId(BigDecimal bpgId) {
		this.bpgId = bpgId;
	}

	public String getDossiernr() {
		return this.dossiernr;
	}

	public void setDossiernr(String dossiernr) {
		this.dossiernr = dossiernr;
	}

	public Object getIngangsdatum() {
		return this.ingangsdatum;
	}

	public void setIngangsdatum(Object ingangsdatum) {
		this.ingangsdatum = ingangsdatum;
	}

	public String getIseCode() {
		return this.iseCode;
	}

	public void setIseCode(String iseCode) {
		this.iseCode = iseCode;
	}

	public String getReden() {
		return this.reden;
	}

	public void setReden(String reden) {
		this.reden = reden;
	}

	public String getTbgCode() {
		return this.tbgCode;
	}

	public void setTbgCode(String tbgCode) {
		this.tbgCode = tbgCode;
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

	public Object getUitgangsdatum() {
		return this.uitgangsdatum;
	}

	public void setUitgangsdatum(Object uitgangsdatum) {
		this.uitgangsdatum = uitgangsdatum;
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