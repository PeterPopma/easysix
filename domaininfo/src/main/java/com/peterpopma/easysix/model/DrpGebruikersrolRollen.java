package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_GEBRUIKERSROL_ROLLEN database table.
 * 
 */
@Entity
@Table(name="DRP_GEBRUIKERSROL_ROLLEN")
@NamedQuery(name="DrpGebruikersrolRollen.findAll", query="SELECT d FROM DrpGebruikersrolRollen d")
public class DrpGebruikersrolRollen implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DrpGebruikersrolRollenPK id;

	@Column(name="GRL_GRLN_ID", nullable=false, precision=12)
	private BigDecimal grlGrlnId;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpGebruikersrol
	@ManyToOne
	@JoinColumn(name="GRL_BEHEERDE_ID", nullable=false, insertable=false, updatable=false)
	private DrpGebruikersrol drpGebruikersrol1;

	//bi-directional many-to-one association to DrpGebruikersrol
	@ManyToOne
	@JoinColumn(name="GRL_BEHERENDE_ID", nullable=false, insertable=false, updatable=false)
	private DrpGebruikersrol drpGebruikersrol2;

	public DrpGebruikersrolRollen() {
	}

	public DrpGebruikersrolRollenPK getId() {
		return this.id;
	}

	public void setId(DrpGebruikersrolRollenPK id) {
		this.id = id;
	}

	public BigDecimal getGrlGrlnId() {
		return this.grlGrlnId;
	}

	public void setGrlGrlnId(BigDecimal grlGrlnId) {
		this.grlGrlnId = grlGrlnId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DrpGebruikersrol getDrpGebruikersrol1() {
		return this.drpGebruikersrol1;
	}

	public void setDrpGebruikersrol1(DrpGebruikersrol drpGebruikersrol1) {
		this.drpGebruikersrol1 = drpGebruikersrol1;
	}

	public DrpGebruikersrol getDrpGebruikersrol2() {
		return this.drpGebruikersrol2;
	}

	public void setDrpGebruikersrol2(DrpGebruikersrol drpGebruikersrol2) {
		this.drpGebruikersrol2 = drpGebruikersrol2;
	}

}