package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_GEBRUIKERSROL_FUNCTIE database table.
 * 
 */
@Entity
@Table(name="DRP_GEBRUIKERSROL_FUNCTIE")
@NamedQuery(name="DrpGebruikersrolFunctie.findAll", query="SELECT d FROM DrpGebruikersrolFunctie d")
public class DrpGebruikersrolFunctie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GRE_ID", unique=true, nullable=false, precision=12)
	private long greId;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpFunctie
	@ManyToOne
	@JoinColumn(name="FTE_CODE", nullable=false)
	private DrpFunctie drpFunctie;

	//bi-directional many-to-one association to DrpGebruikersrol
	@ManyToOne
	@JoinColumn(name="GRL_ID", nullable=false)
	private DrpGebruikersrol drpGebruikersrol;

	public DrpGebruikersrolFunctie() {
	}

	public long getGreId() {
		return this.greId;
	}

	public void setGreId(long greId) {
		this.greId = greId;
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

	public DrpFunctie getDrpFunctie() {
		return this.drpFunctie;
	}

	public void setDrpFunctie(DrpFunctie drpFunctie) {
		this.drpFunctie = drpFunctie;
	}

	public DrpGebruikersrol getDrpGebruikersrol() {
		return this.drpGebruikersrol;
	}

	public void setDrpGebruikersrol(DrpGebruikersrol drpGebruikersrol) {
		this.drpGebruikersrol = drpGebruikersrol;
	}

}