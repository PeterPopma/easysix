package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_XML_LAYOUT database table.
 * 
 */
@Entity
@Table(name="DRP_XML_LAYOUT")
@NamedQuery(name="DrpXmlLayout.findAll", query="SELECT d FROM DrpXmlLayout d")
public class DrpXmlLayout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="XLT_ID", unique=true, nullable=false, precision=12)
	private long xltId;

	@Lob
	@Column(nullable=false)
	private String stylesheet;

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

	public DrpXmlLayout() {
	}

	public long getXltId() {
		return this.xltId;
	}

	public void setXltId(long xltId) {
		this.xltId = xltId;
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