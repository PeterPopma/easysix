package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_DEELNEMERSTATUS database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_DEELNEMERSTATUS")
@NamedQuery(name="DrpTypeDeelnemerstatus.findAll", query="SELECT d FROM DrpTypeDeelnemerstatus d")
public class DrpTypeDeelnemerstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TMS_CODE", unique=true, nullable=false, length=20)
	private String tmsCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpDeelnemer
	@OneToMany(mappedBy="drpTypeDeelnemerstatus")
	private List<DrpDeelnemer> drpDeelnemers;

	public DrpTypeDeelnemerstatus() {
	}

	public String getTmsCode() {
		return this.tmsCode;
	}

	public void setTmsCode(String tmsCode) {
		this.tmsCode = tmsCode;
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
		drpDeelnemer.setDrpTypeDeelnemerstatus(this);

		return drpDeelnemer;
	}

	public DrpDeelnemer removeDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		getDrpDeelnemers().remove(drpDeelnemer);
		drpDeelnemer.setDrpTypeDeelnemerstatus(null);

		return drpDeelnemer;
	}

}