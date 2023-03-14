package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_GEBRUIKER_A database table.
 * 
 */
@Entity
@Table(name="DRP_GEBRUIKER_A")
@NamedQuery(name="DrpGebruikerA.findAll", query="SELECT d FROM DrpGebruikerA d")
public class DrpGebruikerA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="ACTIEF_JN", length=1)
	private String actiefJn;

	@Column(length=255)
	private String activeringsreden;

	@Column(name="DNR_ID", precision=12)
	private BigDecimal dnrId;

	@Column(name="GBR_ID", precision=12)
	private BigDecimal gbrId;

	@Column(name="INLOGGEN_JN", length=1)
	private String inloggenJn;

	@Column(name="MOBIEL_NUMMER", length=30)
	private String mobielNummer;

	@Column(length=100)
	private String naam;

	@Column(name="TGT_CODE", length=10)
	private String tgtCode;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(name="USER_ID", length=50)
	private String userId;

	@Column(name="VERLOOPDATUM_WACHTWOORD")
	private Object verloopdatumWachtwoord;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	@Column(name="VRIJGEGEVEN_JN", length=1)
	private String vrijgegevenJn;

	@Column(length=128)
	private String wachtwoord;

	public DrpGebruikerA() {
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

	public String getActiefJn() {
		return this.actiefJn;
	}

	public void setActiefJn(String actiefJn) {
		this.actiefJn = actiefJn;
	}

	public String getActiveringsreden() {
		return this.activeringsreden;
	}

	public void setActiveringsreden(String activeringsreden) {
		this.activeringsreden = activeringsreden;
	}

	public BigDecimal getDnrId() {
		return this.dnrId;
	}

	public void setDnrId(BigDecimal dnrId) {
		this.dnrId = dnrId;
	}

	public BigDecimal getGbrId() {
		return this.gbrId;
	}

	public void setGbrId(BigDecimal gbrId) {
		this.gbrId = gbrId;
	}

	public String getInloggenJn() {
		return this.inloggenJn;
	}

	public void setInloggenJn(String inloggenJn) {
		this.inloggenJn = inloggenJn;
	}

	public String getMobielNummer() {
		return this.mobielNummer;
	}

	public void setMobielNummer(String mobielNummer) {
		this.mobielNummer = mobielNummer;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getTgtCode() {
		return this.tgtCode;
	}

	public void setTgtCode(String tgtCode) {
		this.tgtCode = tgtCode;
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

	public Object getVerloopdatumWachtwoord() {
		return this.verloopdatumWachtwoord;
	}

	public void setVerloopdatumWachtwoord(Object verloopdatumWachtwoord) {
		this.verloopdatumWachtwoord = verloopdatumWachtwoord;
	}

	public String getVerwijderenJn() {
		return this.verwijderenJn;
	}

	public void setVerwijderenJn(String verwijderenJn) {
		this.verwijderenJn = verwijderenJn;
	}

	public String getVrijgegevenJn() {
		return this.vrijgegevenJn;
	}

	public void setVrijgegevenJn(String vrijgegevenJn) {
		this.vrijgegevenJn = vrijgegevenJn;
	}

	public String getWachtwoord() {
		return this.wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

}