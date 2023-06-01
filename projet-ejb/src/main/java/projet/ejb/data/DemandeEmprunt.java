package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the demande_emprunt database table.
 * 
 */
@Entity
@Table(name = "demande_emprunt")
@NamedQuery(name = "DemandeEmprunt.findAll", query = "SELECT d FROM DemandeEmprunt d")
public class DemandeEmprunt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "iddemandeemprunt")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name = "dateemprunt")
	private Date dateemprunt;

	@JoinColumn(name = "idemprunteur")
	@OneToOne
	private Compte emprunteur;

	@Column(name = "statut")
	private String statut;

	// bi-directional many-to-one association to Ouvrage
	@ManyToOne
	@JoinColumn(name = "idouvrage")
	private Ouvrage ouvrage;

	public DemandeEmprunt() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer iddemandeemprunt) {
		this.id = iddemandeemprunt;
	}

	public Date getDateemprunt() {
		return this.dateemprunt;
	}

	public void setDateemprunt(Date dateemprunt) {
		this.dateemprunt = dateemprunt;
	}

	public Compte getEmprunteur() {
		return this.emprunteur;
	}

	public void setEmprunteur(Compte idemprunteur) {
		this.emprunteur = idemprunteur;
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