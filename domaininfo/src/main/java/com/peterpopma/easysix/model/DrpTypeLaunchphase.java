package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_LAUNCHPHASE database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_LAUNCHPHASE")
@NamedQuery(name="DrpTypeLaunchphase.findAll", query="SELECT d FROM DrpTypeLaunchphase d")
public class DrpTypeLaunchphase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TLP_CODE", unique=true, nullable=false, length=25)
	private String tlpCode;

	//bi-directional many-to-one association to DrpLaunchPhase
	@OneToMany(mappedBy="drpTypeLaunchphase")
	private List<DrpLaunchPhase> drpLaunchPhases;

	public DrpTypeLaunchphase() {
	}

	public String getTlpCode() {
		return this.tlpCode;
	}

	public void setTlpCode(String tlpCode) {
		this.tlpCode = tlpCode;
	}

	public List<DrpLaunchPhase> getDrpLaunchPhases() {
		return this.drpLaunchPhases;
	}

	public void setDrpLaunchPhases(List<DrpLaunchPhase> drpLaunchPhases) {
		this.drpLaunchPhases = drpLaunchPhases;
	}

	public DrpLaunchPhase addDrpLaunchPhas(DrpLaunchPhase drpLaunchPhas) {
		getDrpLaunchPhases().add(drpLaunchPhas);
		drpLaunchPhas.setDrpTypeLaunchphase(this);

		return drpLaunchPhas;
	}

	public DrpLaunchPhase removeDrpLaunchPhas(DrpLaunchPhase drpLaunchPhas) {
		getDrpLaunchPhases().remove(drpLaunchPhas);
		drpLaunchPhas.setDrpTypeLaunchphase(null);

		return drpLaunchPhas;
	}

}