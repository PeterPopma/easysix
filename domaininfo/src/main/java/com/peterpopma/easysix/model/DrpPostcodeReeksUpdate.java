package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_POSTCODE_REEKS_UPDATE database table.
 * 
 */
@Entity
@Table(name="DRP_POSTCODE_REEKS_UPDATE")
@NamedQuery(name="DrpPostcodeReeksUpdate.findAll", query="SELECT d FROM DrpPostcodeReeksUpdate d")
public class DrpPostcodeReeksUpdate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRE_ID", unique=true, nullable=false, precision=12)
	private long preId;

	@Column(name="CIJFERDEEL_POSTCODE_NW", length=4)
	private String cijferdeelPostcodeNw;

	@Column(name="CIJFERDEEL_POSTCODE_OUD", length=4)
	private String cijferdeelPostcodeOud;

	@Column(name="CODEBREEKPUNT_TOT_NW", length=5)
	private String codebreekpuntTotNw;

	@Column(name="CODEBREEKPUNT_TOT_OUD", length=5)
	private String codebreekpuntTotOud;

	@Column(name="CODEBREEKPUNT_VAN_NW", length=5)
	private String codebreekpuntVanNw;

	@Column(name="CODEBREEKPUNT_VAN_OUD", length=5)
	private String codebreekpuntVanOud;

	@Column(name="LETTERDEEL_POSTCODE_NW", length=2)
	private String letterdeelPostcodeNw;

	@Column(name="LETTERDEEL_POSTCODE_OUD", length=2)
	private String letterdeelPostcodeOud;

	@Column(name="MUTATIE_INDICATOREN", length=16)
	private String mutatieIndicatoren;

	@Column(length=1)
	private String mutatiesoort;

	@Column(name="REEKSINDICATIE_NW", length=1)
	private String reeksindicatieNw;

	@Column(name="REEKSINDICATIE_OUD", length=1)
	private String reeksindicatieOud;

	@Column(name="STRAATNAAM_NEN_NW", length=50)
	private String straatnaamNenNw;

	@Column(name="STRAATNAAM_NEN_OUD", length=50)
	private String straatnaamNenOud;

	@Column(name="UPDATE_VERWERKT", length=1)
	private String updateVerwerkt;

	@Column(name="WOONPLAATSNAAM_NEN_NW", length=50)
	private String woonplaatsnaamNenNw;

	@Column(name="WOONPLAATSNAAM_NEN_OUD", length=50)
	private String woonplaatsnaamNenOud;

	public DrpPostcodeReeksUpdate() {
	}

	public long getPreId() {
		return this.preId;
	}

	public void setPreId(long preId) {
		this.preId = preId;
	}

	public String getCijferdeelPostcodeNw() {
		return this.cijferdeelPostcodeNw;
	}

	public void setCijferdeelPostcodeNw(String cijferdeelPostcodeNw) {
		this.cijferdeelPostcodeNw = cijferdeelPostcodeNw;
	}

	public String getCijferdeelPostcodeOud() {
		return this.cijferdeelPostcodeOud;
	}

	public void setCijferdeelPostcodeOud(String cijferdeelPostcodeOud) {
		this.cijferdeelPostcodeOud = cijferdeelPostcodeOud;
	}

	public String getCodebreekpuntTotNw() {
		return this.codebreekpuntTotNw;
	}

	public void setCodebreekpuntTotNw(String codebreekpuntTotNw) {
		this.codebreekpuntTotNw = codebreekpuntTotNw;
	}

	public String getCodebreekpuntTotOud() {
		return this.codebreekpuntTotOud;
	}

	public void setCodebreekpuntTotOud(String codebreekpuntTotOud) {
		this.codebreekpuntTotOud = codebreekpuntTotOud;
	}

	public String getCodebreekpuntVanNw() {
		return this.codebreekpuntVanNw;
	}

	public void setCodebreekpuntVanNw(String codebreekpuntVanNw) {
		this.codebreekpuntVanNw = codebreekpuntVanNw;
	}

	public String getCodebreekpuntVanOud() {
		return this.codebreekpuntVanOud;
	}

	public void setCodebreekpuntVanOud(String codebreekpuntVanOud) {
		this.codebreekpuntVanOud = codebreekpuntVanOud;
	}

	public String getLetterdeelPostcodeNw() {
		return this.letterdeelPostcodeNw;
	}

	public void setLetterdeelPostcodeNw(String letterdeelPostcodeNw) {
		this.letterdeelPostcodeNw = letterdeelPostcodeNw;
	}

	public String getLetterdeelPostcodeOud() {
		return this.letterdeelPostcodeOud;
	}

	public void setLetterdeelPostcodeOud(String letterdeelPostcodeOud) {
		this.letterdeelPostcodeOud = letterdeelPostcodeOud;
	}

	public String getMutatieIndicatoren() {
		return this.mutatieIndicatoren;
	}

	public void setMutatieIndicatoren(String mutatieIndicatoren) {
		this.mutatieIndicatoren = mutatieIndicatoren;
	}

	public String getMutatiesoort() {
		return this.mutatiesoort;
	}

	public void setMutatiesoort(String mutatiesoort) {
		this.mutatiesoort = mutatiesoort;
	}

	public String getReeksindicatieNw() {
		return this.reeksindicatieNw;
	}

	public void setReeksindicatieNw(String reeksindicatieNw) {
		this.reeksindicatieNw = reeksindicatieNw;
	}

	public String getReeksindicatieOud() {
		return this.reeksindicatieOud;
	}

	public void setReeksindicatieOud(String reeksindicatieOud) {
		this.reeksindicatieOud = reeksindicatieOud;
	}

	public String getStraatnaamNenNw() {
		return this.straatnaamNenNw;
	}

	public void setStraatnaamNenNw(String straatnaamNenNw) {
		this.straatnaamNenNw = straatnaamNenNw;
	}

	public String getStraatnaamNenOud() {
		return this.straatnaamNenOud;
	}

	public void setStraatnaamNenOud(String straatnaamNenOud) {
		this.straatnaamNenOud = straatnaamNenOud;
	}

	public String getUpdateVerwerkt() {
		return this.updateVerwerkt;
	}

	public void setUpdateVerwerkt(String updateVerwerkt) {
		this.updateVerwerkt = updateVerwerkt;
	}

	public String getWoonplaatsnaamNenNw() {
		return this.woonplaatsnaamNenNw;
	}

	public void setWoonplaatsnaamNenNw(String woonplaatsnaamNenNw) {
		this.woonplaatsnaamNenNw = woonplaatsnaamNenNw;
	}

	public String getWoonplaatsnaamNenOud() {
		return this.woonplaatsnaamNenOud;
	}

	public void setWoonplaatsnaamNenOud(String woonplaatsnaamNenOud) {
		this.woonplaatsnaamNenOud = woonplaatsnaamNenOud;
	}

}