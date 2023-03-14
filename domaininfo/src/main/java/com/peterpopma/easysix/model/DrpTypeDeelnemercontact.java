package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_DEELNEMERCONTACT database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_DEELNEMERCONTACT")
@NamedQuery(name="DrpTypeDeelnemercontact.findAll", query="SELECT d FROM DrpTypeDeelnemercontact d")
public class DrpTypeDeelnemercontact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TDT_CODE", unique=true, nullable=false, length=20)
	private String tdtCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpDeelnemerContactpersoon
	@OneToMany(mappedBy="drpTypeDeelnemercontact")
	private List<DrpDeelnemerContactpersoon> drpDeelnemerContactpersoons;

	public DrpTypeDeelnemercontact() {
	}

	public String getTdtCode() {
		return this.tdtCode;
	}

	public void setTdtCode(String tdtCode) {
		this.tdtCode = tdtCode;
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
		drpDeelnemerContactpersoon.setDrpTypeDeelnemercontact(this);

		return drpDeelnemerContactpersoon;
	}

	public DrpDeelnemerContactpersoon removeDrpDeelnemerContactpersoon(DrpDeelnemerContactpersoon drpDeelnemerContactpersoon) {
		getDrpDeelnemerContactpersoons().remove(drpDeelnemerContactpersoon);
		drpDeelnemerContactpersoon.setDrpTypeDeelnemercontact(null);

		return drpDeelnemerContactpersoon;
	}

}