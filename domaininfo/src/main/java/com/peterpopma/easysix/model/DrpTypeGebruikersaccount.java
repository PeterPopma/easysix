package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_GEBRUIKERSACCOUNT database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_GEBRUIKERSACCOUNT")
@NamedQuery(name="DrpTypeGebruikersaccount.findAll", query="SELECT d FROM DrpTypeGebruikersaccount d")
public class DrpTypeGebruikersaccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TGT_CODE", unique=true, nullable=false, length=10)
	private String tgtCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpGebruiker
	@OneToMany(mappedBy="drpTypeGebruikersaccount")
	private List<DrpGebruiker> drpGebruikers;

	public DrpTypeGebruikersaccount() {
	}

	public String getTgtCode() {
		return this.tgtCode;
	}

	public void setTgtCode(String tgtCode) {
		this.tgtCode = tgtCode;
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

	public List<DrpGebruiker> getDrpGebruikers() {
		return this.drpGebruikers;
	}

	public void setDrpGebruikers(List<DrpGebruiker> drpGebruikers) {
		this.drpGebruikers = drpGebruikers;
	}

	public DrpGebruiker addDrpGebruiker(DrpGebruiker drpGebruiker) {
		getDrpGebruikers().add(drpGebruiker);
		drpGebruiker.setDrpTypeGebruikersaccount(this);

		return drpGebruiker;
	}

	public DrpGebruiker removeDrpGebruiker(DrpGebruiker drpGebruiker) {
		getDrpGebruikers().remove(drpGebruiker);
		drpGebruiker.setDrpTypeGebruikersaccount(null);

		return drpGebruiker;
	}

}