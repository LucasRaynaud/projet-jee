package model;

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

	private String statut;

	//bi-directional many-to-one association to Compte
	@ManyToOne
	@JoinColumn(name="idenvoyeur")
	private Compte compte1;

	//bi-directional many-to-one association to Compte
	@ManyToOne
	@JoinColumn(name="idreceveur")
	private Compte compte2;

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

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Compte getCompte1() {
		return this.compte1;
	}

	public void setCompte1(Compte compte1) {
		this.compte1 = compte1;
	}

	public Compte getCompte2() {
		return this.compte2;
	}

	public void setCompte2(Compte compte2) {
		this.compte2 = compte2;
	}

}