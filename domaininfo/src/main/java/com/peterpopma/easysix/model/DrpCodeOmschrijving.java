package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_CODE_OMSCHRIJVING database table.
 * 
 */
@Entity
@Table(name="DRP_CODE_OMSCHRIJVING")
@NamedQuery(name="DrpCodeOmschrijving.findAll", query="SELECT d FROM DrpCodeOmschrijving d")
public class DrpCodeOmschrijving implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DrpCodeOmschrijvingPK id;

	@Column(nullable=false, length=512)
	private String omschrijving;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpTaal
	@ManyToOne
	@JoinColumn(name="TAL_CODE", nullable=false, insertable=false, updatable=false)
	private DrpTaal drpTaal;

	public DrpCodeOmschrijving() {
	}

	public DrpCodeOmschrijvingPK getId() {
		return this.id;
	}

	public void setId(DrpCodeOmschrijvingPK id) {
		this.id = id;
	}

	public String getOmschrijving() {
		return this.omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DrpTaal getDrpTaal() {
		return this.drpTaal;
	}

	public void setDrpTaal(DrpTaal drpTaal) {
		this.drpTaal = drpTaal;
	}

}