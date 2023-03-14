package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_NAMESERVER_TRANSACTIE database table.
 * 
 */
@Entity
@Table(name="DRP_NAMESERVER_TRANSACTIE")
@NamedQuery(name="DrpNameserverTransactie.findAll", query="SELECT d FROM DrpNameserverTransactie d")
public class DrpNameserverTransactie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NSE_ID", unique=true, nullable=false, precision=12)
	private long nseId;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpNameserver
	@ManyToOne
	@JoinColumn(name="NSR_ID", nullable=false)
	private DrpNameserver drpNameserver;

	//bi-directional many-to-one association to DrpTransactie
	@ManyToOne
	@JoinColumn(name="TICKETNUMMER", nullable=false)
	private DrpTransactie drpTransactie;

	public DrpNameserverTransactie() {
	}

	public long getNseId() {
		return this.nseId;
	}

	public void setNseId(long nseId) {
		this.nseId = nseId;
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

	public DrpNameserver getDrpNameserver() {
		return this.drpNameserver;
	}

	public void setDrpNameserver(DrpNameserver drpNameserver) {
		this.drpNameserver = drpNameserver;
	}

	public DrpTransactie getDrpTransactie() {
		return this.drpTransactie;
	}

	public void setDrpTransactie(DrpTransactie drpTransactie) {
		this.drpTransactie = drpTransactie;
	}

}