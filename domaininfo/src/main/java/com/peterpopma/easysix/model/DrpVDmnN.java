package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_V_DMN_NS database table.
 * 
 */
@Entity
@Table(name="DRP_V_DMN_NS")
@NamedQuery(name="DrpVDmnN.findAll", query="SELECT d FROM DrpVDmnN d")
public class DrpVDmnN implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=127)
	private String domeinnaam;

	@Column(nullable=false, length=255)
	private String nameservernaam;

	public DrpVDmnN() {
	}

	public String getDomeinnaam() {
		return this.domeinnaam;
	}

	public void setDomeinnaam(String domeinnaam) {
		this.domeinnaam = domeinnaam;
	}

	public String getNameservernaam() {
		return this.nameservernaam;
	}

	public void setNameservernaam(String nameservernaam) {
		this.nameservernaam = nameservernaam;
	}

}