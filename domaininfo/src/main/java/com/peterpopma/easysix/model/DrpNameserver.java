package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the DRP_NAMESERVER database table.
 * 
 */
@Entity
@Table(name="DRP_NAMESERVER")
@NamedQuery(name="DrpNameserver.findAll", query="SELECT d FROM DrpNameserver d")
public class DrpNameserver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NSR_ID", unique=true, nullable=false, precision=12)
	private long nsrId;

	@Column(nullable=false)
	private Object aanmaakdatum;

	@Column(name="LIMITED_JN", nullable=false, length=1)
	private String limitedJn;

	@Column(name="LINKED_JN", nullable=false, length=1)
	private String linkedJn;

	@Column(nullable=false, length=255)
	private String naam;

	@Column(name="OK_JN", nullable=false, length=1)
	private String okJn;

	@Column(name="PENDINGUPDATE_JN", nullable=false, length=1)
	private String pendingupdateJn;

	@Column(nullable=false, length=20)
	private String roid;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	private Object verhuisdatum;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	private Object wijzigingsdatum;

	//bi-directional many-to-one association to DrpAuthoritatiefNameserver
	@OneToMany(mappedBy="drpNameserver")
	private List<DrpAuthoritatiefNameserver> drpAuthoritatiefNameservers;

	//bi-directional many-to-one association to DrpDeelnemer
	@ManyToOne
	@JoinColumn(name="DNR_ID_BEHEERD_DOOR", nullable=false)
	private DrpDeelnemer drpDeelnemer1;

	//bi-directional many-to-one association to DrpDeelnemer
	@ManyToOne
	@JoinColumn(name="DNR_ID_GECREEERD_DOOR", nullable=false)
	private DrpDeelnemer drpDeelnemer2;

	//bi-directional many-to-one association to DrpDeelnemer
	@ManyToOne
	@JoinColumn(name="DNR_ID_LAATSTE_MUTATIE")
	private DrpDeelnemer drpDeelnemer3;

	//bi-directional many-to-one association to DrpDomeinnaam
	@ManyToOne
	@JoinColumn(name="DNM_ID")
	private DrpDomeinnaam drpDomeinnaam;

	//bi-directional many-to-one association to DrpNameserverIpadre
	@OneToMany(mappedBy="drpNameserver")
	private List<DrpNameserverIpadre> drpNameserverIpadres;

	//bi-directional many-to-one association to DrpNameserverTransactie
	@OneToMany(mappedBy="drpNameserver")
	private List<DrpNameserverTransactie> drpNameserverTransacties;

	public DrpNameserver() {
	}

	public long getNsrId() {
		return this.nsrId;
	}

	public void setNsrId(long nsrId) {
		this.nsrId = nsrId;
	}

	public Object getAanmaakdatum() {
		return this.aanmaakdatum;
	}

	public void setAanmaakdatum(Object aanmaakdatum) {
		this.aanmaakdatum = aanmaakdatum;
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

	public List<DrpAuthoritatiefNameserver> getDrpAuthoritatiefNameservers() {
		return this.drpAuthoritatiefNameservers;
	}

	public void setDrpAuthoritatiefNameservers(List<DrpAuthoritatiefNameserver> drpAuthoritatiefNameservers) {
		this.drpAuthoritatiefNameservers = drpAuthoritatiefNameservers;
	}

	public DrpAuthoritatiefNameserver addDrpAuthoritatiefNameserver(DrpAuthoritatiefNameserver drpAuthoritatiefNameserver) {
		getDrpAuthoritatiefNameservers().add(drpAuthoritatiefNameserver);
		drpAuthoritatiefNameserver.setDrpNameserver(this);

		return drpAuthoritatiefNameserver;
	}

	public DrpAuthoritatiefNameserver removeDrpAuthoritatiefNameserver(DrpAuthoritatiefNameserver drpAuthoritatiefNameserver) {
		getDrpAuthoritatiefNameservers().remove(drpAuthoritatiefNameserver);
		drpAuthoritatiefNameserver.setDrpNameserver(null);

		return drpAuthoritatiefNameserver;
	}

	public DrpDeelnemer getDrpDeelnemer1() {
		return this.drpDeelnemer1;
	}

	public void setDrpDeelnemer1(DrpDeelnemer drpDeelnemer1) {
		this.drpDeelnemer1 = drpDeelnemer1;
	}

	public DrpDeelnemer getDrpDeelnemer2() {
		return this.drpDeelnemer2;
	}

	public void setDrpDeelnemer2(DrpDeelnemer drpDeelnemer2) {
		this.drpDeelnemer2 = drpDeelnemer2;
	}

	public DrpDeelnemer getDrpDeelnemer3() {
		return this.drpDeelnemer3;
	}

	public void setDrpDeelnemer3(DrpDeelnemer drpDeelnemer3) {
		this.drpDeelnemer3 = drpDeelnemer3;
	}

	public DrpDomeinnaam getDrpDomeinnaam() {
		return this.drpDomeinnaam;
	}

	public void setDrpDomeinnaam(DrpDomeinnaam drpDomeinnaam) {
		this.drpDomeinnaam = drpDomeinnaam;
	}

	public List<DrpNameserverIpadre> getDrpNameserverIpadres() {
		return this.drpNameserverIpadres;
	}

	public void setDrpNameserverIpadres(List<DrpNameserverIpadre> drpNameserverIpadres) {
		this.drpNameserverIpadres = drpNameserverIpadres;
	}

	public DrpNameserverIpadre addDrpNameserverIpadre(DrpNameserverIpadre drpNameserverIpadre) {
		getDrpNameserverIpadres().add(drpNameserverIpadre);
		drpNameserverIpadre.setDrpNameserver(this);

		return drpNameserverIpadre;
	}

	public DrpNameserverIpadre removeDrpNameserverIpadre(DrpNameserverIpadre drpNameserverIpadre) {
		getDrpNameserverIpadres().remove(drpNameserverIpadre);
		drpNameserverIpadre.setDrpNameserver(null);

		return drpNameserverIpadre;
	}

	public List<DrpNameserverTransactie> getDrpNameserverTransacties() {
		return this.drpNameserverTransacties;
	}

	public void setDrpNameserverTransacties(List<DrpNameserverTransactie> drpNameserverTransacties) {
		this.drpNameserverTransacties = drpNameserverTransacties;
	}

	public DrpNameserverTransactie addDrpNameserverTransacty(DrpNameserverTransactie drpNameserverTransacty) {
		getDrpNameserverTransacties().add(drpNameserverTransacty);
		drpNameserverTransacty.setDrpNameserver(this);

		return drpNameserverTransacty;
	}

	public DrpNameserverTransactie removeDrpNameserverTransacty(DrpNameserverTransactie drpNameserverTransacty) {
		getDrpNameserverTransacties().remove(drpNameserverTransacty);
		drpNameserverTransacty.setDrpNameserver(null);

		return drpNameserverTransacty;
	}

}