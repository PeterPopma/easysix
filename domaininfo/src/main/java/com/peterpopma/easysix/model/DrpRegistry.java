package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_REGISTRY database table.
 * 
 */
@Entity
@Table(name="DRP_REGISTRY")
@NamedQuery(name="DrpRegistry.findAll", query="SELECT d FROM DrpRegistry d")
public class DrpRegistry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RGY_ID", unique=true, nullable=false, precision=12)
	private long rgyId;

	@Column(nullable=false, length=80)
	private String naam;

	@Column(length=100)
	private String tld;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpBedrijfsregelGrpReg
	@OneToMany(mappedBy="drpRegistry")
	private List<DrpBedrijfsregelGrpReg> drpBedrijfsregelGrpRegs;

	//bi-directional many-to-one association to DrpDeelnemer
	@OneToMany(mappedBy="drpRegistry1")
	private List<DrpDeelnemer> drpDeelnemers1;

	//bi-directional many-to-one association to DrpDeelnemer
	@OneToMany(mappedBy="drpRegistry2")
	private List<DrpDeelnemer> drpDeelnemers2;

	public DrpRegistry() {
	}

	public long getRgyId() {
		return this.rgyId;
	}

	public void setRgyId(long rgyId) {
		this.rgyId = rgyId;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getTld() {
		return this.tld;
	}

	public void setTld(String tld) {
		this.tld = tld;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<DrpBedrijfsregelGrpReg> getDrpBedrijfsregelGrpRegs() {
		return this.drpBedrijfsregelGrpRegs;
	}

	public void setDrpBedrijfsregelGrpRegs(List<DrpBedrijfsregelGrpReg> drpBedrijfsregelGrpRegs) {
		this.drpBedrijfsregelGrpRegs = drpBedrijfsregelGrpRegs;
	}

	public DrpBedrijfsregelGrpReg addDrpBedrijfsregelGrpReg(DrpBedrijfsregelGrpReg drpBedrijfsregelGrpReg) {
		getDrpBedrijfsregelGrpRegs().add(drpBedrijfsregelGrpReg);
		drpBedrijfsregelGrpReg.setDrpRegistry(this);

		return drpBedrijfsregelGrpReg;
	}

	public DrpBedrijfsregelGrpReg removeDrpBedrijfsregelGrpReg(DrpBedrijfsregelGrpReg drpBedrijfsregelGrpReg) {
		getDrpBedrijfsregelGrpRegs().remove(drpBedrijfsregelGrpReg);
		drpBedrijfsregelGrpReg.setDrpRegistry(null);

		return drpBedrijfsregelGrpReg;
	}

	public List<DrpDeelnemer> getDrpDeelnemers1() {
		return this.drpDeelnemers1;
	}

	public void setDrpDeelnemers1(List<DrpDeelnemer> drpDeelnemers1) {
		this.drpDeelnemers1 = drpDeelnemers1;
	}

	public DrpDeelnemer addDrpDeelnemers1(DrpDeelnemer drpDeelnemers1) {
		getDrpDeelnemers1().add(drpDeelnemers1);
		drpDeelnemers1.setDrpRegistry1(this);

		return drpDeelnemers1;
	}

	public DrpDeelnemer removeDrpDeelnemers1(DrpDeelnemer drpDeelnemers1) {
		getDrpDeelnemers1().remove(drpDeelnemers1);
		drpDeelnemers1.setDrpRegistry1(null);

		return drpDeelnemers1;
	}

	public List<DrpDeelnemer> getDrpDeelnemers2() {
		return this.drpDeelnemers2;
	}

	public void setDrpDeelnemers2(List<DrpDeelnemer> drpDeelnemers2) {
		this.drpDeelnemers2 = drpDeelnemers2;
	}

	public DrpDeelnemer addDrpDeelnemers2(DrpDeelnemer drpDeelnemers2) {
		getDrpDeelnemers2().add(drpDeelnemers2);
		drpDeelnemers2.setDrpRegistry2(this);

		return drpDeelnemers2;
	}

	public DrpDeelnemer removeDrpDeelnemers2(DrpDeelnemer drpDeelnemers2) {
		getDrpDeelnemers2().remove(drpDeelnemers2);
		drpDeelnemers2.setDrpRegistry2(null);

		return drpDeelnemers2;
	}

}