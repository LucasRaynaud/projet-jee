package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoOuvrage implements Serializable {

	private int id;
	private String titre;
	private String auteur;
	private Integer dateParution;
	private DtoCompte proprietaire;
	private DtoCategorie categorie;
	
	public DtoOuvrage() {
		super();
	}
	
	public DtoOuvrage(int id,String titre,String auteur,Integer dateParution,DtoCategorie categorie,DtoCompte proprietaire) {
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
	public DtoCategorie getCategorie() {
		return categorie;
	}
	public void setCategorie(DtoCategorie categorie) {
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
}
