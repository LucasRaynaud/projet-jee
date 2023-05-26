package projet.jsf.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class Ouvrage implements Serializable {

	private Integer id;

	@NotBlank(message = "Le nom de l'auteur doit être renseigné.")
	@Size(max = 30, message = "La longueur du nom de l'auteur ne doit pas dépasser 30 caractères.")
	private String auteur;

	private Date dateparution;

	@NotNull(message = "L'ouvrage doit avoir un propriétaire")
	private Integer idproprietaire;

	@NotBlank(message = "Le titre doit être renseigné.")
	@Size(max = 25, message = "Le titre ne doit pas dépasser 25 caractères.")
	private String titre;

	@NotNull(message = "La catégorie est obligatoire")
	private String categorieOuvrage;

	private List<DemandeEmprunt> demandeEmprunts = new ArrayList<>();

	public Ouvrage() {
	}

	public Ouvrage(Integer id, String auteur, Date dateparution, Integer idproprietaire, String titre,
			String categorieOuvrage) {
		this.id = id;
		this.auteur = auteur;
		this.dateparution = dateparution;
		this.idproprietaire = idproprietaire;
		this.titre = titre;
		this.categorieOuvrage = categorieOuvrage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Date getDateparution() {
		return dateparution;
	}

	public void setDateparution(Date dateparution) {
		this.dateparution = dateparution;
	}

	public Integer getIdproprietaire() {
		return idproprietaire;
	}

	public void setIdproprietaire(Integer idproprietaire) {
		this.idproprietaire = idproprietaire;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getCategorieOuvrage() {
		return categorieOuvrage;
	}

	public void setCategorieOuvrage(String categorieOuvrage) {
		this.categorieOuvrage = categorieOuvrage;
	}

	public List<DemandeEmprunt> getDemandeEmprunts() {
		return demandeEmprunts;
	}

	public void setDemandeEmprunts(List<DemandeEmprunt> demandeEmprunts) {
		this.demandeEmprunts = demandeEmprunts;
	}

}
