package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_CORRESPONDENTIE_DATA database table.
 * 
 */
@Entity
@Table(name="DRP_CORRESPONDENTIE_DATA")
@NamedQuery(name="DrpCorrespondentieData.findAll", query="SELECT d FROM DrpCorrespondentieData d")
public class DrpCorrespondentieData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRE_ID", unique=true, nullable=false, precision=12)
	private long creId;

	@Lob
	private byte[] binarydata;

	@Lob
	private String stringdata;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional one-to-one association to DrpCorrespondentie
	@OneToOne
	@JoinColumn(name="CRE_ID", nullable=false, insertable=false, updatable=false)
	private DrpCorrespondentie drpCorrespondentie;

	public DrpCorrespondentieData() {
	}

	public long getCreId() {
		return this.creId;
	}

	public void setCreId(long creId) {
		this.creId = creId;
	}

	public byte[] getBinarydata() {
		return this.binarydata;
	}

	public void setBinarydata(byte[] binarydata) {
		this.binarydata = binarydata;
	}

	public String getStringdata() {
		return this.stringdata;
	}

	public void setStringdata(String stringdata) {
		this.stringdata = stringdata;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DrpCorrespondentie getDrpCorrespondentie() {
		return this.drpCorrespondentie;
	}

	public void setDrpCorrespondentie(DrpCorrespondentie drpCorrespondentie) {
		this.drpCorrespondentie = drpCorrespondentie;
	}

}