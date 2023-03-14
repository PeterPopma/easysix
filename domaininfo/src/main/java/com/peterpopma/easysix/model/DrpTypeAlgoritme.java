package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_ALGORITME database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_ALGORITME")
@NamedQuery(name="DrpTypeAlgoritme.findAll", query="SELECT d FROM DrpTypeAlgoritme d")
public class DrpTypeAlgoritme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TA_CODE", unique=true, nullable=false, length=3)
	private String taCode;

	@Column(nullable=false, length=50)
	private String naam;

	@Column(name="USER_ID", length=50)
	private String userId;

	//bi-directional many-to-one association to DrpDnsKey
	@OneToMany(mappedBy="drpTypeAlgoritme")
	private List<DrpDnsKey> drpDnsKeys;

	public DrpTypeAlgoritme() {
	}

	public String getTaCode() {
		return this.taCode;
	}

	public void setTaCode(String taCode) {
		this.taCode = taCode;
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
		drpDnsKey.setDrpTypeAlgoritme(this);

		return drpDnsKey;
	}

	public DrpDnsKey removeDrpDnsKey(DrpDnsKey drpDnsKey) {
		getDrpDnsKeys().remove(drpDnsKey);
		drpDnsKey.setDrpTypeAlgoritme(null);

		return drpDnsKey;
	}

}