package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_DASHBOARD_DOMEINNAAM database table.
 * 
 */
@Entity
@Table(name="DRP_DASHBOARD_DOMEINNAAM")
@NamedQuery(name="DrpDashboardDomeinnaam.findAll", query="SELECT d FROM DrpDashboardDomeinnaam d")
public class DrpDashboardDomeinnaam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DDM_ID", unique=true, nullable=false, precision=12)
	private long ddmId;

	@Column(name="DNM_ID", nullable=false, precision=12)
	private BigDecimal dnmId;

	@Column(name="DNR_ID", nullable=false, precision=12)
	private BigDecimal dnrId;

	@Column(nullable=false)
	private Object laatstbewerkt;

	@Column(name="LAATSTE_ACTIE", length=50)
	private String laatsteActie;

	@Column(name="LAATSTE_TICKETNUMMER", precision=15)
	private BigDecimal laatsteTicketnummer;

	@Column(nullable=false, length=127)
	private String naam;

	public DrpDashboardDomeinnaam() {
	}

	public long getDdmId() {
		return this.ddmId;
	}

	public void setDdmId(long ddmId) {
		this.ddmId = ddmId;
	}

	public BigDecimal getDnmId() {
		return this.dnmId;
	}

	public void setDnmId(BigDecimal dnmId) {
		this.dnmId = dnmId;
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

	public BigDecimal getLaatsteTicketnummer() {
		return this.laatsteTicketnummer;
	}

	public void setLaatsteTicketnummer(BigDecimal laatsteTicketnummer) {
		this.laatsteTicketnummer = laatsteTicketnummer;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

}