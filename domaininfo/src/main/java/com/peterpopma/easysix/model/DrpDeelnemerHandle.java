package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_DEELNEMER_HANDLE database table.
 * 
 */
@Entity
@Table(name="DRP_DEELNEMER_HANDLE")
@NamedQuery(name="DrpDeelnemerHandle.findAll", query="SELECT d FROM DrpDeelnemerHandle d")
public class DrpDeelnemerHandle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=3)
	private String afkorting;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	@Column(nullable=false, precision=6)
	private BigDecimal volgnummer;

	public DrpDeelnemerHandle() {
	}

	public String getAfkorting() {
		return this.afkorting;
	}

	public void setAfkorting(String afkorting) {
		this.afkorting = afkorting;
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