package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_CONTACTPERSOON_A database table.
 * 
 */
@Entity
@Table(name="DRP_CONTACTPERSOON_A")
@NamedQuery(name="DrpContactpersoonA.findAll", query="SELECT d FROM DrpContactpersoonA d")
public class DrpContactpersoonA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	private Object aanmaakdatum;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="ADRESDISCLOSURE_JN", length=1)
	private String adresdisclosureJn;

	@Column(length=80)
	private String afdeling;

	@Column(name="CPN_HANDLE", length=20)
	private String cpnHandle;

	@Column(name="DNR_ID", precision=12)
	private BigDecimal dnrId;

	@Column(name="GBR_ID", precision=12)
	private BigDecimal gbrId;

	@Column(name="LIMITED_JN", length=1)
	private String limitedJn;

	@Column(name="LINKED_JN", length=1)
	private String linkedJn;

	@Column(length=255)
	private String naam;

	@Column(name="OK_JN", length=1)
	private String okJn;

	private Object ontkoppeldatum;

	private Object opschoondatum;

	@Column(name="PENDINGUPDATE_JN", length=1)
	private String pendingupdateJn;

	@Column(name="RECHTSVORM_REGNR", length=25)
	private String rechtsvormRegnr;

	@Column(length=25)
	private String roid;

	@Column(name="RVM_CODE", length=15)
	private String rvmCode;

	@Column(name="TELECOM_EMAIL", length=255)
	private String telecomEmail;

	@Column(name="TELECOM_FAX", length=17)
	private String telecomFax;

	@Column(name="TELECOM_TELEFOON", length=17)
	private String telecomTelefoon;

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

	private Object wijzigingsdatum;

	public DrpContactpersoonA() {
	}

	public long getAudId() {
		return this.audId;
	}

	public void setAudId(long audId) {
		this.audId = audId;
	}

	public Object getAanmaakdatum() {
		return this.aanmaakdatum;
	}

	public void setAanmaakdatum(Object aanmaakdatum) {
		this.aanmaakdatum = aanmaakdatum;
	}

	public String getActie() {
		return this.actie;
	}

	public void setActie(String actie) {
		this.actie = actie;
	}

	public String getAdresdisclosureJn() {
		return this.adresdisclosureJn;
	}

	public void setAdresdisclosureJn(String adresdisclosureJn) {
		this.adresdisclosureJn = adresdisclosureJn;
	}

	public String getAfdeling() {
		return this.afdeling;
	}

	public void setAfdeling(String afdeling) {
		this.afdeling = afdeling;
	}

	public String getCpnHandle() {
		return this.cpnHandle;
	}

	public void setCpnHandle(String cpnHandle) {
		this.cpnHandle = cpnHandle;
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

	public String getLimitedJn() {
		return this.limitedJn;
	}

	public void setLimitedJn(String limitedJn) {
		this.limitedJn = limitedJn;
	}

	public String getLinkedJn() {
		return this.linkedJn;
	}

	public void setLinkedJn(String linkedJn) {
		this.linkedJn = linkedJn;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getOkJn() {
		return this.okJn;
	}

	public void setOkJn(String okJn) {
		this.okJn = okJn;
	}

	public Object getOntkoppeldatum() {
		return this.ontkoppeldatum;
	}

	public void setOntkoppeldatum(Object ontkoppeldatum) {
		this.ontkoppeldatum = ontkoppeldatum;
	}

	public Object getOpschoondatum() {
		return this.opschoondatum;
	}

	public void setOpschoondatum(Object opschoondatum) {
		this.opschoondatum = opschoondatum;
	}

	public String getPendingupdateJn() {
		return this.pendingupdateJn;
	}

	public void setPendingupdateJn(String pendingupdateJn) {
		this.pendingupdateJn = pendingupdateJn;
	}

	public String getRechtsvormRegnr() {
		return this.rechtsvormRegnr;
	}

	public void setRechtsvormRegnr(String rechtsvormRegnr) {
		this.rechtsvormRegnr = rechtsvormRegnr;
	}

	public String getRoid() {
		return this.roid;
	}

	public void setRoid(String roid) {
		this.roid = roid;
	}

	public String getRvmCode() {
		return this.rvmCode;
	}

	public void setRvmCode(String rvmCode) {
		this.rvmCode = rvmCode;
	}

	public String getTelecomEmail() {
		return this.telecomEmail;
	}

	public void setTelecomEmail(String telecomEmail) {
		this.telecomEmail = telecomEmail;
	}

	public String getTelecomFax() {
		return this.telecomFax;
	}

	public void setTelecomFax(String telecomFax) {
		this.telecomFax = telecomFax;
	}

	public String getTelecomTelefoon() {
		return this.telecomTelefoon;
	}

	public void setTelecomTelefoon(String telecomTelefoon) {
		this.telecomTelefoon = telecomTelefoon;
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

	public Object getWijzigingsdatum() {
		return this.wijzigingsdatum;
	}

	public void setWijzigingsdatum(Object wijzigingsdatum) {
		this.wijzigingsdatum = wijzigingsdatum;
	}

}