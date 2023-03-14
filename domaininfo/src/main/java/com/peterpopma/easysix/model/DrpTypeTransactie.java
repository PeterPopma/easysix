package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_TRANSACTIE database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_TRANSACTIE")
@NamedQuery(name="DrpTypeTransactie.findAll", query="SELECT d FROM DrpTypeTransactie d")
public class DrpTypeTransactie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TTE_CODE", unique=true, nullable=false, length=50)
	private String tteCode;

	@Column(name="DRS_CLASS", length=255)
	private String drsClass;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpTransactie
	@OneToMany(mappedBy="drpTypeTransactie")
	private List<DrpTransactie> drpTransacties;

	//bi-directional many-to-one association to DrpTransactieElement
	@OneToMany(mappedBy="drpTypeTransactie")
	private List<DrpTransactieElement> drpTransactieElements;

	//bi-directional many-to-one association to DrpTypeCorrespondentie
	@ManyToOne
	@JoinColumn(name="TCE_CODE", nullable=false)
	private DrpTypeCorrespondentie drpTypeCorrespondentie;

	public DrpTypeTransactie() {
	}

	public String getTteCode() {
		return this.tteCode;
	}

	public void setTteCode(String tteCode) {
		this.tteCode = tteCode;
	}

	public String getDrsClass() {
		return this.drsClass;
	}

	public void setDrsClass(String drsClass) {
		this.drsClass = drsClass;
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

	public List<DrpTransactie> getDrpTransacties() {
		return this.drpTransacties;
	}

	public void setDrpTransacties(List<DrpTransactie> drpTransacties) {
		this.drpTransacties = drpTransacties;
	}

	public DrpTransactie addDrpTransacty(DrpTransactie drpTransacty) {
		getDrpTransacties().add(drpTransacty);
		drpTransacty.setDrpTypeTransactie(this);

		return drpTransacty;
	}

	public DrpTransactie removeDrpTransacty(DrpTransactie drpTransacty) {
		getDrpTransacties().remove(drpTransacty);
		drpTransacty.setDrpTypeTransactie(null);

		return drpTransacty;
	}

	public List<DrpTransactieElement> getDrpTransactieElements() {
		return this.drpTransactieElements;
	}

	public void setDrpTransactieElements(List<DrpTransactieElement> drpTransactieElements) {
		this.drpTransactieElements = drpTransactieElements;
	}

	public DrpTransactieElement addDrpTransactieElement(DrpTransactieElement drpTransactieElement) {
		getDrpTransactieElements().add(drpTransactieElement);
		drpTransactieElement.setDrpTypeTransactie(this);

		return drpTransactieElement;
	}

	public DrpTransactieElement removeDrpTransactieElement(DrpTransactieElement drpTransactieElement) {
		getDrpTransactieElements().remove(drpTransactieElement);
		drpTransactieElement.setDrpTypeTransactie(null);

		return drpTransactieElement;
	}

	public DrpTypeCorrespondentie getDrpTypeCorrespondentie() {
		return this.drpTypeCorrespondentie;
	}

	public void setDrpTypeCorrespondentie(DrpTypeCorrespondentie drpTypeCorrespondentie) {
		this.drpTypeCorrespondentie = drpTypeCorrespondentie;
	}

}