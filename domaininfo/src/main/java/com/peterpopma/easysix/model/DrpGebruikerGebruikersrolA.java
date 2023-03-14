package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_GEBRUIKER_GEBRUIKERSROL_A database table.
 * 
 */
@Entity
@Table(name="DRP_GEBRUIKER_GEBRUIKERSROL_A")
@NamedQuery(name="DrpGebruikerGebruikersrolA.findAll", query="SELECT d FROM DrpGebruikerGebruikersrolA d")
public class DrpGebruikerGebruikersrolA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(name="GBR_ID", precision=12)
	private BigDecimal gbrId;

	@Column(name="GGL_ID", precision=12)
	private BigDecimal gglId;

	@Column(name="GRL_ID", precision=12)
	private BigDecimal grlId;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(name="USER_ID", length=50)
	private String userId;

	@Column(name="VERWIJDEREN_JN", length=1)
	private String verwijderenJn;

	public DrpGebruikerGebruikersrolA() {
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

	public BigDecimal getGbrId() {
		return this.gbrId;
	}

	public void setGbrId(BigDecimal gbrId) {
		this.gbrId = gbrId;
	}

	public BigDecimal getGglId() {
		return this.gglId;
	}

	public void setGglId(BigDecimal gglId) {
		this.gglId = gglId;
	}

	public BigDecimal getGrlId() {
		return this.grlId;
	}

	public void setGrlId(BigDecimal grlId) {
		this.grlId = grlId;
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