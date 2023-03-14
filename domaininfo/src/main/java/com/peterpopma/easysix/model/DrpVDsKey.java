package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_V_DS_KEYS database table.
 * 
 */
@Entity
@Table(name="DRP_V_DS_KEYS")
@NamedQuery(name="DrpVDsKey.findAll", query="SELECT d FROM DrpVDsKey d")
public class DrpVDsKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="DNSKEY_TAG", nullable=false, precision=12)
	private BigDecimal dnskeyTag;

	@Column(nullable=false, length=127)
	private String domeinnaam;

	@Column(name="SIGNER_DIGEST_WAARDE", nullable=false, length=2000)
	private String signerDigestWaarde;

	@Column(name="SIGNER_TA_CODE", nullable=false, length=3)
	private String signerTaCode;

	@Column(name="SIGNER_TD_CODE", nullable=false, length=1)
	private String signerTdCode;

	public DrpVDsKey() {
	}

	public BigDecimal getDnskeyTag() {
		return this.dnskeyTag;
	}

	public void setDnskeyTag(BigDecimal dnskeyTag) {
		this.dnskeyTag = dnskeyTag;
	}

	public String getDomeinnaam() {
		return this.domeinnaam;
	}

	public void setDomeinnaam(String domeinnaam) {
		this.domeinnaam = domeinnaam;
	}

	public String getSignerDigestWaarde() {
		return this.signerDigestWaarde;
	}

	public void setSignerDigestWaarde(String signerDigestWaarde) {
		this.signerDigestWaarde = signerDigestWaarde;
	}

	public String getSignerTaCode() {
		return this.signerTaCode;
	}

	public void setSignerTaCode(String signerTaCode) {
		this.signerTaCode = signerTaCode;
	}

	public String getSignerTdCode() {
		return this.signerTdCode;
	}

	public void setSignerTdCode(String signerTdCode) {
		this.signerTdCode = signerTdCode;
	}

}