package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_SYSTEEMPARAMETER database table.
 * 
 */
@Entity
@Table(name="DRP_SYSTEEMPARAMETER")
@NamedQuery(name="DrpSysteemparameter.findAll", query="SELECT d FROM DrpSysteemparameter d")
public class DrpSysteemparameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SPR_ID", unique=true, nullable=false, precision=12)
	private long sprId;

	@Column(nullable=false, length=255)
	private String omschrijving;

	@Column(nullable=false, length=50)
	private String parameternaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(nullable=false, length=255)
	private String waarde;

	public DrpSysteemparameter() {
	}

	public long getSprId() {
		return this.sprId;
	}

	public void setSprId(long sprId) {
		this.sprId = sprId;
	}

	public String getOmschrijving() {
		return this.omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public String getParameternaam() {
		return this.parameternaam;
	}

	public void setParameternaam(String parameternaam) {
		this.parameternaam = parameternaam;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getWaarde() {
		return this.waarde;
	}

	public void setWaarde(String waarde) {
		this.waarde = waarde;
	}

}