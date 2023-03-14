package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_DNS_KEY_A database table.
 * 
 */
@Entity
@Table(name="DRP_DNS_KEY_A")
@NamedQuery(name="DrpDnsKeyA.findAll", query="SELECT d FROM DrpDnsKeyA d")
public class DrpDnsKeyA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="DK_ID", precision=12)
	private BigDecimal dkId;

	@Column(name="DNM_ID", precision=12)
	private BigDecimal dnmId;

	@Column(name="KEY_TAG", precision=12)
	private BigDecimal keyTag;

	@Column(precision=12)
	private BigDecimal protocol;

	@Column(name="PUBLIEKE_SLEUTEL", length=4000)
	private String publiekeSleutel;

	@Column(name="TA_CODE", length=3)
	private String taCode;

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

	@Column(precision=12)
	private BigDecimal vlag;

	public DrpDnsKeyA() {
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

	public BigDecimal getDkId() {
		return this.dkId;
	}

	public void setDkId(BigDecimal dkId) {
		this.dkId = dkId;
	}

	public BigDecimal getDnmId() {
		return this.dnmId;
	}

	public void setDnmId(BigDecimal dnmId) {
		this.dnmId = dnmId;
	}

	public BigDecimal getKeyTag() {
		return this.keyTag;
	}

	public void setKeyTag(BigDecimal keyTag) {
		this.keyTag = keyTag;
	}

	public BigDecimal getProtocol() {
		return this.protocol;
	}

	public void setProtocol(BigDecimal protocol) {
		this.protocol = protocol;
	}

	public String getPubliekeSleutel() {
		return this.publiekeSleutel;
	}

	public void setPubliekeSleutel(String publiekeSleutel) {
		this.publiekeSleutel = publiekeSleutel;
	}

	public String getTaCode() {
		return this.taCode;
	}

	public void setTaCode(String taCode) {
		this.taCode = taCode;
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

	public BigDecimal getVlag() {
		return this.vlag;
	}

	public void setVlag(BigDecimal vlag) {
		this.vlag = vlag;
	}

}