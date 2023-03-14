package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_GEBRUIKER_GEBRUIKERSROL database table.
 * 
 */
@Entity
@Table(name="DRP_GEBRUIKER_GEBRUIKERSROL")
@NamedQuery(name="DrpGebruikerGebruikersrol.findAll", query="SELECT d FROM DrpGebruikerGebruikersrol d")
public class DrpGebruikerGebruikersrol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GGL_ID", unique=true, nullable=false, precision=12)
	private long gglId;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpGebruiker
	@ManyToOne
	@JoinColumn(name="GBR_ID", nullable=false)
	private DrpGebruiker drpGebruiker;

	//bi-directional many-to-one association to DrpGebruikersrol
	@ManyToOne
	@JoinColumn(name="GRL_ID", nullable=false)
	private DrpGebruikersrol drpGebruikersrol;

	public DrpGebruikerGebruikersrol() {
	}

	public long getGglId() {
		return this.gglId;
	}

	public void setGglId(long gglId) {
		this.gglId = gglId;
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

	public DrpGebruiker getDrpGebruiker() {
		return this.drpGebruiker;
	}

	public void setDrpGebruiker(DrpGebruiker drpGebruiker) {
		this.drpGebruiker = drpGebruiker;
	}

	public DrpGebruikersrol getDrpGebruikersrol() {
		return this.drpGebruikersrol;
	}

	public void setDrpGebruikersrol(DrpGebruikersrol drpGebruikersrol) {
		this.drpGebruikersrol = drpGebruikersrol;
	}

}