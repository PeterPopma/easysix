package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_REGISTRATIEWIJZE database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_REGISTRATIEWIJZE")
@NamedQuery(name="DrpTypeRegistratiewijze.findAll", query="SELECT d FROM DrpTypeRegistratiewijze d")
public class DrpTypeRegistratiewijze implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TRW_CODE", unique=true, nullable=false, length=25)
	private String trwCode;

	//bi-directional many-to-one association to DrpLaunchPhase
	@OneToMany(mappedBy="drpTypeRegistratiewijze")
	private List<DrpLaunchPhase> drpLaunchPhases;

	//bi-directional many-to-one association to DrpTmdbLaunchphaseClaim
	@OneToMany(mappedBy="drpTypeRegistratiewijze")
	private List<DrpTmdbLaunchphaseClaim> drpTmdbLaunchphaseClaims;

	public DrpTypeRegistratiewijze() {
	}

	public String getTrwCode() {
		return this.trwCode;
	}

	public void setTrwCode(String trwCode) {
		this.trwCode = trwCode;
	}

	public List<DrpLaunchPhase> getDrpLaunchPhases() {
		return this.drpLaunchPhases;
	}

	public void setDrpLaunchPhases(List<DrpLaunchPhase> drpLaunchPhases) {
		this.drpLaunchPhases = drpLaunchPhases;
	}

	public DrpLaunchPhase addDrpLaunchPhas(DrpLaunchPhase drpLaunchPhas) {
		getDrpLaunchPhases().add(drpLaunchPhas);
		drpLaunchPhas.setDrpTypeRegistratiewijze(this);

		return drpLaunchPhas;
	}

	public DrpLaunchPhase removeDrpLaunchPhas(DrpLaunchPhase drpLaunchPhas) {
		getDrpLaunchPhases().remove(drpLaunchPhas);
		drpLaunchPhas.setDrpTypeRegistratiewijze(null);

		return drpLaunchPhas;
	}

	public List<DrpTmdbLaunchphaseClaim> getDrpTmdbLaunchphaseClaims() {
		return this.drpTmdbLaunchphaseClaims;
	}

	public void setDrpTmdbLaunchphaseClaims(List<DrpTmdbLaunchphaseClaim> drpTmdbLaunchphaseClaims) {
		this.drpTmdbLaunchphaseClaims = drpTmdbLaunchphaseClaims;
	}

	public DrpTmdbLaunchphaseClaim addDrpTmdbLaunchphaseClaim(DrpTmdbLaunchphaseClaim drpTmdbLaunchphaseClaim) {
		getDrpTmdbLaunchphaseClaims().add(drpTmdbLaunchphaseClaim);
		drpTmdbLaunchphaseClaim.setDrpTypeRegistratiewijze(this);

		return drpTmdbLaunchphaseClaim;
	}

	public DrpTmdbLaunchphaseClaim removeDrpTmdbLaunchphaseClaim(DrpTmdbLaunchphaseClaim drpTmdbLaunchphaseClaim) {
		getDrpTmdbLaunchphaseClaims().remove(drpTmdbLaunchphaseClaim);
		drpTmdbLaunchphaseClaim.setDrpTypeRegistratiewijze(null);

		return drpTmdbLaunchphaseClaim;
	}

}