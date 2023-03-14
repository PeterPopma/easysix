package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DRP_UITGESLOTEN_IP_REEKS database table.
 * 
 */
@Embeddable
public class DrpUitgeslotenIpReekPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="REEKS_VANAF", unique=true, nullable=false, length=39)
	private String reeksVanaf;

	@Column(name="REEKS_TM", unique=true, nullable=false, length=39)
	private String reeksTm;

	public DrpUitgeslotenIpReekPK() {
	}
	public String getReeksVanaf() {
		return this.reeksVanaf;
	}
	public void setReeksVanaf(String reeksVanaf) {
		this.reeksVanaf = reeksVanaf;
	}
	public String getReeksTm() {
		return this.reeksTm;
	}
	public void setReeksTm(String reeksTm) {
		this.reeksTm = reeksTm;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DrpUitgeslotenIpReekPK)) {
			return false;
		}
		DrpUitgeslotenIpReekPK castOther = (DrpUitgeslotenIpReekPK)other;
		return 
			this.reeksVanaf.equals(castOther.reeksVanaf)
			&& this.reeksTm.equals(castOther.reeksTm);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.reeksVanaf.hashCode();
		hash = hash * prime + this.reeksTm.hashCode();
		
		return hash;
	}
}