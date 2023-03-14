package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the DRP_RESELLER database table.
 * 
 */
@Entity
@Table(name="DRP_RESELLER")
@NamedQuery(name="DrpReseller.findAll", query="SELECT d FROM DrpReseller d")
public class DrpReseller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RSR_ID", unique=true, nullable=false, precision=12)
	private long rsrId;

	private Object aanmaakdatum;

	@Column(name="DNR_ID", nullable=false, precision=12)
	private BigDecimal dnrId;

	@Column(length=255)
	private String emailadres;

	@Column(name="LINKED_JN", nullable=false, length=1)
	private String linkedJn;

	@Column(nullable=false, length=255)
	private String naam;

	@Column(name="OK_JN", nullable=false, length=1)
	private String okJn;

	@Column(name="PENDINGUPDATE_JN", nullable=false, length=1)
	private String pendingupdateJn;

	@Column(name="RESELLER_ID", nullable=false, length=16)
	private String resellerId;

	@Column(nullable=false, length=25)
	private String roid;

	@Column(length=17)
	private String telefoonnummer;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(length=255)
	private String url;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	private Object wijzigdatum;

	//bi-directional many-to-one association to DrpDomeinnaam
	@OneToMany(mappedBy="drpReseller")
	private List<DrpDomeinnaam> drpDomeinnaams;

	//bi-directional many-to-one association to DrpResellerAdre
	@OneToMany(mappedBy="drpReseller")
	private List<DrpResellerAdre> drpResellerAdres;

	//bi-directional many-to-one association to DrpResellerTransactie
	@OneToMany(mappedBy="drpReseller")
	private List<DrpResellerTransactie> drpResellerTransacties;

	public DrpReseller() {
	}

	public long getRsrId() {
		return this.rsrId;
	}

	public void setRsrId(long rsrId) {
		this.rsrId = rsrId;
	}

	public Object getAanmaakdatum() {
		return this.aanmaakdatum;
	}

	public void setAanmaakdatum(Object aanmaakdatum) {
		this.aanmaakdatum = aanmaakdatum;
	}

	public BigDecimal getDnrId() {
		return this.dnrId;
	}

	public void setDnrId(BigDecimal dnrId) {
		this.dnrId = dnrId;
	}

	public String getEmailadres() {
		return this.emailadres;
	}

	public void setEmailadres(String emailadres) {
		this.emailadres = emailadres;
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

	public String getPendingupdateJn() {
		return this.pendingupdateJn;
	}

	public void setPendingupdateJn(String pendingupdateJn) {
		this.pendingupdateJn = pendingupdateJn;
	}

	public String getResellerId() {
		return this.resellerId;
	}

	public void setResellerId(String resellerId) {
		this.resellerId = resellerId;
	}

	public String getRoid() {
		return this.roid;
	}

	public void setRoid(String roid) {
		this.roid = roid;
	}

	public String getTelefoonnummer() {
		return this.telefoonnummer;
	}

	public void setTelefoonnummer(String telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}

	public BigDecimal getTicketnummer() {
		return this.ticketnummer;
	}

	public void setTicketnummer(BigDecimal ticketnummer) {
		this.ticketnummer = ticketnummer;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public Object getWijzigdatum() {
		return this.wijzigdatum;
	}

	public void setWijzigdatum(Object wijzigdatum) {
		this.wijzigdatum = wijzigdatum;
	}

	public List<DrpDomeinnaam> getDrpDomeinnaams() {
		return this.drpDomeinnaams;
	}

	public void setDrpDomeinnaams(List<DrpDomeinnaam> drpDomeinnaams) {
		this.drpDomeinnaams = drpDomeinnaams;
	}

	public DrpDomeinnaam addDrpDomeinnaam(DrpDomeinnaam drpDomeinnaam) {
		getDrpDomeinnaams().add(drpDomeinnaam);
		drpDomeinnaam.setDrpReseller(this);

		return drpDomeinnaam;
	}

	public DrpDomeinnaam removeDrpDomeinnaam(DrpDomeinnaam drpDomeinnaam) {
		getDrpDomeinnaams().remove(drpDomeinnaam);
		drpDomeinnaam.setDrpReseller(null);

		return drpDomeinnaam;
	}

	public List<DrpResellerAdre> getDrpResellerAdres() {
		return this.drpResellerAdres;
	}

	public void setDrpResellerAdres(List<DrpResellerAdre> drpResellerAdres) {
		this.drpResellerAdres = drpResellerAdres;
	}

	public DrpResellerAdre addDrpResellerAdre(DrpResellerAdre drpResellerAdre) {
		getDrpResellerAdres().add(drpResellerAdre);
		drpResellerAdre.setDrpReseller(this);

		return drpResellerAdre;
	}

	public DrpResellerAdre removeDrpResellerAdre(DrpResellerAdre drpResellerAdre) {
		getDrpResellerAdres().remove(drpResellerAdre);
		drpResellerAdre.setDrpReseller(null);

		return drpResellerAdre;
	}

	public List<DrpResellerTransactie> getDrpResellerTransacties() {
		return this.drpResellerTransacties;
	}

	public void setDrpResellerTransacties(List<DrpResellerTransactie> drpResellerTransacties) {
		this.drpResellerTransacties = drpResellerTransacties;
	}

	public DrpResellerTransactie addDrpResellerTransacty(DrpResellerTransactie drpResellerTransacty) {
		getDrpResellerTransacties().add(drpResellerTransacty);
		drpResellerTransacty.setDrpReseller(this);

		return drpResellerTransacty;
	}

	public DrpResellerTransactie removeDrpResellerTransacty(DrpResellerTransactie drpResellerTransacty) {
		getDrpResellerTransacties().remove(drpResellerTransacty);
		drpResellerTransacty.setDrpReseller(null);

		return drpResellerTransacty;
	}

}