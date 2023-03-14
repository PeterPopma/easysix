package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_BEOORDELING database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_BEOORDELING")
@NamedQuery(name="DrpTypeBeoordeling.findAll", query="SELECT d FROM DrpTypeBeoordeling d")
public class DrpTypeBeoordeling implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TOG_CODE", unique=true, nullable=false, length=20)
	private String togCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpBeoordeling
	@OneToMany(mappedBy="drpTypeBeoordeling")
	private List<DrpBeoordeling> drpBeoordelings;

	public DrpTypeBeoordeling() {
	}

	public String getTogCode() {
		return this.togCode;
	}

	public void setTogCode(String togCode) {
		this.togCode = togCode;
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

	public List<DrpBeoordeling> getDrpBeoordelings() {
		return this.drpBeoordelings;
	}

	public void setDrpBeoordelings(List<DrpBeoordeling> drpBeoordelings) {
		this.drpBeoordelings = drpBeoordelings;
	}

	public DrpBeoordeling addDrpBeoordeling(DrpBeoordeling drpBeoordeling) {
		getDrpBeoordelings().add(drpBeoordeling);
		drpBeoordeling.setDrpTypeBeoordeling(this);

		return drpBeoordeling;
	}

	public DrpBeoordeling removeDrpBeoordeling(DrpBeoordeling drpBeoordeling) {
		getDrpBeoordelings().remove(drpBeoordeling);
		drpBeoordeling.setDrpTypeBeoordeling(null);

		return drpBeoordeling;
	}

}