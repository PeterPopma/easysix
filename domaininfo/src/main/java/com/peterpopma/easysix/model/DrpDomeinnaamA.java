package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_DOMEINNAAM_A database table.
 * 
 */
@Entity
@Table(name="DRP_DOMEINNAAM_A")
@NamedQuery(name="DrpDomeinnaamA.findAll", query="SELECT d FROM DrpDomeinnaamA d")
public class DrpDomeinnaamA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	private Object aanmaakdatum;

	@Column(name="ABONNEMENTS_PERIODE", precision=9)
	private BigDecimal abonnementsPeriode;

	@Column(nullable=false, length=1)
	private String actie;

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

	@Column(length=1)
	private String dispuutstatus;

	@Column(name="DNM_ID", precision=12)
	private BigDecimal dnmId;

	@Column(name="DNR_ID_BEHEER", precision=12)
	private BigDecimal dnrIdBeheer;

	@Column(name="DNR_ID_CREATIE", precision=12)
	private BigDecimal dnrIdCreatie;

	@Column(name="DNR_ID_LAATSTE_BEHEER", precision=12)
	private BigDecimal dnrIdLaatsteBeheer;

	@Column(name="DNR_ID_LAATSTE_MUTATIE", precision=12)
	private BigDecimal dnrIdLaatsteMutatie;

	@Column(name="EXCLUDED_JN", length=1)
	private String excludedJn;

	@Column(name="GEPLANDE_OPZEGDATUM")
	private Object geplandeOpzegdatum;

	@Column(name="INACTIVE_JN", length=1)
	private String inactiveJn;

	@Column(name="LIMITED_JN", length=1)
	private String limitedJn;

	@Column(length=127)
	private String naam;

	@Column(name="OK_JN", length=1)
	private String okJn;

	@Column(name="OPTOUT_JN", length=1)
	private String optoutJn;

	private Object opzegdatum;

	@Column(name="PENDINGCREATE_JN", length=1)
	private String pendingcreateJn;

	@Column(name="PENDINGDELETE_JN", length=1)
	private String pendingdeleteJn;

	@Column(name="PENDINGRENEW_JN", length=1)
	private String pendingrenewJn;

	@Column(name="PENDINGTRANSFER_JN", length=1)
	private String pendingtransferJn;

	@Column(name="PENDINGUPDATE_JN", length=1)
	private String pendingupdateJn;

	@Column(name="QUARANTAINECONTROLE_JN", length=1)
	private String quarantainecontroleJn;

	@Column(length=260)
	private String roid;

	@Column(name="RSR_ID", precision=12)
	private BigDecimal rsrId;

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

	@Column(length=12)
	private String token;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(name="UIT_QUARANTAINE_DATUM")
	private Object uitQuarantaineDatum;

	@Column(name="USER_ID", length=50)
	private String userId;

	private Object verhuisdatum;

	private Object verlengdatum;

	private Object verloopdatum;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	private Object wijzigdatum;

	@Column(name="WITHDRAWN_JN", length=1)
	private String withdrawnJn;

	public DrpDomeinnaamA() {
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

	public BigDecimal getAbonnementsPeriode() {
		return this.abonnementsPeriode;
	}

	public void setAbonnementsPeriode(BigDecimal abonnementsPeriode) {
		this.abonnementsPeriode = abonnementsPeriode;
	}

	public String getActie() {
		return this.actie;
	}

	public void setActie(String actie) {
		this.actie = actie;
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

	public String getDispuutstatus() {
		return this.dispuutstatus;
	}

	public void setDispuutstatus(String dispuutstatus) {
		this.dispuutstatus = dispuutstatus;
	}

	public BigDecimal getDnmId() {
		return this.dnmId;
	}

	public void setDnmId(BigDecimal dnmId) {
		this.dnmId = dnmId;
	}

	public BigDecimal getDnrIdBeheer() {
		return this.dnrIdBeheer;
	}

	public void setDnrIdBeheer(BigDecimal dnrIdBeheer) {
		this.dnrIdBeheer = dnrIdBeheer;
	}

	public BigDecimal getDnrIdCreatie() {
		return this.dnrIdCreatie;
	}

	public void setDnrIdCreatie(BigDecimal dnrIdCreatie) {
		this.dnrIdCreatie = dnrIdCreatie;
	}

	public BigDecimal getDnrIdLaatsteBeheer() {
		return this.dnrIdLaatsteBeheer;
	}

	public void setDnrIdLaatsteBeheer(BigDecimal dnrIdLaatsteBeheer) {
		this.dnrIdLaatsteBeheer = dnrIdLaatsteBeheer;
	}

	public BigDecimal getDnrIdLaatsteMutatie() {
		return this.dnrIdLaatsteMutatie;
	}

	public void setDnrIdLaatsteMutatie(BigDecimal dnrIdLaatsteMutatie) {
		this.dnrIdLaatsteMutatie = dnrIdLaatsteMutatie;
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

	public BigDecimal getRsrId() {
		return this.rsrId;
	}

	public void setRsrId(BigDecimal rsrId) {
		this.rsrId = rsrId;
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

}