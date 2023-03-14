package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_RESELLER_ADRES database table.
 * 
 */
@Entity
@Table(name="DRP_RESELLER_ADRES")
@NamedQuery(name="DrpResellerAdre.findAll", query="SELECT d FROM DrpResellerAdre d")
public class DrpResellerAdre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RAS_ID", unique=true, nullable=false, precision=12)
	private long rasId;

	private Object aanmaakdatum;

	@Column(name="LAD_CODE", length=5)
	private String ladCode;

	@Column(length=255)
	private String plaats;

	@Column(length=255)
	private String postcode;

	@Column(name="STRAAT_1", nullable=false, length=255)
	private String straat1;

	@Column(name="STRAAT_2", length=255)
	private String straat2;

	@Column(name="STRAAT_3", length=255)
	private String straat3;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	private Object wijzigdatum;

	//bi-directional many-to-one association to DrpReseller
	@ManyToOne
	@JoinColumn(name="RSR_ID", nullable=false)
	private DrpReseller drpReseller;

	public DrpResellerAdre() {
	}

	public long getRasId() {
		return this.rasId;
	}

	public void setRasId(long rasId) {
		this.rasId = rasId;
	}

	public Object getAanmaakdatum() {
		return this.aanmaakdatum;
	}

	public void setAanmaakdatum(Object aanmaakdatum) {
		this.aanmaakdatum = aanmaakdatum;
	}

	public String getLadCode() {
		return this.ladCode;
	}

	public void setLadCode(String ladCode) {
		this.ladCode = ladCode;
	}

	public String getPlaats() {
		return this.plaats;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getStraat1() {
		return this.straat1;
	}

	public void setStraat1(String straat1) {
		this.straat1 = straat1;
	}

	public String getStraat2() {
		return this.straat2;
	}

	public void setStraat2(String straat2) {
		this.straat2 = straat2;
	}

	public String getStraat3() {
		return this.straat3;
	}

	public void setStraat3(String straat3) {
		this.straat3 = straat3;
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

	public Object getWijzigdatum() {
		return this.wijzigdatum;
	}

	public void setWijzigdatum(Object wijzigdatum) {
		this.wijzigdatum = wijzigdatum;
	}

	public DrpReseller getDrpReseller() {
		return this.drpReseller;
	}

	public void setDrpReseller(DrpReseller drpReseller) {
		this.drpReseller = drpReseller;
	}

}