package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_TRANSACTIEBERICHT database table.
 * 
 */
@Entity
@Table(name="DRP_TRANSACTIEBERICHT")
@NamedQuery(name="DrpTransactiebericht.findAll", query="SELECT d FROM DrpTransactiebericht d")
public class DrpTransactiebericht implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TBT_ID", unique=true, nullable=false, precision=12)
	private long tbtId;

	@Lob
	@Column(nullable=false)
	private String bericht;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpTransactie
	@ManyToOne
	@JoinColumn(name="TICKETNUMMER", nullable=false)
	private DrpTransactie drpTransactie;

	//bi-directional many-to-one association to DrpTypeTransactiebericht
	@ManyToOne
	@JoinColumn(name="TRT_CODE", nullable=false)
	private DrpTypeTransactiebericht drpTypeTransactiebericht;

	public DrpTransactiebericht() {
	}

	public long getTbtId() {
		return this.tbtId;
	}

	public void setTbtId(long tbtId) {
		this.tbtId = tbtId;
	}

	public String getBericht() {
		return this.bericht;
	}

	public void setBericht(String bericht) {
		this.bericht = bericht;
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

	public DrpTransactie getDrpTransactie() {
		return this.drpTransactie;
	}

	public void setDrpTransactie(DrpTransactie drpTransactie) {
		this.drpTransactie = drpTransactie;
	}

	public DrpTypeTransactiebericht getDrpTypeTransactiebericht() {
		return this.drpTypeTransactiebericht;
	}

	public void setDrpTypeTransactiebericht(DrpTypeTransactiebericht drpTypeTransactiebericht) {
		this.drpTypeTransactiebericht = drpTypeTransactiebericht;
	}

}