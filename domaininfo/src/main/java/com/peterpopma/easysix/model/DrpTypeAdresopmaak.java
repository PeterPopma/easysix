package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_ADRESOPMAAK database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_ADRESOPMAAK")
@NamedQuery(name="DrpTypeAdresopmaak.findAll", query="SELECT d FROM DrpTypeAdresopmaak d")
public class DrpTypeAdresopmaak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TAK_CODE", unique=true, nullable=false, length=3)
	private String takCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpContactAdre
	@OneToMany(mappedBy="drpTypeAdresopmaak")
	private List<DrpContactAdre> drpContactAdres;

	public DrpTypeAdresopmaak() {
	}

	public String getTakCode() {
		return this.takCode;
	}

	public void setTakCode(String takCode) {
		this.takCode = takCode;
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

	public List<DrpContactAdre> getDrpContactAdres() {
		return this.drpContactAdres;
	}

	public void setDrpContactAdres(List<DrpContactAdre> drpContactAdres) {
		this.drpContactAdres = drpContactAdres;
	}

	public DrpContactAdre addDrpContactAdre(DrpContactAdre drpContactAdre) {
		getDrpContactAdres().add(drpContactAdre);
		drpContactAdre.setDrpTypeAdresopmaak(this);

		return drpContactAdre;
	}

	public DrpContactAdre removeDrpContactAdre(DrpContactAdre drpContactAdre) {
		getDrpContactAdres().remove(drpContactAdre);
		drpContactAdre.setDrpTypeAdresopmaak(null);

		return drpContactAdre;
	}

}