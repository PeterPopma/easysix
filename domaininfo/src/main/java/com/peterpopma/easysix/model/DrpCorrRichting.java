package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_CORR_RICHTING database table.
 * 
 */
@Entity
@Table(name="DRP_CORR_RICHTING")
@NamedQuery(name="DrpCorrRichting.findAll", query="SELECT d FROM DrpCorrRichting d")
public class DrpCorrRichting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRG_CODE", unique=true, nullable=false, length=10)
	private String crgCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpTypeCorrespondentie
	@OneToMany(mappedBy="drpCorrRichting")
	private List<DrpTypeCorrespondentie> drpTypeCorrespondenties;

	public DrpCorrRichting() {
	}

	public String getCrgCode() {
		return this.crgCode;
	}

	public void setCrgCode(String crgCode) {
		this.crgCode = crgCode;
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
		drpTypeCorrespondenty.setDrpCorrRichting(this);

		return drpTypeCorrespondenty;
	}

	public DrpTypeCorrespondentie removeDrpTypeCorrespondenty(DrpTypeCorrespondentie drpTypeCorrespondenty) {
		getDrpTypeCorrespondenties().remove(drpTypeCorrespondenty);
		drpTypeCorrespondenty.setDrpCorrRichting(null);

		return drpTypeCorrespondenty;
	}

}