package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoCategorie implements Serializable{

	private int id;
	private CategorieOuvrage categorie;
	
	public DtoCategorie() {
		super();
	}
	
	public DtoCategorie(int id, CategorieOuvrage categorie) {
		super();
		this.id = id;
		this.categorie = categorie;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CategorieOuvrage getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieOuvrage categorie) {
		this.categorie = categorie;
	}
}
