package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_CONTACT_ADRES_A database table.
 * 
 */
@Entity
@Table(name="DRP_CONTACT_ADRES_A")
@NamedQuery(name="DrpContactAdresA.findAll", query="SELECT d FROM DrpContactAdresA d")
public class DrpContactAdresA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="CAS_ID", precision=12)
	private BigDecimal casId;

	@Column(name="CPN_HANDLE", length=20)
	private String cpnHandle;

	@Column(name="LAD_CODE", length=5)
	private String ladCode;

	@Column(length=255)
	private String plaats;

	@Column(name="PLAATS_MATCH", precision=5)
	private BigDecimal plaatsMatch;

	@Column(length=16)
	private String postcode;

	@Column(name="STRAAT_1", length=255)
	private String straat1;

	@Column(name="STRAAT_2", length=255)
	private String straat2;

	@Column(name="STRAAT_3", length=255)
	private String straat3;

	@Column(name="STRAAT_MATCH", precision=5)
	private BigDecimal straatMatch;

	@Column(name="TAK_CODE", length=3)
	private String takCode;

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

	public DrpContactAdresA() {
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

	public BigDecimal getCasId() {
		return this.casId;
	}

	public void setCasId(BigDecimal casId) {
		this.casId = casId;
	}

	public String getCpnHandle() {
		return this.cpnHandle;
	}

	public void setCpnHandle(String cpnHandle) {
		this.cpnHandle = cpnHandle;
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

	public BigDecimal getPlaatsMatch() {
		return this.plaatsMatch;
	}

	public void setPlaatsMatch(BigDecimal plaatsMatch) {
		this.plaatsMatch = plaatsMatch;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
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

	public BigDecimal getStraatMatch() {
		return this.straatMatch;
	}

	public void setStraatMatch(BigDecimal straatMatch) {
		this.straatMatch = straatMatch;
	}

	public String getTakCode() {
		return this.takCode;
	}

	public void setTakCode(String takCode) {
		this.takCode = takCode;
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