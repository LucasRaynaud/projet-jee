package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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
	private Integer id;

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

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer idouvrage) {
		this.id = idouvrage;
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

	@Override
	public String toString() {
		return "Ouvrage [id=" + id + ", auteur=" + auteur + ", dateParution=" + dateParution + ", proprietaire="
				+ proprietaire + ", titre=" + titre + ", categorie=" + categorie + ", demandeEmprunts="
				+ demandeEmprunts + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ouvrage other = (Ouvrage) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}