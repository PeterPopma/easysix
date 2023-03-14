package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_TRANSACTIESTATUS database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_TRANSACTIESTATUS")
@NamedQuery(name="DrpTypeTransactiestatus.findAll", query="SELECT d FROM DrpTypeTransactiestatus d")
public class DrpTypeTransactiestatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TAS_CODE", unique=true, nullable=false, length=32)
	private String tasCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpTransactie
	@OneToMany(mappedBy="drpTypeTransactiestatus")
	private List<DrpTransactie> drpTransacties;

	public DrpTypeTransactiestatus() {
	}

	public String getTasCode() {
		return this.tasCode;
	}

	public void setTasCode(String tasCode) {
		this.tasCode = tasCode;
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
		drpTransacty.setDrpTypeTransactiestatus(this);

		return drpTransacty;
	}

	public DrpTransactie removeDrpTransacty(DrpTransactie drpTransacty) {
		getDrpTransacties().remove(drpTransacty);
		drpTransacty.setDrpTypeTransactiestatus(null);

		return drpTransacty;
	}

}