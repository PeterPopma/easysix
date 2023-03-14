package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the DRP_DOMEINNAAM database table.
 * 
 */
@Entity
@Table(name="DRP_DOMEINNAAM")
@NamedQuery(name="DrpDomeinnaam.findAll", query="SELECT d FROM DrpDomeinnaam d")
public class DrpDomeinnaam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DNM_ID", unique=true, nullable=false, precision=12)
	private long dnmId;

	@Column(nullable=false)
	private Object aanmaakdatum;

	@Column(name="ABONNEMENTS_PERIODE", precision=9)
	private BigDecimal abonnementsPeriode;

	@Column(name="AUTORENEW_JN", length=1)
	private String autorenewJn;

	@Column(name="CLIENTDELETEPROHIBITED_JN", length=1)
	private String clientdeleteprohibitedJn;

	@Column(name="CLIENTHOLD_JN", length=1)
	private String clientholdJn;

	@Column(name="CLIENTRENEWPROHIBITED_JN", length=1)
	private String clientrenewprohibitedJn;

	@Column(name="CLIENTTRANSFERPROHIBITED_JN", length=1)
	private String clienttransferprohibitedJn;

	@Column(name="CLIENTUPDATEPROHIBITED_JN", length=1)
	private String clientupdateprohibitedJn;

	@Column(name="EXCLUDED_JN", nullable=false, length=1)
	private String excludedJn;

	@Column(name="GEPLANDE_OPZEGDATUM")
	private Object geplandeOpzegdatum;

	@Column(name="INACTIVE_JN", nullable=false, length=1)
	private String inactiveJn;

	@Column(name="LIMITED_JN", nullable=false, length=1)
	private String limitedJn;

	@Column(nullable=false, length=127)
	private String naam;

	@Column(name="OK_JN", nullable=false, length=1)
	private String okJn;

	@Column(name="OPTOUT_JN", nullable=false, length=1)
	private String optoutJn;

	private Object opzegdatum;

	@Column(name="PENDINGCREATE_JN", nullable=false, length=1)
	private String pendingcreateJn;

	@Column(name="PENDINGDELETE_JN", nullable=false, length=1)
	private String pendingdeleteJn;

	@Column(name="PENDINGRENEW_JN", length=1)
	private String pendingrenewJn;

	@Column(name="PENDINGTRANSFER_JN", nullable=false, length=1)
	private String pendingtransferJn;

	@Column(name="PENDINGUPDATE_JN", nullable=false, length=1)
	private String pendingupdateJn;

	@Column(name="QUARANTAINECONTROLE_JN", nullable=false, length=1)
	private String quarantainecontroleJn;

	@Column(nullable=false, length=260)
	private String roid;

	@Column(name="SERVERDELETEPROHIBITED_JN", length=1)
	private String serverdeleteprohibitedJn;

	@Column(name="SERVERHOLD_JN", length=1)
	private String serverholdJn;

	@Column(name="SERVERRENEWPROHIBITED_JN", length=1)
	private String serverrenewprohibitedJn;

	@Column(name="SERVERTRANSFERPROHIBITED_JN", length=1)
	private String servertransferprohibitedJn;

	@Column(name="SERVERUPDATEPROHIBITED_JN", length=1)
	private String serverupdateprohibitedJn;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(nullable=false, length=12)
	private String token;

	@Column(name="UIT_QUARANTAINE_DATUM")
	private Object uitQuarantaineDatum;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	private Object verhuisdatum;

	private Object verlengdatum;

	private Object verloopdatum;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	private Object wijzigdatum;

	@Column(name="WITHDRAWN_JN", nullable=false, length=1)
	private String withdrawnJn;

	//bi-directional many-to-one association to DrpAuthoritatiefNameserver
	@OneToMany(mappedBy="drpDomeinnaam")
	private List<DrpAuthoritatiefNameserver> drpAuthoritatiefNameservers;

	//bi-directional many-to-one association to DrpContactrol
	@OneToMany(mappedBy="drpDomeinnaam")
	private List<DrpContactrol> drpContactrols;

	//bi-directional many-to-one association to DrpDnsKey
	@OneToMany(mappedBy="drpDomeinnaam")
	private List<DrpDnsKey> drpDnsKeys;

	//bi-directional many-to-one association to DrpDeelnemer
	@ManyToOne
	@JoinColumn(name="DNR_ID_BEHEER")
	private DrpDeelnemer drpDeelnemer1;

	//bi-directional many-to-one association to DrpDeelnemer
	@ManyToOne
	@JoinColumn(name="DNR_ID_CREATIE", nullable=false)
	private DrpDeelnemer drpDeelnemer2;

	//bi-directional many-to-one association to DrpDeelnemer
	@ManyToOne
	@JoinColumn(name="DNR_ID_LAATSTE_BEHEER")
	private DrpDeelnemer drpDeelnemer3;

	//bi-directional many-to-one association to DrpDeelnemer
	@ManyToOne
	@JoinColumn(name="DNR_ID_LAATSTE_MUTATIE")
	private DrpDeelnemer drpDeelnemer4;

	//bi-directional many-to-one association to DrpReseller
	@ManyToOne
	@JoinColumn(name="RSR_ID")
	private DrpReseller drpReseller;

	//bi-directional many-to-one association to DrpTypeDispuutstatus
	@ManyToOne
	@JoinColumn(name="DISPUUTSTATUS")
	private DrpTypeDispuutstatus drpTypeDispuutstatus;

	//bi-directional many-to-one association to DrpDomeinnaamTransactie
	@OneToMany(mappedBy="drpDomeinnaam")
	private List<DrpDomeinnaamTransactie> drpDomeinnaamTransacties;

	//bi-directional many-to-one association to DrpIngeschrevenBeperking
	@OneToMany(mappedBy="drpDomeinnaam")
	private List<DrpIngeschrevenBeperking> drpIngeschrevenBeperkings;

	//bi-directional many-to-one association to DrpNameserver
	@OneToMany(mappedBy="drpDomeinnaam")
	private List<DrpNameserver> drpNameservers;

	public DrpDomeinnaam() {
	}

	public long getDnmId() {
		return this.dnmId;
	}

	public void setDnmId(long dnmId) {
		this.dnmId = dnmId;
	}

	public Object getAanmaakdatum() {
		return this.aanmaakdatum;
	}

	public void setAanmaakdatum(Object aanmaakdatum) {
		this.aanmaakdatum = aanmaakdatum;
	}

	public BigDecimal getAbonnementsPeriode() {
		return this.abonnementsPeriode;
	}

	public void setAbonnementsPeriode(BigDecimal abonnementsPeriode) {
		this.abonnementsPeriode = abonnementsPeriode;
	}

	public String getAutorenewJn() {
		return this.autorenewJn;
	}

	public void setAutorenewJn(String autorenewJn) {
		this.autorenewJn = autorenewJn;
	}

	public String getClientdeleteprohibitedJn() {
		return this.clientdeleteprohibitedJn;
	}

	public void setClientdeleteprohibitedJn(String clientdeleteprohibitedJn) {
		this.clientdeleteprohibitedJn = clientdeleteprohibitedJn;
	}

	public String getClientholdJn() {
		return this.clientholdJn;
	}

	public void setClientholdJn(String clientholdJn) {
		this.clientholdJn = clientholdJn;
	}

	public String getClientrenewprohibitedJn() {
		return this.clientrenewprohibitedJn;
	}

	public void setClientrenewprohibitedJn(String clientrenewprohibitedJn) {
		this.clientrenewprohibitedJn = clientrenewprohibitedJn;
	}

	public String getClienttransferprohibitedJn() {
		return this.clienttransferprohibitedJn;
	}

	public void setClienttransferprohibitedJn(String clienttransferprohibitedJn) {
		this.clienttransferprohibitedJn = clienttransferprohibitedJn;
	}

	public String getClientupdateprohibitedJn() {
		return this.clientupdateprohibitedJn;
	}

	public void setClientupdateprohibitedJn(String clientupdateprohibitedJn) {
		this.clientupdateprohibitedJn = clientupdateprohibitedJn;
	}

	public String getExcludedJn() {
		return this.excludedJn;
	}

	public void setExcludedJn(String excludedJn) {
		this.excludedJn = excludedJn;
	}

	public Object getGeplandeOpzegdatum() {
		return this.geplandeOpzegdatum;
	}

	public void setGeplandeOpzegdatum(Object geplandeOpzegdatum) {
		this.geplandeOpzegdatum = geplandeOpzegdatum;
	}

	public String getInactiveJn() {
		return this.inactiveJn;
	}

	public void setInactiveJn(String inactiveJn) {
		this.inactiveJn = inactiveJn;
	}

	public String getLimitedJn() {
		return this.limitedJn;
	}

	public void setLimitedJn(String limitedJn) {
		this.limitedJn = limitedJn;
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

	public String getOptoutJn() {
		return this.optoutJn;
	}

	public void setOptoutJn(String optoutJn) {
		this.optoutJn = optoutJn;
	}

	public Object getOpzegdatum() {
		return this.opzegdatum;
	}

	public void setOpzegdatum(Object opzegdatum) {
		this.opzegdatum = opzegdatum;
	}

	public String getPendingcreateJn() {
		return this.pendingcreateJn;
	}

	public void setPendingcreateJn(String pendingcreateJn) {
		this.pendingcreateJn = pendingcreateJn;
	}

	public String getPendingdeleteJn() {
		return this.pendingdeleteJn;
	}

	public void setPendingdeleteJn(String pendingdeleteJn) {
		this.pendingdeleteJn = pendingdeleteJn;
	}

	public String getPendingrenewJn() {
		return this.pendingrenewJn;
	}

	public void setPendingrenewJn(String pendingrenewJn) {
		this.pendingrenewJn = pendingrenewJn;
	}

	public String getPendingtransferJn() {
		return this.pendingtransferJn;
	}

	public void setPendingtransferJn(String pendingtransferJn) {
		this.pendingtransferJn = pendingtransferJn;
	}

	public String getPendingupdateJn() {
		return this.pendingupdateJn;
	}

	public void setPendingupdateJn(String pendingupdateJn) {
		this.pendingupdateJn = pendingupdateJn;
	}

	public String getQuarantainecontroleJn() {
		return this.quarantainecontroleJn;
	}

	public void setQuarantainecontroleJn(String quarantainecontroleJn) {
		this.quarantainecontroleJn = quarantainecontroleJn;
	}

	public String getRoid() {
		return this.roid;
	}

	public void setRoid(String roid) {
		this.roid = roid;
	}

	public String getServerdeleteprohibitedJn() {
		return this.serverdeleteprohibitedJn;
	}

	public void setServerdeleteprohibitedJn(String serverdeleteprohibitedJn) {
		this.serverdeleteprohibitedJn = serverdeleteprohibitedJn;
	}

	public String getServerholdJn() {
		return this.serverholdJn;
	}

	public void setServerholdJn(String serverholdJn) {
		this.serverholdJn = serverholdJn;
	}

	public String getServerrenewprohibitedJn() {
		return this.serverrenewprohibitedJn;
	}

	public void setServerrenewprohibitedJn(String serverrenewprohibitedJn) {
		this.serverrenewprohibitedJn = serverrenewprohibitedJn;
	}

	public String getServertransferprohibitedJn() {
		return this.servertransferprohibitedJn;
	}

	public void setServertransferprohibitedJn(String servertransferprohibitedJn) {
		this.servertransferprohibitedJn = servertransferprohibitedJn;
	}

	public String getServerupdateprohibitedJn() {
		return this.serverupdateprohibitedJn;
	}

	public void setServerupdateprohibitedJn(String serverupdateprohibitedJn) {
		this.serverupdateprohibitedJn = serverupdateprohibitedJn;
	}

	public BigDecimal getTicketnummer() {
		return this.ticketnummer;
	}

	public void setTicketnummer(BigDecimal ticketnummer) {
		this.ticketnummer = ticketnummer;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Object getUitQuarantaineDatum() {
		return this.uitQuarantaineDatum;
	}

	public void setUitQuarantaineDatum(Object uitQuarantaineDatum) {
		this.uitQuarantaineDatum = uitQuarantaineDatum;
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

	public Object getVerlengdatum() {
		return this.verlengdatum;
	}

	public void setVerlengdatum(Object verlengdatum) {
		this.verlengdatum = verlengdatum;
	}

	public Object getVerloopdatum() {
		return this.verloopdatum;
	}

	public void setVerloopdatum(Object verloopdatum) {
		this.verloopdatum = verloopdatum;
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

	public String getWithdrawnJn() {
		return this.withdrawnJn;
	}

	public void setWithdrawnJn(String withdrawnJn) {
		this.withdrawnJn = withdrawnJn;
	}

	public List<DrpAuthoritatiefNameserver> getDrpAuthoritatiefNameservers() {
		return this.drpAuthoritatiefNameservers;
	}

	public void setDrpAuthoritatiefNameservers(List<DrpAuthoritatiefNameserver> drpAuthoritatiefNameservers) {
		this.drpAuthoritatiefNameservers = drpAuthoritatiefNameservers;
	}

	public DrpAuthoritatiefNameserver addDrpAuthoritatiefNameserver(DrpAuthoritatiefNameserver drpAuthoritatiefNameserver) {
		getDrpAuthoritatiefNameservers().add(drpAuthoritatiefNameserver);
		drpAuthoritatiefNameserver.setDrpDomeinnaam(this);

		return drpAuthoritatiefNameserver;
	}

	public DrpAuthoritatiefNameserver removeDrpAuthoritatiefNameserver(DrpAuthoritatiefNameserver drpAuthoritatiefNameserver) {
		getDrpAuthoritatiefNameservers().remove(drpAuthoritatiefNameserver);
		drpAuthoritatiefNameserver.setDrpDomeinnaam(null);

		return drpAuthoritatiefNameserver;
	}

	public List<DrpContactrol> getDrpContactrols() {
		return this.drpContactrols;
	}

	public void setDrpContactrols(List<DrpContactrol> drpContactrols) {
		this.drpContactrols = drpContactrols;
	}

	public DrpContactrol addDrpContactrol(DrpContactrol drpContactrol) {
		getDrpContactrols().add(drpContactrol);
		drpContactrol.setDrpDomeinnaam(this);

		return drpContactrol;
	}

	public DrpContactrol removeDrpContactrol(DrpContactrol drpContactrol) {
		getDrpContactrols().remove(drpContactrol);
		drpContactrol.setDrpDomeinnaam(null);

		return drpContactrol;
	}

	public List<DrpDnsKey> getDrpDnsKeys() {
		return this.drpDnsKeys;
	}

	public void setDrpDnsKeys(List<DrpDnsKey> drpDnsKeys) {
		this.drpDnsKeys = drpDnsKeys;
	}

	public DrpDnsKey addDrpDnsKey(DrpDnsKey drpDnsKey) {
		getDrpDnsKeys().add(drpDnsKey);
		drpDnsKey.setDrpDomeinnaam(this);

		return drpDnsKey;
	}

	public DrpDnsKey removeDrpDnsKey(DrpDnsKey drpDnsKey) {
		getDrpDnsKeys().remove(drpDnsKey);
		drpDnsKey.setDrpDomeinnaam(null);

		return drpDnsKey;
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

	public DrpDeelnemer getDrpDeelnemer4() {
		return this.drpDeelnemer4;
	}

	public void setDrpDeelnemer4(DrpDeelnemer drpDeelnemer4) {
		this.drpDeelnemer4 = drpDeelnemer4;
	}

	public DrpReseller getDrpReseller() {
		return this.drpReseller;
	}

	public void setDrpReseller(DrpReseller drpReseller) {
		this.drpReseller = drpReseller;
	}

	public DrpTypeDispuutstatus getDrpTypeDispuutstatus() {
		return this.drpTypeDispuutstatus;
	}

	public void setDrpTypeDispuutstatus(DrpTypeDispuutstatus drpTypeDispuutstatus) {
		this.drpTypeDispuutstatus = drpTypeDispuutstatus;
	}

	public List<DrpDomeinnaamTransactie> getDrpDomeinnaamTransacties() {
		return this.drpDomeinnaamTransacties;
	}

	public void setDrpDomeinnaamTransacties(List<DrpDomeinnaamTransactie> drpDomeinnaamTransacties) {
		this.drpDomeinnaamTransacties = drpDomeinnaamTransacties;
	}

	public DrpDomeinnaamTransactie addDrpDomeinnaamTransacty(DrpDomeinnaamTransactie drpDomeinnaamTransacty) {
		getDrpDomeinnaamTransacties().add(drpDomeinnaamTransacty);
		drpDomeinnaamTransacty.setDrpDomeinnaam(this);

		return drpDomeinnaamTransacty;
	}

	public DrpDomeinnaamTransactie removeDrpDomeinnaamTransacty(DrpDomeinnaamTransactie drpDomeinnaamTransacty) {
		getDrpDomeinnaamTransacties().remove(drpDomeinnaamTransacty);
		drpDomeinnaamTransacty.setDrpDomeinnaam(null);

		return drpDomeinnaamTransacty;
	}

	public List<DrpIngeschrevenBeperking> getDrpIngeschrevenBeperkings() {
		return this.drpIngeschrevenBeperkings;
	}

	public void setDrpIngeschrevenBeperkings(List<DrpIngeschrevenBeperking> drpIngeschrevenBeperkings) {
		this.drpIngeschrevenBeperkings = drpIngeschrevenBeperkings;
	}

	public DrpIngeschrevenBeperking addDrpIngeschrevenBeperking(DrpIngeschrevenBeperking drpIngeschrevenBeperking) {
		getDrpIngeschrevenBeperkings().add(drpIngeschrevenBeperking);
		drpIngeschrevenBeperking.setDrpDomeinnaam(this);

		return drpIngeschrevenBeperking;
	}

	public DrpIngeschrevenBeperking removeDrpIngeschrevenBeperking(DrpIngeschrevenBeperking drpIngeschrevenBeperking) {
		getDrpIngeschrevenBeperkings().remove(drpIngeschrevenBeperking);
		drpIngeschrevenBeperking.setDrpDomeinnaam(null);

		return drpIngeschrevenBeperking;
	}

	public List<DrpNameserver> getDrpNameservers() {
		return this.drpNameservers;
	}

	public void setDrpNameservers(List<DrpNameserver> drpNameservers) {
		this.drpNameservers = drpNameservers;
	}

	public DrpNameserver addDrpNameserver(DrpNameserver drpNameserver) {
		getDrpNameservers().add(drpNameserver);
		drpNameserver.setDrpDomeinnaam(this);

		return drpNameserver;
	}

	public DrpNameserver removeDrpNameserver(DrpNameserver drpNameserver) {
		getDrpNameservers().remove(drpNameserver);
		drpNameserver.setDrpDomeinnaam(null);

		return drpNameserver;
	}

}