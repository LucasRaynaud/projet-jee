package projet.jsf.data;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class DemandeEmprunt implements Serializable {

	private Integer id;

	private Date dateemprunt;

	@NotNull(message = "Un emprunt doit avoir un emprunteur")
	private Integer idemprunteur;

	private Integer idproprietaire;

	@NotBlank(message = "Le statut doit être défini")
	@Size(max = 20, message = "Le statut ne doit pas dépasser 20 caractères")
	private String statut;

	@NotNull(message = "L'ouvrage est obligatoire")
	private Ouvrage ouvrage;

	public DemandeEmprunt() {
		super();
	}

	public DemandeEmprunt(Integer id, Date dateemprunt, Integer idemprunteur, Integer idproprietaire, String statut,
			Ouvrage ouvrage) {
		super();
		this.id = id;
		this.dateemprunt = dateemprunt;
		this.idemprunteur = idemprunteur;
		this.idproprietaire = idproprietaire;
		this.statut = statut;
		this.ouvrage = ouvrage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateemprunt() {
		return dateemprunt;
	}

	public void setDateemprunt(Date dateemprunt) {
		this.dateemprunt = dateemprunt;
	}

	public Integer getIdemprunteur() {
		return idemprunteur;
	}

	public void setIdemprunteur(Integer idemprunteur) {
		this.idemprunteur = idemprunteur;
	}

	public Integer getIdproprietaire() {
		return idproprietaire;
	}

	public void setIdproprietaire(Integer idproprietaire) {
		this.idproprietaire = idproprietaire;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Ouvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

}
