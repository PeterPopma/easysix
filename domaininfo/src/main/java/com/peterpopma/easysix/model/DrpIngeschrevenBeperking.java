package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_INGESCHREVEN_BEPERKING database table.
 * 
 */
@Entity
@Table(name="DRP_INGESCHREVEN_BEPERKING")
@NamedQuery(name="DrpIngeschrevenBeperking.findAll", query="SELECT d FROM DrpIngeschrevenBeperking d")
public class DrpIngeschrevenBeperking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IBG_ID", unique=true, nullable=false, precision=12)
	private long ibgId;

	@Column(nullable=false)
	private Object inschrijfdatum;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	private Object uitschrijfdatum;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpBeperking
	@ManyToOne
	@JoinColumn(name="BPG_ID", nullable=false)
	private DrpBeperking drpBeperking;

	//bi-directional many-to-one association to DrpDomeinnaam
	@ManyToOne
	@JoinColumn(name="DNM_ID", nullable=false)
	private DrpDomeinnaam drpDomeinnaam;

	public DrpIngeschrevenBeperking() {
	}

	public long getIbgId() {
		return this.ibgId;
	}

	public void setIbgId(long ibgId) {
		this.ibgId = ibgId;
	}

	public Object getInschrijfdatum() {
		return this.inschrijfdatum;
	}

	public void setInschrijfdatum(Object inschrijfdatum) {
		this.inschrijfdatum = inschrijfdatum;
	}

	public BigDecimal getTicketnummer() {
		return this.ticketnummer;
	}

	public void setTicketnummer(BigDecimal ticketnummer) {
		this.ticketnummer = ticketnummer;
	}

	public Object getUitschrijfdatum() {
		return this.uitschrijfdatum;
	}

	public void setUitschrijfdatum(Object uitschrijfdatum) {
		this.uitschrijfdatum = uitschrijfdatum;
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

	public DrpBeperking getDrpBeperking() {
		return this.drpBeperking;
	}

	public void setDrpBeperking(DrpBeperking drpBeperking) {
		this.drpBeperking = drpBeperking;
	}

	public DrpDomeinnaam getDrpDomeinnaam() {
		return this.drpDomeinnaam;
	}

	public void setDrpDomeinnaam(DrpDomeinnaam drpDomeinnaam) {
		this.drpDomeinnaam = drpDomeinnaam;
	}

}