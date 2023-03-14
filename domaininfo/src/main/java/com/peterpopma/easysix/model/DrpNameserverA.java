package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_NAMESERVER_A database table.
 * 
 */
@Entity
@Table(name="DRP_NAMESERVER_A")
@NamedQuery(name="DrpNameserverA.findAll", query="SELECT d FROM DrpNameserverA d")
public class DrpNameserverA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	private Object aanmaakdatum;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="DNM_ID", precision=12)
	private BigDecimal dnmId;

	@Column(name="DNR_ID_BEHEERD_DOOR", precision=12)
	private BigDecimal dnrIdBeheerdDoor;

	@Column(name="DNR_ID_GECREEERD_DOOR", precision=12)
	private BigDecimal dnrIdGecreeerdDoor;

	@Column(name="DNR_ID_LAATSTE_MUTATIE", precision=12)
	private BigDecimal dnrIdLaatsteMutatie;

	@Column(name="LIMITED_JN", length=1)
	private String limitedJn;

	@Column(name="LINKED_JN", length=1)
	private String linkedJn;

	@Column(length=255)
	private String naam;

	@Column(name="NSR_ID", precision=12)
	private BigDecimal nsrId;

	@Column(name="OK_JN", length=1)
	private String okJn;

	@Column(name="PENDINGUPDATE_JN", length=1)
	private String pendingupdateJn;

	@Column(length=20)
	private String roid;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(name="USER_ID", length=50)
	private String userId;

	private Object verhuisdatum;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	private Object wijzigingsdatum;

	public DrpNameserverA() {
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

	public BigDecimal getDnmId() {
		return this.dnmId;
	}

	public void setDnmId(BigDecimal dnmId) {
		this.dnmId = dnmId;
	}

	public BigDecimal getDnrIdBeheerdDoor() {
		return this.dnrIdBeheerdDoor;
	}

	public void setDnrIdBeheerdDoor(BigDecimal dnrIdBeheerdDoor) {
		this.dnrIdBeheerdDoor = dnrIdBeheerdDoor;
	}

	public BigDecimal getDnrIdGecreeerdDoor() {
		return this.dnrIdGecreeerdDoor;
	}

	public void setDnrIdGecreeerdDoor(BigDecimal dnrIdGecreeerdDoor) {
		this.dnrIdGecreeerdDoor = dnrIdGecreeerdDoor;
	}

	public BigDecimal getDnrIdLaatsteMutatie() {
		return this.dnrIdLaatsteMutatie;
	}

	public void setDnrIdLaatsteMutatie(BigDecimal dnrIdLaatsteMutatie) {
		this.dnrIdLaatsteMutatie = dnrIdLaatsteMutatie;
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

	public BigDecimal getNsrId() {
		return this.nsrId;
	}

	public void setNsrId(BigDecimal nsrId) {
		this.nsrId = nsrId;
	}

	public String getOkJn() {
		return this.okJn;
	}

	public void setOkJn(String okJn) {
		this.okJn = okJn;
	}

	public String getPendingupdateJn() {
		return this.pendingupdateJn;
	}

	public void setPendingupdateJn(String pendingupdateJn) {
		this.pendingupdateJn = pendingupdateJn;
	}

	public String getRoid() {
		return this.roid;
	}

	public void setRoid(String roid) {
		this.roid = roid;
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

	public Object getVerhuisdatum() {
		return this.verhuisdatum;
	}

	public void setVerhuisdatum(Object verhuisdatum) {
		this.verhuisdatum = verhuisdatum;
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