package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_CORRESPONDENTIE database table.
 * 
 */
@Entity
@Table(name="DRP_CORRESPONDENTIE")
@NamedQuery(name="DrpCorrespondentie.findAll", query="SELECT d FROM DrpCorrespondentie d")
public class DrpCorrespondentie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRE_ID", unique=true, nullable=false, precision=12)
	private long creId;

	@Column(length=512)
	private String adresto;

	@Column(name="AFGEROND_JN", nullable=false, length=1)
	private String afgerondJn;

	@Column(nullable=false)
	private Object datumcorrespondentie;

	@Column(length=255)
	private String onderwerp;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpContactpersoon
	@ManyToOne
	@JoinColumn(name="CPN_HANDLE")
	private DrpContactpersoon drpContactpersoon;

	//bi-directional many-to-one association to DrpDeelnemer
	@ManyToOne
	@JoinColumn(name="DNR_ID")
	private DrpDeelnemer drpDeelnemer;

	//bi-directional many-to-one association to DrpTaal
	@ManyToOne
	@JoinColumn(name="TAL_CODE", nullable=false)
	private DrpTaal drpTaal;

	//bi-directional many-to-one association to DrpTransactie
	@ManyToOne
	@JoinColumn(name="TICKETNUMMER", nullable=false)
	private DrpTransactie drpTransactie;

	//bi-directional many-to-one association to DrpTypeCorrespondentie
	@ManyToOne
	@JoinColumn(name="TCE_CODE", nullable=false)
	private DrpTypeCorrespondentie drpTypeCorrespondentie;

	//bi-directional one-to-one association to DrpCorrespondentieData
	@OneToOne(mappedBy="drpCorrespondentie")
	private DrpCorrespondentieData drpCorrespondentieData;

	public DrpCorrespondentie() {
	}

	public long getCreId() {
		return this.creId;
	}

	public void setCreId(long creId) {
		this.creId = creId;
	}

	public String getAdresto() {
		return this.adresto;
	}

	public void setAdresto(String adresto) {
		this.adresto = adresto;
	}

	public String getAfgerondJn() {
		return this.afgerondJn;
	}

	public void setAfgerondJn(String afgerondJn) {
		this.afgerondJn = afgerondJn;
	}

	public Object getDatumcorrespondentie() {
		return this.datumcorrespondentie;
	}

	public void setDatumcorrespondentie(Object datumcorrespondentie) {
		this.datumcorrespondentie = datumcorrespondentie;
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

	public DrpDeelnemer getDrpDeelnemer() {
		return this.drpDeelnemer;
	}

	public void setDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		this.drpDeelnemer = drpDeelnemer;
	}

	public DrpTaal getDrpTaal() {
		return this.drpTaal;
	}

	public void setDrpTaal(DrpTaal drpTaal) {
		this.drpTaal = drpTaal;
	}

	public DrpTransactie getDrpTransactie() {
		return this.drpTransactie;
	}

	public void setDrpTransactie(DrpTransactie drpTransactie) {
		this.drpTransactie = drpTransactie;
	}

	public DrpTypeCorrespondentie getDrpTypeCorrespondentie() {
		return this.drpTypeCorrespondentie;
	}

	public void setDrpTypeCorrespondentie(DrpTypeCorrespondentie drpTypeCorrespondentie) {
		this.drpTypeCorrespondentie = drpTypeCorrespondentie;
	}

	public DrpCorrespondentieData getDrpCorrespondentieData() {
		return this.drpCorrespondentieData;
	}

	public void setDrpCorrespondentieData(DrpCorrespondentieData drpCorrespondentieData) {
		this.drpCorrespondentieData = drpCorrespondentieData;
	}

}