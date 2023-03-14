package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_NNDN_ITEM_CSV database table.
 * 
 */
@Entity
@Table(name="DRP_NNDN_ITEM_CSV")
@NamedQuery(name="DrpNndnItemCsv.findAll", query="SELECT d FROM DrpNndnItemCsv d")
public class DrpNndnItemCsv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="INFO_1", length=255)
	private String info1;

	@Column(name="INFO_2", length=255)
	private String info2;

	@Column(name="INFO_3", length=255)
	private String info3;

	@Column(length=255)
	private String naam;

	@Column(name="NNDN_STATUS_CODE", length=25)
	private String nndnStatusCode;

	@Column(name="NNDN_TYPE_NAAM", length=255)
	private String nndnTypeNaam;

	@Column(length=50)
	private String reserveerder;

	public DrpNndnItemCsv() {
	}

	public String getInfo1() {
		return this.info1;
	}

	public void setInfo1(String info1) {
		this.info1 = info1;
	}

	public String getInfo2() {
		return this.info2;
	}

	public void setInfo2(String info2) {
		this.info2 = info2;
	}

	public String getInfo3() {
		return this.info3;
	}

	public void setInfo3(String info3) {
		this.info3 = info3;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
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

}