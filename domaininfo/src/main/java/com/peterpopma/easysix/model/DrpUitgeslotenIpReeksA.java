package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_UITGESLOTEN_IP_REEKS_A database table.
 * 
 */
@Entity
@Table(name="DRP_UITGESLOTEN_IP_REEKS_A")
@NamedQuery(name="DrpUitgeslotenIpReeksA.findAll", query="SELECT d FROM DrpUitgeslotenIpReeksA d")
public class DrpUitgeslotenIpReeksA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(length=255)
	private String omschrijving;

	@Column(name="REEKS_TM", length=39)
	private String reeksTm;

	@Column(name="REEKS_VANAF", length=39)
	private String reeksVanaf;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	public DrpUitgeslotenIpReeksA() {
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

	public String getOmschrijving() {
		return this.omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public String getReeksTm() {
		return this.reeksTm;
	}

	public void setReeksTm(String reeksTm) {
		this.reeksTm = reeksTm;
	}

	public String getReeksVanaf() {
		return this.reeksVanaf;
	}

	public void setReeksVanaf(String reeksVanaf) {
		this.reeksVanaf = reeksVanaf;
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

}