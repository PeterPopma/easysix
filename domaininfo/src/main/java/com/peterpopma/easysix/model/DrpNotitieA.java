package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_NOTITIE_A database table.
 * 
 */
@Entity
@Table(name="DRP_NOTITIE_A")
@NamedQuery(name="DrpNotitieA.findAll", query="SELECT d FROM DrpNotitieA d")
public class DrpNotitieA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="BPG_ID", precision=12)
	private BigDecimal bpgId;

	@Column(length=255)
	private String kenmerk;

	@Lob
	private String notitie;

	private Object notitiedatum;

	@Column(name="NTE_ID", precision=12)
	private BigDecimal nteId;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="TNE_CODE", length=10)
	private String tneCode;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(name="USER_ID", length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	public DrpNotitieA() {
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

	public BigDecimal getBpgId() {
		return this.bpgId;
	}

	public void setBpgId(BigDecimal bpgId) {
		this.bpgId = bpgId;
	}

	public String getKenmerk() {
		return this.kenmerk;
	}

	public void setKenmerk(String kenmerk) {
		this.kenmerk = kenmerk;
	}

	public String getNotitie() {
		return this.notitie;
	}

	public void setNotitie(String notitie) {
		this.notitie = notitie;
	}

	public Object getNotitiedatum() {
		return this.notitiedatum;
	}

	public void setNotitiedatum(Object notitiedatum) {
		this.notitiedatum = notitiedatum;
	}

	public BigDecimal getNteId() {
		return this.nteId;
	}

	public void setNteId(BigDecimal nteId) {
		this.nteId = nteId;
	}

	public BigDecimal getTicketnummer() {
		return this.ticketnummer;
	}

	public void setTicketnummer(BigDecimal ticketnummer) {
		this.ticketnummer = ticketnummer;
	}

	public String getTneCode() {
		return this.tneCode;
	}

	public void setTneCode(String tneCode) {
		this.tneCode = tneCode;
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

}