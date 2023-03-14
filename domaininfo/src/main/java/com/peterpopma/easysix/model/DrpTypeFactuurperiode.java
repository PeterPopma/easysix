package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_FACTUURPERIODE database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_FACTUURPERIODE")
@NamedQuery(name="DrpTypeFactuurperiode.findAll", query="SELECT d FROM DrpTypeFactuurperiode d")
public class DrpTypeFactuurperiode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TFE_CODE", unique=true, nullable=false, length=10)
	private String tfeCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpDeelnemer
	@OneToMany(mappedBy="drpTypeFactuurperiode")
	private List<DrpDeelnemer> drpDeelnemers;

	public DrpTypeFactuurperiode() {
	}

	public String getTfeCode() {
		return this.tfeCode;
	}

	public void setTfeCode(String tfeCode) {
		this.tfeCode = tfeCode;
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
		drpDeelnemer.setDrpTypeFactuurperiode(this);

		return drpDeelnemer;
	}

	public DrpDeelnemer removeDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		getDrpDeelnemers().remove(drpDeelnemer);
		drpDeelnemer.setDrpTypeFactuurperiode(null);

		return drpDeelnemer;
	}

}