package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_DEELNEMER_TRANSACTIE database table.
 * 
 */
@Entity
@Table(name="DRP_DEELNEMER_TRANSACTIE")
@NamedQuery(name="DrpDeelnemerTransactie.findAll", query="SELECT d FROM DrpDeelnemerTransactie d")
public class DrpDeelnemerTransactie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DNT_ID", unique=true, nullable=false, precision=12)
	private long dntId;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpDeelnemer
	@ManyToOne
	@JoinColumn(name="DNR_ID", nullable=false)
	private DrpDeelnemer drpDeelnemer;

	//bi-directional many-to-one association to DrpTransactie
	@ManyToOne
	@JoinColumn(name="TICKETNUMMER", nullable=false)
	private DrpTransactie drpTransactie;

	public DrpDeelnemerTransactie() {
	}

	public long getDntId() {
		return this.dntId;
	}

	public void setDntId(long dntId) {
		this.dntId = dntId;
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

	public DrpDeelnemer getDrpDeelnemer() {
		return this.drpDeelnemer;
	}

	public void setDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		this.drpDeelnemer = drpDeelnemer;
	}

	public DrpTransactie getDrpTransactie() {
		return this.drpTransactie;
	}

	public void setDrpTransactie(DrpTransactie drpTransactie) {
		this.drpTransactie = drpTransactie;
	}

}