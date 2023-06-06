package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "demande_amis")
@NamedQuery(name = "DemandeAmi.findAll", query = "SELECT d FROM DemandeAmi d")
public class DemandeAmi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddemandeamis")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name = "datedemande")
	private Date datedemande;

	@JoinColumn(name = "idenvoyeur")
	@OneToOne
	private Compte envoyeur;

	@JoinColumn(name = "idreceveur")
	@OneToOne
	private Compte receveur;

	@Column(name = "statut")
	private String statut;

	public DemandeAmi() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer iddemandeamis) {
		this.id = iddemandeamis;
	}

	public Date getDateDemande() {
		return this.datedemande;
	}

	public void setDateDemande(Date datedemande) {
		this.datedemande = datedemande;
	}

	public Compte getEnvoyeur() {
		return this.envoyeur;
	}

	public void setEnvoyeur(Compte idenvoyeur) {
		this.envoyeur = idenvoyeur;
	}

	public Compte getReceveur() {
		return this.receveur;
	}

	public void setReceveur(Compte idreceveur) {
		this.receveur = idreceveur;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "DemandeAmi [id=" + id + ", datedemande=" + datedemande + ", envoyeur=" + envoyeur + ", receveur="
				+ receveur + ", statut=" + statut + "]";
	}

}