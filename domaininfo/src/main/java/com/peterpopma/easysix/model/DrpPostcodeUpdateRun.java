package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_POSTCODE_UPDATE_RUN database table.
 * 
 */
@Entity
@Table(name="DRP_POSTCODE_UPDATE_RUN")
@NamedQuery(name="DrpPostcodeUpdateRun.findAll", query="SELECT d FROM DrpPostcodeUpdateRun d")
public class DrpPostcodeUpdateRun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PUN_ID", unique=true, nullable=false, precision=12)
	private long punId;

	@Column(nullable=false, length=255)
	private String bestandsnaam;

	@Column(name="LAATSTE_STATUS", nullable=false, length=20)
	private String laatsteStatus;

	@Lob
	@Column(name="RAPPORT_XML")
	private String rapportXml;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWERKING_EIND")
	private Object verwerkingEind;

	@Column(name="VERWERKING_START", nullable=false)
	private Object verwerkingStart;

	public DrpPostcodeUpdateRun() {
	}

	public long getPunId() {
		return this.punId;
	}

	public void setPunId(long punId) {
		this.punId = punId;
	}

	public String getBestandsnaam() {
		return this.bestandsnaam;
	}

	public void setBestandsnaam(String bestandsnaam) {
		this.bestandsnaam = bestandsnaam;
	}

	public String getLaatsteStatus() {
		return this.laatsteStatus;
	}

	public void setLaatsteStatus(String laatsteStatus) {
		this.laatsteStatus = laatsteStatus;
	}

	public String getRapportXml() {
		return this.rapportXml;
	}

	public void setRapportXml(String rapportXml) {
		this.rapportXml = rapportXml;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Object getVerwerkingEind() {
		return this.verwerkingEind;
	}

	public void setVerwerkingEind(Object verwerkingEind) {
		this.verwerkingEind = verwerkingEind;
	}

	public Object getVerwerkingStart() {
		return this.verwerkingStart;
	}

	public void setVerwerkingStart(Object verwerkingStart) {
		this.verwerkingStart = verwerkingStart;
	}

}