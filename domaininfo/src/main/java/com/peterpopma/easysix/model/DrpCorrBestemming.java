package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_CORR_BESTEMMING database table.
 * 
 */
@Entity
@Table(name="DRP_CORR_BESTEMMING")
@NamedQuery(name="DrpCorrBestemming.findAll", query="SELECT d FROM DrpCorrBestemming d")
public class DrpCorrBestemming implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CBG_CODE", unique=true, nullable=false, length=15)
	private String cbgCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpTypeCorrespondentie
	@OneToMany(mappedBy="drpCorrBestemming")
	private List<DrpTypeCorrespondentie> drpTypeCorrespondenties;

	public DrpCorrBestemming() {
	}

	public String getCbgCode() {
		return this.cbgCode;
	}

	public void setCbgCode(String cbgCode) {
		this.cbgCode = cbgCode;
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
		drpTypeCorrespondenty.setDrpCorrBestemming(this);

		return drpTypeCorrespondenty;
	}

	public DrpTypeCorrespondentie removeDrpTypeCorrespondenty(DrpTypeCorrespondentie drpTypeCorrespondenty) {
		getDrpTypeCorrespondenties().remove(drpTypeCorrespondenty);
		drpTypeCorrespondenty.setDrpCorrBestemming(null);

		return drpTypeCorrespondenty;
	}

}