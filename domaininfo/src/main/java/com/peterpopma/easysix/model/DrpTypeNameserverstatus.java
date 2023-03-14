package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_TYPE_NAMESERVERSTATUS database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_NAMESERVERSTATUS")
@NamedQuery(name="DrpTypeNameserverstatus.findAll", query="SELECT d FROM DrpTypeNameserverstatus d")
public class DrpTypeNameserverstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TNS_CODE", unique=true, nullable=false, length=40)
	private String tnsCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	public DrpTypeNameserverstatus() {
	}

	public String getTnsCode() {
		return this.tnsCode;
	}

	public void setTnsCode(String tnsCode) {
		this.tnsCode = tnsCode;
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

}