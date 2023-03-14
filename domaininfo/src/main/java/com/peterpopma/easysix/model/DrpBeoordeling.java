package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_BEOORDELING database table.
 * 
 */
@Entity
@Table(name="DRP_BEOORDELING")
@NamedQuery(name="DrpBeoordeling.findAll", query="SELECT d FROM DrpBeoordeling d")
public class DrpBeoordeling implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BOG_ID", unique=true, nullable=false, precision=12)
	private long bogId;

	@Column(nullable=false)
	private Object beoordelingsdatum;

	@Column(length=255)
	private String reden;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpGebruiker
	@ManyToOne
	@JoinColumn(name="GBR_ID", nullable=false)
	private DrpGebruiker drpGebruiker;

	//bi-directional many-to-one association to DrpTransactie
	@ManyToOne
	@JoinColumn(name="TICKETNUMMER", nullable=false)
	private DrpTransactie drpTransactie;

	//bi-directional many-to-one association to DrpTypeBeoordeling
	@ManyToOne
	@JoinColumn(name="TOG_CODE", nullable=false)
	private DrpTypeBeoordeling drpTypeBeoordeling;

	//bi-directional many-to-one association to DrpTypeBeoordelingResult
	@ManyToOne
	@JoinColumn(name="TOT_CODE", nullable=false)
	private DrpTypeBeoordelingResult drpTypeBeoordelingResult;

	public DrpBeoordeling() {
	}

	public long getBogId() {
		return this.bogId;
	}

	public void setBogId(long bogId) {
		this.bogId = bogId;
	}

	public Object getBeoordelingsdatum() {
		return this.beoordelingsdatum;
	}

	public void setBeoordelingsdatum(Object beoordelingsdatum) {
		this.beoordelingsdatum = beoordelingsdatum;
	}

	public String getReden() {
		return this.reden;
	}

	public void setReden(String reden) {
		this.reden = reden;
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

	public DrpTransactie getDrpTransactie() {
		return this.drpTransactie;
	}

	public void setDrpTransactie(DrpTransactie drpTransactie) {
		this.drpTransactie = drpTransactie;
	}

	public DrpTypeBeoordeling getDrpTypeBeoordeling() {
		return this.drpTypeBeoordeling;
	}

	public void setDrpTypeBeoordeling(DrpTypeBeoordeling drpTypeBeoordeling) {
		this.drpTypeBeoordeling = drpTypeBeoordeling;
	}

	public DrpTypeBeoordelingResult getDrpTypeBeoordelingResult() {
		return this.drpTypeBeoordelingResult;
	}

	public void setDrpTypeBeoordelingResult(DrpTypeBeoordelingResult drpTypeBeoordelingResult) {
		this.drpTypeBeoordelingResult = drpTypeBeoordelingResult;
	}

}