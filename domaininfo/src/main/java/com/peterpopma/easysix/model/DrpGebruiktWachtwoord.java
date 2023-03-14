package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_GEBRUIKT_WACHTWOORD database table.
 * 
 */
@Entity
@Table(name="DRP_GEBRUIKT_WACHTWOORD")
@NamedQuery(name="DrpGebruiktWachtwoord.findAll", query="SELECT d FROM DrpGebruiktWachtwoord d")
public class DrpGebruiktWachtwoord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GBW_ID", unique=true, nullable=false, precision=12)
	private long gbwId;

	@Column(nullable=false, length=128)
	private String wachtwoord;

	@Column(nullable=false)
	private Object wijzigingsdatum;

	//bi-directional many-to-one association to DrpGebruiker
	@ManyToOne
	@JoinColumn(name="GBR_ID", nullable=false)
	private DrpGebruiker drpGebruiker;

	public DrpGebruiktWachtwoord() {
	}

	public long getGbwId() {
		return this.gbwId;
	}

	public void setGbwId(long gbwId) {
		this.gbwId = gbwId;
	}

	public String getWachtwoord() {
		return this.wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public Object getWijzigingsdatum() {
		return this.wijzigingsdatum;
	}

	public void setWijzigingsdatum(Object wijzigingsdatum) {
		this.wijzigingsdatum = wijzigingsdatum;
	}

	public DrpGebruiker getDrpGebruiker() {
		return this.drpGebruiker;
	}

	public void setDrpGebruiker(DrpGebruiker drpGebruiker) {
		this.drpGebruiker = drpGebruiker;
	}

}