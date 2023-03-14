package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_BEPERKING database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_BEPERKING")
@NamedQuery(name="DrpTypeBeperking.findAll", query="SELECT d FROM DrpTypeBeperking d")
public class DrpTypeBeperking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TBG_CODE", unique=true, nullable=false, length=50)
	private String tbgCode;

	private Object einddatum;

	@Column(name="IN_EMAILTEMPLATE_CODE", nullable=false, length=50)
	private String inEmailtemplateCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="UIT_EMAILTEMPLATE_CODE", nullable=false, length=50)
	private String uitEmailtemplateCode;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpBeperking
	@OneToMany(mappedBy="drpTypeBeperking")
	private List<DrpBeperking> drpBeperkings;

	//bi-directional many-to-one association to DrpBeperkingValidatie
	@OneToMany(mappedBy="drpTypeBeperking")
	private List<DrpBeperkingValidatie> drpBeperkingValidaties;

	//bi-directional many-to-one association to DrpInstantieTypeBeperking
	@OneToMany(mappedBy="drpTypeBeperking")
	private List<DrpInstantieTypeBeperking> drpInstantieTypeBeperkings;

	public DrpTypeBeperking() {
	}

	public String getTbgCode() {
		return this.tbgCode;
	}

	public void setTbgCode(String tbgCode) {
		this.tbgCode = tbgCode;
	}

	public Object getEinddatum() {
		return this.einddatum;
	}

	public void setEinddatum(Object einddatum) {
		this.einddatum = einddatum;
	}

	public String getInEmailtemplateCode() {
		return this.inEmailtemplateCode;
	}

	public void setInEmailtemplateCode(String inEmailtemplateCode) {
		this.inEmailtemplateCode = inEmailtemplateCode;
	}

	public String getTaalboeknaam() {
		return this.taalboeknaam;
	}

	public void setTaalboeknaam(String taalboeknaam) {
		this.taalboeknaam = taalboeknaam;
	}

	public String getUitEmailtemplateCode() {
		return this.uitEmailtemplateCode;
	}

	public void setUitEmailtemplateCode(String uitEmailtemplateCode) {
		this.uitEmailtemplateCode = uitEmailtemplateCode;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<DrpBeperking> getDrpBeperkings() {
		return this.drpBeperkings;
	}

	public void setDrpBeperkings(List<DrpBeperking> drpBeperkings) {
		this.drpBeperkings = drpBeperkings;
	}

	public DrpBeperking addDrpBeperking(DrpBeperking drpBeperking) {
		getDrpBeperkings().add(drpBeperking);
		drpBeperking.setDrpTypeBeperking(this);

		return drpBeperking;
	}

	public DrpBeperking removeDrpBeperking(DrpBeperking drpBeperking) {
		getDrpBeperkings().remove(drpBeperking);
		drpBeperking.setDrpTypeBeperking(null);

		return drpBeperking;
	}

	public List<DrpBeperkingValidatie> getDrpBeperkingValidaties() {
		return this.drpBeperkingValidaties;
	}

	public void setDrpBeperkingValidaties(List<DrpBeperkingValidatie> drpBeperkingValidaties) {
		this.drpBeperkingValidaties = drpBeperkingValidaties;
	}

	public DrpBeperkingValidatie addDrpBeperkingValidaty(DrpBeperkingValidatie drpBeperkingValidaty) {
		getDrpBeperkingValidaties().add(drpBeperkingValidaty);
		drpBeperkingValidaty.setDrpTypeBeperking(this);

		return drpBeperkingValidaty;
	}

	public DrpBeperkingValidatie removeDrpBeperkingValidaty(DrpBeperkingValidatie drpBeperkingValidaty) {
		getDrpBeperkingValidaties().remove(drpBeperkingValidaty);
		drpBeperkingValidaty.setDrpTypeBeperking(null);

		return drpBeperkingValidaty;
	}

	public List<DrpInstantieTypeBeperking> getDrpInstantieTypeBeperkings() {
		return this.drpInstantieTypeBeperkings;
	}

	public void setDrpInstantieTypeBeperkings(List<DrpInstantieTypeBeperking> drpInstantieTypeBeperkings) {
		this.drpInstantieTypeBeperkings = drpInstantieTypeBeperkings;
	}

	public DrpInstantieTypeBeperking addDrpInstantieTypeBeperking(DrpInstantieTypeBeperking drpInstantieTypeBeperking) {
		getDrpInstantieTypeBeperkings().add(drpInstantieTypeBeperking);
		drpInstantieTypeBeperking.setDrpTypeBeperking(this);

		return drpInstantieTypeBeperking;
	}

	public DrpInstantieTypeBeperking removeDrpInstantieTypeBeperking(DrpInstantieTypeBeperking drpInstantieTypeBeperking) {
		getDrpInstantieTypeBeperkings().remove(drpInstantieTypeBeperking);
		drpInstantieTypeBeperking.setDrpTypeBeperking(null);

		return drpInstantieTypeBeperking;
	}

}