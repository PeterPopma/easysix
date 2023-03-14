package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TAAL database table.
 * 
 */
@Entity
@Table(name="DRP_TAAL")
@NamedQuery(name="DrpTaal.findAll", query="SELECT d FROM DrpTaal d")
public class DrpTaal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TAL_CODE", unique=true, nullable=false, length=10)
	private String talCode;

	@Column(name="JAVA_CODE", nullable=false, length=10)
	private String javaCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpCodeOmschrijving
	@OneToMany(mappedBy="drpTaal")
	private List<DrpCodeOmschrijving> drpCodeOmschrijvings;

	//bi-directional many-to-one association to DrpCorrespondentie
	@OneToMany(mappedBy="drpTaal")
	private List<DrpCorrespondentie> drpCorrespondenties;

	//bi-directional many-to-one association to DrpDeelnemer
	@OneToMany(mappedBy="drpTaal")
	private List<DrpDeelnemer> drpDeelnemers;

	//bi-directional many-to-one association to DrpEmailLayout
	@OneToMany(mappedBy="drpTaal")
	private List<DrpEmailLayout> drpEmailLayouts;

	//bi-directional many-to-one association to DrpRapportLayout
	@OneToMany(mappedBy="drpTaal")
	private List<DrpRapportLayout> drpRapportLayouts;

	//bi-directional many-to-one association to DrpXmlLayout
	@OneToMany(mappedBy="drpTaal")
	private List<DrpXmlLayout> drpXmlLayouts;

	public DrpTaal() {
	}

	public String getTalCode() {
		return this.talCode;
	}

	public void setTalCode(String talCode) {
		this.talCode = talCode;
	}

	public String getJavaCode() {
		return this.javaCode;
	}

	public void setJavaCode(String javaCode) {
		this.javaCode = javaCode;
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

	public List<DrpCodeOmschrijving> getDrpCodeOmschrijvings() {
		return this.drpCodeOmschrijvings;
	}

	public void setDrpCodeOmschrijvings(List<DrpCodeOmschrijving> drpCodeOmschrijvings) {
		this.drpCodeOmschrijvings = drpCodeOmschrijvings;
	}

	public DrpCodeOmschrijving addDrpCodeOmschrijving(DrpCodeOmschrijving drpCodeOmschrijving) {
		getDrpCodeOmschrijvings().add(drpCodeOmschrijving);
		drpCodeOmschrijving.setDrpTaal(this);

		return drpCodeOmschrijving;
	}

	public DrpCodeOmschrijving removeDrpCodeOmschrijving(DrpCodeOmschrijving drpCodeOmschrijving) {
		getDrpCodeOmschrijvings().remove(drpCodeOmschrijving);
		drpCodeOmschrijving.setDrpTaal(null);

		return drpCodeOmschrijving;
	}

	public List<DrpCorrespondentie> getDrpCorrespondenties() {
		return this.drpCorrespondenties;
	}

	public void setDrpCorrespondenties(List<DrpCorrespondentie> drpCorrespondenties) {
		this.drpCorrespondenties = drpCorrespondenties;
	}

	public DrpCorrespondentie addDrpCorrespondenty(DrpCorrespondentie drpCorrespondenty) {
		getDrpCorrespondenties().add(drpCorrespondenty);
		drpCorrespondenty.setDrpTaal(this);

		return drpCorrespondenty;
	}

	public DrpCorrespondentie removeDrpCorrespondenty(DrpCorrespondentie drpCorrespondenty) {
		getDrpCorrespondenties().remove(drpCorrespondenty);
		drpCorrespondenty.setDrpTaal(null);

		return drpCorrespondenty;
	}

	public List<DrpDeelnemer> getDrpDeelnemers() {
		return this.drpDeelnemers;
	}

	public void setDrpDeelnemers(List<DrpDeelnemer> drpDeelnemers) {
		this.drpDeelnemers = drpDeelnemers;
	}

	public DrpDeelnemer addDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		getDrpDeelnemers().add(drpDeelnemer);
		drpDeelnemer.setDrpTaal(this);

		return drpDeelnemer;
	}

	public DrpDeelnemer removeDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		getDrpDeelnemers().remove(drpDeelnemer);
		drpDeelnemer.setDrpTaal(null);

		return drpDeelnemer;
	}

	public List<DrpEmailLayout> getDrpEmailLayouts() {
		return this.drpEmailLayouts;
	}

	public void setDrpEmailLayouts(List<DrpEmailLayout> drpEmailLayouts) {
		this.drpEmailLayouts = drpEmailLayouts;
	}

	public DrpEmailLayout addDrpEmailLayout(DrpEmailLayout drpEmailLayout) {
		getDrpEmailLayouts().add(drpEmailLayout);
		drpEmailLayout.setDrpTaal(this);

		return drpEmailLayout;
	}

	public DrpEmailLayout removeDrpEmailLayout(DrpEmailLayout drpEmailLayout) {
		getDrpEmailLayouts().remove(drpEmailLayout);
		drpEmailLayout.setDrpTaal(null);

		return drpEmailLayout;
	}

	public List<DrpRapportLayout> getDrpRapportLayouts() {
		return this.drpRapportLayouts;
	}

	public void setDrpRapportLayouts(List<DrpRapportLayout> drpRapportLayouts) {
		this.drpRapportLayouts = drpRapportLayouts;
	}

	public DrpRapportLayout addDrpRapportLayout(DrpRapportLayout drpRapportLayout) {
		getDrpRapportLayouts().add(drpRapportLayout);
		drpRapportLayout.setDrpTaal(this);

		return drpRapportLayout;
	}

	public DrpRapportLayout removeDrpRapportLayout(DrpRapportLayout drpRapportLayout) {
		getDrpRapportLayouts().remove(drpRapportLayout);
		drpRapportLayout.setDrpTaal(null);

		return drpRapportLayout;
	}

	public List<DrpXmlLayout> getDrpXmlLayouts() {
		return this.drpXmlLayouts;
	}

	public void setDrpXmlLayouts(List<DrpXmlLayout> drpXmlLayouts) {
		this.drpXmlLayouts = drpXmlLayouts;
	}

	public DrpXmlLayout addDrpXmlLayout(DrpXmlLayout drpXmlLayout) {
		getDrpXmlLayouts().add(drpXmlLayout);
		drpXmlLayout.setDrpTaal(this);

		return drpXmlLayout;
	}

	public DrpXmlLayout removeDrpXmlLayout(DrpXmlLayout drpXmlLayout) {
		getDrpXmlLayouts().remove(drpXmlLayout);
		drpXmlLayout.setDrpTaal(null);

		return drpXmlLayout;
	}

}