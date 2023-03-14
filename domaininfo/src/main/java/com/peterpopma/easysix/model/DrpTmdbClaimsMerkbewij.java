package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_TMDB_CLAIMS_MERKBEWIJS database table.
 * 
 */
@Entity
@Table(name="DRP_TMDB_CLAIMS_MERKBEWIJS")
@NamedQuery(name="DrpTmdbClaimsMerkbewij.findAll", query="SELECT d FROM DrpTmdbClaimsMerkbewij d")
public class DrpTmdbClaimsMerkbewij implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TCM_ID", unique=true, nullable=false, precision=12)
	private long tcmId;

	@Column(name="CREATION_DATETIME", nullable=false)
	private Object creationDatetime;

	@Lob
	@Column(nullable=false)
	private String merkbewijs;

	@Column(name="MERKBEWIJS_ID", length=256)
	private String merkbewijsId;

	@Column(name="NOT_AFTER_DATETIME")
	private Object notAfterDatetime;

	@Column(name="NOT_BEFORE_DATETIME")
	private Object notBeforeDatetime;

	//bi-directional one-to-one association to DrpTmdbLaunchphaseClaim
	@OneToOne
	@JoinColumn(name="TCM_ID", nullable=false, insertable=false, updatable=false)
	private DrpTmdbLaunchphaseClaim drpTmdbLaunchphaseClaim;

	public DrpTmdbClaimsMerkbewij() {
	}

	public long getTcmId() {
		return this.tcmId;
	}

	public void setTcmId(long tcmId) {
		this.tcmId = tcmId;
	}

	public Object getCreationDatetime() {
		return this.creationDatetime;
	}

	public void setCreationDatetime(Object creationDatetime) {
		this.creationDatetime = creationDatetime;
	}

	public String getMerkbewijs() {
		return this.merkbewijs;
	}

	public void setMerkbewijs(String merkbewijs) {
		this.merkbewijs = merkbewijs;
	}

	public String getMerkbewijsId() {
		return this.merkbewijsId;
	}

	public void setMerkbewijsId(String merkbewijsId) {
		this.merkbewijsId = merkbewijsId;
	}

	public Object getNotAfterDatetime() {
		return this.notAfterDatetime;
	}

	public void setNotAfterDatetime(Object notAfterDatetime) {
		this.notAfterDatetime = notAfterDatetime;
	}

	public Object getNotBeforeDatetime() {
		return this.notBeforeDatetime;
	}

	public void setNotBeforeDatetime(Object notBeforeDatetime) {
		this.notBeforeDatetime = notBeforeDatetime;
	}

	public DrpTmdbLaunchphaseClaim getDrpTmdbLaunchphaseClaim() {
		return this.drpTmdbLaunchphaseClaim;
	}

	public void setDrpTmdbLaunchphaseClaim(DrpTmdbLaunchphaseClaim drpTmdbLaunchphaseClaim) {
		this.drpTmdbLaunchphaseClaim = drpTmdbLaunchphaseClaim;
	}

}