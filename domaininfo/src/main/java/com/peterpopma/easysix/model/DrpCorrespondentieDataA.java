package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_CORRESPONDENTIE_DATA_A database table.
 * 
 */
@Entity
@Table(name="DRP_CORRESPONDENTIE_DATA_A")
@NamedQuery(name="DrpCorrespondentieDataA.findAll", query="SELECT d FROM DrpCorrespondentieDataA d")
public class DrpCorrespondentieDataA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="AUD_ID", nullable=false)
	private BigDecimal audId;

	@Lob
	private byte[] binarydata;

	@Column(name="CRE_ID", nullable=false, precision=12)
	private BigDecimal creId;

	@Lob
	private String stringdata;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(name="USER_ID", length=50)
	private String userId;

	public DrpCorrespondentieDataA() {
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

	public byte[] getBinarydata() {
		return this.binarydata;
	}

	public void setBinarydata(byte[] binarydata) {
		this.binarydata = binarydata;
	}

	public BigDecimal getCreId() {
		return this.creId;
	}

	public void setCreId(BigDecimal creId) {
		this.creId = creId;
	}

	public String getStringdata() {
		return this.stringdata;
	}

	public void setStringdata(String stringdata) {
		this.stringdata = stringdata;
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

}