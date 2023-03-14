package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_NAMESERVER_IP database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_NAMESERVER_IP")
@NamedQuery(name="DrpTypeNameserverIp.findAll", query="SELECT d FROM DrpTypeNameserverIp d")
public class DrpTypeNameserverIp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TNP_CODE", unique=true, nullable=false, length=10)
	private String tnpCode;

	@Column(nullable=false, length=30)
	private String taalboeknaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpNameserverIpadre
	@OneToMany(mappedBy="drpTypeNameserverIp")
	private List<DrpNameserverIpadre> drpNameserverIpadres;

	public DrpTypeNameserverIp() {
	}

	public String getTnpCode() {
		return this.tnpCode;
	}

	public void setTnpCode(String tnpCode) {
		this.tnpCode = tnpCode;
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

	public List<DrpNameserverIpadre> getDrpNameserverIpadres() {
		return this.drpNameserverIpadres;
	}

	public void setDrpNameserverIpadres(List<DrpNameserverIpadre> drpNameserverIpadres) {
		this.drpNameserverIpadres = drpNameserverIpadres;
	}

	public DrpNameserverIpadre addDrpNameserverIpadre(DrpNameserverIpadre drpNameserverIpadre) {
		getDrpNameserverIpadres().add(drpNameserverIpadre);
		drpNameserverIpadre.setDrpTypeNameserverIp(this);

		return drpNameserverIpadre;
	}

	public DrpNameserverIpadre removeDrpNameserverIpadre(DrpNameserverIpadre drpNameserverIpadre) {
		getDrpNameserverIpadres().remove(drpNameserverIpadre);
		drpNameserverIpadre.setDrpTypeNameserverIp(null);

		return drpNameserverIpadre;
	}

}