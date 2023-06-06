package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoOuvrage implements Serializable {

	private int id;
	private String titre;
	private String auteur;
	private Integer dateParution;
	private DtoCompte proprietaire;
	private String categorie;
	
	public DtoOuvrage() {
		super();
	}
	
	public DtoOuvrage(int id,String titre,String auteur,Integer dateParution,String categorie,DtoCompte proprietaire) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.setDateParution(dateParution);
		this.categorie = categorie;
		this.proprietaire = proprietaire;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Integer getDateParution() {
		return dateParution;
	}

	public void setDateParution(Integer dateParution) {
		this.dateParution = dateParution;
	}

	public DtoCompte getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(DtoCompte proprietaire) {
		this.proprietaire = proprietaire;
	}

	@Override
	public String toString() {
		return "DtoOuvrage [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", dateParution=" + dateParution
				+ ", proprietaire=" + proprietaire + ", categorie=" + categorie + "]";
	}

}
