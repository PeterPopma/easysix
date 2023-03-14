package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_RAPPORT_LAYOUT database table.
 * 
 */
@Entity
@Table(name="DRP_RAPPORT_LAYOUT")
@NamedQuery(name="DrpRapportLayout.findAll", query="SELECT d FROM DrpRapportLayout d")
public class DrpRapportLayout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RLT_ID", unique=true, nullable=false, precision=12)
	private long rltId;

	@Lob
	@Column(name="\"BODY\"")
	private String body;

	@Lob
	@Column(name="JASPER_QUERY", nullable=false)
	private String jasperQuery;

	@Lob
	@Column(name="JASPER_REPORT", nullable=false)
	private String jasperReport;

	@Column(length=255)
	private String onderwerp;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpTaal
	@ManyToOne
	@JoinColumn(name="TAL_CODE", nullable=false)
	private DrpTaal drpTaal;

	//bi-directional many-to-one association to DrpTypeCorrespondentie
	@ManyToOne
	@JoinColumn(name="TCE_CODE", nullable=false)
	private DrpTypeCorrespondentie drpTypeCorrespondentie;

	public DrpRapportLayout() {
	}

	public long getRltId() {
		return this.rltId;
	}

	public void setRltId(long rltId) {
		this.rltId = rltId;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getJasperQuery() {
		return this.jasperQuery;
	}

	public void setJasperQuery(String jasperQuery) {
		this.jasperQuery = jasperQuery;
	}

	public String getJasperReport() {
		return this.jasperReport;
	}

	public void setJasperReport(String jasperReport) {
		this.jasperReport = jasperReport;
	}

	public String getOnderwerp() {
		return this.onderwerp;
	}

	public void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DrpTaal getDrpTaal() {
		return this.drpTaal;
	}

	public void setDrpTaal(DrpTaal drpTaal) {
		this.drpTaal = drpTaal;
	}

	public DrpTypeCorrespondentie getDrpTypeCorrespondentie() {
		return this.drpTypeCorrespondentie;
	}

	public void setDrpTypeCorrespondentie(DrpTypeCorrespondentie drpTypeCorrespondentie) {
		this.drpTypeCorrespondentie = drpTypeCorrespondentie;
	}

}