package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_NAMESERVER_IPADRES database table.
 * 
 */
@Entity
@Table(name="DRP_NAMESERVER_IPADRES")
@NamedQuery(name="DrpNameserverIpadre.findAll", query="SELECT d FROM DrpNameserverIpadre d")
public class DrpNameserverIpadre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NSS_ID", unique=true, nullable=false, precision=12)
	private long nssId;

	@Column(nullable=false, length=39)
	private String adres;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpNameserver
	@ManyToOne
	@JoinColumn(name="NSR_ID", nullable=false)
	private DrpNameserver drpNameserver;

	//bi-directional many-to-one association to DrpTypeNameserverIp
	@ManyToOne
	@JoinColumn(name="TNP_CODE", nullable=false)
	private DrpTypeNameserverIp drpTypeNameserverIp;

	public DrpNameserverIpadre() {
	}

	public long getNssId() {
		return this.nssId;
	}

	public void setNssId(long nssId) {
		this.nssId = nssId;
	}

	public String getAdres() {
		return this.adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
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

	public DrpNameserver getDrpNameserver() {
		return this.drpNameserver;
	}

	public void setDrpNameserver(DrpNameserver drpNameserver) {
		this.drpNameserver = drpNameserver;
	}

	public DrpTypeNameserverIp getDrpTypeNameserverIp() {
		return this.drpTypeNameserverIp;
	}

	public void setDrpTypeNameserverIp(DrpTypeNameserverIp drpTypeNameserverIp) {
		this.drpTypeNameserverIp = drpTypeNameserverIp;
	}

}