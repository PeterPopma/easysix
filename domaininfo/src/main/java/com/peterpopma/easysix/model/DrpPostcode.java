package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_POSTCODE database table.
 * 
 */
@Entity
@Table(name="DRP_POSTCODE")
@NamedQuery(name="DrpPostcode.findAll", query="SELECT d FROM DrpPostcode d")
public class DrpPostcode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PCE_ID", unique=true, nullable=false, precision=12)
	private long pceId;

	@Column(name="BREEKPUNT_TM", nullable=false, precision=5)
	private BigDecimal breekpuntTm;

	@Column(name="BREEKPUNT_VANAF", nullable=false, precision=5)
	private BigDecimal breekpuntVanaf;

	@Column(length=50)
	private String plaats;

	@Column(length=6)
	private String postcode;

	@Column(length=1)
	private String reeks;

	@Column(length=50)
	private String straatnaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	public DrpPostcode() {
	}

	public long getPceId() {
		return this.pceId;
	}

	public void setPceId(long pceId) {
		this.pceId = pceId;
	}

	public BigDecimal getBreekpuntTm() {
		return this.breekpuntTm;
	}

	public void setBreekpuntTm(BigDecimal breekpuntTm) {
		this.breekpuntTm = breekpuntTm;
	}

	public BigDecimal getBreekpuntVanaf() {
		return this.breekpuntVanaf;
	}

	public void setBreekpuntVanaf(BigDecimal breekpuntVanaf) {
		this.breekpuntVanaf = breekpuntVanaf;
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

	public String getReeks() {
		return this.reeks;
	}

	public void setReeks(String reeks) {
		this.reeks = reeks;
	}

	public String getStraatnaam() {
		return this.straatnaam;
	}

	public void setStraatnaam(String straatnaam) {
		this.straatnaam = straatnaam;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}