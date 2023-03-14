package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_GEBRUIKERSROL database table.
 * 
 */
@Entity
@Table(name="DRP_GEBRUIKERSROL")
@NamedQuery(name="DrpGebruikersrol.findAll", query="SELECT d FROM DrpGebruikersrol d")
public class DrpGebruikersrol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GRL_ID", unique=true, nullable=false, precision=12)
	private long grlId;

	@Column(nullable=false, length=30)
	private String naam;

	@Column(nullable=false, length=255)
	private String omschrijving;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpGebruikersrolFunctie
	@OneToMany(mappedBy="drpGebruikersrol")
	private List<DrpGebruikersrolFunctie> drpGebruikersrolFuncties;

	//bi-directional many-to-one association to DrpGebruikersrolRollen
	@OneToMany(mappedBy="drpGebruikersrol1")
	private List<DrpGebruikersrolRollen> drpGebruikersrolRollens1;

	//bi-directional many-to-one association to DrpGebruikersrolRollen
	@OneToMany(mappedBy="drpGebruikersrol2")
	private List<DrpGebruikersrolRollen> drpGebruikersrolRollens2;

	//bi-directional many-to-one association to DrpGebruikerGebruikersrol
	@OneToMany(mappedBy="drpGebruikersrol")
	private List<DrpGebruikerGebruikersrol> drpGebruikerGebruikersrols;

	public DrpGebruikersrol() {
	}

	public long getGrlId() {
		return this.grlId;
	}

	public void setGrlId(long grlId) {
		this.grlId = grlId;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
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

	public List<DrpGebruikersrolFunctie> getDrpGebruikersrolFuncties() {
		return this.drpGebruikersrolFuncties;
	}

	public void setDrpGebruikersrolFuncties(List<DrpGebruikersrolFunctie> drpGebruikersrolFuncties) {
		this.drpGebruikersrolFuncties = drpGebruikersrolFuncties;
	}

	public DrpGebruikersrolFunctie addDrpGebruikersrolFuncty(DrpGebruikersrolFunctie drpGebruikersrolFuncty) {
		getDrpGebruikersrolFuncties().add(drpGebruikersrolFuncty);
		drpGebruikersrolFuncty.setDrpGebruikersrol(this);

		return drpGebruikersrolFuncty;
	}

	public DrpGebruikersrolFunctie removeDrpGebruikersrolFuncty(DrpGebruikersrolFunctie drpGebruikersrolFuncty) {
		getDrpGebruikersrolFuncties().remove(drpGebruikersrolFuncty);
		drpGebruikersrolFuncty.setDrpGebruikersrol(null);

		return drpGebruikersrolFuncty;
	}

	public List<DrpGebruikersrolRollen> getDrpGebruikersrolRollens1() {
		return this.drpGebruikersrolRollens1;
	}

	public void setDrpGebruikersrolRollens1(List<DrpGebruikersrolRollen> drpGebruikersrolRollens1) {
		this.drpGebruikersrolRollens1 = drpGebruikersrolRollens1;
	}

	public DrpGebruikersrolRollen addDrpGebruikersrolRollens1(DrpGebruikersrolRollen drpGebruikersrolRollens1) {
		getDrpGebruikersrolRollens1().add(drpGebruikersrolRollens1);
		drpGebruikersrolRollens1.setDrpGebruikersrol1(this);

		return drpGebruikersrolRollens1;
	}

	public DrpGebruikersrolRollen removeDrpGebruikersrolRollens1(DrpGebruikersrolRollen drpGebruikersrolRollens1) {
		getDrpGebruikersrolRollens1().remove(drpGebruikersrolRollens1);
		drpGebruikersrolRollens1.setDrpGebruikersrol1(null);

		return drpGebruikersrolRollens1;
	}

	public List<DrpGebruikersrolRollen> getDrpGebruikersrolRollens2() {
		return this.drpGebruikersrolRollens2;
	}

	public void setDrpGebruikersrolRollens2(List<DrpGebruikersrolRollen> drpGebruikersrolRollens2) {
		this.drpGebruikersrolRollens2 = drpGebruikersrolRollens2;
	}

	public DrpGebruikersrolRollen addDrpGebruikersrolRollens2(DrpGebruikersrolRollen drpGebruikersrolRollens2) {
		getDrpGebruikersrolRollens2().add(drpGebruikersrolRollens2);
		drpGebruikersrolRollens2.setDrpGebruikersrol2(this);

		return drpGebruikersrolRollens2;
	}

	public DrpGebruikersrolRollen removeDrpGebruikersrolRollens2(DrpGebruikersrolRollen drpGebruikersrolRollens2) {
		getDrpGebruikersrolRollens2().remove(drpGebruikersrolRollens2);
		drpGebruikersrolRollens2.setDrpGebruikersrol2(null);

		return drpGebruikersrolRollens2;
	}

	public List<DrpGebruikerGebruikersrol> getDrpGebruikerGebruikersrols() {
		return this.drpGebruikerGebruikersrols;
	}

	public void setDrpGebruikerGebruikersrols(List<DrpGebruikerGebruikersrol> drpGebruikerGebruikersrols) {
		this.drpGebruikerGebruikersrols = drpGebruikerGebruikersrols;
	}

	public DrpGebruikerGebruikersrol addDrpGebruikerGebruikersrol(DrpGebruikerGebruikersrol drpGebruikerGebruikersrol) {
		getDrpGebruikerGebruikersrols().add(drpGebruikerGebruikersrol);
		drpGebruikerGebruikersrol.setDrpGebruikersrol(this);

		return drpGebruikerGebruikersrol;
	}

	public DrpGebruikerGebruikersrol removeDrpGebruikerGebruikersrol(DrpGebruikerGebruikersrol drpGebruikerGebruikersrol) {
		getDrpGebruikerGebruikersrols().remove(drpGebruikerGebruikersrol);
		drpGebruikerGebruikersrol.setDrpGebruikersrol(null);

		return drpGebruikerGebruikersrol;
	}

}