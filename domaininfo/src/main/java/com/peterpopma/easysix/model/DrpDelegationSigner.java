package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_DELEGATION_SIGNER database table.
 * 
 */
@Entity
@Table(name="DRP_DELEGATION_SIGNER")
@NamedQuery(name="DrpDelegationSigner.findAll", query="SELECT d FROM DrpDelegationSigner d")
public class DrpDelegationSigner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DS_ID", unique=true, nullable=false, precision=12)
	private long dsId;

	@Column(name="DIGEST_WAARDE", nullable=false, length=2000)
	private String digestWaarde;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="USER_ID", length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpDnsKey
	@ManyToOne
	@JoinColumn(name="DK_ID", nullable=false)
	private DrpDnsKey drpDnsKey;

	//bi-directional many-to-one association to DrpTypeDigest
	@ManyToOne
	@JoinColumn(name="TD_CODE", nullable=false)
	private DrpTypeDigest drpTypeDigest;

	public DrpDelegationSigner() {
	}

	public long getDsId() {
		return this.dsId;
	}

	public void setDsId(long dsId) {
		this.dsId = dsId;
	}

	public String getDigestWaarde() {
		return this.digestWaarde;
	}

	public void setDigestWaarde(String digestWaarde) {
		this.digestWaarde = digestWaarde;
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

	public DrpDnsKey getDrpDnsKey() {
		return this.drpDnsKey;
	}

	public void setDrpDnsKey(DrpDnsKey drpDnsKey) {
		this.drpDnsKey = drpDnsKey;
	}

	public DrpTypeDigest getDrpTypeDigest() {
		return this.drpTypeDigest;
	}

	public void setDrpTypeDigest(DrpTypeDigest drpTypeDigest) {
		this.drpTypeDigest = drpTypeDigest;
	}

}