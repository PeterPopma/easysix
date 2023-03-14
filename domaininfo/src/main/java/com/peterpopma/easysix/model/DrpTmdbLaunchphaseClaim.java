package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_TMDB_LAUNCHPHASE_CLAIMS database table.
 * 
 */
@Entity
@Table(name="DRP_TMDB_LAUNCHPHASE_CLAIMS")
@NamedQuery(name="DrpTmdbLaunchphaseClaim.findAll", query="SELECT d FROM DrpTmdbLaunchphaseClaim d")
public class DrpTmdbLaunchphaseClaim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LPC_ID", unique=true, nullable=false, precision=12)
	private long lpcId;

	@Column(name="ACCEPTED_BY_NORDN")
	private Object acceptedByNordn;

	@Column(name="ACCEPTED_DATETIME")
	private Object acceptedDatetime;

	@Column(name="APPLICATION_ID", precision=15)
	private BigDecimal applicationId;

	@Column(name="CPN_HANDLE", length=20)
	private String cpnHandle;

	@Column(name="CREATION_DATETIME", nullable=false)
	private Object creationDatetime;

	@Column(nullable=false, length=127)
	private String dnl;

	@Column(name="EXPORT_DATUM")
	private Object exportDatum;

	@Column(name="QLP_JN", nullable=false, length=1)
	private String qlpJn;

	@Column(name="REGISTRAR_ID", length=10)
	private String registrarId;

	@Column(name="REGISTRATION_DATETIME")
	private Object registrationDatetime;

	@Column(length=256)
	private String roid;

	@Column(name="TYPE_LAUNCHPHASE", length=64)
	private String typeLaunchphase;

	//bi-directional one-to-one association to DrpTmdbClaimsMerkbewij
	@OneToOne(mappedBy="drpTmdbLaunchphaseClaim")
	private DrpTmdbClaimsMerkbewij drpTmdbClaimsMerkbewij;

	//bi-directional many-to-one association to DrpTypeRegistratiewijze
	@ManyToOne
	@JoinColumn(name="TRW_CODE", nullable=false)
	private DrpTypeRegistratiewijze drpTypeRegistratiewijze;

	public DrpTmdbLaunchphaseClaim() {
	}

	public long getLpcId() {
		return this.lpcId;
	}

	public void setLpcId(long lpcId) {
		this.lpcId = lpcId;
	}

	public Object getAcceptedByNordn() {
		return this.acceptedByNordn;
	}

	public void setAcceptedByNordn(Object acceptedByNordn) {
		this.acceptedByNordn = acceptedByNordn;
	}

	public Object getAcceptedDatetime() {
		return this.acceptedDatetime;
	}

	public void setAcceptedDatetime(Object acceptedDatetime) {
		this.acceptedDatetime = acceptedDatetime;
	}

	public BigDecimal getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(BigDecimal applicationId) {
		this.applicationId = applicationId;
	}

	public String getCpnHandle() {
		return this.cpnHandle;
	}

	public void setCpnHandle(String cpnHandle) {
		this.cpnHandle = cpnHandle;
	}

	public Object getCreationDatetime() {
		return this.creationDatetime;
	}

	public void setCreationDatetime(Object creationDatetime) {
		this.creationDatetime = creationDatetime;
	}

	public String getDnl() {
		return this.dnl;
	}

	public void setDnl(String dnl) {
		this.dnl = dnl;
	}

	public Object getExportDatum() {
		return this.exportDatum;
	}

	public void setExportDatum(Object exportDatum) {
		this.exportDatum = exportDatum;
	}

	public String getQlpJn() {
		return this.qlpJn;
	}

	public void setQlpJn(String qlpJn) {
		this.qlpJn = qlpJn;
	}

	public String getRegistrarId() {
		return this.registrarId;
	}

	public void setRegistrarId(String registrarId) {
		this.registrarId = registrarId;
	}

	public Object getRegistrationDatetime() {
		return this.registrationDatetime;
	}

	public void setRegistrationDatetime(Object registrationDatetime) {
		this.registrationDatetime = registrationDatetime;
	}

	public String getRoid() {
		return this.roid;
	}

	public void setRoid(String roid) {
		this.roid = roid;
	}

	public String getTypeLaunchphase() {
		return this.typeLaunchphase;
	}

	public void setTypeLaunchphase(String typeLaunchphase) {
		this.typeLaunchphase = typeLaunchphase;
	}

	public DrpTmdbClaimsMerkbewij getDrpTmdbClaimsMerkbewij() {
		return this.drpTmdbClaimsMerkbewij;
	}

	public void setDrpTmdbClaimsMerkbewij(DrpTmdbClaimsMerkbewij drpTmdbClaimsMerkbewij) {
		this.drpTmdbClaimsMerkbewij = drpTmdbClaimsMerkbewij;
	}

	public DrpTypeRegistratiewijze getDrpTypeRegistratiewijze() {
		return this.drpTypeRegistratiewijze;
	}

	public void setDrpTypeRegistratiewijze(DrpTypeRegistratiewijze drpTypeRegistratiewijze) {
		this.drpTypeRegistratiewijze = drpTypeRegistratiewijze;
	}

}