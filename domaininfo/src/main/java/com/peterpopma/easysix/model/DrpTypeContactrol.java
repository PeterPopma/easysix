package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_CONTACTROL database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_CONTACTROL")
@NamedQuery(name="DrpTypeContactrol.findAll", query="SELECT d FROM DrpTypeContactrol d")
public class DrpTypeContactrol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TCL_CODE", unique=true, nullable=false, length=16)
	private String tclCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpContactrol
	@OneToMany(mappedBy="drpTypeContactrol")
	private List<DrpContactrol> drpContactrols;

	public DrpTypeContactrol() {
	}

	public String getTclCode() {
		return this.tclCode;
	}

	public void setTclCode(String tclCode) {
		this.tclCode = tclCode;
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

	public List<DrpContactrol> getDrpContactrols() {
		return this.drpContactrols;
	}

	public void setDrpContactrols(List<DrpContactrol> drpContactrols) {
		this.drpContactrols = drpContactrols;
	}

	public DrpContactrol addDrpContactrol(DrpContactrol drpContactrol) {
		getDrpContactrols().add(drpContactrol);
		drpContactrol.setDrpTypeContactrol(this);

		return drpContactrol;
	}

	public DrpContactrol removeDrpContactrol(DrpContactrol drpContactrol) {
		getDrpContactrols().remove(drpContactrol);
		drpContactrol.setDrpTypeContactrol(null);

		return drpContactrol;
	}

}