package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_FCFS database table.
 * 
 */
@Entity
@Table(name="DRP_FCFS")
@NamedQuery(name="DrpFcf.findAll", query="SELECT d FROM DrpFcf d")
public class DrpFcf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FCS_ID", unique=true, nullable=false, precision=12)
	private long fcsId;

	@Column(nullable=false)
	private Object datumtijd;

	@Column(nullable=false, length=255)
	private String naam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpGebruiker
	@ManyToOne
	@JoinColumn(name="GBR_ID", nullable=false)
	private DrpGebruiker drpGebruiker;

	//bi-directional many-to-one association to DrpTransactie
	@ManyToOne
	@JoinColumn(name="TICKETNUMMER")
	private DrpTransactie drpTransactie;

	public DrpFcf() {
	}

	public long getFcsId() {
		return this.fcsId;
	}

	public void setFcsId(long fcsId) {
		this.fcsId = fcsId;
	}

	public Object getDatumtijd() {
		return this.datumtijd;
	}

	public void setDatumtijd(Object datumtijd) {
		this.datumtijd = datumtijd;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DrpGebruiker getDrpGebruiker() {
		return this.drpGebruiker;
	}

	public void setDrpGebruiker(DrpGebruiker drpGebruiker) {
		this.drpGebruiker = drpGebruiker;
	}

	public DrpTransactie getDrpTransactie() {
		return this.drpTransactie;
	}

	public void setDrpTransactie(DrpTransactie drpTransactie) {
		this.drpTransactie = drpTransactie;
	}

}