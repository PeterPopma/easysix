package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DRP_CODE_OMSCHRIJVING database table.
 * 
 */
@Embeddable
public class DrpCodeOmschrijvingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, length=50)
	private String code;

	@Column(unique=true, nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="TAL_CODE", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String talCode;

	public DrpCodeOmschrijvingPK() {
	}
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTaalboeknaam() {
		return this.taalboeknaam;
	}
	public void setTaalboeknaam(String taalboeknaam) {
		this.taalboeknaam = taalboeknaam;
	}
	public String getTalCode() {
		return this.talCode;
	}
	public void setTalCode(String talCode) {
		this.talCode = talCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DrpCodeOmschrijvingPK)) {
			return false;
		}
		DrpCodeOmschrijvingPK castOther = (DrpCodeOmschrijvingPK)other;
		return 
			this.code.equals(castOther.code)
			&& this.taalboeknaam.equals(castOther.taalboeknaam)
			&& this.talCode.equals(castOther.talCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.code.hashCode();
		hash = hash * prime + this.taalboeknaam.hashCode();
		hash = hash * prime + this.talCode.hashCode();
		
		return hash;
	}
}