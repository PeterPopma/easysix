package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_LAND database table.
 * 
 */
@Entity
@Table(name="DRP_LAND")
@NamedQuery(name="DrpLand.findAll", query="SELECT d FROM DrpLand d")
public class DrpLand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LAD_CODE", unique=true, nullable=false, length=5)
	private String ladCode;

	@Column(name="EU_JN", nullable=false, length=1)
	private String euJn;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(nullable=false, length=5)
	private String toegangscode;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpContactAdre
	@OneToMany(mappedBy="drpLand")
	private List<DrpContactAdre> drpContactAdres;

	//bi-directional many-to-one association to DrpDeelnemerAdre
	@OneToMany(mappedBy="drpLand")
	private List<DrpDeelnemerAdre> drpDeelnemerAdres;

	public DrpLand() {
	}

	public String getLadCode() {
		return this.ladCode;
	}

	public void setLadCode(String ladCode) {
		this.ladCode = ladCode;
	}

	public String getEuJn() {
		return this.euJn;
	}

	public void setEuJn(String euJn) {
		this.euJn = euJn;
	}

	public String getTaalboeknaam() {
		return this.taalboeknaam;
	}

	public void setTaalboeknaam(String taalboeknaam) {
		this.taalboeknaam = taalboeknaam;
	}

	public String getToegangscode() {
		return this.toegangscode;
	}

	public void setToegangscode(String toegangscode) {
		this.toegangscode = toegangscode;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<DrpContactAdre> getDrpContactAdres() {
		return this.drpContactAdres;
	}

	public void setDrpContactAdres(List<DrpContactAdre> drpContactAdres) {
		this.drpContactAdres = drpContactAdres;
	}

	public DrpContactAdre addDrpContactAdre(DrpContactAdre drpContactAdre) {
		getDrpContactAdres().add(drpContactAdre);
		drpContactAdre.setDrpLand(this);

		return drpContactAdre;
	}

	public DrpContactAdre removeDrpContactAdre(DrpContactAdre drpContactAdre) {
		getDrpContactAdres().remove(drpContactAdre);
		drpContactAdre.setDrpLand(null);

		return drpContactAdre;
	}

	public List<DrpDeelnemerAdre> getDrpDeelnemerAdres() {
		return this.drpDeelnemerAdres;
	}

	public void setDrpDeelnemerAdres(List<DrpDeelnemerAdre> drpDeelnemerAdres) {
		this.drpDeelnemerAdres = drpDeelnemerAdres;
	}

	public DrpDeelnemerAdre addDrpDeelnemerAdre(DrpDeelnemerAdre drpDeelnemerAdre) {
		getDrpDeelnemerAdres().add(drpDeelnemerAdre);
		drpDeelnemerAdre.setDrpLand(this);

		return drpDeelnemerAdre;
	}

	public DrpDeelnemerAdre removeDrpDeelnemerAdre(DrpDeelnemerAdre drpDeelnemerAdre) {
		getDrpDeelnemerAdres().remove(drpDeelnemerAdre);
		drpDeelnemerAdre.setDrpLand(null);

		return drpDeelnemerAdre;
	}

}