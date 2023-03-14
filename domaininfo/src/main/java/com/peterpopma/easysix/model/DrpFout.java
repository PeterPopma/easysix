package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_FOUT database table.
 * 
 */
@Entity
@Table(name="DRP_FOUT")
@NamedQuery(name="DrpFout.findAll", query="SELECT d FROM DrpFout d")
public class DrpFout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FOT_CODE", unique=true, nullable=false, length=10)
	private String fotCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpBedrijfsregel
	@OneToMany(mappedBy="drpFout")
	private List<DrpBedrijfsregel> drpBedrijfsregels;

	//bi-directional many-to-one association to DrpGekoppeldeBedrijfsregel
	@OneToMany(mappedBy="drpFout")
	private List<DrpGekoppeldeBedrijfsregel> drpGekoppeldeBedrijfsregels;

	public DrpFout() {
	}

	public String getFotCode() {
		return this.fotCode;
	}

	public void setFotCode(String fotCode) {
		this.fotCode = fotCode;
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

	public List<DrpBedrijfsregel> getDrpBedrijfsregels() {
		return this.drpBedrijfsregels;
	}

	public void setDrpBedrijfsregels(List<DrpBedrijfsregel> drpBedrijfsregels) {
		this.drpBedrijfsregels = drpBedrijfsregels;
	}

	public DrpBedrijfsregel addDrpBedrijfsregel(DrpBedrijfsregel drpBedrijfsregel) {
		getDrpBedrijfsregels().add(drpBedrijfsregel);
		drpBedrijfsregel.setDrpFout(this);

		return drpBedrijfsregel;
	}

	public DrpBedrijfsregel removeDrpBedrijfsregel(DrpBedrijfsregel drpBedrijfsregel) {
		getDrpBedrijfsregels().remove(drpBedrijfsregel);
		drpBedrijfsregel.setDrpFout(null);

		return drpBedrijfsregel;
	}

	public List<DrpGekoppeldeBedrijfsregel> getDrpGekoppeldeBedrijfsregels() {
		return this.drpGekoppeldeBedrijfsregels;
	}

	public void setDrpGekoppeldeBedrijfsregels(List<DrpGekoppeldeBedrijfsregel> drpGekoppeldeBedrijfsregels) {
		this.drpGekoppeldeBedrijfsregels = drpGekoppeldeBedrijfsregels;
	}

	public DrpGekoppeldeBedrijfsregel addDrpGekoppeldeBedrijfsregel(DrpGekoppeldeBedrijfsregel drpGekoppeldeBedrijfsregel) {
		getDrpGekoppeldeBedrijfsregels().add(drpGekoppeldeBedrijfsregel);
		drpGekoppeldeBedrijfsregel.setDrpFout(this);

		return drpGekoppeldeBedrijfsregel;
	}

	public DrpGekoppeldeBedrijfsregel removeDrpGekoppeldeBedrijfsregel(DrpGekoppeldeBedrijfsregel drpGekoppeldeBedrijfsregel) {
		getDrpGekoppeldeBedrijfsregels().remove(drpGekoppeldeBedrijfsregel);
		drpGekoppeldeBedrijfsregel.setDrpFout(null);

		return drpGekoppeldeBedrijfsregel;
	}

}