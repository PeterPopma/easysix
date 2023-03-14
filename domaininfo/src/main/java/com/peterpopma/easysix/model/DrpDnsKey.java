package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the DRP_DNS_KEY database table.
 * 
 */
@Entity
@Table(name="DRP_DNS_KEY")
@NamedQuery(name="DrpDnsKey.findAll", query="SELECT d FROM DrpDnsKey d")
public class DrpDnsKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DK_ID", unique=true, nullable=false, precision=12)
	private long dkId;

	@Column(name="KEY_TAG", nullable=false, precision=12)
	private BigDecimal keyTag;

	@Column(nullable=false, precision=12)
	private BigDecimal protocol;

	@Column(name="PUBLIEKE_SLEUTEL", nullable=false, length=4000)
	private String publiekeSleutel;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="USER_ID", length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpDelegationSigner
	@OneToMany(mappedBy="drpDnsKey")
	private List<DrpDelegationSigner> drpDelegationSigners;

	//bi-directional many-to-one association to DrpDomeinnaam
	@ManyToOne
	@JoinColumn(name="DNM_ID", nullable=false)
	private DrpDomeinnaam drpDomeinnaam;

	//bi-directional many-to-one association to DrpTypeAlgoritme
	@ManyToOne
	@JoinColumn(name="TA_CODE", nullable=false)
	private DrpTypeAlgoritme drpTypeAlgoritme;

	//bi-directional many-to-one association to DrpTypeVlag
	@ManyToOne
	@JoinColumn(name="VLAG", nullable=false)
	private DrpTypeVlag drpTypeVlag;

	public DrpDnsKey() {
	}

	public long getDkId() {
		return this.dkId;
	}

	public void setDkId(long dkId) {
		this.dkId = dkId;
	}

	public BigDecimal getKeyTag() {
		return this.keyTag;
	}

	public void setKeyTag(BigDecimal keyTag) {
		this.keyTag = keyTag;
	}

	public BigDecimal getProtocol() {
		return this.protocol;
	}

	public void setProtocol(BigDecimal protocol) {
		this.protocol = protocol;
	}

	public String getPubliekeSleutel() {
		return this.publiekeSleutel;
	}

	public void setPubliekeSleutel(String publiekeSleutel) {
		this.publiekeSleutel = publiekeSleutel;
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

	public List<DrpDelegationSigner> getDrpDelegationSigners() {
		return this.drpDelegationSigners;
	}

	public void setDrpDelegationSigners(List<DrpDelegationSigner> drpDelegationSigners) {
		this.drpDelegationSigners = drpDelegationSigners;
	}

	public DrpDelegationSigner addDrpDelegationSigner(DrpDelegationSigner drpDelegationSigner) {
		getDrpDelegationSigners().add(drpDelegationSigner);
		drpDelegationSigner.setDrpDnsKey(this);

		return drpDelegationSigner;
	}

	public DrpDelegationSigner removeDrpDelegationSigner(DrpDelegationSigner drpDelegationSigner) {
		getDrpDelegationSigners().remove(drpDelegationSigner);
		drpDelegationSigner.setDrpDnsKey(null);

		return drpDelegationSigner;
	}

	public DrpDomeinnaam getDrpDomeinnaam() {
		return this.drpDomeinnaam;
	}

	public void setDrpDomeinnaam(DrpDomeinnaam drpDomeinnaam) {
		this.drpDomeinnaam = drpDomeinnaam;
	}

	public DrpTypeAlgoritme getDrpTypeAlgoritme() {
		return this.drpTypeAlgoritme;
	}

	public void setDrpTypeAlgoritme(DrpTypeAlgoritme drpTypeAlgoritme) {
		this.drpTypeAlgoritme = drpTypeAlgoritme;
	}

	public DrpTypeVlag getDrpTypeVlag() {
		return this.drpTypeVlag;
	}

	public void setDrpTypeVlag(DrpTypeVlag drpTypeVlag) {
		this.drpTypeVlag = drpTypeVlag;
	}

}