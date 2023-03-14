package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_TRANSACTIE_ELEMENT database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_TRANSACTIE_ELEMENT")
@NamedQuery(name="DrpTypeTransactieElement.findAll", query="SELECT d FROM DrpTypeTransactieElement d")
public class DrpTypeTransactieElement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TTT_CODE", unique=true, nullable=false, length=10)
	private String tttCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpTransactieElement
	@OneToMany(mappedBy="drpTypeTransactieElement")
	private List<DrpTransactieElement> drpTransactieElements;

	public DrpTypeTransactieElement() {
	}

	public String getTttCode() {
		return this.tttCode;
	}

	public void setTttCode(String tttCode) {
		this.tttCode = tttCode;
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

	public List<DrpTransactieElement> getDrpTransactieElements() {
		return this.drpTransactieElements;
	}

	public void setDrpTransactieElements(List<DrpTransactieElement> drpTransactieElements) {
		this.drpTransactieElements = drpTransactieElements;
	}

	public DrpTransactieElement addDrpTransactieElement(DrpTransactieElement drpTransactieElement) {
		getDrpTransactieElements().add(drpTransactieElement);
		drpTransactieElement.setDrpTypeTransactieElement(this);

		return drpTransactieElement;
	}

	public DrpTransactieElement removeDrpTransactieElement(DrpTransactieElement drpTransactieElement) {
		getDrpTransactieElements().remove(drpTransactieElement);
		drpTransactieElement.setDrpTypeTransactieElement(null);

		return drpTransactieElement;
	}

}