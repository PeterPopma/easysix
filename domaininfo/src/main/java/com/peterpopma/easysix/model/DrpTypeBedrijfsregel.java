package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_BEDRIJFSREGEL database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_BEDRIJFSREGEL")
@NamedQuery(name="DrpTypeBedrijfsregel.findAll", query="SELECT d FROM DrpTypeBedrijfsregel d")
public class DrpTypeBedrijfsregel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TBL_CODE", unique=true, nullable=false, length=10)
	private String tblCode;

	@Column(length=255)
	private String omschrijving;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(nullable=false, precision=2)
	private BigDecimal volgorde;

	//bi-directional many-to-one association to DrpBedrijfsregel
	@OneToMany(mappedBy="drpTypeBedrijfsregel")
	private List<DrpBedrijfsregel> drpBedrijfsregels;

	public DrpTypeBedrijfsregel() {
	}

	public String getTblCode() {
		return this.tblCode;
	}

	public void setTblCode(String tblCode) {
		this.tblCode = tblCode;
	}

	public String getOmschrijving() {
		return this.omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BigDecimal getVolgorde() {
		return this.volgorde;
	}

	public void setVolgorde(BigDecimal volgorde) {
		this.volgorde = volgorde;
	}

	public List<DrpBedrijfsregel> getDrpBedrijfsregels() {
		return this.drpBedrijfsregels;
	}

	public void setDrpBedrijfsregels(List<DrpBedrijfsregel> drpBedrijfsregels) {
		this.drpBedrijfsregels = drpBedrijfsregels;
	}

	public DrpBedrijfsregel addDrpBedrijfsregel(DrpBedrijfsregel drpBedrijfsregel) {
		getDrpBedrijfsregels().add(drpBedrijfsregel);
		drpBedrijfsregel.setDrpTypeBedrijfsregel(this);

		return drpBedrijfsregel;
	}

	public DrpBedrijfsregel removeDrpBedrijfsregel(DrpBedrijfsregel drpBedrijfsregel) {
		getDrpBedrijfsregels().remove(drpBedrijfsregel);
		drpBedrijfsregel.setDrpTypeBedrijfsregel(null);

		return drpBedrijfsregel;
	}

}