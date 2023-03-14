package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_INVULHULPWAARDE database table.
 * 
 */
@Entity
@Table(name="DRP_INVULHULPWAARDE")
@NamedQuery(name="DrpInvulhulpwaarde.findAll", query="SELECT d FROM DrpInvulhulpwaarde d")
public class DrpInvulhulpwaarde implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IHE_ID", unique=true, nullable=false, precision=12)
	private long iheId;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(nullable=false, length=255)
	private String waarde;

	//bi-directional many-to-one association to DrpDeelnemer
	@ManyToOne
	@JoinColumn(name="DNR_ID", nullable=false)
	private DrpDeelnemer drpDeelnemer;

	//bi-directional many-to-one association to DrpTypeInvulhulpwaarde
	@ManyToOne
	@JoinColumn(name="TIE_CODE", nullable=false)
	private DrpTypeInvulhulpwaarde drpTypeInvulhulpwaarde;

	public DrpInvulhulpwaarde() {
	}

	public long getIheId() {
		return this.iheId;
	}

	public void setIheId(long iheId) {
		this.iheId = iheId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getWaarde() {
		return this.waarde;
	}

	public void setWaarde(String waarde) {
		this.waarde = waarde;
	}

	public DrpDeelnemer getDrpDeelnemer() {
		return this.drpDeelnemer;
	}

	public void setDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		this.drpDeelnemer = drpDeelnemer;
	}

	public DrpTypeInvulhulpwaarde getDrpTypeInvulhulpwaarde() {
		return this.drpTypeInvulhulpwaarde;
	}

	public void setDrpTypeInvulhulpwaarde(DrpTypeInvulhulpwaarde drpTypeInvulhulpwaarde) {
		this.drpTypeInvulhulpwaarde = drpTypeInvulhulpwaarde;
	}

}