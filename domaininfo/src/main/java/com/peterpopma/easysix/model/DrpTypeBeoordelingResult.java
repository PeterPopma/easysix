package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_BEOORDELING_RESULT database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_BEOORDELING_RESULT")
@NamedQuery(name="DrpTypeBeoordelingResult.findAll", query="SELECT d FROM DrpTypeBeoordelingResult d")
public class DrpTypeBeoordelingResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TOT_CODE", unique=true, nullable=false, length=20)
	private String totCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpBeoordeling
	@OneToMany(mappedBy="drpTypeBeoordelingResult")
	private List<DrpBeoordeling> drpBeoordelings;

	public DrpTypeBeoordelingResult() {
	}

	public String getTotCode() {
		return this.totCode;
	}

	public void setTotCode(String totCode) {
		this.totCode = totCode;
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
		drpBeoordeling.setDrpTypeBeoordelingResult(this);

		return drpBeoordeling;
	}

	public DrpBeoordeling removeDrpBeoordeling(DrpBeoordeling drpBeoordeling) {
		getDrpBeoordelings().remove(drpBeoordeling);
		drpBeoordeling.setDrpTypeBeoordelingResult(null);

		return drpBeoordeling;
	}

}