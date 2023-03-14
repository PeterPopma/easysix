package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_DELEGATION_SIGNER_A database table.
 * 
 */
@Entity
@Table(name="DRP_DELEGATION_SIGNER_A")
@NamedQuery(name="DrpDelegationSignerA.findAll", query="SELECT d FROM DrpDelegationSignerA d")
public class DrpDelegationSignerA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="DIGEST_WAARDE", length=2000)
	private String digestWaarde;

	@Column(name="DK_ID", precision=12)
	private BigDecimal dkId;

	@Column(name="DS_ID", precision=12)
	private BigDecimal dsId;

	@Column(name="TD_CODE", length=1)
	private String tdCode;

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

	public DrpDelegationSignerA() {
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

	public String getDigestWaarde() {
		return this.digestWaarde;
	}

	public void setDigestWaarde(String digestWaarde) {
		this.digestWaarde = digestWaarde;
	}

	public BigDecimal getDkId() {
		return this.dkId;
	}

	public void setDkId(BigDecimal dkId) {
		this.dkId = dkId;
	}

	public BigDecimal getDsId() {
		return this.dsId;
	}

	public void setDsId(BigDecimal dsId) {
		this.dsId = dsId;
	}

	public String getTdCode() {
		return this.tdCode;
	}

	public void setTdCode(String tdCode) {
		this.tdCode = tdCode;
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