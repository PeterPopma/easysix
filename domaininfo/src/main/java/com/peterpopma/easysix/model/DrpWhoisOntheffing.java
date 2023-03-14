package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_WHOIS_ONTHEFFING database table.
 * 
 */
@Entity
@Table(name="DRP_WHOIS_ONTHEFFING")
@NamedQuery(name="DrpWhoisOntheffing.findAll", query="SELECT d FROM DrpWhoisOntheffing d")
public class DrpWhoisOntheffing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="WOG_ID", unique=true, nullable=false, precision=12)
	private long wogId;

	@Column(name="DATUM_AANVRAAG", nullable=false)
	private Object datumAanvraag;

	@Column(name="DATUM_TOEKENNING", nullable=false)
	private Object datumToekenning;

	@Column(name="IPRANGE_EINDE", length=39)
	private String iprangeEinde;

	@Column(name="IPRANGE_START", nullable=false, length=39)
	private String iprangeStart;

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

	public DrpWhoisOntheffing() {
	}

	public long getWogId() {
		return this.wogId;
	}

	public void setWogId(long wogId) {
		this.wogId = wogId;
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

}