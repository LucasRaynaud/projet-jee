package projet.jsf.data;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class DemandeAmi implements Serializable {

	private Integer id;

	@NotBlank(message = "Le statut ne doit pas être vide.")
	@Size(max = 20, message = "La longueur du statut ne doit pas dépasser 20 caractères.")
	private String statut;

	@NotBlank(message = "La date doit être renseignée.")
	private Date datedemande;

	@NotNull(message = "Un receveur est obligatoire")
	private Compte receveur;

	@NotNull(message = "Un envoyeur est obligatoire")
	private Compte envoyeur;

	public DemandeAmi() {
		super();
	}

	public DemandeAmi(Integer id,
			@NotBlank(message = "Le statut ne doit pas être vide.") @Size(max = 20, message = "La longueur du statut ne doit pas dépasser 20 caractères.") String statut,
			@NotBlank(message = "La date doit être renseignée.") Date dateDemande,
			@NotNull(message = "Un receveur est obligatoire") Compte receveur,
			@NotNull(message = "Un envoyeur est obligatoire") Compte envoyeur) {
		super();
		this.id = id;
		this.statut = statut;
		this.datedemande = dateDemande;
		this.receveur = receveur;
		this.envoyeur = envoyeur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateDemande() {
		return datedemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.datedemande = dateDemande;
	}

	public Compte getReceveur() {
		return receveur;
	}

	public void setReceveur(Compte receveur) {
		this.receveur = receveur;
	}

	public Compte getEnvoyeur() {
		return envoyeur;
	}

	public void setEnvoyeur(Compte envoyeur) {
		this.envoyeur = envoyeur;
	}

}
