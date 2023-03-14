package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_RESELLER_ADRES_A database table.
 * 
 */
@Entity
@Table(name="DRP_RESELLER_ADRES_A")
@NamedQuery(name="DrpResellerAdresA.findAll", query="SELECT d FROM DrpResellerAdresA d")
public class DrpResellerAdresA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	private Object aanmaakdatum;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="LAD_CODE", length=255)
	private String ladCode;

	@Column(length=255)
	private String plaats;

	@Column(length=255)
	private String postcode;

	@Column(name="RAS_ID", precision=12)
	private BigDecimal rasId;

	@Column(name="RSR_ID", precision=12)
	private BigDecimal rsrId;

	@Column(name="STRAAT_1", length=255)
	private String straat1;

	@Column(name="STRAAT_2", length=255)
	private String straat2;

	@Column(name="STRAAT_3", length=255)
	private String straat3;

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

	private Object wijzigdatum;

	public DrpResellerAdresA() {
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

	public String getLadCode() {
		return this.ladCode;
	}

	public void setLadCode(String ladCode) {
		this.ladCode = ladCode;
	}

	public String getPlaats() {
		return this.plaats;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public BigDecimal getRasId() {
		return this.rasId;
	}

	public void setRasId(BigDecimal rasId) {
		this.rasId = rasId;
	}

	public BigDecimal getRsrId() {
		return this.rsrId;
	}

	public void setRsrId(BigDecimal rsrId) {
		this.rsrId = rsrId;
	}

	public String getStraat1() {
		return this.straat1;
	}

	public void setStraat1(String straat1) {
		this.straat1 = straat1;
	}

	public String getStraat2() {
		return this.straat2;
	}

	public void setStraat2(String straat2) {
		this.straat2 = straat2;
	}

	public String getStraat3() {
		return this.straat3;
	}

	public void setStraat3(String straat3) {
		this.straat3 = straat3;
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

	public Object getWijzigdatum() {
		return this.wijzigdatum;
	}

	public void setWijzigdatum(Object wijzigdatum) {
		this.wijzigdatum = wijzigdatum;
	}

}