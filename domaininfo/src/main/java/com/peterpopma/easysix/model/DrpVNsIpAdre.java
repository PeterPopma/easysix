package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_V_NS_IP_ADRES database table.
 * 
 */
@Entity
@Table(name="DRP_V_NS_IP_ADRES")
@NamedQuery(name="DrpVNsIpAdre.findAll", query="SELECT d FROM DrpVNsIpAdre d")
public class DrpVNsIpAdre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="IP_ADRES", nullable=false, length=39)
	private String ipAdres;

	@Column(length=255)
	private String nameservernaam;

	public DrpVNsIpAdre() {
	}

	public String getIpAdres() {
		return this.ipAdres;
	}

	public void setIpAdres(String ipAdres) {
		this.ipAdres = ipAdres;
	}

	public String getNameservernaam() {
		return this.nameservernaam;
	}

	public void setNameservernaam(String nameservernaam) {
		this.nameservernaam = nameservernaam;
	}

}