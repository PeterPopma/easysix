package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the DRP_DEELNEMER database table.
 * 
 */
@Entity
@Table(name="DRP_DEELNEMER")
@NamedQuery(name="DrpDeelnemer.findAll", query="SELECT d FROM DrpDeelnemer d")
public class DrpDeelnemer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DNR_ID", unique=true, nullable=false, precision=12)
	private long dnrId;

	@Column(name="ABUSE_EMAILADRES", length=255)
	private String abuseEmailadres;

	@Column(name="ABUSE_TELEFOONNUMMER", length=17)
	private String abuseTelefoonnummer;

	@Column(nullable=false)
	private Object activeringsdatum;

	@Column(name="BEHOUDEN_DNS_KEY_JN", nullable=false, length=1)
	private String behoudenDnsKeyJn;

	@Column(name="BERICHTEN_VIA_EMAIL_JN", nullable=false, length=1)
	private String berichtenViaEmailJn;

	@Column(name="BERICHTEN_VIA_POLL_JN", nullable=false, length=1)
	private String berichtenViaPollJn;

	@Column(name="BUITENLANDSE_DEELNEMER_JN", nullable=false, length=1)
	private String buitenlandseDeelnemerJn;

	@Column(nullable=false, length=1)
	private String categorie;

	@Column(name="CONTRACT_GETEKEND_JN", nullable=false, length=1)
	private String contractGetekendJn;

	@Column(name="DATUM_OPZEGGING")
	private Object datumOpzegging;

	@Column(nullable=false, length=5)
	private String deelnemercode;

	@Column(nullable=false, length=16)
	private String deelnemernummer;

	@Column(name="FACTUURBIJLAGE_VIA_EMAIL_JN", nullable=false, length=1)
	private String factuurbijlageViaEmailJn;

	@Column(length=17)
	private String faxnummer;

	@Column(name="IANA_ID", length=10)
	private String ianaId;

	@Column(name="INGANGSDATUM_FAILLISSEMENT")
	private Object ingangsdatumFaillissement;

	@Column(nullable=false)
	private Object inschrijfdatum;

	@Column(name="LID_VAN_VVR_JN", nullable=false, length=1)
	private String lidVanVvrJn;

	@Column(name="MAX_AANTAL_WHOIS", nullable=false, precision=8)
	private BigDecimal maxAantalWhois;

	@Column(nullable=false, length=80)
	private String naam;

	@Column(name="NAAM_DEELNEMERLIJST", nullable=false, length=255)
	private String naamDeelnemerlijst;

	@Column(length=255)
	private String notifyemailadres;

	@Column(name="ONTVANGSTDATUM_BRIEF_CURATOR")
	private Object ontvangstdatumBriefCurator;

	@Column(name="ONTVANGSTDATUM_VRZK_OPHEFFING")
	private Object ontvangstdatumVrzkOpheffing;

	@Column(name="PBLCR_ONDERSTEUNING_DNSSEC_JN", nullable=false, length=1)
	private String pblcrOndersteuningDnssecJn;

	@Column(length=25)
	private String registratienummer;

	@Column(name="REKENINGNUMMER_INCASSO", length=10)
	private String rekeningnummerIncasso;

	@Column(length=128)
	private String sid;

	@Column(length=17)
	private String telefoonnummer;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="TOON_RESELLER_IN_DRS_JN", length=1)
	private String toonResellerInDrsJn;

	@Column(length=255)
	private String url;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VAN_REGISTRY_JN", nullable=false, length=1)
	private String vanRegistryJn;

	@Column(name="VERHUIZING_EMAILADRES", length=255)
	private String verhuizingEmailadres;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	@Column(name="WHOIS_URL", length=255)
	private String whoisUrl;

	//bi-directional many-to-one association to DrpBerichtenqueue
	@OneToMany(mappedBy="drpDeelnemer")
	private List<DrpBerichtenqueue> drpBerichtenqueues;

	//bi-directional many-to-one association to DrpContactpersoon
	@OneToMany(mappedBy="drpDeelnemer")
	private List<DrpContactpersoon> drpContactpersoons;

	//bi-directional many-to-one association to DrpCorrespondentie
	@OneToMany(mappedBy="drpDeelnemer")
	private List<DrpCorrespondentie> drpCorrespondenties;

	//bi-directional many-to-one association to DrpRechtsvorm
	@ManyToOne
	@JoinColumn(name="RVM_CODE", nullable=false)
	private DrpRechtsvorm drpRechtsvorm;

	//bi-directional many-to-one association to DrpRedenDeelnemerstatus
	@ManyToOne
	@JoinColumn(name="RDS_CODE")
	private DrpRedenDeelnemerstatus drpRedenDeelnemerstatus;

	//bi-directional many-to-one association to DrpRegistry
	@ManyToOne
	@JoinColumn(name="RGY_ID_AANGESLOTEN_BIJ", nullable=false)
	private DrpRegistry drpRegistry1;

	//bi-directional many-to-one association to DrpRegistry
	@ManyToOne
	@JoinColumn(name="RGY_ID_VERTEGENWOORDIGT")
	private DrpRegistry drpRegistry2;

	//bi-directional many-to-one association to DrpTaal
	@ManyToOne
	@JoinColumn(name="TAL_CODE", nullable=false)
	private DrpTaal drpTaal;

	//bi-directional many-to-one association to DrpTypeDeelnemerstatus
	@ManyToOne
	@JoinColumn(name="TMS_CODE", nullable=false)
	private DrpTypeDeelnemerstatus drpTypeDeelnemerstatus;

	//bi-directional many-to-one association to DrpTypeFactuurperiode
	@ManyToOne
	@JoinColumn(name="TFE_CODE", nullable=false)
	private DrpTypeFactuurperiode drpTypeFactuurperiode;

	//bi-directional many-to-one association to DrpDeelnemerAdre
	@OneToMany(mappedBy="drpDeelnemer")
	private List<DrpDeelnemerAdre> drpDeelnemerAdres;

	//bi-directional many-to-one association to DrpDeelnemerContactpersoon
	@OneToMany(mappedBy="drpDeelnemer")
	private List<DrpDeelnemerContactpersoon> drpDeelnemerContactpersoons;

	//bi-directional many-to-one association to DrpDeelnemerTransactie
	@OneToMany(mappedBy="drpDeelnemer")
	private List<DrpDeelnemerTransactie> drpDeelnemerTransacties;

	//bi-directional many-to-one association to DrpDomeinnaam
	@OneToMany(mappedBy="drpDeelnemer1")
	private List<DrpDomeinnaam> drpDomeinnaams1;

	//bi-directional many-to-one association to DrpDomeinnaam
	@OneToMany(mappedBy="drpDeelnemer2")
	private List<DrpDomeinnaam> drpDomeinnaams2;

	//bi-directional many-to-one association to DrpDomeinnaam
	@OneToMany(mappedBy="drpDeelnemer3")
	private List<DrpDomeinnaam> drpDomeinnaams3;

	//bi-directional many-to-one association to DrpDomeinnaam
	@OneToMany(mappedBy="drpDeelnemer4")
	private List<DrpDomeinnaam> drpDomeinnaams4;

	//bi-directional many-to-one association to DrpGebruiker
	@OneToMany(mappedBy="drpDeelnemer")
	private List<DrpGebruiker> drpGebruikers;

	//bi-directional many-to-one association to DrpInvulhulpwaarde
	@OneToMany(mappedBy="drpDeelnemer")
	private List<DrpInvulhulpwaarde> drpInvulhulpwaardes;

	//bi-directional many-to-one association to DrpNameserver
	@OneToMany(mappedBy="drpDeelnemer1")
	private List<DrpNameserver> drpNameservers1;

	//bi-directional many-to-one association to DrpNameserver
	@OneToMany(mappedBy="drpDeelnemer2")
	private List<DrpNameserver> drpNameservers2;

	//bi-directional many-to-one association to DrpNameserver
	@OneToMany(mappedBy="drpDeelnemer3")
	private List<DrpNameserver> drpNameservers3;

	//bi-directional many-to-one association to DrpTransactie
	@OneToMany(mappedBy="drpDeelnemer")
	private List<DrpTransactie> drpTransacties;

	//bi-directional many-to-one association to DrpWhoisOntheffing
	@OneToMany(mappedBy="drpDeelnemer")
	private List<DrpWhoisOntheffing> drpWhoisOntheffings;

	public DrpDeelnemer() {
	}

	public long getDnrId() {
		return this.dnrId;
	}

	public void setDnrId(long dnrId) {
		this.dnrId = dnrId;
	}

	public String getAbuseEmailadres() {
		return this.abuseEmailadres;
	}

	public void setAbuseEmailadres(String abuseEmailadres) {
		this.abuseEmailadres = abuseEmailadres;
	}

	public String getAbuseTelefoonnummer() {
		return this.abuseTelefoonnummer;
	}

	public void setAbuseTelefoonnummer(String abuseTelefoonnummer) {
		this.abuseTelefoonnummer = abuseTelefoonnummer;
	}

	public Object getActiveringsdatum() {
		return this.activeringsdatum;
	}

	public void setActiveringsdatum(Object activeringsdatum) {
		this.activeringsdatum = activeringsdatum;
	}

	public String getBehoudenDnsKeyJn() {
		return this.behoudenDnsKeyJn;
	}

	public void setBehoudenDnsKeyJn(String behoudenDnsKeyJn) {
		this.behoudenDnsKeyJn = behoudenDnsKeyJn;
	}

	public String getBerichtenViaEmailJn() {
		return this.berichtenViaEmailJn;
	}

	public void setBerichtenViaEmailJn(String berichtenViaEmailJn) {
		this.berichtenViaEmailJn = berichtenViaEmailJn;
	}

	public String getBerichtenViaPollJn() {
		return this.berichtenViaPollJn;
	}

	public void setBerichtenViaPollJn(String berichtenViaPollJn) {
		this.berichtenViaPollJn = berichtenViaPollJn;
	}

	public String getBuitenlandseDeelnemerJn() {
		return this.buitenlandseDeelnemerJn;
	}

	public void setBuitenlandseDeelnemerJn(String buitenlandseDeelnemerJn) {
		this.buitenlandseDeelnemerJn = buitenlandseDeelnemerJn;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getContractGetekendJn() {
		return this.contractGetekendJn;
	}

	public void setContractGetekendJn(String contractGetekendJn) {
		this.contractGetekendJn = contractGetekendJn;
	}

	public Object getDatumOpzegging() {
		return this.datumOpzegging;
	}

	public void setDatumOpzegging(Object datumOpzegging) {
		this.datumOpzegging = datumOpzegging;
	}

	public String getDeelnemercode() {
		return this.deelnemercode;
	}

	public void setDeelnemercode(String deelnemercode) {
		this.deelnemercode = deelnemercode;
	}

	public String getDeelnemernummer() {
		return this.deelnemernummer;
	}

	public void setDeelnemernummer(String deelnemernummer) {
		this.deelnemernummer = deelnemernummer;
	}

	public String getFactuurbijlageViaEmailJn() {
		return this.factuurbijlageViaEmailJn;
	}

	public void setFactuurbijlageViaEmailJn(String factuurbijlageViaEmailJn) {
		this.factuurbijlageViaEmailJn = factuurbijlageViaEmailJn;
	}

	public String getFaxnummer() {
		return this.faxnummer;
	}

	public void setFaxnummer(String faxnummer) {
		this.faxnummer = faxnummer;
	}

	public String getIanaId() {
		return this.ianaId;
	}

	public void setIanaId(String ianaId) {
		this.ianaId = ianaId;
	}

	public Object getIngangsdatumFaillissement() {
		return this.ingangsdatumFaillissement;
	}

	public void setIngangsdatumFaillissement(Object ingangsdatumFaillissement) {
		this.ingangsdatumFaillissement = ingangsdatumFaillissement;
	}

	public Object getInschrijfdatum() {
		return this.inschrijfdatum;
	}

	public void setInschrijfdatum(Object inschrijfdatum) {
		this.inschrijfdatum = inschrijfdatum;
	}

	public String getLidVanVvrJn() {
		return this.lidVanVvrJn;
	}

	public void setLidVanVvrJn(String lidVanVvrJn) {
		this.lidVanVvrJn = lidVanVvrJn;
	}

	public BigDecimal getMaxAantalWhois() {
		return this.maxAantalWhois;
	}

	public void setMaxAantalWhois(BigDecimal maxAantalWhois) {
		this.maxAantalWhois = maxAantalWhois;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getNaamDeelnemerlijst() {
		return this.naamDeelnemerlijst;
	}

	public void setNaamDeelnemerlijst(String naamDeelnemerlijst) {
		this.naamDeelnemerlijst = naamDeelnemerlijst;
	}

	public String getNotifyemailadres() {
		return this.notifyemailadres;
	}

	public void setNotifyemailadres(String notifyemailadres) {
		this.notifyemailadres = notifyemailadres;
	}

	public Object getOntvangstdatumBriefCurator() {
		return this.ontvangstdatumBriefCurator;
	}

	public void setOntvangstdatumBriefCurator(Object ontvangstdatumBriefCurator) {
		this.ontvangstdatumBriefCurator = ontvangstdatumBriefCurator;
	}

	public Object getOntvangstdatumVrzkOpheffing() {
		return this.ontvangstdatumVrzkOpheffing;
	}

	public void setOntvangstdatumVrzkOpheffing(Object ontvangstdatumVrzkOpheffing) {
		this.ontvangstdatumVrzkOpheffing = ontvangstdatumVrzkOpheffing;
	}

	public String getPblcrOndersteuningDnssecJn() {
		return this.pblcrOndersteuningDnssecJn;
	}

	public void setPblcrOndersteuningDnssecJn(String pblcrOndersteuningDnssecJn) {
		this.pblcrOndersteuningDnssecJn = pblcrOndersteuningDnssecJn;
	}

	public String getRegistratienummer() {
		return this.registratienummer;
	}

	public void setRegistratienummer(String registratienummer) {
		this.registratienummer = registratienummer;
	}

	public String getRekeningnummerIncasso() {
		return this.rekeningnummerIncasso;
	}

	public void setRekeningnummerIncasso(String rekeningnummerIncasso) {
		this.rekeningnummerIncasso = rekeningnummerIncasso;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
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

	public String getToonResellerInDrsJn() {
		return this.toonResellerInDrsJn;
	}

	public void setToonResellerInDrsJn(String toonResellerInDrsJn) {
		this.toonResellerInDrsJn = toonResellerInDrsJn;
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

	public String getVanRegistryJn() {
		return this.vanRegistryJn;
	}

	public void setVanRegistryJn(String vanRegistryJn) {
		this.vanRegistryJn = vanRegistryJn;
	}

	public String getVerhuizingEmailadres() {
		return this.verhuizingEmailadres;
	}

	public void setVerhuizingEmailadres(String verhuizingEmailadres) {
		this.verhuizingEmailadres = verhuizingEmailadres;
	}

	public String getVerwijderenJn() {
		return this.verwijderenJn;
	}

	public void setVerwijderenJn(String verwijderenJn) {
		this.verwijderenJn = verwijderenJn;
	}

	public String getWhoisUrl() {
		return this.whoisUrl;
	}

	public void setWhoisUrl(String whoisUrl) {
		this.whoisUrl = whoisUrl;
	}

	public List<DrpBerichtenqueue> getDrpBerichtenqueues() {
		return this.drpBerichtenqueues;
	}

	public void setDrpBerichtenqueues(List<DrpBerichtenqueue> drpBerichtenqueues) {
		this.drpBerichtenqueues = drpBerichtenqueues;
	}

	public DrpBerichtenqueue addDrpBerichtenqueue(DrpBerichtenqueue drpBerichtenqueue) {
		getDrpBerichtenqueues().add(drpBerichtenqueue);
		drpBerichtenqueue.setDrpDeelnemer(this);

		return drpBerichtenqueue;
	}

	public DrpBerichtenqueue removeDrpBerichtenqueue(DrpBerichtenqueue drpBerichtenqueue) {
		getDrpBerichtenqueues().remove(drpBerichtenqueue);
		drpBerichtenqueue.setDrpDeelnemer(null);

		return drpBerichtenqueue;
	}

	public List<DrpContactpersoon> getDrpContactpersoons() {
		return this.drpContactpersoons;
	}

	public void setDrpContactpersoons(List<DrpContactpersoon> drpContactpersoons) {
		this.drpContactpersoons = drpContactpersoons;
	}

	public DrpContactpersoon addDrpContactpersoon(DrpContactpersoon drpContactpersoon) {
		getDrpContactpersoons().add(drpContactpersoon);
		drpContactpersoon.setDrpDeelnemer(this);

		return drpContactpersoon;
	}

	public DrpContactpersoon removeDrpContactpersoon(DrpContactpersoon drpContactpersoon) {
		getDrpContactpersoons().remove(drpContactpersoon);
		drpContactpersoon.setDrpDeelnemer(null);

		return drpContactpersoon;
	}

	public List<DrpCorrespondentie> getDrpCorrespondenties() {
		return this.drpCorrespondenties;
	}

	public void setDrpCorrespondenties(List<DrpCorrespondentie> drpCorrespondenties) {
		this.drpCorrespondenties = drpCorrespondenties;
	}

	public DrpCorrespondentie addDrpCorrespondenty(DrpCorrespondentie drpCorrespondenty) {
		getDrpCorrespondenties().add(drpCorrespondenty);
		drpCorrespondenty.setDrpDeelnemer(this);

		return drpCorrespondenty;
	}

	public DrpCorrespondentie removeDrpCorrespondenty(DrpCorrespondentie drpCorrespondenty) {
		getDrpCorrespondenties().remove(drpCorrespondenty);
		drpCorrespondenty.setDrpDeelnemer(null);

		return drpCorrespondenty;
	}

	public DrpRechtsvorm getDrpRechtsvorm() {
		return this.drpRechtsvorm;
	}

	public void setDrpRechtsvorm(DrpRechtsvorm drpRechtsvorm) {
		this.drpRechtsvorm = drpRechtsvorm;
	}

	public DrpRedenDeelnemerstatus getDrpRedenDeelnemerstatus() {
		return this.drpRedenDeelnemerstatus;
	}

	public void setDrpRedenDeelnemerstatus(DrpRedenDeelnemerstatus drpRedenDeelnemerstatus) {
		this.drpRedenDeelnemerstatus = drpRedenDeelnemerstatus;
	}

	public DrpRegistry getDrpRegistry1() {
		return this.drpRegistry1;
	}

	public void setDrpRegistry1(DrpRegistry drpRegistry1) {
		this.drpRegistry1 = drpRegistry1;
	}

	public DrpRegistry getDrpRegistry2() {
		return this.drpRegistry2;
	}

	public void setDrpRegistry2(DrpRegistry drpRegistry2) {
		this.drpRegistry2 = drpRegistry2;
	}

	public DrpTaal getDrpTaal() {
		return this.drpTaal;
	}

	public void setDrpTaal(DrpTaal drpTaal) {
		this.drpTaal = drpTaal;
	}

	public DrpTypeDeelnemerstatus getDrpTypeDeelnemerstatus() {
		return this.drpTypeDeelnemerstatus;
	}

	public void setDrpTypeDeelnemerstatus(DrpTypeDeelnemerstatus drpTypeDeelnemerstatus) {
		this.drpTypeDeelnemerstatus = drpTypeDeelnemerstatus;
	}

	public DrpTypeFactuurperiode getDrpTypeFactuurperiode() {
		return this.drpTypeFactuurperiode;
	}

	public void setDrpTypeFactuurperiode(DrpTypeFactuurperiode drpTypeFactuurperiode) {
		this.drpTypeFactuurperiode = drpTypeFactuurperiode;
	}

	public List<DrpDeelnemerAdre> getDrpDeelnemerAdres() {
		return this.drpDeelnemerAdres;
	}

	public void setDrpDeelnemerAdres(List<DrpDeelnemerAdre> drpDeelnemerAdres) {
		this.drpDeelnemerAdres = drpDeelnemerAdres;
	}

	public DrpDeelnemerAdre addDrpDeelnemerAdre(DrpDeelnemerAdre drpDeelnemerAdre) {
		getDrpDeelnemerAdres().add(drpDeelnemerAdre);
		drpDeelnemerAdre.setDrpDeelnemer(this);

		return drpDeelnemerAdre;
	}

	public DrpDeelnemerAdre removeDrpDeelnemerAdre(DrpDeelnemerAdre drpDeelnemerAdre) {
		getDrpDeelnemerAdres().remove(drpDeelnemerAdre);
		drpDeelnemerAdre.setDrpDeelnemer(null);

		return drpDeelnemerAdre;
	}

	public List<DrpDeelnemerContactpersoon> getDrpDeelnemerContactpersoons() {
		return this.drpDeelnemerContactpersoons;
	}

	public void setDrpDeelnemerContactpersoons(List<DrpDeelnemerContactpersoon> drpDeelnemerContactpersoons) {
		this.drpDeelnemerContactpersoons = drpDeelnemerContactpersoons;
	}

	public DrpDeelnemerContactpersoon addDrpDeelnemerContactpersoon(DrpDeelnemerContactpersoon drpDeelnemerContactpersoon) {
		getDrpDeelnemerContactpersoons().add(drpDeelnemerContactpersoon);
		drpDeelnemerContactpersoon.setDrpDeelnemer(this);

		return drpDeelnemerContactpersoon;
	}

	public DrpDeelnemerContactpersoon removeDrpDeelnemerContactpersoon(DrpDeelnemerContactpersoon drpDeelnemerContactpersoon) {
		getDrpDeelnemerContactpersoons().remove(drpDeelnemerContactpersoon);
		drpDeelnemerContactpersoon.setDrpDeelnemer(null);

		return drpDeelnemerContactpersoon;
	}

	public List<DrpDeelnemerTransactie> getDrpDeelnemerTransacties() {
		return this.drpDeelnemerTransacties;
	}

	public void setDrpDeelnemerTransacties(List<DrpDeelnemerTransactie> drpDeelnemerTransacties) {
		this.drpDeelnemerTransacties = drpDeelnemerTransacties;
	}

	public DrpDeelnemerTransactie addDrpDeelnemerTransacty(DrpDeelnemerTransactie drpDeelnemerTransacty) {
		getDrpDeelnemerTransacties().add(drpDeelnemerTransacty);
		drpDeelnemerTransacty.setDrpDeelnemer(this);

		return drpDeelnemerTransacty;
	}

	public DrpDeelnemerTransactie removeDrpDeelnemerTransacty(DrpDeelnemerTransactie drpDeelnemerTransacty) {
		getDrpDeelnemerTransacties().remove(drpDeelnemerTransacty);
		drpDeelnemerTransacty.setDrpDeelnemer(null);

		return drpDeelnemerTransacty;
	}

	public List<DrpDomeinnaam> getDrpDomeinnaams1() {
		return this.drpDomeinnaams1;
	}

	public void setDrpDomeinnaams1(List<DrpDomeinnaam> drpDomeinnaams1) {
		this.drpDomeinnaams1 = drpDomeinnaams1;
	}

	public DrpDomeinnaam addDrpDomeinnaams1(DrpDomeinnaam drpDomeinnaams1) {
		getDrpDomeinnaams1().add(drpDomeinnaams1);
		drpDomeinnaams1.setDrpDeelnemer1(this);

		return drpDomeinnaams1;
	}

	public DrpDomeinnaam removeDrpDomeinnaams1(DrpDomeinnaam drpDomeinnaams1) {
		getDrpDomeinnaams1().remove(drpDomeinnaams1);
		drpDomeinnaams1.setDrpDeelnemer1(null);

		return drpDomeinnaams1;
	}

	public List<DrpDomeinnaam> getDrpDomeinnaams2() {
		return this.drpDomeinnaams2;
	}

	public void setDrpDomeinnaams2(List<DrpDomeinnaam> drpDomeinnaams2) {
		this.drpDomeinnaams2 = drpDomeinnaams2;
	}

	public DrpDomeinnaam addDrpDomeinnaams2(DrpDomeinnaam drpDomeinnaams2) {
		getDrpDomeinnaams2().add(drpDomeinnaams2);
		drpDomeinnaams2.setDrpDeelnemer2(this);

		return drpDomeinnaams2;
	}

	public DrpDomeinnaam removeDrpDomeinnaams2(DrpDomeinnaam drpDomeinnaams2) {
		getDrpDomeinnaams2().remove(drpDomeinnaams2);
		drpDomeinnaams2.setDrpDeelnemer2(null);

		return drpDomeinnaams2;
	}

	public List<DrpDomeinnaam> getDrpDomeinnaams3() {
		return this.drpDomeinnaams3;
	}

	public void setDrpDomeinnaams3(List<DrpDomeinnaam> drpDomeinnaams3) {
		this.drpDomeinnaams3 = drpDomeinnaams3;
	}

	public DrpDomeinnaam addDrpDomeinnaams3(DrpDomeinnaam drpDomeinnaams3) {
		getDrpDomeinnaams3().add(drpDomeinnaams3);
		drpDomeinnaams3.setDrpDeelnemer3(this);

		return drpDomeinnaams3;
	}

	public DrpDomeinnaam removeDrpDomeinnaams3(DrpDomeinnaam drpDomeinnaams3) {
		getDrpDomeinnaams3().remove(drpDomeinnaams3);
		drpDomeinnaams3.setDrpDeelnemer3(null);

		return drpDomeinnaams3;
	}

	public List<DrpDomeinnaam> getDrpDomeinnaams4() {
		return this.drpDomeinnaams4;
	}

	public void setDrpDomeinnaams4(List<DrpDomeinnaam> drpDomeinnaams4) {
		this.drpDomeinnaams4 = drpDomeinnaams4;
	}

	public DrpDomeinnaam addDrpDomeinnaams4(DrpDomeinnaam drpDomeinnaams4) {
		getDrpDomeinnaams4().add(drpDomeinnaams4);
		drpDomeinnaams4.setDrpDeelnemer4(this);

		return drpDomeinnaams4;
	}

	public DrpDomeinnaam removeDrpDomeinnaams4(DrpDomeinnaam drpDomeinnaams4) {
		getDrpDomeinnaams4().remove(drpDomeinnaams4);
		drpDomeinnaams4.setDrpDeelnemer4(null);

		return drpDomeinnaams4;
	}

	public List<DrpGebruiker> getDrpGebruikers() {
		return this.drpGebruikers;
	}

	public void setDrpGebruikers(List<DrpGebruiker> drpGebruikers) {
		this.drpGebruikers = drpGebruikers;
	}

	public DrpGebruiker addDrpGebruiker(DrpGebruiker drpGebruiker) {
		getDrpGebruikers().add(drpGebruiker);
		drpGebruiker.setDrpDeelnemer(this);

		return drpGebruiker;
	}

	public DrpGebruiker removeDrpGebruiker(DrpGebruiker drpGebruiker) {
		getDrpGebruikers().remove(drpGebruiker);
		drpGebruiker.setDrpDeelnemer(null);

		return drpGebruiker;
	}

	public List<DrpInvulhulpwaarde> getDrpInvulhulpwaardes() {
		return this.drpInvulhulpwaardes;
	}

	public void setDrpInvulhulpwaardes(List<DrpInvulhulpwaarde> drpInvulhulpwaardes) {
		this.drpInvulhulpwaardes = drpInvulhulpwaardes;
	}

	public DrpInvulhulpwaarde addDrpInvulhulpwaarde(DrpInvulhulpwaarde drpInvulhulpwaarde) {
		getDrpInvulhulpwaardes().add(drpInvulhulpwaarde);
		drpInvulhulpwaarde.setDrpDeelnemer(this);

		return drpInvulhulpwaarde;
	}

	public DrpInvulhulpwaarde removeDrpInvulhulpwaarde(DrpInvulhulpwaarde drpInvulhulpwaarde) {
		getDrpInvulhulpwaardes().remove(drpInvulhulpwaarde);
		drpInvulhulpwaarde.setDrpDeelnemer(null);

		return drpInvulhulpwaarde;
	}

	public List<DrpNameserver> getDrpNameservers1() {
		return this.drpNameservers1;
	}

	public void setDrpNameservers1(List<DrpNameserver> drpNameservers1) {
		this.drpNameservers1 = drpNameservers1;
	}

	public DrpNameserver addDrpNameservers1(DrpNameserver drpNameservers1) {
		getDrpNameservers1().add(drpNameservers1);
		drpNameservers1.setDrpDeelnemer1(this);

		return drpNameservers1;
	}

	public DrpNameserver removeDrpNameservers1(DrpNameserver drpNameservers1) {
		getDrpNameservers1().remove(drpNameservers1);
		drpNameservers1.setDrpDeelnemer1(null);

		return drpNameservers1;
	}

	public List<DrpNameserver> getDrpNameservers2() {
		return this.drpNameservers2;
	}

	public void setDrpNameservers2(List<DrpNameserver> drpNameservers2) {
		this.drpNameservers2 = drpNameservers2;
	}

	public DrpNameserver addDrpNameservers2(DrpNameserver drpNameservers2) {
		getDrpNameservers2().add(drpNameservers2);
		drpNameservers2.setDrpDeelnemer2(this);

		return drpNameservers2;
	}

	public DrpNameserver removeDrpNameservers2(DrpNameserver drpNameservers2) {
		getDrpNameservers2().remove(drpNameservers2);
		drpNameservers2.setDrpDeelnemer2(null);

		return drpNameservers2;
	}

	public List<DrpNameserver> getDrpNameservers3() {
		return this.drpNameservers3;
	}

	public void setDrpNameservers3(List<DrpNameserver> drpNameservers3) {
		this.drpNameservers3 = drpNameservers3;
	}

	public DrpNameserver addDrpNameservers3(DrpNameserver drpNameservers3) {
		getDrpNameservers3().add(drpNameservers3);
		drpNameservers3.setDrpDeelnemer3(this);

		return drpNameservers3;
	}

	public DrpNameserver removeDrpNameservers3(DrpNameserver drpNameservers3) {
		getDrpNameservers3().remove(drpNameservers3);
		drpNameservers3.setDrpDeelnemer3(null);

		return drpNameservers3;
	}

	public List<DrpTransactie> getDrpTransacties() {
		return this.drpTransacties;
	}

	public void setDrpTransacties(List<DrpTransactie> drpTransacties) {
		this.drpTransacties = drpTransacties;
	}

	public DrpTransactie addDrpTransacty(DrpTransactie drpTransacty) {
		getDrpTransacties().add(drpTransacty);
		drpTransacty.setDrpDeelnemer(this);

		return drpTransacty;
	}

	public DrpTransactie removeDrpTransacty(DrpTransactie drpTransacty) {
		getDrpTransacties().remove(drpTransacty);
		drpTransacty.setDrpDeelnemer(null);

		return drpTransacty;
	}

	public List<DrpWhoisOntheffing> getDrpWhoisOntheffings() {
		return this.drpWhoisOntheffings;
	}

	public void setDrpWhoisOntheffings(List<DrpWhoisOntheffing> drpWhoisOntheffings) {
		this.drpWhoisOntheffings = drpWhoisOntheffings;
	}

	public DrpWhoisOntheffing addDrpWhoisOntheffing(DrpWhoisOntheffing drpWhoisOntheffing) {
		getDrpWhoisOntheffings().add(drpWhoisOntheffing);
		drpWhoisOntheffing.setDrpDeelnemer(this);

		return drpWhoisOntheffing;
	}

	public DrpWhoisOntheffing removeDrpWhoisOntheffing(DrpWhoisOntheffing drpWhoisOntheffing) {
		getDrpWhoisOntheffings().remove(drpWhoisOntheffing);
		drpWhoisOntheffing.setDrpDeelnemer(null);

		return drpWhoisOntheffing;
	}

}