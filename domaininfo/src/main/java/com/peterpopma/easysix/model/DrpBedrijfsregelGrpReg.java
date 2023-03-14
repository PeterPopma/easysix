package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_BEDRIJFSREGEL_GRP_REG database table.
 * 
 */
@Entity
@Table(name="DRP_BEDRIJFSREGEL_GRP_REG")
@NamedQuery(name="DrpBedrijfsregelGrpReg.findAll", query="SELECT d FROM DrpBedrijfsregelGrpReg d")
public class DrpBedrijfsregelGrpReg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BGR_ID", unique=true, nullable=false, precision=12)
	private long bgrId;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpBedrijfsregelGroep
	@ManyToOne
	@JoinColumn(name="BGP_ID", nullable=false)
	private DrpBedrijfsregelGroep drpBedrijfsregelGroep;

	//bi-directional many-to-one association to DrpRegistry
	@ManyToOne
	@JoinColumn(name="RGY_ID", nullable=false)
	private DrpRegistry drpRegistry;

	public DrpBedrijfsregelGrpReg() {
	}

	public long getBgrId() {
		return this.bgrId;
	}

	public void setBgrId(long bgrId) {
		this.bgrId = bgrId;
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

	public DrpRegistry getDrpRegistry() {
		return this.drpRegistry;
	}

	public void setDrpRegistry(DrpRegistry drpRegistry) {
		this.drpRegistry = drpRegistry;
	}

}