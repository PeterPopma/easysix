package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_DEELNEMER_CONTACTPERSOON database table.
 * 
 */
@Entity
@Table(name="DRP_DEELNEMER_CONTACTPERSOON")
@NamedQuery(name="DrpDeelnemerContactpersoon.findAll", query="SELECT d FROM DrpDeelnemerContactpersoon d")
public class DrpDeelnemerContactpersoon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DCN_ID", unique=true, nullable=false, precision=12)
	private long dcnId;

	@Column(length=110)
	private String achternaam;

	@Column(name="TELECOM_EMAIL", length=255)
	private String telecomEmail;

	@Column(name="TELECOM_FAX", length=17)
	private String telecomFax;

	@Column(name="TELECOM_TELEFOON", length=17)
	private String telecomTelefoon;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(length=15)
	private String tussenvoegsels;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	@Column(length=15)
	private String voorletters;

	//bi-directional many-to-one association to DrpDeelnemer
	@ManyToOne
	@JoinColumn(name="DNR_ID", nullable=false)
	private DrpDeelnemer drpDeelnemer;

	//bi-directional many-to-one association to DrpGeslacht
	@ManyToOne
	@JoinColumn(name="GST_CODE")
	private DrpGeslacht drpGeslacht;

	//bi-directional many-to-one association to DrpTypeDeelnemercontact
	@ManyToOne
	@JoinColumn(name="TDT_CODE", nullable=false)
	private DrpTypeDeelnemercontact drpTypeDeelnemercontact;

	public DrpDeelnemerContactpersoon() {
	}

	public long getDcnId() {
		return this.dcnId;
	}

	public void setDcnId(long dcnId) {
		this.dcnId = dcnId;
	}

	public String getAchternaam() {
		return this.achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getTelecomEmail() {
		return this.telecomEmail;
	}

	public void setTelecomEmail(String telecomEmail) {
		this.telecomEmail = telecomEmail;
	}

	public String getTelecomFax() {
		return this.telecomFax;
	}

	public void setTelecomFax(String telecomFax) {
		this.telecomFax = telecomFax;
	}

	public String getTelecomTelefoon() {
		return this.telecomTelefoon;
	}

	public void setTelecomTelefoon(String telecomTelefoon) {
		this.telecomTelefoon = telecomTelefoon;
	}

	public BigDecimal getTicketnummer() {
		return this.ticketnummer;
	}

	public void setTicketnummer(BigDecimal ticketnummer) {
		this.ticketnummer = ticketnummer;
	}

	public String getTussenvoegsels() {
		return this.tussenvoegsels;
	}

	public void setTussenvoegsels(String tussenvoegsels) {
		this.tussenvoegsels = tussenvoegsels;
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

	public String getVoorletters() {
		return this.voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

	public DrpDeelnemer getDrpDeelnemer() {
		return this.drpDeelnemer;
	}

	public void setDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		this.drpDeelnemer = drpDeelnemer;
	}

	public DrpGeslacht getDrpGeslacht() {
		return this.drpGeslacht;
	}

	public void setDrpGeslacht(DrpGeslacht drpGeslacht) {
		this.drpGeslacht = drpGeslacht;
	}

	public DrpTypeDeelnemercontact getDrpTypeDeelnemercontact() {
		return this.drpTypeDeelnemercontact;
	}

	public void setDrpTypeDeelnemercontact(DrpTypeDeelnemercontact drpTypeDeelnemercontact) {
		this.drpTypeDeelnemercontact = drpTypeDeelnemercontact;
	}

}