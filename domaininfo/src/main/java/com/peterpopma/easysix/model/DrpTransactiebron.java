package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TRANSACTIEBRON database table.
 * 
 */
@Entity
@Table(name="DRP_TRANSACTIEBRON")
@NamedQuery(name="DrpTransactiebron.findAll", query="SELECT d FROM DrpTransactiebron d")
public class DrpTransactiebron implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TBN_CODE", unique=true, nullable=false, length=12)
	private String tbnCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpTransactie
	@OneToMany(mappedBy="drpTransactiebron")
	private List<DrpTransactie> drpTransacties;

	public DrpTransactiebron() {
	}

	public String getTbnCode() {
		return this.tbnCode;
	}

	public void setTbnCode(String tbnCode) {
		this.tbnCode = tbnCode;
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
		drpTransacty.setDrpTransactiebron(this);

		return drpTransacty;
	}

	public DrpTransactie removeDrpTransacty(DrpTransactie drpTransacty) {
		getDrpTransacties().remove(drpTransacty);
		drpTransacty.setDrpTransactiebron(null);

		return drpTransacty;
	}

}