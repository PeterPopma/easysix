package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the DRP_GEBRUIKER database table.
 * 
 */
@Entity
@Table(name="DRP_GEBRUIKER")
@NamedQuery(name="DrpGebruiker.findAll", query="SELECT d FROM DrpGebruiker d")
public class DrpGebruiker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GBR_ID", unique=true, nullable=false, precision=12)
	private long gbrId;

	@Column(name="ACTIEF_JN", nullable=false, length=1)
	private String actiefJn;

	@Column(length=255)
	private String activeringsreden;

	@Column(name="INLOGGEN_JN", nullable=false, length=1)
	private String inloggenJn;

	@Column(name="MOBIEL_NUMMER", length=30)
	private String mobielNummer;

	@Column(nullable=false, length=100)
	private String naam;

	@Column(precision=15)
	private BigDecimal ticketnummer;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	@Column(name="VERLOOPDATUM_WACHTWOORD")
	private Object verloopdatumWachtwoord;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	@Column(name="VRIJGEGEVEN_JN", nullable=false, length=1)
	private String vrijgegevenJn;

	@Column(nullable=false, length=128)
	private String wachtwoord;

	//bi-directional many-to-one association to DrpBeoordeling
	@OneToMany(mappedBy="drpGebruiker")
	private List<DrpBeoordeling> drpBeoordelings;

	//bi-directional many-to-one association to DrpContactpersoon
	@OneToMany(mappedBy="drpGebruiker")
	private List<DrpContactpersoon> drpContactpersoons;

	//bi-directional many-to-one association to DrpFcf
	@OneToMany(mappedBy="drpGebruiker")
	private List<DrpFcf> drpFcfs;

	//bi-directional many-to-one association to DrpDeelnemer
	@ManyToOne
	@JoinColumn(name="DNR_ID", nullable=false)
	private DrpDeelnemer drpDeelnemer;

	//bi-directional many-to-one association to DrpTypeGebruikersaccount
	@ManyToOne
	@JoinColumn(name="TGT_CODE", nullable=false)
	private DrpTypeGebruikersaccount drpTypeGebruikersaccount;

	//bi-directional many-to-one association to DrpGebruikerGebruikersrol
	@OneToMany(mappedBy="drpGebruiker")
	private List<DrpGebruikerGebruikersrol> drpGebruikerGebruikersrols;

	//bi-directional many-to-one association to DrpGebruiktWachtwoord
	@OneToMany(mappedBy="drpGebruiker")
	private List<DrpGebruiktWachtwoord> drpGebruiktWachtwoords;

	//bi-directional many-to-one association to DrpTransactie
	@OneToMany(mappedBy="drpGebruiker")
	private List<DrpTransactie> drpTransacties;

	public DrpGebruiker() {
	}

	public long getGbrId() {
		return this.gbrId;
	}

	public void setGbrId(long gbrId) {
		this.gbrId = gbrId;
	}

	public String getActiefJn() {
		return this.actiefJn;
	}

	public void setActiefJn(String actiefJn) {
		this.actiefJn = actiefJn;
	}

	public String getActiveringsreden() {
		return this.activeringsreden;
	}

	public void setActiveringsreden(String activeringsreden) {
		this.activeringsreden = activeringsreden;
	}

	public String getInloggenJn() {
		return this.inloggenJn;
	}

	public void setInloggenJn(String inloggenJn) {
		this.inloggenJn = inloggenJn;
	}

	public String getMobielNummer() {
		return this.mobielNummer;
	}

	public void setMobielNummer(String mobielNummer) {
		this.mobielNummer = mobielNummer;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public BigDecimal getTicketnummer() {
		return this.ticketnummer;
	}

	public void setTicketnummer(BigDecimal ticketnummer) {
		this.ticketnummer = ticketnummer;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Object getVerloopdatumWachtwoord() {
		return this.verloopdatumWachtwoord;
	}

	public void setVerloopdatumWachtwoord(Object verloopdatumWachtwoord) {
		this.verloopdatumWachtwoord = verloopdatumWachtwoord;
	}

	public String getVerwijderenJn() {
		return this.verwijderenJn;
	}

	public void setVerwijderenJn(String verwijderenJn) {
		this.verwijderenJn = verwijderenJn;
	}

	public String getVrijgegevenJn() {
		return this.vrijgegevenJn;
	}

	public void setVrijgegevenJn(String vrijgegevenJn) {
		this.vrijgegevenJn = vrijgegevenJn;
	}

	public String getWachtwoord() {
		return this.wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public List<DrpBeoordeling> getDrpBeoordelings() {
		return this.drpBeoordelings;
	}

	public void setDrpBeoordelings(List<DrpBeoordeling> drpBeoordelings) {
		this.drpBeoordelings = drpBeoordelings;
	}

	public DrpBeoordeling addDrpBeoordeling(DrpBeoordeling drpBeoordeling) {
		getDrpBeoordelings().add(drpBeoordeling);
		drpBeoordeling.setDrpGebruiker(this);

		return drpBeoordeling;
	}

	public DrpBeoordeling removeDrpBeoordeling(DrpBeoordeling drpBeoordeling) {
		getDrpBeoordelings().remove(drpBeoordeling);
		drpBeoordeling.setDrpGebruiker(null);

		return drpBeoordeling;
	}

	public List<DrpContactpersoon> getDrpContactpersoons() {
		return this.drpContactpersoons;
	}

	public void setDrpContactpersoons(List<DrpContactpersoon> drpContactpersoons) {
		this.drpContactpersoons = drpContactpersoons;
	}

	public DrpContactpersoon addDrpContactpersoon(DrpContactpersoon drpContactpersoon) {
		getDrpContactpersoons().add(drpContactpersoon);
		drpContactpersoon.setDrpGebruiker(this);

		return drpContactpersoon;
	}

	public DrpContactpersoon removeDrpContactpersoon(DrpContactpersoon drpContactpersoon) {
		getDrpContactpersoons().remove(drpContactpersoon);
		drpContactpersoon.setDrpGebruiker(null);

		return drpContactpersoon;
	}

	public List<DrpFcf> getDrpFcfs() {
		return this.drpFcfs;
	}

	public void setDrpFcfs(List<DrpFcf> drpFcfs) {
		this.drpFcfs = drpFcfs;
	}

	public DrpFcf addDrpFcf(DrpFcf drpFcf) {
		getDrpFcfs().add(drpFcf);
		drpFcf.setDrpGebruiker(this);

		return drpFcf;
	}

	public DrpFcf removeDrpFcf(DrpFcf drpFcf) {
		getDrpFcfs().remove(drpFcf);
		drpFcf.setDrpGebruiker(null);

		return drpFcf;
	}

	public DrpDeelnemer getDrpDeelnemer() {
		return this.drpDeelnemer;
	}

	public void setDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		this.drpDeelnemer = drpDeelnemer;
	}

	public DrpTypeGebruikersaccount getDrpTypeGebruikersaccount() {
		return this.drpTypeGebruikersaccount;
	}

	public void setDrpTypeGebruikersaccount(DrpTypeGebruikersaccount drpTypeGebruikersaccount) {
		this.drpTypeGebruikersaccount = drpTypeGebruikersaccount;
	}

	public List<DrpGebruikerGebruikersrol> getDrpGebruikerGebruikersrols() {
		return this.drpGebruikerGebruikersrols;
	}

	public void setDrpGebruikerGebruikersrols(List<DrpGebruikerGebruikersrol> drpGebruikerGebruikersrols) {
		this.drpGebruikerGebruikersrols = drpGebruikerGebruikersrols;
	}

	public DrpGebruikerGebruikersrol addDrpGebruikerGebruikersrol(DrpGebruikerGebruikersrol drpGebruikerGebruikersrol) {
		getDrpGebruikerGebruikersrols().add(drpGebruikerGebruikersrol);
		drpGebruikerGebruikersrol.setDrpGebruiker(this);

		return drpGebruikerGebruikersrol;
	}

	public DrpGebruikerGebruikersrol removeDrpGebruikerGebruikersrol(DrpGebruikerGebruikersrol drpGebruikerGebruikersrol) {
		getDrpGebruikerGebruikersrols().remove(drpGebruikerGebruikersrol);
		drpGebruikerGebruikersrol.setDrpGebruiker(null);

		return drpGebruikerGebruikersrol;
	}

	public List<DrpGebruiktWachtwoord> getDrpGebruiktWachtwoords() {
		return this.drpGebruiktWachtwoords;
	}

	public void setDrpGebruiktWachtwoords(List<DrpGebruiktWachtwoord> drpGebruiktWachtwoords) {
		this.drpGebruiktWachtwoords = drpGebruiktWachtwoords;
	}

	public DrpGebruiktWachtwoord addDrpGebruiktWachtwoord(DrpGebruiktWachtwoord drpGebruiktWachtwoord) {
		getDrpGebruiktWachtwoords().add(drpGebruiktWachtwoord);
		drpGebruiktWachtwoord.setDrpGebruiker(this);

		return drpGebruiktWachtwoord;
	}

	public DrpGebruiktWachtwoord removeDrpGebruiktWachtwoord(DrpGebruiktWachtwoord drpGebruiktWachtwoord) {
		getDrpGebruiktWachtwoords().remove(drpGebruiktWachtwoord);
		drpGebruiktWachtwoord.setDrpGebruiker(null);

		return drpGebruiktWachtwoord;
	}

	public List<DrpTransactie> getDrpTransacties() {
		return this.drpTransacties;
	}

	public void setDrpTransacties(List<DrpTransactie> drpTransacties) {
		this.drpTransacties = drpTransacties;
	}

	public DrpTransactie addDrpTransacty(DrpTransactie drpTransacty) {
		getDrpTransacties().add(drpTransacty);
		drpTransacty.setDrpGebruiker(this);

		return drpTransacty;
	}

	public DrpTransactie removeDrpTransacty(DrpTransactie drpTransacty) {
		getDrpTransacties().remove(drpTransacty);
		drpTransacty.setDrpGebruiker(null);

		return drpTransacty;
	}

}