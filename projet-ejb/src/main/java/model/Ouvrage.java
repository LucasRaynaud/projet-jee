package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ouvrage database table.
 * 
 */
@Entity
@NamedQuery(name="Ouvrage.findAll", query="SELECT o FROM Ouvrage o")
public class Ouvrage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String auteur;
	
	private Integer dateParution;

	private String titre;

	private String categorie;

	//bi-directional many-to-one association to DemandeEmprunt
	@OneToMany(mappedBy="ouvrage")
	private List<DemandeEmprunt> demandeEmprunts;

	@OneToOne
	@JoinColumn(name="idproprietaire")
	private Compte proprietaire;

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

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorieOuvrage) {
		this.categorie = categorieOuvrage;
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

	public Compte getProprietaire() {
		return this.proprietaire;
	}

	public void setProprietaire(Compte compte) {
		this.proprietaire = compte;
	}

}