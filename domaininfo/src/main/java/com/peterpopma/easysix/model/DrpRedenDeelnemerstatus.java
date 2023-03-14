package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_REDEN_DEELNEMERSTATUS database table.
 * 
 */
@Entity
@Table(name="DRP_REDEN_DEELNEMERSTATUS")
@NamedQuery(name="DrpRedenDeelnemerstatus.findAll", query="SELECT d FROM DrpRedenDeelnemerstatus d")
public class DrpRedenDeelnemerstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RDS_CODE", unique=true, nullable=false, length=40)
	private String rdsCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpDeelnemer
	@OneToMany(mappedBy="drpRedenDeelnemerstatus")
	private List<DrpDeelnemer> drpDeelnemers;

	public DrpRedenDeelnemerstatus() {
	}

	public String getRdsCode() {
		return this.rdsCode;
	}

	public void setRdsCode(String rdsCode) {
		this.rdsCode = rdsCode;
	}

	public String getTaalboeknaam() {
		return this.taalboeknaam;
	}

	public void setTaalboeknaam(String taalboeknaam) {
		this.taalboeknaam = taalboeknaam;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<DrpDeelnemer> getDrpDeelnemers() {
		return this.drpDeelnemers;
	}

	public void setDrpDeelnemers(List<DrpDeelnemer> drpDeelnemers) {
		this.drpDeelnemers = drpDeelnemers;
	}

	public DrpDeelnemer addDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		getDrpDeelnemers().add(drpDeelnemer);
		drpDeelnemer.setDrpRedenDeelnemerstatus(this);

		return drpDeelnemer;
	}

	public DrpDeelnemer removeDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		getDrpDeelnemers().remove(drpDeelnemer);
		drpDeelnemer.setDrpRedenDeelnemerstatus(null);

		return drpDeelnemer;
	}

}