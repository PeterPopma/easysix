package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_GEK_BEDRIJFSREGEL_GRP database table.
 * 
 */
@Entity
@Table(name="DRP_GEK_BEDRIJFSREGEL_GRP")
@NamedQuery(name="DrpGekBedrijfsregelGrp.findAll", query="SELECT d FROM DrpGekBedrijfsregelGrp d")
public class DrpGekBedrijfsregelGrp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BRP_ID", unique=true, nullable=false, precision=12)
	private long brpId;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpBedrijfsregelGroep
	@ManyToOne
	@JoinColumn(name="BGP_ID", nullable=false)
	private DrpBedrijfsregelGroep drpBedrijfsregelGroep;

	//bi-directional many-to-one association to DrpGekoppeldeBedrijfsregel
	@ManyToOne
	@JoinColumn(name="GBL_ID", nullable=false)
	private DrpGekoppeldeBedrijfsregel drpGekoppeldeBedrijfsregel;

	public DrpGekBedrijfsregelGrp() {
	}

	public long getBrpId() {
		return this.brpId;
	}

	public void setBrpId(long brpId) {
		this.brpId = brpId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DrpBedrijfsregelGroep getDrpBedrijfsregelGroep() {
		return this.drpBedrijfsregelGroep;
	}

	public void setDrpBedrijfsregelGroep(DrpBedrijfsregelGroep drpBedrijfsregelGroep) {
		this.drpBedrijfsregelGroep = drpBedrijfsregelGroep;
	}

	public DrpGekoppeldeBedrijfsregel getDrpGekoppeldeBedrijfsregel() {
		return this.drpGekoppeldeBedrijfsregel;
	}

	public void setDrpGekoppeldeBedrijfsregel(DrpGekoppeldeBedrijfsregel drpGekoppeldeBedrijfsregel) {
		this.drpGekoppeldeBedrijfsregel = drpGekoppeldeBedrijfsregel;
	}

}