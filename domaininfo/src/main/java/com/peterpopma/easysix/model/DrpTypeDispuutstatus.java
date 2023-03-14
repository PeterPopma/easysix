package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_DISPUUTSTATUS database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_DISPUUTSTATUS")
@NamedQuery(name="DrpTypeDispuutstatus.findAll", query="SELECT d FROM DrpTypeDispuutstatus d")
public class DrpTypeDispuutstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TDA_CODE", unique=true, nullable=false, length=1)
	private String tdaCode;

	@Column(nullable=false, length=30)
	private String naam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpDomeinnaam
	@OneToMany(mappedBy="drpTypeDispuutstatus")
	private List<DrpDomeinnaam> drpDomeinnaams;

	public DrpTypeDispuutstatus() {
	}

	public String getTdaCode() {
		return this.tdaCode;
	}

	public void setTdaCode(String tdaCode) {
		this.tdaCode = tdaCode;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<DrpDomeinnaam> getDrpDomeinnaams() {
		return this.drpDomeinnaams;
	}

	public void setDrpDomeinnaams(List<DrpDomeinnaam> drpDomeinnaams) {
		this.drpDomeinnaams = drpDomeinnaams;
	}

	public DrpDomeinnaam addDrpDomeinnaam(DrpDomeinnaam drpDomeinnaam) {
		getDrpDomeinnaams().add(drpDomeinnaam);
		drpDomeinnaam.setDrpTypeDispuutstatus(this);

		return drpDomeinnaam;
	}

	public DrpDomeinnaam removeDrpDomeinnaam(DrpDomeinnaam drpDomeinnaam) {
		getDrpDomeinnaams().remove(drpDomeinnaam);
		drpDomeinnaam.setDrpTypeDispuutstatus(null);

		return drpDomeinnaam;
	}

}