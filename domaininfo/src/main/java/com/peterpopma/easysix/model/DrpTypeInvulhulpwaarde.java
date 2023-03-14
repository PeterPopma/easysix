package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_INVULHULPWAARDE database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_INVULHULPWAARDE")
@NamedQuery(name="DrpTypeInvulhulpwaarde.findAll", query="SELECT d FROM DrpTypeInvulhulpwaarde d")
public class DrpTypeInvulhulpwaarde implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TIE_CODE", unique=true, nullable=false, length=16)
	private String tieCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpInvulhulpwaarde
	@OneToMany(mappedBy="drpTypeInvulhulpwaarde")
	private List<DrpInvulhulpwaarde> drpInvulhulpwaardes;

	public DrpTypeInvulhulpwaarde() {
	}

	public String getTieCode() {
		return this.tieCode;
	}

	public void setTieCode(String tieCode) {
		this.tieCode = tieCode;
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

	public List<DrpInvulhulpwaarde> getDrpInvulhulpwaardes() {
		return this.drpInvulhulpwaardes;
	}

	public void setDrpInvulhulpwaardes(List<DrpInvulhulpwaarde> drpInvulhulpwaardes) {
		this.drpInvulhulpwaardes = drpInvulhulpwaardes;
	}

	public DrpInvulhulpwaarde addDrpInvulhulpwaarde(DrpInvulhulpwaarde drpInvulhulpwaarde) {
		getDrpInvulhulpwaardes().add(drpInvulhulpwaarde);
		drpInvulhulpwaarde.setDrpTypeInvulhulpwaarde(this);

		return drpInvulhulpwaarde;
	}

	public DrpInvulhulpwaarde removeDrpInvulhulpwaarde(DrpInvulhulpwaarde drpInvulhulpwaarde) {
		getDrpInvulhulpwaardes().remove(drpInvulhulpwaarde);
		drpInvulhulpwaarde.setDrpTypeInvulhulpwaarde(null);

		return drpInvulhulpwaarde;
	}

}