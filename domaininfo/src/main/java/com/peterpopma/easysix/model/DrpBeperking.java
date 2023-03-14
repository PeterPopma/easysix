package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the DRP_BEPERKING database table.
 * 
 */
@Entity
@Table(name="DRP_BEPERKING")
@NamedQuery(name="DrpBeperking.findAll", query="SELECT d FROM DrpBeperking d")
public class DrpBeperking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BPG_ID", unique=true, nullable=false, precision=12)
	private long bpgId;

	@Column(length=255)
	private String dossiernr;

	@Column(nullable=false)
	private Object ingangsdatum;

	@Column(length=255)
	private String reden;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	private Object uitgangsdatum;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpInstantie
	@ManyToOne
	@JoinColumn(name="ISE_CODE", nullable=false)
	private DrpInstantie drpInstantie;

	//bi-directional many-to-one association to DrpTypeBeperking
	@ManyToOne
	@JoinColumn(name="TBG_CODE", nullable=false)
	private DrpTypeBeperking drpTypeBeperking;

	//bi-directional many-to-one association to DrpIngeschrevenBeperking
	@OneToMany(mappedBy="drpBeperking")
	private List<DrpIngeschrevenBeperking> drpIngeschrevenBeperkings;

	//bi-directional many-to-one association to DrpNotitie
	@OneToMany(mappedBy="drpBeperking")
	private List<DrpNotitie> drpNotities;

	public DrpBeperking() {
	}

	public long getBpgId() {
		return this.bpgId;
	}

	public void setBpgId(long bpgId) {
		this.bpgId = bpgId;
	}

	public String getDossiernr() {
		return this.dossiernr;
	}

	public void setDossiernr(String dossiernr) {
		this.dossiernr = dossiernr;
	}

	public Object getIngangsdatum() {
		return this.ingangsdatum;
	}

	public void setIngangsdatum(Object ingangsdatum) {
		this.ingangsdatum = ingangsdatum;
	}

	public String getReden() {
		return this.reden;
	}

	public void setReden(String reden) {
		this.reden = reden;
	}

	public BigDecimal getTicketnummer() {
		return this.ticketnummer;
	}

	public void setTicketnummer(BigDecimal ticketnummer) {
		this.ticketnummer = ticketnummer;
	}

	public Object getUitgangsdatum() {
		return this.uitgangsdatum;
	}

	public void setUitgangsdatum(Object uitgangsdatum) {
		this.uitgangsdatum = uitgangsdatum;
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

	public DrpInstantie getDrpInstantie() {
		return this.drpInstantie;
	}

	public void setDrpInstantie(DrpInstantie drpInstantie) {
		this.drpInstantie = drpInstantie;
	}

	public DrpTypeBeperking getDrpTypeBeperking() {
		return this.drpTypeBeperking;
	}

	public void setDrpTypeBeperking(DrpTypeBeperking drpTypeBeperking) {
		this.drpTypeBeperking = drpTypeBeperking;
	}

	public List<DrpIngeschrevenBeperking> getDrpIngeschrevenBeperkings() {
		return this.drpIngeschrevenBeperkings;
	}

	public void setDrpIngeschrevenBeperkings(List<DrpIngeschrevenBeperking> drpIngeschrevenBeperkings) {
		this.drpIngeschrevenBeperkings = drpIngeschrevenBeperkings;
	}

	public DrpIngeschrevenBeperking addDrpIngeschrevenBeperking(DrpIngeschrevenBeperking drpIngeschrevenBeperking) {
		getDrpIngeschrevenBeperkings().add(drpIngeschrevenBeperking);
		drpIngeschrevenBeperking.setDrpBeperking(this);

		return drpIngeschrevenBeperking;
	}

	public DrpIngeschrevenBeperking removeDrpIngeschrevenBeperking(DrpIngeschrevenBeperking drpIngeschrevenBeperking) {
		getDrpIngeschrevenBeperkings().remove(drpIngeschrevenBeperking);
		drpIngeschrevenBeperking.setDrpBeperking(null);

		return drpIngeschrevenBeperking;
	}

	public List<DrpNotitie> getDrpNotities() {
		return this.drpNotities;
	}

	public void setDrpNotities(List<DrpNotitie> drpNotities) {
		this.drpNotities = drpNotities;
	}

	public DrpNotitie addDrpNotity(DrpNotitie drpNotity) {
		getDrpNotities().add(drpNotity);
		drpNotity.setDrpBeperking(this);

		return drpNotity;
	}

	public DrpNotitie removeDrpNotity(DrpNotitie drpNotity) {
		getDrpNotities().remove(drpNotity);
		drpNotity.setDrpBeperking(null);

		return drpNotity;
	}

}