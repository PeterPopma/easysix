package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_DASHBOARD_RESELLER database table.
 * 
 */
@Entity
@Table(name="DRP_DASHBOARD_RESELLER")
@NamedQuery(name="DrpDashboardReseller.findAll", query="SELECT d FROM DrpDashboardReseller d")
public class DrpDashboardReseller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRR_ID", unique=true, nullable=false, precision=12)
	private long drrId;

	@Column(name="DNR_ID", nullable=false, precision=12)
	private BigDecimal dnrId;

	@Column(nullable=false)
	private Object laatstbewerkt;

	@Column(name="LAATSTE_ACTIE", length=50)
	private String laatsteActie;

	@Column(nullable=false, length=255)
	private String naam;

	@Column(name="RESELLER_ID", nullable=false, length=20)
	private String resellerId;

	@Column(name="RSR_ID", nullable=false, precision=12)
	private BigDecimal rsrId;

	public DrpDashboardReseller() {
	}

	public long getDrrId() {
		return this.drrId;
	}

	public void setDrrId(long drrId) {
		this.drrId = drrId;
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

	public String getResellerId() {
		return this.resellerId;
	}

	public void setResellerId(String resellerId) {
		this.resellerId = resellerId;
	}

	public BigDecimal getRsrId() {
		return this.rsrId;
	}

	public void setRsrId(BigDecimal rsrId) {
		this.rsrId = rsrId;
	}

}