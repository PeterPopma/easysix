package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_CORRESPONDENTIE_A database table.
 * 
 */
@Entity
@Table(name="DRP_CORRESPONDENTIE_A")
@NamedQuery(name="DrpCorrespondentieA.findAll", query="SELECT d FROM DrpCorrespondentieA d")
public class DrpCorrespondentieA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(length=512)
	private String adresto;

	@Column(name="AFGEROND_JN", length=1)
	private String afgerondJn;

	@Column(name="CPN_HANDLE", length=20)
	private String cpnHandle;

	@Column(name="CRE_ID", precision=12)
	private BigDecimal creId;

	private Object datumcorrespondentie;

	@Column(name="DNR_ID", precision=12)
	private BigDecimal dnrId;

	@Column(length=255)
	private String onderwerp;

	@Column(name="TAL_CODE", length=10)
	private String talCode;

	@Column(name="TCE_CODE", length=40)
	private String tceCode;

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

	public DrpCorrespondentieA() {
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

	public String getAdresto() {
		return this.adresto;
	}

	public void setAdresto(String adresto) {
		this.adresto = adresto;
	}

	public String getAfgerondJn() {
		return this.afgerondJn;
	}

	public void setAfgerondJn(String afgerondJn) {
		this.afgerondJn = afgerondJn;
	}

	public String getCpnHandle() {
		return this.cpnHandle;
	}

	public void setCpnHandle(String cpnHandle) {
		this.cpnHandle = cpnHandle;
	}

	public BigDecimal getCreId() {
		return this.creId;
	}

	public void setCreId(BigDecimal creId) {
		this.creId = creId;
	}

	public Object getDatumcorrespondentie() {
		return this.datumcorrespondentie;
	}

	public void setDatumcorrespondentie(Object datumcorrespondentie) {
		this.datumcorrespondentie = datumcorrespondentie;
	}

	public BigDecimal getDnrId() {
		return this.dnrId;
	}

	public void setDnrId(BigDecimal dnrId) {
		this.dnrId = dnrId;
	}

	public String getOnderwerp() {
		return this.onderwerp;
	}

	public void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}

	public String getTalCode() {
		return this.talCode;
	}

	public void setTalCode(String talCode) {
		this.talCode = talCode;
	}

	public String getTceCode() {
		return this.tceCode;
	}

	public void setTceCode(String tceCode) {
		this.tceCode = tceCode;
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