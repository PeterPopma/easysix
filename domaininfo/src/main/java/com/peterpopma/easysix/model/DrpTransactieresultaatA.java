package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_TRANSACTIERESULTAAT_A database table.
 * 
 */
@Entity
@Table(name="DRP_TRANSACTIERESULTAAT_A")
@NamedQuery(name="DrpTransactieresultaatA.findAll", query="SELECT d FROM DrpTransactieresultaatA d")
public class DrpTransactieresultaatA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(precision=5)
	private BigDecimal aantal;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="AUD_ID", nullable=false)
	private BigDecimal audId;

	@Column(nullable=false, length=16)
	private String deelnemernummer;

	private Object einddatum;

	private Object exportdatum;

	@Column(precision=15)
	private BigDecimal exportvolgnummer;

	@Column(nullable=false, precision=5)
	private BigDecimal nettoverlenging;

	@Column(length=255)
	private String referentie;

	@Column(nullable=false, length=50)
	private String resultaatcode;

	private Object startdatum;

	@Column(nullable=false, precision=15)
	private BigDecimal ticketnummer;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(nullable=false)
	private Object transactiedatum;

	@Column(name="TRT_ID", nullable=false, precision=15)
	private BigDecimal trtId;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	public DrpTransactieresultaatA() {
	}

	public BigDecimal getAantal() {
		return this.aantal;
	}

	public void setAantal(BigDecimal aantal) {
		this.aantal = aantal;
	}

	public String getActie() {
		return this.actie;
	}

	public void setActie(String actie) {
		this.actie = actie;
	}

	public BigDecimal getAudId() {
		return this.audId;
	}

	public void setAudId(BigDecimal audId) {
		this.audId = audId;
	}

	public String getDeelnemernummer() {
		return this.deelnemernummer;
	}

	public void setDeelnemernummer(String deelnemernummer) {
		this.deelnemernummer = deelnemernummer;
	}

	public Object getEinddatum() {
		return this.einddatum;
	}

	public void setEinddatum(Object einddatum) {
		this.einddatum = einddatum;
	}

	public Object getExportdatum() {
		return this.exportdatum;
	}

	public void setExportdatum(Object exportdatum) {
		this.exportdatum = exportdatum;
	}

	public BigDecimal getExportvolgnummer() {
		return this.exportvolgnummer;
	}

	public void setExportvolgnummer(BigDecimal exportvolgnummer) {
		this.exportvolgnummer = exportvolgnummer;
	}

	public BigDecimal getNettoverlenging() {
		return this.nettoverlenging;
	}

	public void setNettoverlenging(BigDecimal nettoverlenging) {
		this.nettoverlenging = nettoverlenging;
	}

	public String getReferentie() {
		return this.referentie;
	}

	public void setReferentie(String referentie) {
		this.referentie = referentie;
	}

	public String getResultaatcode() {
		return this.resultaatcode;
	}

	public void setResultaatcode(String resultaatcode) {
		this.resultaatcode = resultaatcode;
	}

	public Object getStartdatum() {
		return this.startdatum;
	}

	public void setStartdatum(Object startdatum) {
		this.startdatum = startdatum;
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

	public Object getTransactiedatum() {
		return this.transactiedatum;
	}

	public void setTransactiedatum(Object transactiedatum) {
		this.transactiedatum = transactiedatum;
	}

	public BigDecimal getTrtId() {
		return this.trtId;
	}

	public void setTrtId(BigDecimal trtId) {
		this.trtId = trtId;
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

}