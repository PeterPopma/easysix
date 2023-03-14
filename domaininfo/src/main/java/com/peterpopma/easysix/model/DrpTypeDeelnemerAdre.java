package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_DEELNEMER_ADRES database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_DEELNEMER_ADRES")
@NamedQuery(name="DrpTypeDeelnemerAdre.findAll", query="SELECT d FROM DrpTypeDeelnemerAdre d")
public class DrpTypeDeelnemerAdre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TDS_CODE", unique=true, nullable=false, length=20)
	private String tdsCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpDeelnemerAdre
	@OneToMany(mappedBy="drpTypeDeelnemerAdre")
	private List<DrpDeelnemerAdre> drpDeelnemerAdres;

	public DrpTypeDeelnemerAdre() {
	}

	public String getTdsCode() {
		return this.tdsCode;
	}

	public void setTdsCode(String tdsCode) {
		this.tdsCode = tdsCode;
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

	public List<DrpDeelnemerAdre> getDrpDeelnemerAdres() {
		return this.drpDeelnemerAdres;
	}

	public void setDrpDeelnemerAdres(List<DrpDeelnemerAdre> drpDeelnemerAdres) {
		this.drpDeelnemerAdres = drpDeelnemerAdres;
	}

	public DrpDeelnemerAdre addDrpDeelnemerAdre(DrpDeelnemerAdre drpDeelnemerAdre) {
		getDrpDeelnemerAdres().add(drpDeelnemerAdre);
		drpDeelnemerAdre.setDrpTypeDeelnemerAdre(this);

		return drpDeelnemerAdre;
	}

	public DrpDeelnemerAdre removeDrpDeelnemerAdre(DrpDeelnemerAdre drpDeelnemerAdre) {
		getDrpDeelnemerAdres().remove(drpDeelnemerAdre);
		drpDeelnemerAdre.setDrpTypeDeelnemerAdre(null);

		return drpDeelnemerAdre;
	}

}