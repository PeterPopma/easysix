package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_NOTITIE database table.
 * 
 */
@Entity
@Table(name="DRP_NOTITIE")
@NamedQuery(name="DrpNotitie.findAll", query="SELECT d FROM DrpNotitie d")
public class DrpNotitie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NTE_ID", unique=true, nullable=false, precision=12)
	private long nteId;

	@Column(length=255)
	private String kenmerk;

	@Lob
	@Column(nullable=false)
	private String notitie;

	@Column(nullable=false)
	private Object notitiedatum;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpBeperking
	@ManyToOne
	@JoinColumn(name="BPG_ID")
	private DrpBeperking drpBeperking;

	//bi-directional many-to-one association to DrpTransactie
	@ManyToOne
	@JoinColumn(name="TICKETNUMMER")
	private DrpTransactie drpTransactie;

	//bi-directional many-to-one association to DrpTypeNotitie
	@ManyToOne
	@JoinColumn(name="TNE_CODE", nullable=false)
	private DrpTypeNotitie drpTypeNotitie;

	public DrpNotitie() {
	}

	public long getNteId() {
		return this.nteId;
	}

	public void setNteId(long nteId) {
		this.nteId = nteId;
	}

	public String getKenmerk() {
		return this.kenmerk;
	}

	public void setKenmerk(String kenmerk) {
		this.kenmerk = kenmerk;
	}

	public String getNotitie() {
		return this.notitie;
	}

	public void setNotitie(String notitie) {
		this.notitie = notitie;
	}

	public Object getNotitiedatum() {
		return this.notitiedatum;
	}

	public void setNotitiedatum(Object notitiedatum) {
		this.notitiedatum = notitiedatum;
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

	public DrpTransactie getDrpTransactie() {
		return this.drpTransactie;
	}

	public void setDrpTransactie(DrpTransactie drpTransactie) {
		this.drpTransactie = drpTransactie;
	}

	public DrpTypeNotitie getDrpTypeNotitie() {
		return this.drpTypeNotitie;
	}

	public void setDrpTypeNotitie(DrpTypeNotitie drpTypeNotitie) {
		this.drpTypeNotitie = drpTypeNotitie;
	}

}