package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the DRP_BEDRIJFSREGEL database table.
 * 
 */
@Entity
@Table(name="DRP_BEDRIJFSREGEL")
@NamedQuery(name="DrpBedrijfsregel.findAll", query="SELECT d FROM DrpBedrijfsregel d")
public class DrpBedrijfsregel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BRL_CODE", unique=true, nullable=false, length=5)
	private String brlCode;

	@Column(length=255)
	private String clazz;

	@Column(name="CODE_TABEL", length=255)
	private String codeTabel;

	@Column(length=50)
	private String datatype;

	@Column(length=255)
	private String formaat;

	@Column(precision=5)
	private BigDecimal lengte;

	@Column(name="MAX_OCCUR", precision=5)
	private BigDecimal maxOccur;

	@Column(name="MIN_OCCUR", precision=5)
	private BigDecimal minOccur;

	@Column(length=4000)
	private String omschrijving;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(length=255)
	private String waarden;

	//bi-directional many-to-one association to DrpFout
	@ManyToOne
	@JoinColumn(name="FOT_CODE")
	private DrpFout drpFout;

	//bi-directional many-to-one association to DrpTypeBedrijfsregel
	@ManyToOne
	@JoinColumn(name="TBL_CODE", nullable=false)
	private DrpTypeBedrijfsregel drpTypeBedrijfsregel;

	//bi-directional many-to-one association to DrpGekoppeldeBedrijfsregel
	@OneToMany(mappedBy="drpBedrijfsregel")
	private List<DrpGekoppeldeBedrijfsregel> drpGekoppeldeBedrijfsregels;

	public DrpBedrijfsregel() {
	}

	public String getBrlCode() {
		return this.brlCode;
	}

	public void setBrlCode(String brlCode) {
		this.brlCode = brlCode;
	}

	public String getClazz() {
		return this.clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getCodeTabel() {
		return this.codeTabel;
	}

	public void setCodeTabel(String codeTabel) {
		this.codeTabel = codeTabel;
	}

	public String getDatatype() {
		return this.datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getFormaat() {
		return this.formaat;
	}

	public void setFormaat(String formaat) {
		this.formaat = formaat;
	}

	public BigDecimal getLengte() {
		return this.lengte;
	}

	public void setLengte(BigDecimal lengte) {
		this.lengte = lengte;
	}

	public BigDecimal getMaxOccur() {
		return this.maxOccur;
	}

	public void setMaxOccur(BigDecimal maxOccur) {
		this.maxOccur = maxOccur;
	}

	public BigDecimal getMinOccur() {
		return this.minOccur;
	}

	public void setMinOccur(BigDecimal minOccur) {
		this.minOccur = minOccur;
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

	public String getWaarden() {
		return this.waarden;
	}

	public void setWaarden(String waarden) {
		this.waarden = waarden;
	}

	public DrpFout getDrpFout() {
		return this.drpFout;
	}

	public void setDrpFout(DrpFout drpFout) {
		this.drpFout = drpFout;
	}

	public DrpTypeBedrijfsregel getDrpTypeBedrijfsregel() {
		return this.drpTypeBedrijfsregel;
	}

	public void setDrpTypeBedrijfsregel(DrpTypeBedrijfsregel drpTypeBedrijfsregel) {
		this.drpTypeBedrijfsregel = drpTypeBedrijfsregel;
	}

	public List<DrpGekoppeldeBedrijfsregel> getDrpGekoppeldeBedrijfsregels() {
		return this.drpGekoppeldeBedrijfsregels;
	}

	public void setDrpGekoppeldeBedrijfsregels(List<DrpGekoppeldeBedrijfsregel> drpGekoppeldeBedrijfsregels) {
		this.drpGekoppeldeBedrijfsregels = drpGekoppeldeBedrijfsregels;
	}

	public DrpGekoppeldeBedrijfsregel addDrpGekoppeldeBedrijfsregel(DrpGekoppeldeBedrijfsregel drpGekoppeldeBedrijfsregel) {
		getDrpGekoppeldeBedrijfsregels().add(drpGekoppeldeBedrijfsregel);
		drpGekoppeldeBedrijfsregel.setDrpBedrijfsregel(this);

		return drpGekoppeldeBedrijfsregel;
	}

	public DrpGekoppeldeBedrijfsregel removeDrpGekoppeldeBedrijfsregel(DrpGekoppeldeBedrijfsregel drpGekoppeldeBedrijfsregel) {
		getDrpGekoppeldeBedrijfsregels().remove(drpGekoppeldeBedrijfsregel);
		drpGekoppeldeBedrijfsregel.setDrpBedrijfsregel(null);

		return drpGekoppeldeBedrijfsregel;
	}

}