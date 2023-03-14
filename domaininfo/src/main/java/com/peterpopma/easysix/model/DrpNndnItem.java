package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_NNDN_ITEM database table.
 * 
 */
@Entity
@Table(name="DRP_NNDN_ITEM")
@NamedQuery(name="DrpNndnItem.findAll", query="SELECT d FROM DrpNndnItem d")
public class DrpNndnItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NNDN_ITEM_ID", unique=true, nullable=false, precision=12, scale=2)
	private long nndnItemId;

	private Object aanmaakdatum;

	@Column(nullable=false, length=255)
	private String naam;

	@Column(name="NNDN_STATUS_CODE", nullable=false, length=25)
	private String nndnStatusCode;

	@Column(length=50)
	private String reserveerder;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpTypeNndn
	@ManyToOne
	@JoinColumn(name="NNDN_TYPE_ID")
	private DrpTypeNndn drpTypeNndn;

	public DrpNndnItem() {
	}

	public long getNndnItemId() {
		return this.nndnItemId;
	}

	public void setNndnItemId(long nndnItemId) {
		this.nndnItemId = nndnItemId;
	}

	public Object getAanmaakdatum() {
		return this.aanmaakdatum;
	}

	public void setAanmaakdatum(Object aanmaakdatum) {
		this.aanmaakdatum = aanmaakdatum;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getNndnStatusCode() {
		return this.nndnStatusCode;
	}

	public void setNndnStatusCode(String nndnStatusCode) {
		this.nndnStatusCode = nndnStatusCode;
	}

	public String getReserveerder() {
		return this.reserveerder;
	}

	public void setReserveerder(String reserveerder) {
		this.reserveerder = reserveerder;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DrpTypeNndn getDrpTypeNndn() {
		return this.drpTypeNndn;
	}

	public void setDrpTypeNndn(DrpTypeNndn drpTypeNndn) {
		this.drpTypeNndn = drpTypeNndn;
	}

}