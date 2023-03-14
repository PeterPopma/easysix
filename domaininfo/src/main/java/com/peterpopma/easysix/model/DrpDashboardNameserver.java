package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_DASHBOARD_NAMESERVER database table.
 * 
 */
@Entity
@Table(name="DRP_DASHBOARD_NAMESERVER")
@NamedQuery(name="DrpDashboardNameserver.findAll", query="SELECT d FROM DrpDashboardNameserver d")
public class DrpDashboardNameserver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DBN_ID", unique=true, nullable=false, precision=12)
	private long dbnId;

	@Column(name="DNR_ID", nullable=false, precision=12)
	private BigDecimal dnrId;

	@Column(nullable=false)
	private Object laatstbewerkt;

	@Column(name="LAATSTE_ACTIE", length=50)
	private String laatsteActie;

	@Column(nullable=false, length=255)
	private String naam;

	@Column(name="NSR_ID", nullable=false, precision=12)
	private BigDecimal nsrId;

	public DrpDashboardNameserver() {
	}

	public long getDbnId() {
		return this.dbnId;
	}

	public void setDbnId(long dbnId) {
		this.dbnId = dbnId;
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

	public BigDecimal getNsrId() {
		return this.nsrId;
	}

	public void setNsrId(BigDecimal nsrId) {
		this.nsrId = nsrId;
	}

}