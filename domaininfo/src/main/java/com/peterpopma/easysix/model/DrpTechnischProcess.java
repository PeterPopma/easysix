package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRP_TECHNISCH_PROCESS database table.
 * 
 */
@Entity
@Table(name="DRP_TECHNISCH_PROCESS")
@NamedQuery(name="DrpTechnischProcess.findAll", query="SELECT d FROM DrpTechnischProcess d")
public class DrpTechnischProcess implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TPS_ID", unique=true, nullable=false, precision=12)
	private long tpsId;

	@Lob
	private String drsepprequestdocument;

	@Lob
	private String error;

	@Column(name="ERROR_TIJDSTIP")
	private Object errorTijdstip;

	@Column(length=80)
	private String processclassname;

	@Column(name="\"SAVEPOINT\"", length=17)
	private String savepoint;

	@Column(length=17)
	private String status;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	public DrpTechnischProcess() {
	}

	public long getTpsId() {
		return this.tpsId;
	}

	public void setTpsId(long tpsId) {
		this.tpsId = tpsId;
	}

	public String getDrsepprequestdocument() {
		return this.drsepprequestdocument;
	}

	public void setDrsepprequestdocument(String drsepprequestdocument) {
		this.drsepprequestdocument = drsepprequestdocument;
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Object getErrorTijdstip() {
		return this.errorTijdstip;
	}

	public void setErrorTijdstip(Object errorTijdstip) {
		this.errorTijdstip = errorTijdstip;
	}

	public String getProcessclassname() {
		return this.processclassname;
	}

	public void setProcessclassname(String processclassname) {
		this.processclassname = processclassname;
	}

	public String getSavepoint() {
		return this.savepoint;
	}

	public void setSavepoint(String savepoint) {
		this.savepoint = savepoint;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTicketnummer() {
		return this.ticketnummer;
	}

	public void setTicketnummer(BigDecimal ticketnummer) {
		this.ticketnummer = ticketnummer;
	}

}