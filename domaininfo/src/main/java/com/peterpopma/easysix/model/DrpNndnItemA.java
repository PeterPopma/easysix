package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_NNDN_ITEM_A database table.
 * 
 */
@Entity
@Table(name="DRP_NNDN_ITEM_A")
@NamedQuery(name="DrpNndnItemA.findAll", query="SELECT d FROM DrpNndnItemA d")
public class DrpNndnItemA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	private Object aanmaakdatum;

	@Column(nullable=false, length=1)
	private String actie;

	@Column(length=255)
	private String naam;

	@Column(name="NNDN_ITEM_ID", precision=12, scale=2)
	private BigDecimal nndnItemId;

	@Column(name="NNDN_STATUS_CODE", length=25)
	private String nndnStatusCode;

	@Column(name="NNDN_TYPE_ID", precision=12, scale=2)
	private BigDecimal nndnTypeId;

	@Column(length=50)
	private String reserveerder;

	@Column(name="TRANSACTIE_ID", nullable=false, length=255)
	private String transactieId;

	@Column(name="TRANSACTIE_TIMESTAMP", nullable=false)
	private Object transactieTimestamp;

	@Column(name="USER_ID", length=50)
	private String userId;

	public DrpNndnItemA() {
	}

	public long getAudId() {
		return this.audId;
	}

	public void setAudId(long audId) {
		this.audId = audId;
	}

	public Object getAanmaakdatum() {
		return this.aanmaakdatum;
	}

	public void setAanmaakdatum(Object aanmaakdatum) {
		this.aanmaakdatum = aanmaakdatum;
	}

	public String getActie() {
		return this.actie;
	}

	public void setActie(String actie) {
		this.actie = actie;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public BigDecimal getNndnItemId() {
		return this.nndnItemId;
	}

	public void setNndnItemId(BigDecimal nndnItemId) {
		this.nndnItemId = nndnItemId;
	}

	public String getNndnStatusCode() {
		return this.nndnStatusCode;
	}

	public void setNndnStatusCode(String nndnStatusCode) {
		this.nndnStatusCode = nndnStatusCode;
	}

	public BigDecimal getNndnTypeId() {
		return this.nndnTypeId;
	}

	public void setNndnTypeId(BigDecimal nndnTypeId) {
		this.nndnTypeId = nndnTypeId;
	}

	public String getReserveerder() {
		return this.reserveerder;
	}

	public void setReserveerder(String reserveerder) {
		this.reserveerder = reserveerder;
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

}