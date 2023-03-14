package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_CORRESPONDENTIE database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_CORRESPONDENTIE")
@NamedQuery(name="DrpTypeCorrespondentie.findAll", query="SELECT d FROM DrpTypeCorrespondentie d")
public class DrpTypeCorrespondentie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TCE_CODE", unique=true, nullable=false, length=40)
	private String tceCode;

	@Column(name="BEWAREN_JN", nullable=false, length=1)
	private String bewarenJn;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpCorrespondentie
	@OneToMany(mappedBy="drpTypeCorrespondentie")
	private List<DrpCorrespondentie> drpCorrespondenties;

	//bi-directional many-to-one association to DrpEmailLayout
	@OneToMany(mappedBy="drpTypeCorrespondentie")
	private List<DrpEmailLayout> drpEmailLayouts;

	//bi-directional many-to-one association to DrpRapportLayout
	@OneToMany(mappedBy="drpTypeCorrespondentie")
	private List<DrpRapportLayout> drpRapportLayouts;

	//bi-directional many-to-one association to DrpCorrBestemming
	@ManyToOne
	@JoinColumn(name="CBG_CODE")
	private DrpCorrBestemming drpCorrBestemming;

	//bi-directional many-to-one association to DrpCorrRichting
	@ManyToOne
	@JoinColumn(name="CRG_CODE", nullable=false)
	private DrpCorrRichting drpCorrRichting;

	//bi-directional many-to-one association to DrpCorrSoort
	@ManyToOne
	@JoinColumn(name="CST_CODE", nullable=false)
	private DrpCorrSoort drpCorrSoort;

	//bi-directional many-to-one association to DrpTypeTransactie
	@OneToMany(mappedBy="drpTypeCorrespondentie")
	private List<DrpTypeTransactie> drpTypeTransacties;

	//bi-directional many-to-one association to DrpXmlLayout
	@OneToMany(mappedBy="drpTypeCorrespondentie")
	private List<DrpXmlLayout> drpXmlLayouts;

	public DrpTypeCorrespondentie() {
	}

	public String getTceCode() {
		return this.tceCode;
	}

	public void setTceCode(String tceCode) {
		this.tceCode = tceCode;
	}

	public String getBewarenJn() {
		return this.bewarenJn;
	}

	public void setBewarenJn(String bewarenJn) {
		this.bewarenJn = bewarenJn;
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

	public List<DrpCorrespondentie> getDrpCorrespondenties() {
		return this.drpCorrespondenties;
	}

	public void setDrpCorrespondenties(List<DrpCorrespondentie> drpCorrespondenties) {
		this.drpCorrespondenties = drpCorrespondenties;
	}

	public DrpCorrespondentie addDrpCorrespondenty(DrpCorrespondentie drpCorrespondenty) {
		getDrpCorrespondenties().add(drpCorrespondenty);
		drpCorrespondenty.setDrpTypeCorrespondentie(this);

		return drpCorrespondenty;
	}

	public DrpCorrespondentie removeDrpCorrespondenty(DrpCorrespondentie drpCorrespondenty) {
		getDrpCorrespondenties().remove(drpCorrespondenty);
		drpCorrespondenty.setDrpTypeCorrespondentie(null);

		return drpCorrespondenty;
	}

	public List<DrpEmailLayout> getDrpEmailLayouts() {
		return this.drpEmailLayouts;
	}

	public void setDrpEmailLayouts(List<DrpEmailLayout> drpEmailLayouts) {
		this.drpEmailLayouts = drpEmailLayouts;
	}

	public DrpEmailLayout addDrpEmailLayout(DrpEmailLayout drpEmailLayout) {
		getDrpEmailLayouts().add(drpEmailLayout);
		drpEmailLayout.setDrpTypeCorrespondentie(this);

		return drpEmailLayout;
	}

	public DrpEmailLayout removeDrpEmailLayout(DrpEmailLayout drpEmailLayout) {
		getDrpEmailLayouts().remove(drpEmailLayout);
		drpEmailLayout.setDrpTypeCorrespondentie(null);

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
		drpRapportLayout.setDrpTypeCorrespondentie(this);

		return drpRapportLayout;
	}

	public DrpRapportLayout removeDrpRapportLayout(DrpRapportLayout drpRapportLayout) {
		getDrpRapportLayouts().remove(drpRapportLayout);
		drpRapportLayout.setDrpTypeCorrespondentie(null);

		return drpRapportLayout;
	}

	public DrpCorrBestemming getDrpCorrBestemming() {
		return this.drpCorrBestemming;
	}

	public void setDrpCorrBestemming(DrpCorrBestemming drpCorrBestemming) {
		this.drpCorrBestemming = drpCorrBestemming;
	}

	public DrpCorrRichting getDrpCorrRichting() {
		return this.drpCorrRichting;
	}

	public void setDrpCorrRichting(DrpCorrRichting drpCorrRichting) {
		this.drpCorrRichting = drpCorrRichting;
	}

	public DrpCorrSoort getDrpCorrSoort() {
		return this.drpCorrSoort;
	}

	public void setDrpCorrSoort(DrpCorrSoort drpCorrSoort) {
		this.drpCorrSoort = drpCorrSoort;
	}

	public List<DrpTypeTransactie> getDrpTypeTransacties() {
		return this.drpTypeTransacties;
	}

	public void setDrpTypeTransacties(List<DrpTypeTransactie> drpTypeTransacties) {
		this.drpTypeTransacties = drpTypeTransacties;
	}

	public DrpTypeTransactie addDrpTypeTransacty(DrpTypeTransactie drpTypeTransacty) {
		getDrpTypeTransacties().add(drpTypeTransacty);
		drpTypeTransacty.setDrpTypeCorrespondentie(this);

		return drpTypeTransacty;
	}

	public DrpTypeTransactie removeDrpTypeTransacty(DrpTypeTransactie drpTypeTransacty) {
		getDrpTypeTransacties().remove(drpTypeTransacty);
		drpTypeTransacty.setDrpTypeCorrespondentie(null);

		return drpTypeTransacty;
	}

	public List<DrpXmlLayout> getDrpXmlLayouts() {
		return this.drpXmlLayouts;
	}

	public void setDrpXmlLayouts(List<DrpXmlLayout> drpXmlLayouts) {
		this.drpXmlLayouts = drpXmlLayouts;
	}

	public DrpXmlLayout addDrpXmlLayout(DrpXmlLayout drpXmlLayout) {
		getDrpXmlLayouts().add(drpXmlLayout);
		drpXmlLayout.setDrpTypeCorrespondentie(this);

		return drpXmlLayout;
	}

	public DrpXmlLayout removeDrpXmlLayout(DrpXmlLayout drpXmlLayout) {
		getDrpXmlLayouts().remove(drpXmlLayout);
		drpXmlLayout.setDrpTypeCorrespondentie(null);

		return drpXmlLayout;
	}

}