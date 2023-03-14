package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_INSTANTIE database table.
 * 
 */
@Entity
@Table(name="DRP_INSTANTIE")
@NamedQuery(name="DrpInstantie.findAll", query="SELECT d FROM DrpInstantie d")
public class DrpInstantie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ISE_CODE", unique=true, nullable=false, length=40)
	private String iseCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpBeperking
	@OneToMany(mappedBy="drpInstantie")
	private List<DrpBeperking> drpBeperkings;

	//bi-directional many-to-one association to DrpInstantieTypeBeperking
	@OneToMany(mappedBy="drpInstantie")
	private List<DrpInstantieTypeBeperking> drpInstantieTypeBeperkings;

	public DrpInstantie() {
	}

	public String getIseCode() {
		return this.iseCode;
	}

	public void setIseCode(String iseCode) {
		this.iseCode = iseCode;
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

	public List<DrpBeperking> getDrpBeperkings() {
		return this.drpBeperkings;
	}

	public void setDrpBeperkings(List<DrpBeperking> drpBeperkings) {
		this.drpBeperkings = drpBeperkings;
	}

	public DrpBeperking addDrpBeperking(DrpBeperking drpBeperking) {
		getDrpBeperkings().add(drpBeperking);
		drpBeperking.setDrpInstantie(this);

		return drpBeperking;
	}

	public DrpBeperking removeDrpBeperking(DrpBeperking drpBeperking) {
		getDrpBeperkings().remove(drpBeperking);
		drpBeperking.setDrpInstantie(null);

		return drpBeperking;
	}

	public List<DrpInstantieTypeBeperking> getDrpInstantieTypeBeperkings() {
		return this.drpInstantieTypeBeperkings;
	}

	public void setDrpInstantieTypeBeperkings(List<DrpInstantieTypeBeperking> drpInstantieTypeBeperkings) {
		this.drpInstantieTypeBeperkings = drpInstantieTypeBeperkings;
	}

	public DrpInstantieTypeBeperking addDrpInstantieTypeBeperking(DrpInstantieTypeBeperking drpInstantieTypeBeperking) {
		getDrpInstantieTypeBeperkings().add(drpInstantieTypeBeperking);
		drpInstantieTypeBeperking.setDrpInstantie(this);

		return drpInstantieTypeBeperking;
	}

	public DrpInstantieTypeBeperking removeDrpInstantieTypeBeperking(DrpInstantieTypeBeperking drpInstantieTypeBeperking) {
		getDrpInstantieTypeBeperkings().remove(drpInstantieTypeBeperking);
		drpInstantieTypeBeperking.setDrpInstantie(null);

		return drpInstantieTypeBeperking;
	}

}