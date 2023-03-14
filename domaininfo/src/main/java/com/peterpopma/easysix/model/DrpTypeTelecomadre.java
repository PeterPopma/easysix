package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_TYPE_TELECOMADRES database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_TELECOMADRES")
@NamedQuery(name="DrpTypeTelecomadre.findAll", query="SELECT d FROM DrpTypeTelecomadre d")
public class DrpTypeTelecomadre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TTS_CODE", unique=true, nullable=false, length=10)
	private String ttsCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	public DrpTypeTelecomadre() {
	}

	public String getTtsCode() {
		return this.ttsCode;
	}

	public void setTtsCode(String ttsCode) {
		this.ttsCode = ttsCode;
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