package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_DOMEINNAAM_TRANSACTIE database table.
 * 
 */
@Entity
@Table(name="DRP_DOMEINNAAM_TRANSACTIE")
@NamedQuery(name="DrpDomeinnaamTransactie.findAll", query="SELECT d FROM DrpDomeinnaamTransactie d")
public class DrpDomeinnaamTransactie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DNE_ID", unique=true, nullable=false, precision=12)
	private long dneId;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpDomeinnaam
	@ManyToOne
	@JoinColumn(name="DNM_ID", nullable=false)
	private DrpDomeinnaam drpDomeinnaam;

	//bi-directional many-to-one association to DrpTransactie
	@ManyToOne
	@JoinColumn(name="TICKETNUMMER", nullable=false)
	private DrpTransactie drpTransactie;

	public DrpDomeinnaamTransactie() {
	}

	public long getDneId() {
		return this.dneId;
	}

	public void setDneId(long dneId) {
		this.dneId = dneId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVerwijderenJn() {
		return this.verwijderenJn;
	}

	public void setVerwijderenJn(String verwijderenJn) {
		this.verwijderenJn = verwijderenJn;
	}

	public DrpDomeinnaam getDrpDomeinnaam() {
		return this.drpDomeinnaam;
	}

	public void setDrpDomeinnaam(DrpDomeinnaam drpDomeinnaam) {
		this.drpDomeinnaam = drpDomeinnaam;
	}

	public DrpTransactie getDrpTransactie() {
		return this.drpTransactie;
	}

	public void setDrpTransactie(DrpTransactie drpTransactie) {
		this.drpTransactie = drpTransactie;
	}

}