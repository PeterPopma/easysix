package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_DIGEST database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_DIGEST")
@NamedQuery(name="DrpTypeDigest.findAll", query="SELECT d FROM DrpTypeDigest d")
public class DrpTypeDigest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TD_CODE", unique=true, nullable=false, length=1)
	private String tdCode;

	@Column(nullable=false, length=50)
	private String naam;

	@Column(name="USER_ID", length=50)
	private String userId;

	//bi-directional many-to-one association to DrpDelegationSigner
	@OneToMany(mappedBy="drpTypeDigest")
	private List<DrpDelegationSigner> drpDelegationSigners;

	public DrpTypeDigest() {
	}

	public String getTdCode() {
		return this.tdCode;
	}

	public void setTdCode(String tdCode) {
		this.tdCode = tdCode;
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

	public List<DrpDelegationSigner> getDrpDelegationSigners() {
		return this.drpDelegationSigners;
	}

	public void setDrpDelegationSigners(List<DrpDelegationSigner> drpDelegationSigners) {
		this.drpDelegationSigners = drpDelegationSigners;
	}

	public DrpDelegationSigner addDrpDelegationSigner(DrpDelegationSigner drpDelegationSigner) {
		getDrpDelegationSigners().add(drpDelegationSigner);
		drpDelegationSigner.setDrpTypeDigest(this);

		return drpDelegationSigner;
	}

	public DrpDelegationSigner removeDrpDelegationSigner(DrpDelegationSigner drpDelegationSigner) {
		getDrpDelegationSigners().remove(drpDelegationSigner);
		drpDelegationSigner.setDrpTypeDigest(null);

		return drpDelegationSigner;
	}

}