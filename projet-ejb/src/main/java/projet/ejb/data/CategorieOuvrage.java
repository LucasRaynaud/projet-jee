package projet.ejb.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="categorie_ouvrage")
@NamedQuery(name="CategorieOuvrage.findAll", query="SELECT c FROM CategorieOuvrage c")
public class CategorieOuvrage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column( name = "idouvrage")
	private Integer idouvrage;
	
	@Column( name = "categorie")
	private String categorie;

	//bi-directional one-to-one association to Ouvrage
	@OneToOne
	@JoinColumn(name="idouvrage")
	private Ouvrage ouvrage;

	public CategorieOuvrage() {
	}

	public Integer getIdouvrage() {
		return this.idouvrage;
	}

	public void setIdouvrage(Integer idouvrage) {
		this.idouvrage = idouvrage;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Ouvrage getOuvrage() {
		return this.ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

}