package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the ouvrage database table.
 * 
 */
@Entity
@NamedQuery(name = "Ouvrage.findAll", query = "SELECT o FROM Ouvrage o")
@Table(name = "ouvrage")
public class Ouvrage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idouvrage")
	private Integer idouvrage;

	// @NotBlank( message = "Le Nom de l'auteur doit etre renseigné")
	@Column(name = "auteur")
	private String auteur;

	@Column(name = "dateparution")
	private Integer dateParution;

	@JoinColumn(name = "idproprietaire")
	@OneToOne
	private Compte proprietaire;

	@Column(name = "titre")
	private String titre;

	// bi-directional one-to-one association to CategorieOuvrage
	@Column(name = "categorie")
	private String categorie;

	// bi-directional many-to-one association to DemandeEmprunt
	@OneToMany(mappedBy = "ouvrage")
	private List<DemandeEmprunt> demandeEmprunts;

	public Ouvrage() {
	}

	public Integer getIdouvrage() {
		return this.idouvrage;
	}

	public void setIdouvrage(Integer idouvrage) {
		this.idouvrage = idouvrage;
	}

	public String getAuteur() {
		return this.auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Integer getDateParution() {
		return this.dateParution;
	}

	public void setDateParution(Integer dateparution) {
		this.dateParution = dateparution;
	}

	public Compte getProprietaire() {
		return this.proprietaire;
	}

	public void setProprietaire(Compte idproprietaire) {
		this.proprietaire = idproprietaire;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<DemandeEmprunt> getDemandeEmprunts() {
		return this.demandeEmprunts;
	}

	public void setDemandeEmprunts(List<DemandeEmprunt> demandeEmprunts) {
		this.demandeEmprunts = demandeEmprunts;
	}

	public DemandeEmprunt addDemandeEmprunt(DemandeEmprunt demandeEmprunt) {
		getDemandeEmprunts().add(demandeEmprunt);
		demandeEmprunt.setOuvrage(this);

		return demandeEmprunt;
	}

	public DemandeEmprunt removeDemandeEmprunt(DemandeEmprunt demandeEmprunt) {
		getDemandeEmprunts().remove(demandeEmprunt);
		demandeEmprunt.setOuvrage(null);

		return demandeEmprunt;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorieOuvrage) {
		this.categorie = categorieOuvrage;
	}
	

}