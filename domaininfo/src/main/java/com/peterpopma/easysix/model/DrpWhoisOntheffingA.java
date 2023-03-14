package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_WHOIS_ONTHEFFING_A database table.
 * 
 */
@Entity
@Table(name="DRP_WHOIS_ONTHEFFING_A")
@NamedQuery(name="DrpWhoisOntheffingA.findAll", query="SELECT d FROM DrpWhoisOntheffingA d")
public class DrpWhoisOntheffingA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="DATUM_AANVRAAG")
	private Object datumAanvraag;

	@Column(name="DATUM_TOEKENNING")
	private Object datumToekenning;

	@Column(name="DNR_ID", precision=12)
	private BigDecimal dnrId;

	@Column(name="IPRANGE_EINDE", length=39)
	private String iprangeEinde;

	@Column(name="IPRANGE_START", length=39)
	private String iprangeStart;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(name="USER_ID", length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	@Column(name="WOG_ID", precision=12)
	private BigDecimal wogId;

	public DrpWhoisOntheffingA() {
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

	public Object getDatumAanvraag() {
		return this.datumAanvraag;
	}

	public void setDatumAanvraag(Object datumAanvraag) {
		this.datumAanvraag = datumAanvraag;
	}

	public Object getDatumToekenning() {
		return this.datumToekenning;
	}

	public void setDatumToekenning(Object datumToekenning) {
		this.datumToekenning = datumToekenning;
	}

	public BigDecimal getDnrId() {
		return this.dnrId;
	}

	public void setDnrId(BigDecimal dnrId) {
		this.dnrId = dnrId;
	}

	public String getIprangeEinde() {
		return this.iprangeEinde;
	}

	public void setIprangeEinde(String iprangeEinde) {
		this.iprangeEinde = iprangeEinde;
	}

	public String getIprangeStart() {
		return this.iprangeStart;
	}

	public void setIprangeStart(String iprangeStart) {
		this.iprangeStart = iprangeStart;
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

	public BigDecimal getWogId() {
		return this.wogId;
	}

	public void setWogId(BigDecimal wogId) {
		this.wogId = wogId;
	}

}