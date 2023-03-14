package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_UITGESLOTEN_IP_REEKS database table.
 * 
 */
@Entity
@Table(name="DRP_UITGESLOTEN_IP_REEKS")
@NamedQuery(name="DrpUitgeslotenIpReek.findAll", query="SELECT d FROM DrpUitgeslotenIpReek d")
public class DrpUitgeslotenIpReek implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DrpUitgeslotenIpReekPK id;

	@Column(nullable=false, length=255)
	private String omschrijving;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	public DrpUitgeslotenIpReek() {
	}

	public DrpUitgeslotenIpReekPK getId() {
		return this.id;
	}

	public void setId(DrpUitgeslotenIpReekPK id) {
		this.id = id;
	}

	public String getOmschrijving() {
		return this.omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public String getVerwijderenJn() {
		return this.verwijderenJn;
	}

	public void setVerwijderenJn(String verwijderenJn) {
		this.verwijderenJn = verwijderenJn;
	}

}