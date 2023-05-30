package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoOuvrage implements Serializable {

	private int id;
	private String titre;
	private String auteur;
	private Integer dateParution;
	private Integer idproprietaire;
	private Integer idcategorie;
	
	public DtoOuvrage() {
		super();
	}
	
	public DtoOuvrage(int id,String titre,String auteur,Integer dateParution,Integer dtoCategorie,Integer proprietaire) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.setDateParution(dateParution);
		this.idcategorie = dtoCategorie;
		this.idproprietaire = proprietaire;
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
	public Integer getCategorie() {
		return idcategorie;
	}
	public void setCategorie(Integer categorie) {
		this.idcategorie = categorie;
	}

	public Integer getDateParution() {
		return dateParution;
	}

	public void setDateParution(Integer dateParution) {
		this.dateParution = dateParution;
	}

	public Integer getProprietaire() {
		return idproprietaire;
	}

	public void setProprietaire(Integer proprietaire) {
		this.idproprietaire = proprietaire;
	}
}
