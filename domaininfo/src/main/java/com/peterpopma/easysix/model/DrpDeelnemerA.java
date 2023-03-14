package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_DEELNEMER_A database table.
 * 
 */
@Entity
@Table(name="DRP_DEELNEMER_A")
@NamedQuery(name="DrpDeelnemerA.findAll", query="SELECT d FROM DrpDeelnemerA d")
public class DrpDeelnemerA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(name="ABUSE_EMAILADRES", length=255)
	private String abuseEmailadres;

	@Column(name="ABUSE_TELEFOONNUMMER", length=17)
	private String abuseTelefoonnummer;

	@Column(nullable=false, length=1)
	private String actie;

	private Object activeringsdatum;

	@Column(name="BEHOUDEN_DNS_KEY_JN", length=1)
	private String behoudenDnsKeyJn;

	@Column(name="BERICHTEN_VIA_EMAIL_JN", length=1)
	private String berichtenViaEmailJn;

	@Column(name="BERICHTEN_VIA_POLL_JN", length=1)
	private String berichtenViaPollJn;

	@Column(name="BUITENLANDSE_DEELNEMER_JN", length=1)
	private String buitenlandseDeelnemerJn;

	@Column(length=1)
	private String categorie;

	@Column(name="CONTRACT_GETEKEND_JN", length=1)
	private String contractGetekendJn;

	@Column(name="DATUM_OPZEGGING")
	private Object datumOpzegging;

	@Column(length=5)
	private String deelnemercode;

	@Column(length=16)
	private String deelnemernummer;

	@Column(name="DNR_ID", precision=12)
	private BigDecimal dnrId;

	@Column(name="FACTUURBIJLAGE_VIA_EMAIL_JN", length=1)
	private String factuurbijlageViaEmailJn;

	@Column(length=17)
	private String faxnummer;

	@Column(name="IANA_ID", length=10)
	private String ianaId;

	@Column(name="INGANGSDATUM_FAILLISSEMENT")
	private Object ingangsdatumFaillissement;

	private Object inschrijfdatum;

	@Column(name="LID_VAN_VVR_JN", length=1)
	private String lidVanVvrJn;

	@Column(name="MAX_AANTAL_WHOIS", precision=8)
	private BigDecimal maxAantalWhois;

	@Column(length=80)
	private String naam;

	@Column(name="NAAM_DEELNEMERLIJST", length=255)
	private String naamDeelnemerlijst;

	@Column(length=255)
	private String notifyemailadres;

	@Column(name="ONTVANGSTDATUM_BRIEF_CURATOR")
	private Object ontvangstdatumBriefCurator;

	@Column(name="ONTVANGSTDATUM_VRZK_OPHEFFING")
	private Object ontvangstdatumVrzkOpheffing;

	@Column(name="PBLCR_ONDERSTEUNING_DNSSEC_JN", length=1)
	private String pblcrOndersteuningDnssecJn;

	@Column(name="RDS_CODE", length=40)
	private String rdsCode;

	@Column(length=25)
	private String registratienummer;

	@Column(name="REKENINGNUMMER_INCASSO", length=10)
	private String rekeningnummerIncasso;

	@Column(name="RGY_ID_AANGESLOTEN_BIJ", precision=12)
	private BigDecimal rgyIdAangeslotenBij;

	@Column(name="RGY_ID_VERTEGENWOORDIGT", precision=12)
	private BigDecimal rgyIdVertegenwoordigt;

	@Column(name="RVM_CODE", length=15)
	private String rvmCode;

	@Column(length=128)
	private String sid;

	@Column(name="TAL_CODE", length=10)
	private String talCode;

	@Column(length=17)
	private String telefoonnummer;

	@Column(name="TFE_CODE", length=10)
	private String tfeCode;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="TMS_CODE", length=10)
	private String tmsCode;

	@Column(name="TOON_RESELLER_IN_DRS_JN", length=1)
	private String toonResellerInDrsJn;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(length=255)
	private String url;

	@Column(name="USER_ID", length=50)
	private String userId;

	@Column(name="VAN_REGISTRY_JN", length=1)
	private String vanRegistryJn;

	@Column(name="VERHUIZING_EMAILADRES", length=255)
	private String verhuizingEmailadres;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	@Column(name="WHOIS_URL", length=255)
	private String whoisUrl;

	public DrpDeelnemerA() {
	}

	public long getAudId() {
		return this.audId;
	}

	public void setAudId(long audId) {
		this.audId = audId;
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

	public String getActie() {
		return this.actie;
	}

	public void setActie(String actie) {
		this.actie = actie;
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

	public BigDecimal getDnrId() {
		return this.dnrId;
	}

	public void setDnrId(BigDecimal dnrId) {
		this.dnrId = dnrId;
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

	public String getRdsCode() {
		return this.rdsCode;
	}

	public void setRdsCode(String rdsCode) {
		this.rdsCode = rdsCode;
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

	public BigDecimal getRgyIdAangeslotenBij() {
		return this.rgyIdAangeslotenBij;
	}

	public void setRgyIdAangeslotenBij(BigDecimal rgyIdAangeslotenBij) {
		this.rgyIdAangeslotenBij = rgyIdAangeslotenBij;
	}

	public BigDecimal getRgyIdVertegenwoordigt() {
		return this.rgyIdVertegenwoordigt;
	}

	public void setRgyIdVertegenwoordigt(BigDecimal rgyIdVertegenwoordigt) {
		this.rgyIdVertegenwoordigt = rgyIdVertegenwoordigt;
	}

	public String getRvmCode() {
		return this.rvmCode;
	}

	public void setRvmCode(String rvmCode) {
		this.rvmCode = rvmCode;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getTalCode() {
		return this.talCode;
	}

	public void setTalCode(String talCode) {
		this.talCode = talCode;
	}

	public String getTelefoonnummer() {
		return this.telefoonnummer;
	}

	public void setTelefoonnummer(String telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}

	public String getTfeCode() {
		return this.tfeCode;
	}

	public void setTfeCode(String tfeCode) {
		this.tfeCode = tfeCode;
	}

	public BigDecimal getTicketnummer() {
		return this.ticketnummer;
	}

	public void setTicketnummer(BigDecimal ticketnummer) {
		this.ticketnummer = ticketnummer;
	}

	public String getTmsCode() {
		return this.tmsCode;
	}

	public void setTmsCode(String tmsCode) {
		this.tmsCode = tmsCode;
	}

	public String getToonResellerInDrsJn() {
		return this.toonResellerInDrsJn;
	}

	public void setToonResellerInDrsJn(String toonResellerInDrsJn) {
		this.toonResellerInDrsJn = toonResellerInDrsJn;
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

}