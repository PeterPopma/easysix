package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_LAUNCH_PHASE database table.
 * 
 */
@Entity
@Table(name="DRP_LAUNCH_PHASE")
@NamedQuery(name="DrpLaunchPhase.findAll", query="SELECT d FROM DrpLaunchPhase d")
public class DrpLaunchPhase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LP_ID", unique=true, nullable=false, precision=12)
	private long lpId;

	@Column(name="EIND_DATETIME")
	private Object eindDatetime;

	@Column(name="EXCLUSIEVE_REGISTRAR", length=10)
	private String exclusieveRegistrar;

	@Column(length=25)
	private String naam;

	@Column(name="START_DATETIME", nullable=false)
	private Object startDatetime;

	//bi-directional many-to-one association to DrpTypeLaunchphase
	@ManyToOne
	@JoinColumn(name="PHASE_TYPE", nullable=false)
	private DrpTypeLaunchphase drpTypeLaunchphase;

	//bi-directional many-to-one association to DrpTypeRegistratiewijze
	@ManyToOne
	@JoinColumn(name="REGISTRATIEWIJZE_TYPE")
	private DrpTypeRegistratiewijze drpTypeRegistratiewijze;

	public DrpLaunchPhase() {
	}

	public long getLpId() {
		return this.lpId;
	}

	public void setLpId(long lpId) {
		this.lpId = lpId;
	}

	public Object getEindDatetime() {
		return this.eindDatetime;
	}

	public void setEindDatetime(Object eindDatetime) {
		this.eindDatetime = eindDatetime;
	}

	public String getExclusieveRegistrar() {
		return this.exclusieveRegistrar;
	}

	public void setExclusieveRegistrar(String exclusieveRegistrar) {
		this.exclusieveRegistrar = exclusieveRegistrar;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Object getStartDatetime() {
		return this.startDatetime;
	}

	public void setStartDatetime(Object startDatetime) {
		this.startDatetime = startDatetime;
	}

	public DrpTypeLaunchphase getDrpTypeLaunchphase() {
		return this.drpTypeLaunchphase;
	}

	public void setDrpTypeLaunchphase(DrpTypeLaunchphase drpTypeLaunchphase) {
		this.drpTypeLaunchphase = drpTypeLaunchphase;
	}

	public DrpTypeRegistratiewijze getDrpTypeRegistratiewijze() {
		return this.drpTypeRegistratiewijze;
	}

	public void setDrpTypeRegistratiewijze(DrpTypeRegistratiewijze drpTypeRegistratiewijze) {
		this.drpTypeRegistratiewijze = drpTypeRegistratiewijze;
	}

}