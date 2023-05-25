package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
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
	private Integer idouvrage;

	private String auteur;

	@Temporal(TemporalType.DATE)
	private Date dateparution;

	private Integer idproprietaire;

	private String titre;

	//bi-directional one-to-one association to CategorieOuvrage
	@OneToOne(mappedBy="ouvrage")
	private CategorieOuvrage categorieOuvrage;

	//bi-directional many-to-one association to DemandeEmprunt
	@OneToMany(mappedBy="ouvrage")
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

	public Date getDateparution() {
		return this.dateparution;
	}

	public void setDateparution(Date dateparution) {
		this.dateparution = dateparution;
	}

	public Integer getIdproprietaire() {
		return this.idproprietaire;
	}

	public void setIdproprietaire(Integer idproprietaire) {
		this.idproprietaire = idproprietaire;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public CategorieOuvrage getCategorieOuvrage() {
		return this.categorieOuvrage;
	}

	public void setCategorieOuvrage(CategorieOuvrage categorieOuvrage) {
		this.categorieOuvrage = categorieOuvrage;
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

}