package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_GESLACHT database table.
 * 
 */
@Entity
@Table(name="DRP_GESLACHT")
@NamedQuery(name="DrpGeslacht.findAll", query="SELECT d FROM DrpGeslacht d")
public class DrpGeslacht implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GST_CODE", unique=true, nullable=false, length=10)
	private String gstCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpDeelnemerContactpersoon
	@OneToMany(mappedBy="drpGeslacht")
	private List<DrpDeelnemerContactpersoon> drpDeelnemerContactpersoons;

	public DrpGeslacht() {
	}

	public String getGstCode() {
		return this.gstCode;
	}

	public void setGstCode(String gstCode) {
		this.gstCode = gstCode;
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

	public List<DrpDeelnemerContactpersoon> getDrpDeelnemerContactpersoons() {
		return this.drpDeelnemerContactpersoons;
	}

	public void setDrpDeelnemerContactpersoons(List<DrpDeelnemerContactpersoon> drpDeelnemerContactpersoons) {
		this.drpDeelnemerContactpersoons = drpDeelnemerContactpersoons;
	}

	public DrpDeelnemerContactpersoon addDrpDeelnemerContactpersoon(DrpDeelnemerContactpersoon drpDeelnemerContactpersoon) {
		getDrpDeelnemerContactpersoons().add(drpDeelnemerContactpersoon);
		drpDeelnemerContactpersoon.setDrpGeslacht(this);

		return drpDeelnemerContactpersoon;
	}

	public DrpDeelnemerContactpersoon removeDrpDeelnemerContactpersoon(DrpDeelnemerContactpersoon drpDeelnemerContactpersoon) {
		getDrpDeelnemerContactpersoons().remove(drpDeelnemerContactpersoon);
		drpDeelnemerContactpersoon.setDrpGeslacht(null);

		return drpDeelnemerContactpersoon;
	}

}