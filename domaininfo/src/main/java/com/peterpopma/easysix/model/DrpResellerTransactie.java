package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_RESELLER_TRANSACTIE database table.
 * 
 */
@Entity
@Table(name="DRP_RESELLER_TRANSACTIE")
@NamedQuery(name="DrpResellerTransactie.findAll", query="SELECT d FROM DrpResellerTransactie d")
public class DrpResellerTransactie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RRE_ID", unique=true, nullable=false, precision=12)
	private long rreId;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpReseller
	@ManyToOne
	@JoinColumn(name="RSR_ID", nullable=false)
	private DrpReseller drpReseller;

	//bi-directional many-to-one association to DrpTransactie
	@ManyToOne
	@JoinColumn(name="TICKETNUMMER", nullable=false)
	private DrpTransactie drpTransactie;

	public DrpResellerTransactie() {
	}

	public long getRreId() {
		return this.rreId;
	}

	public void setRreId(long rreId) {
		this.rreId = rreId;
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

	public DrpReseller getDrpReseller() {
		return this.drpReseller;
	}

	public void setDrpReseller(DrpReseller drpReseller) {
		this.drpReseller = drpReseller;
	}

	public DrpTransactie getDrpTransactie() {
		return this.drpTransactie;
	}

	public void setDrpTransactie(DrpTransactie drpTransactie) {
		this.drpTransactie = drpTransactie;
	}

}