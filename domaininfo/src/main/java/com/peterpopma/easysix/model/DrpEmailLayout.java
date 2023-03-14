package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_EMAIL_LAYOUT database table.
 * 
 */
@Entity
@Table(name="DRP_EMAIL_LAYOUT")
@NamedQuery(name="DrpEmailLayout.findAll", query="SELECT d FROM DrpEmailLayout d")
public class DrpEmailLayout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ELT_ID", unique=true, nullable=false, precision=12)
	private long eltId;

	@Lob
	@Column(name="\"BODY\"", nullable=false)
	private String body;

	@Column(nullable=false, length=255)
	private String onderwerp;

	@Lob
	private String stylesheet;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpEmailDynamischVeld
	@OneToMany(mappedBy="drpEmailLayout")
	private List<DrpEmailDynamischVeld> drpEmailDynamischVelds;

	//bi-directional many-to-one association to DrpTaal
	@ManyToOne
	@JoinColumn(name="TAL_CODE", nullable=false)
	private DrpTaal drpTaal;

	//bi-directional many-to-one association to DrpTypeCorrespondentie
	@ManyToOne
	@JoinColumn(name="TCE_CODE", nullable=false)
	private DrpTypeCorrespondentie drpTypeCorrespondentie;

	public DrpEmailLayout() {
	}

	public long getEltId() {
		return this.eltId;
	}

	public void setEltId(long eltId) {
		this.eltId = eltId;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getOnderwerp() {
		return this.onderwerp;
	}

	public void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}

	public String getStylesheet() {
		return this.stylesheet;
	}

	public void setStylesheet(String stylesheet) {
		this.stylesheet = stylesheet;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<DrpEmailDynamischVeld> getDrpEmailDynamischVelds() {
		return this.drpEmailDynamischVelds;
	}

	public void setDrpEmailDynamischVelds(List<DrpEmailDynamischVeld> drpEmailDynamischVelds) {
		this.drpEmailDynamischVelds = drpEmailDynamischVelds;
	}

	public DrpEmailDynamischVeld addDrpEmailDynamischVeld(DrpEmailDynamischVeld drpEmailDynamischVeld) {
		getDrpEmailDynamischVelds().add(drpEmailDynamischVeld);
		drpEmailDynamischVeld.setDrpEmailLayout(this);

		return drpEmailDynamischVeld;
	}

	public DrpEmailDynamischVeld removeDrpEmailDynamischVeld(DrpEmailDynamischVeld drpEmailDynamischVeld) {
		getDrpEmailDynamischVelds().remove(drpEmailDynamischVeld);
		drpEmailDynamischVeld.setDrpEmailLayout(null);

		return drpEmailDynamischVeld;
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