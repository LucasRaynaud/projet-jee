package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoCategorie implements Serializable{

	private int id;
	private String categorie;
	
	public DtoCategorie() {
		super();
	}
	
	public DtoCategorie(int id, String categorie) {
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
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
}
