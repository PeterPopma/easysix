package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_TMDB_CRL_LIJST database table.
 * 
 */
@Entity
@Table(name="DRP_TMDB_CRL_LIJST")
@NamedQuery(name="DrpTmdbCrlLijst.findAll", query="SELECT d FROM DrpTmdbCrlLijst d")
public class DrpTmdbCrlLijst implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LAST_IMPORT_DATETIME", unique=true, nullable=false)
	private String lastImportDatetime;

	@Lob
	@Column(nullable=false)
	private String crl;

	public DrpTmdbCrlLijst() {
	}

	public String getLastImportDatetime() {
		return this.lastImportDatetime;
	}

	public void setLastImportDatetime(String lastImportDatetime) {
		this.lastImportDatetime = lastImportDatetime;
	}

	public String getCrl() {
		return this.crl;
	}

	public void setCrl(String crl) {
		this.crl = crl;
	}

}