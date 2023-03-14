package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_VLAG database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_VLAG")
@NamedQuery(name="DrpTypeVlag.findAll", query="SELECT d FROM DrpTypeVlag d")
public class DrpTypeVlag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long vlag;

	@Column(nullable=false, length=50)
	private String naam;

	@Column(name="USER_ID", length=50)
	private String userId;

	//bi-directional many-to-one association to DrpDnsKey
	@OneToMany(mappedBy="drpTypeVlag")
	private List<DrpDnsKey> drpDnsKeys;

	public DrpTypeVlag() {
	}

	public long getVlag() {
		return this.vlag;
	}

	public void setVlag(long vlag) {
		this.vlag = vlag;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<DrpDnsKey> getDrpDnsKeys() {
		return this.drpDnsKeys;
	}

	public void setDrpDnsKeys(List<DrpDnsKey> drpDnsKeys) {
		this.drpDnsKeys = drpDnsKeys;
	}

	public DrpDnsKey addDrpDnsKey(DrpDnsKey drpDnsKey) {
		getDrpDnsKeys().add(drpDnsKey);
		drpDnsKey.setDrpTypeVlag(this);

		return drpDnsKey;
	}

	public DrpDnsKey removeDrpDnsKey(DrpDnsKey drpDnsKey) {
		getDrpDnsKeys().remove(drpDnsKey);
		drpDnsKey.setDrpTypeVlag(null);

		return drpDnsKey;
	}

}