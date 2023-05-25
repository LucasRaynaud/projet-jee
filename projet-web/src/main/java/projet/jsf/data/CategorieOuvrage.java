package projet.jsf.data;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class CategorieOuvrage implements Serializable {

	private Integer id;

	@NotBlank(message = "La catégorie doit avoir un nom")
	@Size(max = 25, message = "Le nom de la catégorie ne doit pas dépasser 25 caractères")
	private String categorie;

	public CategorieOuvrage() {
		super();
	}

	public CategorieOuvrage(Integer id, String categorie) {
		super();
		this.id = id;
		this.categorie = categorie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

}
