package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_TRANSACTIE_A database table.
 * 
 */
@Entity
@Table(name="DRP_TRANSACTIE_A")
@NamedQuery(name="DrpTransactieA.findAll", query="SELECT d FROM DrpTransactieA d")
public class DrpTransactieA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="CPN_HANDLE", length=20)
	private String cpnHandle;

	@Column(name="DEELNEMER_CANCEL_JN", length=1)
	private String deelnemerCancelJn;

	@Column(name="DEELNEMER_TICKETNUMMER", length=64)
	private String deelnemerTicketnummer;

	@Column(name="DNR_ID", precision=12)
	private BigDecimal dnrId;

	private Object einddatum;

	@Column(name="GBR_ID", precision=12)
	private BigDecimal gbrId;

	@Column(name="LATENDE_DEELNEMER_REJECT_JN", length=1)
	private String latendeDeelnemerRejectJn;

	@Column(name="REGISTRY_CANCEL_JN", length=1)
	private String registryCancelJn;

	private Object startdatum;

	private Object statusdatum;

	@Column(length=255)
	private String statusreden;

	@Column(name="TAS_CODE", length=32)
	private String tasCode;

	@Column(name="TBN_CODE", length=12)
	private String tbnCode;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(name="TTE_CODE", length=50)
	private String tteCode;

	@Column(name="USER_ID", length=50)
	private String userId;

	private Object vervaldatum;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	public DrpTransactieA() {
	}

	public long getAudId() {
		return this.audId;
	}

	public void setAudId(long audId) {
		this.audId = audId;
	}

	public String getActie() {
		return this.actie;
	}

	public void setActie(String actie) {
		this.actie = actie;
	}

	public String getCpnHandle() {
		return this.cpnHandle;
	}

	public void setCpnHandle(String cpnHandle) {
		this.cpnHandle = cpnHandle;
	}

	public String getDeelnemerCancelJn() {
		return this.deelnemerCancelJn;
	}

	public void setDeelnemerCancelJn(String deelnemerCancelJn) {
		this.deelnemerCancelJn = deelnemerCancelJn;
	}

	public String getDeelnemerTicketnummer() {
		return this.deelnemerTicketnummer;
	}

	public void setDeelnemerTicketnummer(String deelnemerTicketnummer) {
		this.deelnemerTicketnummer = deelnemerTicketnummer;
	}

	public BigDecimal getDnrId() {
		return this.dnrId;
	}

	public void setDnrId(BigDecimal dnrId) {
		this.dnrId = dnrId;
	}

	public Object getEinddatum() {
		return this.einddatum;
	}

	public void setEinddatum(Object einddatum) {
		this.einddatum = einddatum;
	}

	public BigDecimal getGbrId() {
		return this.gbrId;
	}

	public void setGbrId(BigDecimal gbrId) {
		this.gbrId = gbrId;
	}

	public String getLatendeDeelnemerRejectJn() {
		return this.latendeDeelnemerRejectJn;
	}

	public void setLatendeDeelnemerRejectJn(String latendeDeelnemerRejectJn) {
		this.latendeDeelnemerRejectJn = latendeDeelnemerRejectJn;
	}

	public String getRegistryCancelJn() {
		return this.registryCancelJn;
	}

	public void setRegistryCancelJn(String registryCancelJn) {
		this.registryCancelJn = registryCancelJn;
	}

	public Object getStartdatum() {
		return this.startdatum;
	}

	public void setStartdatum(Object startdatum) {
		this.startdatum = startdatum;
	}

	public Object getStatusdatum() {
		return this.statusdatum;
	}

	public void setStatusdatum(Object statusdatum) {
		this.statusdatum = statusdatum;
	}

	public String getStatusreden() {
		return this.statusreden;
	}

	public void setStatusreden(String statusreden) {
		this.statusreden = statusreden;
	}

	public String getTasCode() {
		return this.tasCode;
	}

	public void setTasCode(String tasCode) {
		this.tasCode = tasCode;
	}

	public String getTbnCode() {
		return this.tbnCode;
	}

	public void setTbnCode(String tbnCode) {
		this.tbnCode = tbnCode;
	}

	public BigDecimal getTicketnummer() {
		return this.ticketnummer;
	}

	public void setTicketnummer(BigDecimal ticketnummer) {
		this.ticketnummer = ticketnummer;
	}

	public String getTransactieId() {
		return this.transactieId;
	}

	public void setTransactieId(String transactieId) {
		this.transactieId = transactieId;
	}

	public Object getTransactieTimestamp() {
		return this.transactieTimestamp;
	}

	public void setTransactieTimestamp(Object transactieTimestamp) {
		this.transactieTimestamp = transactieTimestamp;
	}

	public String getTteCode() {
		return this.tteCode;
	}

	public void setTteCode(String tteCode) {
		this.tteCode = tteCode;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Object getVervaldatum() {
		return this.vervaldatum;
	}

	public void setVervaldatum(Object vervaldatum) {
		this.vervaldatum = vervaldatum;
	}

	public String getVerwijderenJn() {
		return this.verwijderenJn;
	}

	public void setVerwijderenJn(String verwijderenJn) {
		this.verwijderenJn = verwijderenJn;
	}

}