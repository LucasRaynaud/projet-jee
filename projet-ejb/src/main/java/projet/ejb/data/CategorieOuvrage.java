package projet.ejb.data;

<<<<<<< HEAD
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the categorie_ouvrage database table.
 * 
 */
@Entity
@Table(name="categorie_ouvrage")
@NamedQuery(name="CategorieOuvrage.findAll", query="SELECT c FROM CategorieOuvrage c")
public class CategorieOuvrage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idouvrage;

=======
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the categorie_ouvrage database table.
 * 
 */
@Entity
@Table(name="categorie_ouvrage")
@NamedQuery(name="CategorieOuvrage.findAll", query="SELECT c FROM CategorieOuvrage c")
public class CategorieOuvrage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = IDENTITY)
	@Column( name = "idouvrage")
	private Integer idouvrage;
	
	@Column( name = "categorie")
>>>>>>> refs/remotes/GitHub/master
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