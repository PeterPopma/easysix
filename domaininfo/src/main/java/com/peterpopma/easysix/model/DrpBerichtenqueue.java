package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_BERICHTENQUEUE database table.
 * 
 */
@Entity
@Table(name="DRP_BERICHTENQUEUE")
@NamedQuery(name="DrpBerichtenqueue.findAll", query="SELECT d FROM DrpBerichtenqueue d")
public class DrpBerichtenqueue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BQE_ID", unique=true, nullable=false, precision=12)
	private long bqeId;

	@Lob
	private String bericht;

	private Object datum;

	@Column(length=255)
	private String onderwerp;

	//bi-directional many-to-one association to DrpDeelnemer
	@ManyToOne
	@JoinColumn(name="DNR_ID", nullable=false)
	private DrpDeelnemer drpDeelnemer;

	public DrpBerichtenqueue() {
	}

	public long getBqeId() {
		return this.bqeId;
	}

	public void setBqeId(long bqeId) {
		this.bqeId = bqeId;
	}

	public String getBericht() {
		return this.bericht;
	}

	public void setBericht(String bericht) {
		this.bericht = bericht;
	}

	public Object getDatum() {
		return this.datum;
	}

	public void setDatum(Object datum) {
		this.datum = datum;
	}

	public String getOnderwerp() {
		return this.onderwerp;
	}

	public void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}

	public DrpDeelnemer getDrpDeelnemer() {
		return this.drpDeelnemer;
	}

	public void setDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		this.drpDeelnemer = drpDeelnemer;
	}

}