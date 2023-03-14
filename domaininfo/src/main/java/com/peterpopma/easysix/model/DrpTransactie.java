package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRP_TRANSACTIE database table.
 * 
 */
@Entity
@Table(name="DRP_TRANSACTIE")
@NamedQuery(name="DrpTransactie.findAll", query="SELECT d FROM DrpTransactie d")
public class DrpTransactie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, precision=15)
	private long ticketnummer;

	@Column(name="DEELNEMER_CANCEL_JN", nullable=false, length=1)
	private String deelnemerCancelJn;

	@Column(name="DEELNEMER_TICKETNUMMER", length=64)
	private String deelnemerTicketnummer;

	private Object einddatum;

	@Column(name="LATENDE_DEELNEMER_REJECT_JN", length=1)
	private String latendeDeelnemerRejectJn;

	@Column(name="REGISTRY_CANCEL_JN", nullable=false, length=1)
	private String registryCancelJn;

	@Column(nullable=false)
	private Object startdatum;

	@Column(nullable=false)
	private Object statusdatum;

	@Column(length=255)
	private String statusreden;

	@Column(name="USER_ID", nullable=false, length=50)
	private String userId;

	private Object vervaldatum;

	@Column(name="VERWIJDEREN_JN", nullable=false, length=1)
	private String verwijderenJn;

	//bi-directional many-to-one association to DrpBeoordeling
	@OneToMany(mappedBy="drpTransactie")
	private List<DrpBeoordeling> drpBeoordelings;

	//bi-directional many-to-one association to DrpCorrespondentie
	@OneToMany(mappedBy="drpTransactie")
	private List<DrpCorrespondentie> drpCorrespondenties;

	//bi-directional many-to-one association to DrpDeelnemerTransactie
	@OneToMany(mappedBy="drpTransactie")
	private List<DrpDeelnemerTransactie> drpDeelnemerTransacties;

	//bi-directional many-to-one association to DrpDomeinnaamTransactie
	@OneToMany(mappedBy="drpTransactie")
	private List<DrpDomeinnaamTransactie> drpDomeinnaamTransacties;

	//bi-directional many-to-one association to DrpFcf
	@OneToMany(mappedBy="drpTransactie")
	private List<DrpFcf> drpFcfs;

	//bi-directional many-to-one association to DrpNameserverTransactie
	@OneToMany(mappedBy="drpTransactie")
	private List<DrpNameserverTransactie> drpNameserverTransacties;

	//bi-directional many-to-one association to DrpNotitie
	@OneToMany(mappedBy="drpTransactie")
	private List<DrpNotitie> drpNotities;

	//bi-directional many-to-one association to DrpResellerTransactie
	@OneToMany(mappedBy="drpTransactie")
	private List<DrpResellerTransactie> drpResellerTransacties;

	//bi-directional many-to-one association to DrpContactpersoon
	@ManyToOne
	@JoinColumn(name="CPN_HANDLE")
	private DrpContactpersoon drpContactpersoon;

	//bi-directional many-to-one association to DrpDeelnemer
	@ManyToOne
	@JoinColumn(name="DNR_ID", nullable=false)
	private DrpDeelnemer drpDeelnemer;

	//bi-directional many-to-one association to DrpGebruiker
	@ManyToOne
	@JoinColumn(name="GBR_ID")
	private DrpGebruiker drpGebruiker;

	//bi-directional many-to-one association to DrpTransactiebron
	@ManyToOne
	@JoinColumn(name="TBN_CODE", nullable=false)
	private DrpTransactiebron drpTransactiebron;

	//bi-directional many-to-one association to DrpTypeTransactie
	@ManyToOne
	@JoinColumn(name="TTE_CODE", nullable=false)
	private DrpTypeTransactie drpTypeTransactie;

	//bi-directional many-to-one association to DrpTypeTransactiestatus
	@ManyToOne
	@JoinColumn(name="TAS_CODE", nullable=false)
	private DrpTypeTransactiestatus drpTypeTransactiestatus;

	//bi-directional many-to-one association to DrpTransactiebericht
	@OneToMany(mappedBy="drpTransactie")
	private List<DrpTransactiebericht> drpTransactieberichts;

	public DrpTransactie() {
	}

	public long getTicketnummer() {
		return this.ticketnummer;
	}

	public void setTicketnummer(long ticketnummer) {
		this.ticketnummer = ticketnummer;
	}

	public String getDeelnemerCancelJn() {
		return this.deelnemerCancelJn;
	}

	public void setDeelnemerCancelJn(String deelnemerCancelJn) {
		this.deelnemerCancelJn = deelnemerCancelJn;
	}

	public String getDeelnemerTicketnummer() {
		return this.deelnemerTicketnummer;
	}

	public void setDeelnemerTicketnummer(String deelnemerTicketnummer) {
		this.deelnemerTicketnummer = deelnemerTicketnummer;
	}

	public Object getEinddatum() {
		return this.einddatum;
	}

	public void setEinddatum(Object einddatum) {
		this.einddatum = einddatum;
	}

	public String getLatendeDeelnemerRejectJn() {
		return this.latendeDeelnemerRejectJn;
	}

	public void setLatendeDeelnemerRejectJn(String latendeDeelnemerRejectJn) {
		this.latendeDeelnemerRejectJn = latendeDeelnemerRejectJn;
	}

	public String getRegistryCancelJn() {
		return this.registryCancelJn;
	}

	public void setRegistryCancelJn(String registryCancelJn) {
		this.registryCancelJn = registryCancelJn;
	}

	public Object getStartdatum() {
		return this.startdatum;
	}

	public void setStartdatum(Object startdatum) {
		this.startdatum = startdatum;
	}

	public Object getStatusdatum() {
		return this.statusdatum;
	}

	public void setStatusdatum(Object statusdatum) {
		this.statusdatum = statusdatum;
	}

	public String getStatusreden() {
		return this.statusreden;
	}

	public void setStatusreden(String statusreden) {
		this.statusreden = statusreden;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Object getVervaldatum() {
		return this.vervaldatum;
	}

	public void setVervaldatum(Object vervaldatum) {
		this.vervaldatum = vervaldatum;
	}

	public String getVerwijderenJn() {
		return this.verwijderenJn;
	}

	public void setVerwijderenJn(String verwijderenJn) {
		this.verwijderenJn = verwijderenJn;
	}

	public List<DrpBeoordeling> getDrpBeoordelings() {
		return this.drpBeoordelings;
	}

	public void setDrpBeoordelings(List<DrpBeoordeling> drpBeoordelings) {
		this.drpBeoordelings = drpBeoordelings;
	}

	public DrpBeoordeling addDrpBeoordeling(DrpBeoordeling drpBeoordeling) {
		getDrpBeoordelings().add(drpBeoordeling);
		drpBeoordeling.setDrpTransactie(this);

		return drpBeoordeling;
	}

	public DrpBeoordeling removeDrpBeoordeling(DrpBeoordeling drpBeoordeling) {
		getDrpBeoordelings().remove(drpBeoordeling);
		drpBeoordeling.setDrpTransactie(null);

		return drpBeoordeling;
	}

	public List<DrpCorrespondentie> getDrpCorrespondenties() {
		return this.drpCorrespondenties;
	}

	public void setDrpCorrespondenties(List<DrpCorrespondentie> drpCorrespondenties) {
		this.drpCorrespondenties = drpCorrespondenties;
	}

	public DrpCorrespondentie addDrpCorrespondenty(DrpCorrespondentie drpCorrespondenty) {
		getDrpCorrespondenties().add(drpCorrespondenty);
		drpCorrespondenty.setDrpTransactie(this);

		return drpCorrespondenty;
	}

	public DrpCorrespondentie removeDrpCorrespondenty(DrpCorrespondentie drpCorrespondenty) {
		getDrpCorrespondenties().remove(drpCorrespondenty);
		drpCorrespondenty.setDrpTransactie(null);

		return drpCorrespondenty;
	}

	public List<DrpDeelnemerTransactie> getDrpDeelnemerTransacties() {
		return this.drpDeelnemerTransacties;
	}

	public void setDrpDeelnemerTransacties(List<DrpDeelnemerTransactie> drpDeelnemerTransacties) {
		this.drpDeelnemerTransacties = drpDeelnemerTransacties;
	}

	public DrpDeelnemerTransactie addDrpDeelnemerTransacty(DrpDeelnemerTransactie drpDeelnemerTransacty) {
		getDrpDeelnemerTransacties().add(drpDeelnemerTransacty);
		drpDeelnemerTransacty.setDrpTransactie(this);

		return drpDeelnemerTransacty;
	}

	public DrpDeelnemerTransactie removeDrpDeelnemerTransacty(DrpDeelnemerTransactie drpDeelnemerTransacty) {
		getDrpDeelnemerTransacties().remove(drpDeelnemerTransacty);
		drpDeelnemerTransacty.setDrpTransactie(null);

		return drpDeelnemerTransacty;
	}

	public List<DrpDomeinnaamTransactie> getDrpDomeinnaamTransacties() {
		return this.drpDomeinnaamTransacties;
	}

	public void setDrpDomeinnaamTransacties(List<DrpDomeinnaamTransactie> drpDomeinnaamTransacties) {
		this.drpDomeinnaamTransacties = drpDomeinnaamTransacties;
	}

	public DrpDomeinnaamTransactie addDrpDomeinnaamTransacty(DrpDomeinnaamTransactie drpDomeinnaamTransacty) {
		getDrpDomeinnaamTransacties().add(drpDomeinnaamTransacty);
		drpDomeinnaamTransacty.setDrpTransactie(this);

		return drpDomeinnaamTransacty;
	}

	public DrpDomeinnaamTransactie removeDrpDomeinnaamTransacty(DrpDomeinnaamTransactie drpDomeinnaamTransacty) {
		getDrpDomeinnaamTransacties().remove(drpDomeinnaamTransacty);
		drpDomeinnaamTransacty.setDrpTransactie(null);

		return drpDomeinnaamTransacty;
	}

	public List<DrpFcf> getDrpFcfs() {
		return this.drpFcfs;
	}

	public void setDrpFcfs(List<DrpFcf> drpFcfs) {
		this.drpFcfs = drpFcfs;
	}

	public DrpFcf addDrpFcf(DrpFcf drpFcf) {
		getDrpFcfs().add(drpFcf);
		drpFcf.setDrpTransactie(this);

		return drpFcf;
	}

	public DrpFcf removeDrpFcf(DrpFcf drpFcf) {
		getDrpFcfs().remove(drpFcf);
		drpFcf.setDrpTransactie(null);

		return drpFcf;
	}

	public List<DrpNameserverTransactie> getDrpNameserverTransacties() {
		return this.drpNameserverTransacties;
	}

	public void setDrpNameserverTransacties(List<DrpNameserverTransactie> drpNameserverTransacties) {
		this.drpNameserverTransacties = drpNameserverTransacties;
	}

	public DrpNameserverTransactie addDrpNameserverTransacty(DrpNameserverTransactie drpNameserverTransacty) {
		getDrpNameserverTransacties().add(drpNameserverTransacty);
		drpNameserverTransacty.setDrpTransactie(this);

		return drpNameserverTransacty;
	}

	public DrpNameserverTransactie removeDrpNameserverTransacty(DrpNameserverTransactie drpNameserverTransacty) {
		getDrpNameserverTransacties().remove(drpNameserverTransacty);
		drpNameserverTransacty.setDrpTransactie(null);

		return drpNameserverTransacty;
	}

	public List<DrpNotitie> getDrpNotities() {
		return this.drpNotities;
	}

	public void setDrpNotities(List<DrpNotitie> drpNotities) {
		this.drpNotities = drpNotities;
	}

	public DrpNotitie addDrpNotity(DrpNotitie drpNotity) {
		getDrpNotities().add(drpNotity);
		drpNotity.setDrpTransactie(this);

		return drpNotity;
	}

	public DrpNotitie removeDrpNotity(DrpNotitie drpNotity) {
		getDrpNotities().remove(drpNotity);
		drpNotity.setDrpTransactie(null);

		return drpNotity;
	}

	public List<DrpResellerTransactie> getDrpResellerTransacties() {
		return this.drpResellerTransacties;
	}

	public void setDrpResellerTransacties(List<DrpResellerTransactie> drpResellerTransacties) {
		this.drpResellerTransacties = drpResellerTransacties;
	}

	public DrpResellerTransactie addDrpResellerTransacty(DrpResellerTransactie drpResellerTransacty) {
		getDrpResellerTransacties().add(drpResellerTransacty);
		drpResellerTransacty.setDrpTransactie(this);

		return drpResellerTransacty;
	}

	public DrpResellerTransactie removeDrpResellerTransacty(DrpResellerTransactie drpResellerTransacty) {
		getDrpResellerTransacties().remove(drpResellerTransacty);
		drpResellerTransacty.setDrpTransactie(null);

		return drpResellerTransacty;
	}

	public DrpContactpersoon getDrpContactpersoon() {
		return this.drpContactpersoon;
	}

	public void setDrpContactpersoon(DrpContactpersoon drpContactpersoon) {
		this.drpContactpersoon = drpContactpersoon;
	}

	public DrpDeelnemer getDrpDeelnemer() {
		return this.drpDeelnemer;
	}

	public void setDrpDeelnemer(DrpDeelnemer drpDeelnemer) {
		this.drpDeelnemer = drpDeelnemer;
	}

	public DrpGebruiker getDrpGebruiker() {
		return this.drpGebruiker;
	}

	public void setDrpGebruiker(DrpGebruiker drpGebruiker) {
		this.drpGebruiker = drpGebruiker;
	}

	public DrpTransactiebron getDrpTransactiebron() {
		return this.drpTransactiebron;
	}

	public void setDrpTransactiebron(DrpTransactiebron drpTransactiebron) {
		this.drpTransactiebron = drpTransactiebron;
	}

	public DrpTypeTransactie getDrpTypeTransactie() {
		return this.drpTypeTransactie;
	}

	public void setDrpTypeTransactie(DrpTypeTransactie drpTypeTransactie) {
		this.drpTypeTransactie = drpTypeTransactie;
	}

	public DrpTypeTransactiestatus getDrpTypeTransactiestatus() {
		return this.drpTypeTransactiestatus;
	}

	public void setDrpTypeTransactiestatus(DrpTypeTransactiestatus drpTypeTransactiestatus) {
		this.drpTypeTransactiestatus = drpTypeTransactiestatus;
	}

	public List<DrpTransactiebericht> getDrpTransactieberichts() {
		return this.drpTransactieberichts;
	}

	public void setDrpTransactieberichts(List<DrpTransactiebericht> drpTransactieberichts) {
		this.drpTransactieberichts = drpTransactieberichts;
	}

	public DrpTransactiebericht addDrpTransactiebericht(DrpTransactiebericht drpTransactiebericht) {
		getDrpTransactieberichts().add(drpTransactiebericht);
		drpTransactiebericht.setDrpTransactie(this);

		return drpTransactiebericht;
	}

	public DrpTransactiebericht removeDrpTransactiebericht(DrpTransactiebericht drpTransactiebericht) {
		getDrpTransactieberichts().remove(drpTransactiebericht);
		drpTransactiebericht.setDrpTransactie(null);

		return drpTransactiebericht;
	}

}