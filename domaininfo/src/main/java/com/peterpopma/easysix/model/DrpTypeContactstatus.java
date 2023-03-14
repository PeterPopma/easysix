package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_TYPE_CONTACTSTATUS database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_CONTACTSTATUS")
@NamedQuery(name="DrpTypeContactstatus.findAll", query="SELECT d FROM DrpTypeContactstatus d")
public class DrpTypeContactstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TCS_CODE", unique=true, nullable=false, length=50)
	private String tcsCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	public DrpTypeContactstatus() {
	}

	public String getTcsCode() {
		return this.tcsCode;
	}

	public void setTcsCode(String tcsCode) {
		this.tcsCode = tcsCode;
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