package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_CORR_SOORT database table.
 * 
 */
@Entity
@Table(name="DRP_CORR_SOORT")
@NamedQuery(name="DrpCorrSoort.findAll", query="SELECT d FROM DrpCorrSoort d")
public class DrpCorrSoort implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CST_CODE", unique=true, nullable=false, length=10)
	private String cstCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpTypeCorrespondentie
	@OneToMany(mappedBy="drpCorrSoort")
	private List<DrpTypeCorrespondentie> drpTypeCorrespondenties;

	public DrpCorrSoort() {
	}

	public String getCstCode() {
		return this.cstCode;
	}

	public void setCstCode(String cstCode) {
		this.cstCode = cstCode;
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

	public List<DrpTypeCorrespondentie> getDrpTypeCorrespondenties() {
		return this.drpTypeCorrespondenties;
	}

	public void setDrpTypeCorrespondenties(List<DrpTypeCorrespondentie> drpTypeCorrespondenties) {
		this.drpTypeCorrespondenties = drpTypeCorrespondenties;
	}

	public DrpTypeCorrespondentie addDrpTypeCorrespondenty(DrpTypeCorrespondentie drpTypeCorrespondenty) {
		getDrpTypeCorrespondenties().add(drpTypeCorrespondenty);
		drpTypeCorrespondenty.setDrpCorrSoort(this);

		return drpTypeCorrespondenty;
	}

	public DrpTypeCorrespondentie removeDrpTypeCorrespondenty(DrpTypeCorrespondentie drpTypeCorrespondenty) {
		getDrpTypeCorrespondenties().remove(drpTypeCorrespondenty);
		drpTypeCorrespondenty.setDrpCorrSoort(null);

		return drpTypeCorrespondenty;
	}

}