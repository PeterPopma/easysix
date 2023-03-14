package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_TRANSACTIEBERICHT database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_TRANSACTIEBERICHT")
@NamedQuery(name="DrpTypeTransactiebericht.findAll", query="SELECT d FROM DrpTypeTransactiebericht d")
public class DrpTypeTransactiebericht implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TRT_CODE", unique=true, nullable=false, length=10)
	private String trtCode;

	@Column(length=50)
	private String omschrijving;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpTransactiebericht
	@OneToMany(mappedBy="drpTypeTransactiebericht")
	private List<DrpTransactiebericht> drpTransactieberichts;

	public DrpTypeTransactiebericht() {
	}

	public String getTrtCode() {
		return this.trtCode;
	}

	public void setTrtCode(String trtCode) {
		this.trtCode = trtCode;
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

	public List<DrpTransactiebericht> getDrpTransactieberichts() {
		return this.drpTransactieberichts;
	}

	public void setDrpTransactieberichts(List<DrpTransactiebericht> drpTransactieberichts) {
		this.drpTransactieberichts = drpTransactieberichts;
	}

	public DrpTransactiebericht addDrpTransactiebericht(DrpTransactiebericht drpTransactiebericht) {
		getDrpTransactieberichts().add(drpTransactiebericht);
		drpTransactiebericht.setDrpTypeTransactiebericht(this);

		return drpTransactiebericht;
	}

	public DrpTransactiebericht removeDrpTransactiebericht(DrpTransactiebericht drpTransactiebericht) {
		getDrpTransactieberichts().remove(drpTransactiebericht);
		drpTransactiebericht.setDrpTypeTransactiebericht(null);

		return drpTransactiebericht;
	}

}