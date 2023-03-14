package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_TYPE_NNDN_STATUS database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_NNDN_STATUS")
@NamedQuery(name="DrpTypeNndnStatus.findAll", query="SELECT d FROM DrpTypeNndnStatus d")
public class DrpTypeNndnStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NNDN_STATUS_CODE", unique=true, nullable=false, length=25)
	private String nndnStatusCode;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	public DrpTypeNndnStatus() {
	}

	public String getNndnStatusCode() {
		return this.nndnStatusCode;
	}

	public void setNndnStatusCode(String nndnStatusCode) {
		this.nndnStatusCode = nndnStatusCode;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}