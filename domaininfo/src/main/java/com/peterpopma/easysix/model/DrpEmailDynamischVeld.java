package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_EMAIL_DYNAMISCH_VELD database table.
 * 
 */
@Entity
@Table(name="DRP_EMAIL_DYNAMISCH_VELD")
@NamedQuery(name="DrpEmailDynamischVeld.findAll", query="SELECT d FROM DrpEmailDynamischVeld d")
public class DrpEmailDynamischVeld implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EDD_ID", unique=true, nullable=false, precision=12)
	private long eddId;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpDynamischVeld
	@ManyToOne
	@JoinColumn(name="DVD_ID", nullable=false)
	private DrpDynamischVeld drpDynamischVeld;

	//bi-directional many-to-one association to DrpEmailLayout
	@ManyToOne
	@JoinColumn(name="ELT_ID", nullable=false)
	private DrpEmailLayout drpEmailLayout;

	public DrpEmailDynamischVeld() {
	}

	public long getEddId() {
		return this.eddId;
	}

	public void setEddId(long eddId) {
		this.eddId = eddId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DrpDynamischVeld getDrpDynamischVeld() {
		return this.drpDynamischVeld;
	}

	public void setDrpDynamischVeld(DrpDynamischVeld drpDynamischVeld) {
		this.drpDynamischVeld = drpDynamischVeld;
	}

	public DrpEmailLayout getDrpEmailLayout() {
		return this.drpEmailLayout;
	}

	public void setDrpEmailLayout(DrpEmailLayout drpEmailLayout) {
		this.drpEmailLayout = drpEmailLayout;
	}

}