package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TRANSACTIE_ELEMENT database table.
 * 
 */
@Entity
@Table(name="DRP_TRANSACTIE_ELEMENT")
@NamedQuery(name="DrpTransactieElement.findAll", query="SELECT d FROM DrpTransactieElement d")
public class DrpTransactieElement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TET_ID", unique=true, nullable=false, precision=12)
	private long tetId;

	@Column(name="CHILD_XPAD", nullable=false, length=255)
	private String childXpad;

	@Column(length=50)
	private String omschrijving;

	@Column(name="PARENT_XPAD", nullable=false, length=255)
	private String parentXpad;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpGekoppeldeBedrijfsregel
	@OneToMany(mappedBy="drpTransactieElement")
	private List<DrpGekoppeldeBedrijfsregel> drpGekoppeldeBedrijfsregels;

	//bi-directional many-to-one association to DrpTypeTransactie
	@ManyToOne
	@JoinColumn(name="TTE_CODE", nullable=false)
	private DrpTypeTransactie drpTypeTransactie;

	//bi-directional many-to-one association to DrpTypeTransactieElement
	@ManyToOne
	@JoinColumn(name="TTT_CODE", nullable=false)
	private DrpTypeTransactieElement drpTypeTransactieElement;

	public DrpTransactieElement() {
	}

	public long getTetId() {
		return this.tetId;
	}

	public void setTetId(long tetId) {
		this.tetId = tetId;
	}

	public String getChildXpad() {
		return this.childXpad;
	}

	public void setChildXpad(String childXpad) {
		this.childXpad = childXpad;
	}

	public String getOmschrijving() {
		return this.omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public String getParentXpad() {
		return this.parentXpad;
	}

	public void setParentXpad(String parentXpad) {
		this.parentXpad = parentXpad;
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

	public List<DrpGekoppeldeBedrijfsregel> getDrpGekoppeldeBedrijfsregels() {
		return this.drpGekoppeldeBedrijfsregels;
	}

	public void setDrpGekoppeldeBedrijfsregels(List<DrpGekoppeldeBedrijfsregel> drpGekoppeldeBedrijfsregels) {
		this.drpGekoppeldeBedrijfsregels = drpGekoppeldeBedrijfsregels;
	}

	public DrpGekoppeldeBedrijfsregel addDrpGekoppeldeBedrijfsregel(DrpGekoppeldeBedrijfsregel drpGekoppeldeBedrijfsregel) {
		getDrpGekoppeldeBedrijfsregels().add(drpGekoppeldeBedrijfsregel);
		drpGekoppeldeBedrijfsregel.setDrpTransactieElement(this);

		return drpGekoppeldeBedrijfsregel;
	}

	public DrpGekoppeldeBedrijfsregel removeDrpGekoppeldeBedrijfsregel(DrpGekoppeldeBedrijfsregel drpGekoppeldeBedrijfsregel) {
		getDrpGekoppeldeBedrijfsregels().remove(drpGekoppeldeBedrijfsregel);
		drpGekoppeldeBedrijfsregel.setDrpTransactieElement(null);

		return drpGekoppeldeBedrijfsregel;
	}

	public DrpTypeTransactie getDrpTypeTransactie() {
		return this.drpTypeTransactie;
	}

	public void setDrpTypeTransactie(DrpTypeTransactie drpTypeTransactie) {
		this.drpTypeTransactie = drpTypeTransactie;
	}

	public DrpTypeTransactieElement getDrpTypeTransactieElement() {
		return this.drpTypeTransactieElement;
	}

	public void setDrpTypeTransactieElement(DrpTypeTransactieElement drpTypeTransactieElement) {
		this.drpTypeTransactieElement = drpTypeTransactieElement;
	}

}