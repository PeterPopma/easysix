package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_KLASSEATTRIBUUT database table.
 * 
 */
@Entity
@Table(name="DRP_KLASSEATTRIBUUT")
@NamedQuery(name="DrpKlasseattribuut.findAll", query="SELECT d FROM DrpKlasseattribuut d")
public class DrpKlasseattribuut implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="KAT_ID", unique=true, nullable=false, precision=12)
	private long katId;

	@Column(length=35)
	private String attribuut;

	@Column(nullable=false, length=220)
	private String klasse;

	@Column(nullable=false, length=255)
	private String naam;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	//bi-directional many-to-one association to DrpBeperkingValidatie
	@OneToMany(mappedBy="drpKlasseattribuut")
	private List<DrpBeperkingValidatie> drpBeperkingValidaties;

	public DrpKlasseattribuut() {
	}

	public long getKatId() {
		return this.katId;
	}

	public void setKatId(long katId) {
		this.katId = katId;
	}

	public String getAttribuut() {
		return this.attribuut;
	}

	public void setAttribuut(String attribuut) {
		this.attribuut = attribuut;
	}

	public String getKlasse() {
		return this.klasse;
	}

	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<DrpBeperkingValidatie> getDrpBeperkingValidaties() {
		return this.drpBeperkingValidaties;
	}

	public void setDrpBeperkingValidaties(List<DrpBeperkingValidatie> drpBeperkingValidaties) {
		this.drpBeperkingValidaties = drpBeperkingValidaties;
	}

	public DrpBeperkingValidatie addDrpBeperkingValidaty(DrpBeperkingValidatie drpBeperkingValidaty) {
		getDrpBeperkingValidaties().add(drpBeperkingValidaty);
		drpBeperkingValidaty.setDrpKlasseattribuut(this);

		return drpBeperkingValidaty;
	}

	public DrpBeperkingValidatie removeDrpBeperkingValidaty(DrpBeperkingValidatie drpBeperkingValidaty) {
		getDrpBeperkingValidaties().remove(drpBeperkingValidaty);
		drpBeperkingValidaty.setDrpKlasseattribuut(null);

		return drpBeperkingValidaty;
	}

}