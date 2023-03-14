package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_AUDIT_PROCESSOR_QUE database table.
 * 
 */
@Entity
@Table(name="DRP_AUDIT_PROCESSOR_QUE")
@NamedQuery(name="DrpAuditProcessorQue.findAll", query="SELECT d FROM DrpAuditProcessorQue d")
public class DrpAuditProcessorQue implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DrpAuditProcessorQuePK id;

	//bi-directional many-to-one association to DrpAuditProcessorTab
	@ManyToOne
	@JoinColumn(name="AUDIT_TABEL_ID", nullable=false, insertable=false, updatable=false)
	private DrpAuditProcessorTab drpAuditProcessorTab;

	public DrpAuditProcessorQue() {
	}

	public DrpAuditProcessorQuePK getId() {
		return this.id;
	}

	public void setId(DrpAuditProcessorQuePK id) {
		this.id = id;
	}

	public DrpAuditProcessorTab getDrpAuditProcessorTab() {
		return this.drpAuditProcessorTab;
	}

	public void setDrpAuditProcessorTab(DrpAuditProcessorTab drpAuditProcessorTab) {
		this.drpAuditProcessorTab = drpAuditProcessorTab;
	}

}