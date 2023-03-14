package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DRP_AUDIT_PROCESSOR_QUE database table.
 * 
 */
@Embeddable
public class DrpAuditProcessorQuePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="AUDIT_TABEL_ID", insertable=false, updatable=false, unique=true, nullable=false)
	private long auditTabelId;

	@Column(name="AUD_ID", unique=true, nullable=false)
	private long audId;

	public DrpAuditProcessorQuePK() {
	}
	public long getAuditTabelId() {
		return this.auditTabelId;
	}
	public void setAuditTabelId(long auditTabelId) {
		this.auditTabelId = auditTabelId;
	}
	public long getAudId() {
		return this.audId;
	}
	public void setAudId(long audId) {
		this.audId = audId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DrpAuditProcessorQuePK)) {
			return false;
		}
		DrpAuditProcessorQuePK castOther = (DrpAuditProcessorQuePK)other;
		return 
			(this.auditTabelId == castOther.auditTabelId)
			&& (this.audId == castOther.audId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.auditTabelId ^ (this.auditTabelId >>> 32)));
		hash = hash * prime + ((int) (this.audId ^ (this.audId >>> 32)));
		
		return hash;
	}
}