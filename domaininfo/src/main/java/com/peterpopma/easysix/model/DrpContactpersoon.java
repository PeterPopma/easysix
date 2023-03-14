package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the DRP_CONTACTPERSOON database table.
 * 
 */
@Entity
@Table(name="DRP_CONTACTPERSOON")
@NamedQuery(name="DrpContactpersoon.findAll", query="SELECT d FROM DrpContactpersoon d")
public class DrpContactpersoon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CPN_HANDLE", unique=true, nullable=false, length=20)
	private String cpnHandle;

	@Column(nullable=false)
	private Object aanmaakdatum;

	@Column(name="ADRESDISCLOSURE_JN", nullable=false, length=1)
	private String adresdisclosureJn;

	@Column(length=80)
	private String afdeling;

	@Column(name="LIMITED_JN", nullable=false, length=1)
	private String limitedJn;

	@Column(name="LINKED_JN", nullable=false, length=1)
	private String linkedJn;

	@Column(nullable=false, length=255)
	private String naam;

	@Column(name="OK_JN", nullable=false, length=1)
	private String okJn;

	private Object ontkoppeldatum;

	private Object opschoondatum;

	@Column(name="PENDINGUPDATE_JN", nullable=false, length=1)
	private String pendingupdateJn;

	@Column(name="RECHTSVORM_REGNR", length=25)
	private String rechtsvormRegnr;

	@Column(nullable=false, length=25)
	private String roid;

	@Column(name="TELECOM_EMAIL", nullable=false, length=255)
	private String telecomEmail;

	@Column(name="TELECOM_FAX", length=17)
	private String telecomFax;

	@Column(name="TELECOM_TELEFOON", nullable=false, length=17)
	private String telecomTelefoon;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	private Object wijzigingsdatum;

	//bi-directional many-to-one association to DrpDeelnemer
	@ManyToOne
	@JoinColumn(name="DNR_ID", nullable=false)
	private DrpDeelnemer drpDeelnemer;

	//bi-directional many-to-one association to DrpGebruiker
	@ManyToOne
	@JoinColumn(name="GBR_ID", nullable=false)
	private DrpGebruiker drpGebruiker;

	//bi-directional many-to-one association to DrpRechtsvorm
	@ManyToOne
	@JoinColumn(name="RVM_CODE", nullable=false)
	private DrpRechtsvorm drpRechtsvorm;

	//bi-directional many-to-one association to DrpContactrol
	@OneToMany(mappedBy="drpContactpersoon")
	private List<DrpContactrol> drpContactrols;

	//bi-directional many-to-one association to DrpContactAdre
	@OneToMany(mappedBy="drpContactpersoon")
	private List<DrpContactAdre> drpContactAdres;

	//bi-directional many-to-one association to DrpCorrespondentie
	@OneToMany(mappedBy="drpContactpersoon")
	private List<DrpCorrespondentie> drpCorrespondenties;

	//bi-directional many-to-one association to DrpTransactie
	@OneToMany(mappedBy="drpContactpersoon")
	private List<DrpTransactie> drpTransacties;

	public DrpContactpersoon() {
	}

	public String getCpnHandle() {
		return this.cpnHandle;
	}

	public void setCpnHandle(String cpnHandle) {
		this.cpnHandle = cpnHandle;
	}

	public Object getAanmaakdatum() {
		return this.aanmaakdatum;
	}

	public void setAanmaakdatum(Object aanmaakdatum) {
		this.aanmaakdatum = aanmaakdatum;
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

	public DrpDeelnemer getDrpDeelnemer() {
		return this.drpDeelnemer;
	}

	public void setDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		this.drpDeelnemer = drpDeelnemer;
	}

	public DrpGebruiker getDrpGebruiker() {
		return this.drpGebruiker;
	}

	public void setDrpGebruiker(DrpGebruiker drpGebruiker) {
		this.drpGebruiker = drpGebruiker;
	}

	public DrpRechtsvorm getDrpRechtsvorm() {
		return this.drpRechtsvorm;
	}

	public void setDrpRechtsvorm(DrpRechtsvorm drpRechtsvorm) {
		this.drpRechtsvorm = drpRechtsvorm;
	}

	public List<DrpContactrol> getDrpContactrols() {
		return this.drpContactrols;
	}

	public void setDrpContactrols(List<DrpContactrol> drpContactrols) {
		this.drpContactrols = drpContactrols;
	}

	public DrpContactrol addDrpContactrol(DrpContactrol drpContactrol) {
		getDrpContactrols().add(drpContactrol);
		drpContactrol.setDrpContactpersoon(this);

		return drpContactrol;
	}

	public DrpContactrol removeDrpContactrol(DrpContactrol drpContactrol) {
		getDrpContactrols().remove(drpContactrol);
		drpContactrol.setDrpContactpersoon(null);

		return drpContactrol;
	}

	public List<DrpContactAdre> getDrpContactAdres() {
		return this.drpContactAdres;
	}

	public void setDrpContactAdres(List<DrpContactAdre> drpContactAdres) {
		this.drpContactAdres = drpContactAdres;
	}

	public DrpContactAdre addDrpContactAdre(DrpContactAdre drpContactAdre) {
		getDrpContactAdres().add(drpContactAdre);
		drpContactAdre.setDrpContactpersoon(this);

		return drpContactAdre;
	}

	public DrpContactAdre removeDrpContactAdre(DrpContactAdre drpContactAdre) {
		getDrpContactAdres().remove(drpContactAdre);
		drpContactAdre.setDrpContactpersoon(null);

		return drpContactAdre;
	}

	public List<DrpCorrespondentie> getDrpCorrespondenties() {
		return this.drpCorrespondenties;
	}

	public void setDrpCorrespondenties(List<DrpCorrespondentie> drpCorrespondenties) {
		this.drpCorrespondenties = drpCorrespondenties;
	}

	public DrpCorrespondentie addDrpCorrespondenty(DrpCorrespondentie drpCorrespondenty) {
		getDrpCorrespondenties().add(drpCorrespondenty);
		drpCorrespondenty.setDrpContactpersoon(this);

		return drpCorrespondenty;
	}

	public DrpCorrespondentie removeDrpCorrespondenty(DrpCorrespondentie drpCorrespondenty) {
		getDrpCorrespondenties().remove(drpCorrespondenty);
		drpCorrespondenty.setDrpContactpersoon(null);

		return drpCorrespondenty;
	}

	public List<DrpTransactie> getDrpTransacties() {
		return this.drpTransacties;
	}

	public void setDrpTransacties(List<DrpTransactie> drpTransacties) {
		this.drpTransacties = drpTransacties;
	}

	public DrpTransactie addDrpTransacty(DrpTransactie drpTransacty) {
		getDrpTransacties().add(drpTransacty);
		drpTransacty.setDrpContactpersoon(this);

		return drpTransacty;
	}

	public DrpTransactie removeDrpTransacty(DrpTransactie drpTransacty) {
		getDrpTransacties().remove(drpTransacty);
		drpTransacty.setDrpContactpersoon(null);

		return drpTransacty;
	}

}