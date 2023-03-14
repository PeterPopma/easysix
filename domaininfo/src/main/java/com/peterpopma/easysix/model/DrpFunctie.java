package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_FUNCTIE database table.
 * 
 */
@Entity
@Table(name="DRP_FUNCTIE")
@NamedQuery(name="DrpFunctie.findAll", query="SELECT d FROM DrpFunctie d")
public class DrpFunctie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FTE_CODE", unique=true, nullable=false, length=50)
	private String fteCode;

	@Column(name="KIESBAAR_VOOR_UITSLUITEN_JN", nullable=false, length=1)
	private String kiesbaarVoorUitsluitenJn;

	@Column(name="STANDAARD_UITSLUITEN_JN", nullable=false, length=1)
	private String standaardUitsluitenJn;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpGebruikersrolFunctie
	@OneToMany(mappedBy="drpFunctie")
	private List<DrpGebruikersrolFunctie> drpGebruikersrolFuncties;

	public DrpFunctie() {
	}

	public String getFteCode() {
		return this.fteCode;
	}

	public void setFteCode(String fteCode) {
		this.fteCode = fteCode;
	}

	public String getKiesbaarVoorUitsluitenJn() {
		return this.kiesbaarVoorUitsluitenJn;
	}

	public void setKiesbaarVoorUitsluitenJn(String kiesbaarVoorUitsluitenJn) {
		this.kiesbaarVoorUitsluitenJn = kiesbaarVoorUitsluitenJn;
	}

	public String getStandaardUitsluitenJn() {
		return this.standaardUitsluitenJn;
	}

	public void setStandaardUitsluitenJn(String standaardUitsluitenJn) {
		this.standaardUitsluitenJn = standaardUitsluitenJn;
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

	public List<DrpGebruikersrolFunctie> getDrpGebruikersrolFuncties() {
		return this.drpGebruikersrolFuncties;
	}

	public void setDrpGebruikersrolFuncties(List<DrpGebruikersrolFunctie> drpGebruikersrolFuncties) {
		this.drpGebruikersrolFuncties = drpGebruikersrolFuncties;
	}

	public DrpGebruikersrolFunctie addDrpGebruikersrolFuncty(DrpGebruikersrolFunctie drpGebruikersrolFuncty) {
		getDrpGebruikersrolFuncties().add(drpGebruikersrolFuncty);
		drpGebruikersrolFuncty.setDrpFunctie(this);

		return drpGebruikersrolFuncty;
	}

	public DrpGebruikersrolFunctie removeDrpGebruikersrolFuncty(DrpGebruikersrolFunctie drpGebruikersrolFuncty) {
		getDrpGebruikersrolFuncties().remove(drpGebruikersrolFuncty);
		drpGebruikersrolFuncty.setDrpFunctie(null);

		return drpGebruikersrolFuncty;
	}

}