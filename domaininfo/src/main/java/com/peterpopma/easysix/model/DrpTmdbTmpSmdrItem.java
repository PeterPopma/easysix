package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_TMDB_TMP_SMDR_ITEM database table.
 * 
 */
@Entity
@Table(name="DRP_TMDB_TMP_SMDR_ITEM")
@NamedQuery(name="DrpTmdbTmpSmdrItem.findAll", query="SELECT d FROM DrpTmdbTmpSmdrItem d")
public class DrpTmdbTmpSmdrItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SMDR_ID", unique=true, nullable=false, length=50)
	private String smdrId;

	@Column(name="INSERTION_DATETIME", nullable=false)
	private Object insertionDatetime;

	public DrpTmdbTmpSmdrItem() {
	}

	public String getSmdrId() {
		return this.smdrId;
	}

	public void setSmdrId(String smdrId) {
		this.smdrId = smdrId;
	}

	public Object getInsertionDatetime() {
		return this.insertionDatetime;
	}

	public void setInsertionDatetime(Object insertionDatetime) {
		this.insertionDatetime = insertionDatetime;
	}

}