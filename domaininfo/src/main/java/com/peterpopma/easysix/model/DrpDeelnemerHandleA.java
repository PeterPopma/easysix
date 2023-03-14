package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_DEELNEMER_HANDLE_A database table.
 * 
 */
@Entity
@Table(name="DRP_DEELNEMER_HANDLE_A")
@NamedQuery(name="DrpDeelnemerHandleA.findAll", query="SELECT d FROM DrpDeelnemerHandleA d")
public class DrpDeelnemerHandleA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(length=3)
	private String afkorting;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	@Column(precision=6)
	private BigDecimal volgnummer;

	public DrpDeelnemerHandleA() {
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

	public String getAfkorting() {
		return this.afkorting;
	}

	public void setAfkorting(String afkorting) {
		this.afkorting = afkorting;
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

	public String getVerwijderenJn() {
		return this.verwijderenJn;
	}

	public void setVerwijderenJn(String verwijderenJn) {
		this.verwijderenJn = verwijderenJn;
	}

	public BigDecimal getVolgnummer() {
		return this.volgnummer;
	}

	public void setVolgnummer(BigDecimal volgnummer) {
		this.volgnummer = volgnummer;
	}

}