package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the demande_amis database table.
 * 
 */
@Entity
@Table(name="demande_amis")
@NamedQuery(name="DemandeAmi.findAll", query="SELECT d FROM DemandeAmi d")
public class DemandeAmi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iddemandeamis;

	@Temporal(TemporalType.DATE)
	private Date datedemande;

	private Integer idenvoyeur;

	private Integer idreceveur;

	private String statut;

	public DemandeAmi() {
	}

	public Integer getIddemandeamis() {
		return this.iddemandeamis;
	}

	public void setIddemandeamis(Integer iddemandeamis) {
		this.iddemandeamis = iddemandeamis;
	}

	public Date getDatedemande() {
		return this.datedemande;
	}

	public void setDatedemande(Date datedemande) {
		this.datedemande = datedemande;
	}

	public Integer getIdenvoyeur() {
		return this.idenvoyeur;
	}

	public void setIdenvoyeur(Integer idenvoyeur) {
		this.idenvoyeur = idenvoyeur;
	}

	public Integer getIdreceveur() {
		return this.idreceveur;
	}

	public void setIdreceveur(Integer idreceveur) {
		this.idreceveur = idreceveur;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

}