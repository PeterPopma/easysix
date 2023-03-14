package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_INSTANTIE_TYPE_BEPERKING database table.
 * 
 */
@Entity
@Table(name="DRP_INSTANTIE_TYPE_BEPERKING")
@NamedQuery(name="DrpInstantieTypeBeperking.findAll", query="SELECT d FROM DrpInstantieTypeBeperking d")
public class DrpInstantieTypeBeperking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ITG_ID", unique=true, nullable=false, precision=12)
	private long itgId;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpInstantie
	@ManyToOne
	@JoinColumn(name="ISE_CODE", nullable=false)
	private DrpInstantie drpInstantie;

	//bi-directional many-to-one association to DrpTypeBeperking
	@ManyToOne
	@JoinColumn(name="TBG_CODE", nullable=false)
	private DrpTypeBeperking drpTypeBeperking;

	public DrpInstantieTypeBeperking() {
	}

	public long getItgId() {
		return this.itgId;
	}

	public void setItgId(long itgId) {
		this.itgId = itgId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DrpInstantie getDrpInstantie() {
		return this.drpInstantie;
	}

	public void setDrpInstantie(DrpInstantie drpInstantie) {
		this.drpInstantie = drpInstantie;
	}

	public DrpTypeBeperking getDrpTypeBeperking() {
		return this.drpTypeBeperking;
	}

	public void setDrpTypeBeperking(DrpTypeBeperking drpTypeBeperking) {
		this.drpTypeBeperking = drpTypeBeperking;
	}

}