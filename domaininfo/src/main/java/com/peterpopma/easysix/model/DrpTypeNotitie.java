package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_NOTITIE database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_NOTITIE")
@NamedQuery(name="DrpTypeNotitie.findAll", query="SELECT d FROM DrpTypeNotitie d")
public class DrpTypeNotitie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TNE_CODE", unique=true, nullable=false, length=10)
	private String tneCode;

	@Column(length=50)
	private String omschrijving;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpNotitie
	@OneToMany(mappedBy="drpTypeNotitie")
	private List<DrpNotitie> drpNotities;

	public DrpTypeNotitie() {
	}

	public String getTneCode() {
		return this.tneCode;
	}

	public void setTneCode(String tneCode) {
		this.tneCode = tneCode;
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

	public List<DrpNotitie> getDrpNotities() {
		return this.drpNotities;
	}

	public void setDrpNotities(List<DrpNotitie> drpNotities) {
		this.drpNotities = drpNotities;
	}

	public DrpNotitie addDrpNotity(DrpNotitie drpNotity) {
		getDrpNotities().add(drpNotity);
		drpNotity.setDrpTypeNotitie(this);

		return drpNotity;
	}

	public DrpNotitie removeDrpNotity(DrpNotitie drpNotity) {
		getDrpNotities().remove(drpNotity);
		drpNotity.setDrpTypeNotitie(null);

		return drpNotity;
	}

}