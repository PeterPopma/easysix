package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_RECHTSVORM database table.
 * 
 */
@Entity
@Table(name="DRP_RECHTSVORM")
@NamedQuery(name="DrpRechtsvorm.findAll", query="SELECT d FROM DrpRechtsvorm d")
public class DrpRechtsvorm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RVM_CODE", unique=true, nullable=false, length=15)
	private String rvmCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpContactpersoon
	@OneToMany(mappedBy="drpRechtsvorm")
	private List<DrpContactpersoon> drpContactpersoons;

	//bi-directional many-to-one association to DrpDeelnemer
	@OneToMany(mappedBy="drpRechtsvorm")
	private List<DrpDeelnemer> drpDeelnemers;

	public DrpRechtsvorm() {
	}

	public String getRvmCode() {
		return this.rvmCode;
	}

	public void setRvmCode(String rvmCode) {
		this.rvmCode = rvmCode;
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

	public List<DrpContactpersoon> getDrpContactpersoons() {
		return this.drpContactpersoons;
	}

	public void setDrpContactpersoons(List<DrpContactpersoon> drpContactpersoons) {
		this.drpContactpersoons = drpContactpersoons;
	}

	public DrpContactpersoon addDrpContactpersoon(DrpContactpersoon drpContactpersoon) {
		getDrpContactpersoons().add(drpContactpersoon);
		drpContactpersoon.setDrpRechtsvorm(this);

		return drpContactpersoon;
	}

	public DrpContactpersoon removeDrpContactpersoon(DrpContactpersoon drpContactpersoon) {
		getDrpContactpersoons().remove(drpContactpersoon);
		drpContactpersoon.setDrpRechtsvorm(null);

		return drpContactpersoon;
	}

	public List<DrpDeelnemer> getDrpDeelnemers() {
		return this.drpDeelnemers;
	}

	public void setDrpDeelnemers(List<DrpDeelnemer> drpDeelnemers) {
		this.drpDeelnemers = drpDeelnemers;
	}

	public DrpDeelnemer addDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		getDrpDeelnemers().add(drpDeelnemer);
		drpDeelnemer.setDrpRechtsvorm(this);

		return drpDeelnemer;
	}

	public DrpDeelnemer removeDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		getDrpDeelnemers().remove(drpDeelnemer);
		drpDeelnemer.setDrpRechtsvorm(null);

		return drpDeelnemer;
	}

}