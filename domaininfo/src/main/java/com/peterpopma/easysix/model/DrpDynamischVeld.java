package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_DYNAMISCH_VELD database table.
 * 
 */
@Entity
@Table(name="DRP_DYNAMISCH_VELD")
@NamedQuery(name="DrpDynamischVeld.findAll", query="SELECT d FROM DrpDynamischVeld d")
public class DrpDynamischVeld implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DVD_ID", unique=true, nullable=false, precision=12)
	private long dvdId;

	@Column(nullable=false, length=50)
	private String naam;

	@Column(name="PARENT_XQUERY", length=255)
	private String parentXquery;

	@Column(length=2000)
	private String query;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(length=255)
	private String xquery;

	//bi-directional many-to-one association to DrpEmailDynamischVeld
	@OneToMany(mappedBy="drpDynamischVeld")
	private List<DrpEmailDynamischVeld> drpEmailDynamischVelds;

	public DrpDynamischVeld() {
	}

	public long getDvdId() {
		return this.dvdId;
	}

	public void setDvdId(long dvdId) {
		this.dvdId = dvdId;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getParentXquery() {
		return this.parentXquery;
	}

	public void setParentXquery(String parentXquery) {
		this.parentXquery = parentXquery;
	}

	public String getQuery() {
		return this.query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getXquery() {
		return this.xquery;
	}

	public void setXquery(String xquery) {
		this.xquery = xquery;
	}

	public List<DrpEmailDynamischVeld> getDrpEmailDynamischVelds() {
		return this.drpEmailDynamischVelds;
	}

	public void setDrpEmailDynamischVelds(List<DrpEmailDynamischVeld> drpEmailDynamischVelds) {
		this.drpEmailDynamischVelds = drpEmailDynamischVelds;
	}

	public DrpEmailDynamischVeld addDrpEmailDynamischVeld(DrpEmailDynamischVeld drpEmailDynamischVeld) {
		getDrpEmailDynamischVelds().add(drpEmailDynamischVeld);
		drpEmailDynamischVeld.setDrpDynamischVeld(this);

		return drpEmailDynamischVeld;
	}

	public DrpEmailDynamischVeld removeDrpEmailDynamischVeld(DrpEmailDynamischVeld drpEmailDynamischVeld) {
		getDrpEmailDynamischVelds().remove(drpEmailDynamischVeld);
		drpEmailDynamischVeld.setDrpDynamischVeld(null);

		return drpEmailDynamischVeld;
	}

}