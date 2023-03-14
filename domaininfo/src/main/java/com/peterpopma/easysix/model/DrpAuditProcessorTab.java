package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the DRP_AUDIT_PROCESSOR_TAB database table.
 * 
 */
@Entity
@Table(name="DRP_AUDIT_PROCESSOR_TAB")
@NamedQuery(name="DrpAuditProcessorTab.findAll", query="SELECT d FROM DrpAuditProcessorTab d")
public class DrpAuditProcessorTab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUDIT_TABEL_ID", unique=true, nullable=false, precision=3)
	private long auditTabelId;

	@Column(name="AUDIT_TABEL_NAAM", nullable=false, length=30)
	private String auditTabelNaam;

	@Column(name="PROD_TABEL_NAAM", nullable=false, length=30)
	private String prodTabelNaam;

	@Column(name="STORAGE_TIME", nullable=false)
	private BigDecimal storageTime;

	//bi-directional many-to-one association to DrpAuditProcessorQue
	@OneToMany(mappedBy="drpAuditProcessorTab")
	private List<DrpAuditProcessorQue> drpAuditProcessorQues;

	public DrpAuditProcessorTab() {
	}

	public long getAuditTabelId() {
		return this.auditTabelId;
	}

	public void setAuditTabelId(long auditTabelId) {
		this.auditTabelId = auditTabelId;
	}

	public String getAuditTabelNaam() {
		return this.auditTabelNaam;
	}

	public void setAuditTabelNaam(String auditTabelNaam) {
		this.auditTabelNaam = auditTabelNaam;
	}

	public String getProdTabelNaam() {
		return this.prodTabelNaam;
	}

	public void setProdTabelNaam(String prodTabelNaam) {
		this.prodTabelNaam = prodTabelNaam;
	}

	public BigDecimal getStorageTime() {
		return this.storageTime;
	}

	public void setStorageTime(BigDecimal storageTime) {
		this.storageTime = storageTime;
	}

	public List<DrpAuditProcessorQue> getDrpAuditProcessorQues() {
		return this.drpAuditProcessorQues;
	}

	public void setDrpAuditProcessorQues(List<DrpAuditProcessorQue> drpAuditProcessorQues) {
		this.drpAuditProcessorQues = drpAuditProcessorQues;
	}

	public DrpAuditProcessorQue addDrpAuditProcessorQue(DrpAuditProcessorQue drpAuditProcessorQue) {
		getDrpAuditProcessorQues().add(drpAuditProcessorQue);
		drpAuditProcessorQue.setDrpAuditProcessorTab(this);

		return drpAuditProcessorQue;
	}

	public DrpAuditProcessorQue removeDrpAuditProcessorQue(DrpAuditProcessorQue drpAuditProcessorQue) {
		getDrpAuditProcessorQues().remove(drpAuditProcessorQue);
		drpAuditProcessorQue.setDrpAuditProcessorTab(null);

		return drpAuditProcessorQue;
	}

}