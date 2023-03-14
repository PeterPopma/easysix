package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_DASHBOARD_CONTACTPERSOON database table.
 * 
 */
@Entity
@Table(name="DRP_DASHBOARD_CONTACTPERSOON")
@NamedQuery(name="DrpDashboardContactpersoon.findAll", query="SELECT d FROM DrpDashboardContactpersoon d")
public class DrpDashboardContactpersoon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DCN_ID", unique=true, nullable=false, precision=12)
	private long dcnId;

	@Column(name="CPN_HANDLE", nullable=false, length=20)
	private String cpnHandle;

	@Column(name="DNR_ID", nullable=false, precision=12)
	private BigDecimal dnrId;

	@Column(nullable=false)
	private Object laatstbewerkt;

	@Column(name="LAATSTE_ACTIE", length=50)
	private String laatsteActie;

	@Column(nullable=false, length=255)
	private String naam;

	public DrpDashboardContactpersoon() {
	}

	public long getDcnId() {
		return this.dcnId;
	}

	public void setDcnId(long dcnId) {
		this.dcnId = dcnId;
	}

	public String getCpnHandle() {
		return this.cpnHandle;
	}

	public void setCpnHandle(String cpnHandle) {
		this.cpnHandle = cpnHandle;
	}

	public BigDecimal getDnrId() {
		return this.dnrId;
	}

	public void setDnrId(BigDecimal dnrId) {
		this.dnrId = dnrId;
	}

	public Object getLaatstbewerkt() {
		return this.laatstbewerkt;
	}

	public void setLaatstbewerkt(Object laatstbewerkt) {
		this.laatstbewerkt = laatstbewerkt;
	}

	public String getLaatsteActie() {
		return this.laatsteActie;
	}

	public void setLaatsteActie(String laatsteActie) {
		this.laatsteActie = laatsteActie;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

}