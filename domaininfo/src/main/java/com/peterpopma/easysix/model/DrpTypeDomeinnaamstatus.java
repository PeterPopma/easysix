package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_TYPE_DOMEINNAAMSTATUS database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_DOMEINNAAMSTATUS")
@NamedQuery(name="DrpTypeDomeinnaamstatus.findAll", query="SELECT d FROM DrpTypeDomeinnaamstatus d")
public class DrpTypeDomeinnaamstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TSS_CODE", unique=true, nullable=false, length=30)
	private String tssCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	public DrpTypeDomeinnaamstatus() {
	}

	public String getTssCode() {
		return this.tssCode;
	}

	public void setTssCode(String tssCode) {
		this.tssCode = tssCode;
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