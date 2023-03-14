package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_AUTHORITATIEF_NAMESERVER database table.
 * 
 */
@Entity
@Table(name="DRP_AUTHORITATIEF_NAMESERVER")
@NamedQuery(name="DrpAuthoritatiefNameserver.findAll", query="SELECT d FROM DrpAuthoritatiefNameserver d")
public class DrpAuthoritatiefNameserver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ANR_ID", unique=true, nullable=false, precision=12)
	private long anrId;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	@Column(nullable=false, precision=2)
	private BigDecimal volgnummer;

	//bi-directional many-to-one association to DrpDomeinnaam
	@ManyToOne
	@JoinColumn(name="DNM_ID", nullable=false)
	private DrpDomeinnaam drpDomeinnaam;

	//bi-directional many-to-one association to DrpNameserver
	@ManyToOne
	@JoinColumn(name="NSR_ID", nullable=false)
	private DrpNameserver drpNameserver;

	public DrpAuthoritatiefNameserver() {
	}

	public long getAnrId() {
		return this.anrId;
	}

	public void setAnrId(long anrId) {
		this.anrId = anrId;
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

	public BigDecimal getVolgnummer() {
		return this.volgnummer;
	}

	public void setVolgnummer(BigDecimal volgnummer) {
		this.volgnummer = volgnummer;
	}

	public DrpDomeinnaam getDrpDomeinnaam() {
		return this.drpDomeinnaam;
	}

	public void setDrpDomeinnaam(DrpDomeinnaam drpDomeinnaam) {
		this.drpDomeinnaam = drpDomeinnaam;
	}

	public DrpNameserver getDrpNameserver() {
		return this.drpNameserver;
	}

	public void setDrpNameserver(DrpNameserver drpNameserver) {
		this.drpNameserver = drpNameserver;
	}

}