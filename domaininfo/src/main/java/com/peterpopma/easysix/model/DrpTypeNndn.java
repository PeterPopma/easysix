package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TYPE_NNDN database table.
 * 
 */
@Entity
@Table(name="DRP_TYPE_NNDN")
@NamedQuery(name="DrpTypeNndn.findAll", query="SELECT d FROM DrpTypeNndn d")
public class DrpTypeNndn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NNDN_TYPE_ID", unique=true, nullable=false, precision=12, scale=2)
	private long nndnTypeId;

	@Column(name="NNDN_TYPE_NAAM", nullable=false, length=255)
	private String nndnTypeNaam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpNndnItem
	@OneToMany(mappedBy="drpTypeNndn")
	private List<DrpNndnItem> drpNndnItems;

	public DrpTypeNndn() {
	}

	public long getNndnTypeId() {
		return this.nndnTypeId;
	}

	public void setNndnTypeId(long nndnTypeId) {
		this.nndnTypeId = nndnTypeId;
	}

	public String getNndnTypeNaam() {
		return this.nndnTypeNaam;
	}

	public void setNndnTypeNaam(String nndnTypeNaam) {
		this.nndnTypeNaam = nndnTypeNaam;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<DrpNndnItem> getDrpNndnItems() {
		return this.drpNndnItems;
	}

	public void setDrpNndnItems(List<DrpNndnItem> drpNndnItems) {
		this.drpNndnItems = drpNndnItems;
	}

	public DrpNndnItem addDrpNndnItem(DrpNndnItem drpNndnItem) {
		getDrpNndnItems().add(drpNndnItem);
		drpNndnItem.setDrpTypeNndn(this);

		return drpNndnItem;
	}

	public DrpNndnItem removeDrpNndnItem(DrpNndnItem drpNndnItem) {
		getDrpNndnItems().remove(drpNndnItem);
		drpNndnItem.setDrpTypeNndn(null);

		return drpNndnItem;
	}

}