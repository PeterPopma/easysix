package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_TOKEN_RESET database table.
 * 
 */
@Entity
@Table(name="DRP_TOKEN_RESET")
@NamedQuery(name="DrpTokenReset.findAll", query="SELECT d FROM DrpTokenReset d")
public class DrpTokenReset implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=16)
	private String deelnemernummer;

	@Column(name="DNM_ID", nullable=false, precision=12)
	private BigDecimal dnmId;

	private Object einddatum;

	@Column(nullable=false)
	private Object startdatum;

	@Column(name="TOKEN_NEW", length=12)
	private String tokenNew;

	@Column(name="TOKEN_OLD", nullable=false, length=12)
	private String tokenOld;

	public DrpTokenReset() {
	}

	public String getDeelnemernummer() {
		return this.deelnemernummer;
	}

	public void setDeelnemernummer(String deelnemernummer) {
		this.deelnemernummer = deelnemernummer;
	}

	public BigDecimal getDnmId() {
		return this.dnmId;
	}

	public void setDnmId(BigDecimal dnmId) {
		this.dnmId = dnmId;
	}

	public Object getEinddatum() {
		return this.einddatum;
	}

	public void setEinddatum(Object einddatum) {
		this.einddatum = einddatum;
	}

	public Object getStartdatum() {
		return this.startdatum;
	}

	public void setStartdatum(Object startdatum) {
		this.startdatum = startdatum;
	}

	public String getTokenNew() {
		return this.tokenNew;
	}

	public void setTokenNew(String tokenNew) {
		this.tokenNew = tokenNew;
	}

	public String getTokenOld() {
		return this.tokenOld;
	}

	public void setTokenOld(String tokenOld) {
		this.tokenOld = tokenOld;
	}

}