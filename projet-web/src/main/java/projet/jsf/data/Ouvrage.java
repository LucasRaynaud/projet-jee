package projet.jsf.data;

import java.io.Serializable;
import java.util.ArrayList;
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

	private Integer dateParution;

	@NotNull(message = "L'ouvrage doit avoir un propriétaire")
	private Compte proprietaire;

	@NotBlank(message = "Le titre doit être renseigné.")
	@Size(max = 25, message = "Le titre ne doit pas dépasser 25 caractères.")
	private String titre;

	@NotBlank(message = "La catégorie est obligatoire")
	private String categorie;

	private List<DemandeEmprunt> demandeEmprunts = new ArrayList<>();

	public Ouvrage() {
	}

	public Ouvrage(Integer id, String auteur, Integer dateparution, Compte proprietaire, String titre,
			String categorieOuvrage) {
		this.id = id;
		this.auteur = auteur;
		this.dateParution = dateparution;
		this.proprietaire = proprietaire;
		this.titre = titre;
		this.categorie = categorieOuvrage;
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

	public Integer getDateParution() {
		return dateParution;
	}

	public void setDateParution(Integer dateparution) {
		this.dateParution = dateparution;
	}

	public Compte getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Compte idproprietaire) {
		this.proprietaire = idproprietaire;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorieOuvrage) {
		this.categorie = categorieOuvrage;
	}

	public List<DemandeEmprunt> getDemandeEmprunts() {
		return demandeEmprunts;
	}

	public void setDemandeEmprunts(List<DemandeEmprunt> demandeEmprunts) {
		this.demandeEmprunts = demandeEmprunts;
	}

}
