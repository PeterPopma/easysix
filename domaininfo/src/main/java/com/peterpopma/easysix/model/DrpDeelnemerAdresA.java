package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_DEELNEMER_ADRES_A database table.
 * 
 */
@Entity
@Table(name="DRP_DEELNEMER_ADRES_A")
@NamedQuery(name="DrpDeelnemerAdresA.findAll", query="SELECT d FROM DrpDeelnemerAdresA d")
public class DrpDeelnemerAdresA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="DAS_ID", precision=12)
	private BigDecimal dasId;

	@Column(name="DNR_ID", precision=12)
	private BigDecimal dnrId;

	@Column(precision=5)
	private BigDecimal huisnummer;

	@Column(length=6)
	private String huisnummertoevoeging;

	@Column(name="LAD_CODE", length=5)
	private String ladCode;

	@Column(length=40)
	private String plaats;

	@Column(length=16)
	private String postcode;

	@Column(length=255)
	private String staat;

	@Column(name="STRAAT_1", length=255)
	private String straat1;

	@Column(name="STRAAT_2", length=255)
	private String straat2;

	@Column(name="STRAAT_3", length=255)
	private String straat3;

	@Column(name="TDS_CODE", length=20)
	private String tdsCode;

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

	public DrpDeelnemerAdresA() {
	}

	public long getAudId() {
		return this.audId;
	}

	public void setAudId(long audId) {
		this.audId = audId;
	}

	public String getActie() {
		return this.actie;
	}

	public void setActie(String actie) {
		this.actie = actie;
	}

	public BigDecimal getDasId() {
		return this.dasId;
	}

	public void setDasId(BigDecimal dasId) {
		this.dasId = dasId;
	}

	public BigDecimal getDnrId() {
		return this.dnrId;
	}

	public void setDnrId(BigDecimal dnrId) {
		this.dnrId = dnrId;
	}

	public BigDecimal getHuisnummer() {
		return this.huisnummer;
	}

	public void setHuisnummer(BigDecimal huisnummer) {
		this.huisnummer = huisnummer;
	}

	public String getHuisnummertoevoeging() {
		return this.huisnummertoevoeging;
	}

	public void setHuisnummertoevoeging(String huisnummertoevoeging) {
		this.huisnummertoevoeging = huisnummertoevoeging;
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

	public String getStaat() {
		return this.staat;
	}

	public void setStaat(String staat) {
		this.staat = staat;
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

	public String getTdsCode() {
		return this.tdsCode;
	}

	public void setTdsCode(String tdsCode) {
		this.tdsCode = tdsCode;
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

}