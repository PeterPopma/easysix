package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_BEDRIJFSREGEL_GROEP database table.
 * 
 */
@Entity
@Table(name="DRP_BEDRIJFSREGEL_GROEP")
@NamedQuery(name="DrpBedrijfsregelGroep.findAll", query="SELECT d FROM DrpBedrijfsregelGroep d")
public class DrpBedrijfsregelGroep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BGP_ID", unique=true, nullable=false, precision=12, scale=2)
	private long bgpId;

	@Column(nullable=false, length=25)
	private String code;

	@Column(nullable=false, length=50)
	private String omschrijving;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpBedrijfsregelGrpReg
	@OneToMany(mappedBy="drpBedrijfsregelGroep")
	private List<DrpBedrijfsregelGrpReg> drpBedrijfsregelGrpRegs;

	//bi-directional many-to-one association to DrpGekBedrijfsregelGrp
	@OneToMany(mappedBy="drpBedrijfsregelGroep")
	private List<DrpGekBedrijfsregelGrp> drpGekBedrijfsregelGrps;

	public DrpBedrijfsregelGroep() {
	}

	public long getBgpId() {
		return this.bgpId;
	}

	public void setBgpId(long bgpId) {
		this.bgpId = bgpId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOmschrijving() {
		return this.omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
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
		drpBedrijfsregelGrpReg.setDrpBedrijfsregelGroep(this);

		return drpBedrijfsregelGrpReg;
	}

	public DrpBedrijfsregelGrpReg removeDrpBedrijfsregelGrpReg(DrpBedrijfsregelGrpReg drpBedrijfsregelGrpReg) {
		getDrpBedrijfsregelGrpRegs().remove(drpBedrijfsregelGrpReg);
		drpBedrijfsregelGrpReg.setDrpBedrijfsregelGroep(null);

		return drpBedrijfsregelGrpReg;
	}

	public List<DrpGekBedrijfsregelGrp> getDrpGekBedrijfsregelGrps() {
		return this.drpGekBedrijfsregelGrps;
	}

	public void setDrpGekBedrijfsregelGrps(List<DrpGekBedrijfsregelGrp> drpGekBedrijfsregelGrps) {
		this.drpGekBedrijfsregelGrps = drpGekBedrijfsregelGrps;
	}

	public DrpGekBedrijfsregelGrp addDrpGekBedrijfsregelGrp(DrpGekBedrijfsregelGrp drpGekBedrijfsregelGrp) {
		getDrpGekBedrijfsregelGrps().add(drpGekBedrijfsregelGrp);
		drpGekBedrijfsregelGrp.setDrpBedrijfsregelGroep(this);

		return drpGekBedrijfsregelGrp;
	}

	public DrpGekBedrijfsregelGrp removeDrpGekBedrijfsregelGrp(DrpGekBedrijfsregelGrp drpGekBedrijfsregelGrp) {
		getDrpGekBedrijfsregelGrps().remove(drpGekBedrijfsregelGrp);
		drpGekBedrijfsregelGrp.setDrpBedrijfsregelGroep(null);

		return drpGekBedrijfsregelGrp;
	}

}