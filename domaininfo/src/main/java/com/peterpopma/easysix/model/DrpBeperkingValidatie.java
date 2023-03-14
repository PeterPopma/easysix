package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_BEPERKING_VALIDATIE database table.
 * 
 */
@Entity
@Table(name="DRP_BEPERKING_VALIDATIE")
@NamedQuery(name="DrpBeperkingValidatie.findAll", query="SELECT d FROM DrpBeperkingValidatie d")
public class DrpBeperkingValidatie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BVE_ID", unique=true, nullable=false, precision=12)
	private long bveId;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpKlasseattribuut
	@ManyToOne
	@JoinColumn(name="KAT_ID", nullable=false)
	private DrpKlasseattribuut drpKlasseattribuut;

	//bi-directional many-to-one association to DrpTypeBeperking
	@ManyToOne
	@JoinColumn(name="TBG_CODE", nullable=false)
	private DrpTypeBeperking drpTypeBeperking;

	//bi-directional many-to-one association to DrpTypeBeperkingActie
	@ManyToOne
	@JoinColumn(name="VERWIJDER_TBE_CODE")
	private DrpTypeBeperkingActie drpTypeBeperkingActie1;

	//bi-directional many-to-one association to DrpTypeBeperkingActie
	@ManyToOne
	@JoinColumn(name="WIJZIG_TBE_CODE")
	private DrpTypeBeperkingActie drpTypeBeperkingActie2;

	public DrpBeperkingValidatie() {
	}

	public long getBveId() {
		return this.bveId;
	}

	public void setBveId(long bveId) {
		this.bveId = bveId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DrpKlasseattribuut getDrpKlasseattribuut() {
		return this.drpKlasseattribuut;
	}

	public void setDrpKlasseattribuut(DrpKlasseattribuut drpKlasseattribuut) {
		this.drpKlasseattribuut = drpKlasseattribuut;
	}

	public DrpTypeBeperking getDrpTypeBeperking() {
		return this.drpTypeBeperking;
	}

	public void setDrpTypeBeperking(DrpTypeBeperking drpTypeBeperking) {
		this.drpTypeBeperking = drpTypeBeperking;
	}

	public DrpTypeBeperkingActie getDrpTypeBeperkingActie1() {
		return this.drpTypeBeperkingActie1;
	}

	public void setDrpTypeBeperkingActie1(DrpTypeBeperkingActie drpTypeBeperkingActie1) {
		this.drpTypeBeperkingActie1 = drpTypeBeperkingActie1;
	}

	public DrpTypeBeperkingActie getDrpTypeBeperkingActie2() {
		return this.drpTypeBeperkingActie2;
	}

	public void setDrpTypeBeperkingActie2(DrpTypeBeperkingActie drpTypeBeperkingActie2) {
		this.drpTypeBeperkingActie2 = drpTypeBeperkingActie2;
	}

}