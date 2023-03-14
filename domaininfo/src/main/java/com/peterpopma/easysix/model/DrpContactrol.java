package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_CONTACTROL database table.
 * 
 */
@Entity
@Table(name="DRP_CONTACTROL")
@NamedQuery(name="DrpContactrol.findAll", query="SELECT d FROM DrpContactrol d")
public class DrpContactrol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRL_ID", unique=true, nullable=false, precision=12)
	private long crlId;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpContactpersoon
	@ManyToOne
	@JoinColumn(name="CPN_HANDLE", nullable=false)
	private DrpContactpersoon drpContactpersoon;

	//bi-directional many-to-one association to DrpDomeinnaam
	@ManyToOne
	@JoinColumn(name="DNM_ID", nullable=false)
	private DrpDomeinnaam drpDomeinnaam;

	//bi-directional many-to-one association to DrpTypeContactrol
	@ManyToOne
	@JoinColumn(name="TCL_CODE", nullable=false)
	private DrpTypeContactrol drpTypeContactrol;

	public DrpContactrol() {
	}

	public long getCrlId() {
		return this.crlId;
	}

	public void setCrlId(long crlId) {
		this.crlId = crlId;
	}

	public BigDecimal getTicketnummer() {
		return this.ticketnummer;
	}

	public void setTicketnummer(BigDecimal ticketnummer) {
		this.ticketnummer = ticketnummer;
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

	public DrpContactpersoon getDrpContactpersoon() {
		return this.drpContactpersoon;
	}

	public void setDrpContactpersoon(DrpContactpersoon drpContactpersoon) {
		this.drpContactpersoon = drpContactpersoon;
	}

	public DrpDomeinnaam getDrpDomeinnaam() {
		return this.drpDomeinnaam;
	}

	public void setDrpDomeinnaam(DrpDomeinnaam drpDomeinnaam) {
		this.drpDomeinnaam = drpDomeinnaam;
	}

	public DrpTypeContactrol getDrpTypeContactrol() {
		return this.drpTypeContactrol;
	}

	public void setDrpTypeContactrol(DrpTypeContactrol drpTypeContactrol) {
		this.drpTypeContactrol = drpTypeContactrol;
	}

}