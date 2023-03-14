package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_CONTACT_ADRES database table.
 * 
 */
@Entity
@Table(name="DRP_CONTACT_ADRES")
@NamedQuery(name="DrpContactAdre.findAll", query="SELECT d FROM DrpContactAdre d")
public class DrpContactAdre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CAS_ID", unique=true, nullable=false, precision=12)
	private long casId;

	@Column(nullable=false, length=255)
	private String plaats;

	@Column(name="PLAATS_MATCH", precision=5)
	private BigDecimal plaatsMatch;

	@Column(length=16)
	private String postcode;

	@Column(name="STRAAT_1", nullable=false, length=255)
	private String straat1;

	@Column(name="STRAAT_2", length=255)
	private String straat2;

	@Column(name="STRAAT_3", length=255)
	private String straat3;

	@Column(name="STRAAT_MATCH", precision=5)
	private BigDecimal straatMatch;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpContactpersoon
	@ManyToOne
	@JoinColumn(name="CPN_HANDLE", nullable=false)
	private DrpContactpersoon drpContactpersoon;

	//bi-directional many-to-one association to DrpLand
	@ManyToOne
	@JoinColumn(name="LAD_CODE", nullable=false)
	private DrpLand drpLand;

	//bi-directional many-to-one association to DrpTypeAdresopmaak
	@ManyToOne
	@JoinColumn(name="TAK_CODE", nullable=false)
	private DrpTypeAdresopmaak drpTypeAdresopmaak;

	public DrpContactAdre() {
	}

	public long getCasId() {
		return this.casId;
	}

	public void setCasId(long casId) {
		this.casId = casId;
	}

	public String getPlaats() {
		return this.plaats;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	public BigDecimal getPlaatsMatch() {
		return this.plaatsMatch;
	}

	public void setPlaatsMatch(BigDecimal plaatsMatch) {
		this.plaatsMatch = plaatsMatch;
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

	public BigDecimal getStraatMatch() {
		return this.straatMatch;
	}

	public void setStraatMatch(BigDecimal straatMatch) {
		this.straatMatch = straatMatch;
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

	public DrpContactpersoon getDrpContactpersoon() {
		return this.drpContactpersoon;
	}

	public void setDrpContactpersoon(DrpContactpersoon drpContactpersoon) {
		this.drpContactpersoon = drpContactpersoon;
	}

	public DrpLand getDrpLand() {
		return this.drpLand;
	}

	public void setDrpLand(DrpLand drpLand) {
		this.drpLand = drpLand;
	}

	public DrpTypeAdresopmaak getDrpTypeAdresopmaak() {
		return this.drpTypeAdresopmaak;
	}

	public void setDrpTypeAdresopmaak(DrpTypeAdresopmaak drpTypeAdresopmaak) {
		this.drpTypeAdresopmaak = drpTypeAdresopmaak;
	}

}