package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_WOONPLAATSERVARING database table.
 * 
 */
@Entity
@Table(name="DRP_WOONPLAATSERVARING")
@NamedQuery(name="DrpWoonplaatservaring.findAll", query="SELECT d FROM DrpWoonplaatservaring d")
public class DrpWoonplaatservaring implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="WEG_ID", unique=true, nullable=false, precision=12)
	private long wegId;

	@Column(name="PWE_NEN", nullable=false, length=24)
	private String pweNen;

	@Column(name="PWE_NIET_ERKEND", nullable=false, length=30)
	private String pweNietErkend;

	@Column(name="PWE_TPG", length=18)
	private String pweTpg;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	public DrpWoonplaatservaring() {
	}

	public long getWegId() {
		return this.wegId;
	}

	public void setWegId(long wegId) {
		this.wegId = wegId;
	}

	public String getPweNen() {
		return this.pweNen;
	}

	public void setPweNen(String pweNen) {
		this.pweNen = pweNen;
	}

	public String getPweNietErkend() {
		return this.pweNietErkend;
	}

	public void setPweNietErkend(String pweNietErkend) {
		this.pweNietErkend = pweNietErkend;
	}

	public String getPweTpg() {
		return this.pweTpg;
	}

	public void setPweTpg(String pweTpg) {
		this.pweTpg = pweTpg;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}