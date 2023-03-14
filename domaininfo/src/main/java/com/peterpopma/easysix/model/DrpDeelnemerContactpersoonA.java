package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_DEELNEMER_CONTACTPERSOON_A database table.
 * 
 */
@Entity
@Table(name="DRP_DEELNEMER_CONTACTPERSOON_A")
@NamedQuery(name="DrpDeelnemerContactpersoonA.findAll", query="SELECT d FROM DrpDeelnemerContactpersoonA d")
public class DrpDeelnemerContactpersoonA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(length=110)
	private String achternaam;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="DCN_ID", precision=12)
	private BigDecimal dcnId;

	@Column(name="DNR_ID", precision=12)
	private BigDecimal dnrId;

	@Column(name="GST_CODE", length=10)
	private String gstCode;

	@Column(name="TDT_CODE", length=50)
	private String tdtCode;

	@Column(name="TELECOM_EMAIL", length=255)
	private String telecomEmail;

	@Column(name="TELECOM_FAX", length=17)
	private String telecomFax;

	@Column(name="TELECOM_TELEFOON", length=17)
	private String telecomTelefoon;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(length=15)
	private String tussenvoegsels;

	@Column(name="USER_ID", length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	@Column(length=15)
	private String voorletters;

	public DrpDeelnemerContactpersoonA() {
	}

	public long getAudId() {
		return this.audId;
	}

	public void setAudId(long audId) {
		this.audId = audId;
	}

	public String getAchternaam() {
		return this.achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getActie() {
		return this.actie;
	}

	public void setActie(String actie) {
		this.actie = actie;
	}

	public BigDecimal getDcnId() {
		return this.dcnId;
	}

	public void setDcnId(BigDecimal dcnId) {
		this.dcnId = dcnId;
	}

	public BigDecimal getDnrId() {
		return this.dnrId;
	}

	public void setDnrId(BigDecimal dnrId) {
		this.dnrId = dnrId;
	}

	public String getGstCode() {
		return this.gstCode;
	}

	public void setGstCode(String gstCode) {
		this.gstCode = gstCode;
	}

	public String getTdtCode() {
		return this.tdtCode;
	}

	public void setTdtCode(String tdtCode) {
		this.tdtCode = tdtCode;
	}

	public String getTelecomEmail() {
		return this.telecomEmail;
	}

	public void setTelecomEmail(String telecomEmail) {
		this.telecomEmail = telecomEmail;
	}

	public String getTelecomFax() {
		return this.telecomFax;
	}

	public void setTelecomFax(String telecomFax) {
		this.telecomFax = telecomFax;
	}

	public String getTelecomTelefoon() {
		return this.telecomTelefoon;
	}

	public void setTelecomTelefoon(String telecomTelefoon) {
		this.telecomTelefoon = telecomTelefoon;
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

	public String getTussenvoegsels() {
		return this.tussenvoegsels;
	}

	public void setTussenvoegsels(String tussenvoegsels) {
		this.tussenvoegsels = tussenvoegsels;
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

	public String getVoorletters() {
		return this.voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

}