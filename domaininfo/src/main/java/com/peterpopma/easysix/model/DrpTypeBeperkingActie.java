package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_BEPERKING_ACTIE database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_BEPERKING_ACTIE")
@NamedQuery(name="DrpTypeBeperkingActie.findAll", query="SELECT d FROM DrpTypeBeperkingActie d")
public class DrpTypeBeperkingActie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TBE_CODE", unique=true, nullable=false, length=16)
	private String tbeCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpBeperkingValidatie
	@OneToMany(mappedBy="drpTypeBeperkingActie1")
	private List<DrpBeperkingValidatie> drpBeperkingValidaties1;

	//bi-directional many-to-one association to DrpBeperkingValidatie
	@OneToMany(mappedBy="drpTypeBeperkingActie2")
	private List<DrpBeperkingValidatie> drpBeperkingValidaties2;

	public DrpTypeBeperkingActie() {
	}

	public String getTbeCode() {
		return this.tbeCode;
	}

	public void setTbeCode(String tbeCode) {
		this.tbeCode = tbeCode;
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

	public List<DrpBeperkingValidatie> getDrpBeperkingValidaties1() {
		return this.drpBeperkingValidaties1;
	}

	public void setDrpBeperkingValidaties1(List<DrpBeperkingValidatie> drpBeperkingValidaties1) {
		this.drpBeperkingValidaties1 = drpBeperkingValidaties1;
	}

	public DrpBeperkingValidatie addDrpBeperkingValidaties1(DrpBeperkingValidatie drpBeperkingValidaties1) {
		getDrpBeperkingValidaties1().add(drpBeperkingValidaties1);
		drpBeperkingValidaties1.setDrpTypeBeperkingActie1(this);

		return drpBeperkingValidaties1;
	}

	public DrpBeperkingValidatie removeDrpBeperkingValidaties1(DrpBeperkingValidatie drpBeperkingValidaties1) {
		getDrpBeperkingValidaties1().remove(drpBeperkingValidaties1);
		drpBeperkingValidaties1.setDrpTypeBeperkingActie1(null);

		return drpBeperkingValidaties1;
	}

	public List<DrpBeperkingValidatie> getDrpBeperkingValidaties2() {
		return this.drpBeperkingValidaties2;
	}

	public void setDrpBeperkingValidaties2(List<DrpBeperkingValidatie> drpBeperkingValidaties2) {
		this.drpBeperkingValidaties2 = drpBeperkingValidaties2;
	}

	public DrpBeperkingValidatie addDrpBeperkingValidaties2(DrpBeperkingValidatie drpBeperkingValidaties2) {
		getDrpBeperkingValidaties2().add(drpBeperkingValidaties2);
		drpBeperkingValidaties2.setDrpTypeBeperkingActie2(this);

		return drpBeperkingValidaties2;
	}

	public DrpBeperkingValidatie removeDrpBeperkingValidaties2(DrpBeperkingValidatie drpBeperkingValidaties2) {
		getDrpBeperkingValidaties2().remove(drpBeperkingValidaties2);
		drpBeperkingValidaties2.setDrpTypeBeperkingActie2(null);

		return drpBeperkingValidaties2;
	}

}