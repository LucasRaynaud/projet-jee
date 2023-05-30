package projet.ejb.data;

<<<<<<< HEAD
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the demande_emprunt database table.
 * 
 */
@Entity
@Table(name="demande_emprunt")
@NamedQuery(name="DemandeEmprunt.findAll", query="SELECT d FROM DemandeEmprunt d")
public class DemandeEmprunt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iddemandeemprunt;

	@Temporal(TemporalType.DATE)
	private Date dateemprunt;

	private Integer idemprunteur;

	private Integer idproprietaire;

	private String statut;

	//bi-directional many-to-one association to Ouvrage
	@ManyToOne
	@JoinColumn(name="idouvrage")
	private Ouvrage ouvrage;

	public DemandeEmprunt() {
	}

	public Integer getIddemandeemprunt() {
		return this.iddemandeemprunt;
	}

	public void setIddemandeemprunt(Integer iddemandeemprunt) {
		this.iddemandeemprunt = iddemandeemprunt;
	}

	public Date getDateemprunt() {
		return this.dateemprunt;
	}

	public void setDateemprunt(Date dateemprunt) {
		this.dateemprunt = dateemprunt;
	}

	public Integer getIdemprunteur() {
		return this.idemprunteur;
	}

	public void setIdemprunteur(Integer idemprunteur) {
		this.idemprunteur = idemprunteur;
	}

	public Integer getIdproprietaire() {
		return this.idproprietaire;
	}

	public void setIdproprietaire(Integer idproprietaire) {
=======
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the demande_emprunt database table.
 * 
 */
@Entity
@Table(name="demande_emprunt")
@NamedQuery(name="DemandeEmprunt.findAll", query="SELECT d FROM DemandeEmprunt d")
public class DemandeEmprunt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = IDENTITY)
	@Column( name = "iddemandeemprunt")
	private Integer iddemandeemprunt;

	@Temporal(TemporalType.DATE)
	@Column( name = "dateemprunt")
	private Date dateemprunt;
	
	@JoinColumn( name = "idemprunteur")
	@OneToOne
	private Compte idemprunteur;
	
	@JoinColumn( name = "idproprietaire")
	@OneToOne
	private Compte idproprietaire;
	
	@Column( name = "statut")
	private String statut;

	//bi-directional many-to-one association to Ouvrage
	@ManyToOne
	@JoinColumn(name="idouvrage")
	private Ouvrage ouvrage;

	public DemandeEmprunt() {
	}

	public Integer getIddemandeemprunt() {
		return this.iddemandeemprunt;
	}

	public void setIddemandeemprunt(Integer iddemandeemprunt) {
		this.iddemandeemprunt = iddemandeemprunt;
	}

	public Date getDateemprunt() {
		return this.dateemprunt;
	}

	public void setDateemprunt(Date dateemprunt) {
		this.dateemprunt = dateemprunt;
	}

	public Compte getIdemprunteur() {
		return this.idemprunteur;
	}

	public void setIdemprunteur(Compte idemprunteur) {
		this.idemprunteur = idemprunteur;
	}

	public Compte getIdproprietaire() {
		return this.idproprietaire;
	}

	public void setIdproprietaire(Compte idproprietaire) {
>>>>>>> refs/remotes/GitHub/master
		this.idproprietaire = idproprietaire;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Ouvrage getOuvrage() {
		return this.ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

}