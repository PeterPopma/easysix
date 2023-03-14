package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DRP_GEBRUIKERSROL_ROLLEN database table.
 * 
 */
@Embeddable
public class DrpGebruikersrolRollenPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="GRL_BEHERENDE_ID", insertable=false, updatable=false, unique=true, nullable=false, precision=12)
	private long grlBeherendeId;

	@Column(name="GRL_BEHEERDE_ID", insertable=false, updatable=false, unique=true, nullable=false, precision=12)
	private long grlBeheerdeId;

	public DrpGebruikersrolRollenPK() {
	}
	public long getGrlBeherendeId() {
		return this.grlBeherendeId;
	}
	public void setGrlBeherendeId(long grlBeherendeId) {
		this.grlBeherendeId = grlBeherendeId;
	}
	public long getGrlBeheerdeId() {
		return this.grlBeheerdeId;
	}
	public void setGrlBeheerdeId(long grlBeheerdeId) {
		this.grlBeheerdeId = grlBeheerdeId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DrpGebruikersrolRollenPK)) {
			return false;
		}
		DrpGebruikersrolRollenPK castOther = (DrpGebruikersrolRollenPK)other;
		return 
			(this.grlBeherendeId == castOther.grlBeherendeId)
			&& (this.grlBeheerdeId == castOther.grlBeheerdeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.grlBeherendeId ^ (this.grlBeherendeId >>> 32)));
		hash = hash * prime + ((int) (this.grlBeheerdeId ^ (this.grlBeheerdeId >>> 32)));
		
		return hash;
	}
}