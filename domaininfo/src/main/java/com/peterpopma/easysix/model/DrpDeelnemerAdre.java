package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_DEELNEMER_ADRES database table.
 * 
 */
@Entity
@Table(name="DRP_DEELNEMER_ADRES")
@NamedQuery(name="DrpDeelnemerAdre.findAll", query="SELECT d FROM DrpDeelnemerAdre d")
public class DrpDeelnemerAdre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DAS_ID", unique=true, nullable=false, precision=12)
	private long dasId;

	@Column(precision=5)
	private BigDecimal huisnummer;

	@Column(length=6)
	private String huisnummertoevoeging;

	@Column(length=40)
	private String plaats;

	@Column(length=16)
	private String postcode;

	@Column(length=255)
	private String staat;

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

	//bi-directional many-to-one association to DrpDeelnemer
	@ManyToOne
	@JoinColumn(name="DNR_ID", nullable=false)
	private DrpDeelnemer drpDeelnemer;

	//bi-directional many-to-one association to DrpLand
	@ManyToOne
	@JoinColumn(name="LAD_CODE", nullable=false)
	private DrpLand drpLand;

	//bi-directional many-to-one association to DrpTypeDeelnemerAdre
	@ManyToOne
	@JoinColumn(name="TDS_CODE", nullable=false)
	private DrpTypeDeelnemerAdre drpTypeDeelnemerAdre;

	public DrpDeelnemerAdre() {
	}

	public long getDasId() {
		return this.dasId;
	}

	public void setDasId(long dasId) {
		this.dasId = dasId;
	}

	public BigDecimal getHuisnummer() {
		return this.huisnummer;
	}

	public void setHuisnummer(BigDecimal huisnummer) {
		this.huisnummer = huisnummer;
	}

	public String getHuisnummertoevoeging() {
		return this.huisnummertoevoeging;
	}

	public void setHuisnummertoevoeging(String huisnummertoevoeging) {
		this.huisnummertoevoeging = huisnummertoevoeging;
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

	public String getStaat() {
		return this.staat;
	}

	public void setStaat(String staat) {
		this.staat = staat;
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

	public DrpDeelnemer getDrpDeelnemer() {
		return this.drpDeelnemer;
	}

	public void setDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		this.drpDeelnemer = drpDeelnemer;
	}

	public DrpLand getDrpLand() {
		return this.drpLand;
	}

	public void setDrpLand(DrpLand drpLand) {
		this.drpLand = drpLand;
	}

	public DrpTypeDeelnemerAdre getDrpTypeDeelnemerAdre() {
		return this.drpTypeDeelnemerAdre;
	}

	public void setDrpTypeDeelnemerAdre(DrpTypeDeelnemerAdre drpTypeDeelnemerAdre) {
		this.drpTypeDeelnemerAdre = drpTypeDeelnemerAdre;
	}

}