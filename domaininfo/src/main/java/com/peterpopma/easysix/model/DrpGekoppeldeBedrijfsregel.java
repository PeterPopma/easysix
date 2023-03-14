package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_GEKOPPELDE_BEDRIJFSREGEL database table.
 * 
 */
@Entity
@Table(name="DRP_GEKOPPELDE_BEDRIJFSREGEL")
@NamedQuery(name="DrpGekoppeldeBedrijfsregel.findAll", query="SELECT d FROM DrpGekoppeldeBedrijfsregel d")
public class DrpGekoppeldeBedrijfsregel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GBL_ID", unique=true, nullable=false, precision=12)
	private long gblId;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpBedrijfsregel
	@ManyToOne
	@JoinColumn(name="BRL_CODE", nullable=false)
	private DrpBedrijfsregel drpBedrijfsregel;

	//bi-directional many-to-one association to DrpFout
	@ManyToOne
	@JoinColumn(name="FOT_CODE")
	private DrpFout drpFout;

	//bi-directional many-to-one association to DrpTransactieElement
	@ManyToOne
	@JoinColumn(name="TET_ID", nullable=false)
	private DrpTransactieElement drpTransactieElement;

	//bi-directional many-to-one association to DrpGekBedrijfsregelGrp
	@OneToMany(mappedBy="drpGekoppeldeBedrijfsregel")
	private List<DrpGekBedrijfsregelGrp> drpGekBedrijfsregelGrps;

	public DrpGekoppeldeBedrijfsregel() {
	}

	public long getGblId() {
		return this.gblId;
	}

	public void setGblId(long gblId) {
		this.gblId = gblId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DrpBedrijfsregel getDrpBedrijfsregel() {
		return this.drpBedrijfsregel;
	}

	public void setDrpBedrijfsregel(DrpBedrijfsregel drpBedrijfsregel) {
		this.drpBedrijfsregel = drpBedrijfsregel;
	}

	public DrpFout getDrpFout() {
		return this.drpFout;
	}

	public void setDrpFout(DrpFout drpFout) {
		this.drpFout = drpFout;
	}

	public DrpTransactieElement getDrpTransactieElement() {
		return this.drpTransactieElement;
	}

	public void setDrpTransactieElement(DrpTransactieElement drpTransactieElement) {
		this.drpTransactieElement = drpTransactieElement;
	}

	public List<DrpGekBedrijfsregelGrp> getDrpGekBedrijfsregelGrps() {
		return this.drpGekBedrijfsregelGrps;
	}

	public void setDrpGekBedrijfsregelGrps(List<DrpGekBedrijfsregelGrp> drpGekBedrijfsregelGrps) {
		this.drpGekBedrijfsregelGrps = drpGekBedrijfsregelGrps;
	}

	public DrpGekBedrijfsregelGrp addDrpGekBedrijfsregelGrp(DrpGekBedrijfsregelGrp drpGekBedrijfsregelGrp) {
		getDrpGekBedrijfsregelGrps().add(drpGekBedrijfsregelGrp);
		drpGekBedrijfsregelGrp.setDrpGekoppeldeBedrijfsregel(this);

		return drpGekBedrijfsregelGrp;
	}

	public DrpGekBedrijfsregelGrp removeDrpGekBedrijfsregelGrp(DrpGekBedrijfsregelGrp drpGekBedrijfsregelGrp) {
		getDrpGekBedrijfsregelGrps().remove(drpGekBedrijfsregelGrp);
		drpGekBedrijfsregelGrp.setDrpGekoppeldeBedrijfsregel(null);

		return drpGekBedrijfsregelGrp;
	}

}