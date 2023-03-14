package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_NNDN_ITEM_IMP database table.
 * 
 */
@Entity
@Table(name="DRP_NNDN_ITEM_IMP")
@NamedQuery(name="DrpNndnItemImp.findAll", query="SELECT d FROM DrpNndnItemImp d")
public class DrpNndnItemImp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=255)
	private String naam;

	private Object aanmaakdatum;

	@Column(length=50)
	private String actie;

	@Column(name="DATUM_ACTIE")
	private Object datumActie;

	@Column(name="DATUM_IMPORT")
	private Object datumImport;

	@Column(length=255)
	private String fouten;

	@Column(name="NNDN_STATUS_CODE", nullable=false, length=25)
	private String nndnStatusCode;

	@Column(name="NNDN_TYPE_NAAM", length=255)
	private String nndnTypeNaam;

	@Column(length=50)
	private String reserveerder;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(length=1)
	private String valide;

	public DrpNndnItemImp() {
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Object getAanmaakdatum() {
		return this.aanmaakdatum;
	}

	public void setAanmaakdatum(Object aanmaakdatum) {
		this.aanmaakdatum = aanmaakdatum;
	}

	public String getActie() {
		return this.actie;
	}

	public void setActie(String actie) {
		this.actie = actie;
	}

	public Object getDatumActie() {
		return this.datumActie;
	}

	public void setDatumActie(Object datumActie) {
		this.datumActie = datumActie;
	}

	public Object getDatumImport() {
		return this.datumImport;
	}

	public void setDatumImport(Object datumImport) {
		this.datumImport = datumImport;
	}

	public String getFouten() {
		return this.fouten;
	}

	public void setFouten(String fouten) {
		this.fouten = fouten;
	}

	public String getNndnStatusCode() {
		return this.nndnStatusCode;
	}

	public void setNndnStatusCode(String nndnStatusCode) {
		this.nndnStatusCode = nndnStatusCode;
	}

	public String getNndnTypeNaam() {
		return this.nndnTypeNaam;
	}

	public void setNndnTypeNaam(String nndnTypeNaam) {
		this.nndnTypeNaam = nndnTypeNaam;
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

	public String getValide() {
		return this.valide;
	}

	public void setValide(String valide) {
		this.valide = valide;
	}

}