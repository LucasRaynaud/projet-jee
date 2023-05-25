package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the demande_emprunt database table.
 * 
 */
@Entity
@Table(name="demande_emprunt")
@NamedQuery(name="DemandeEmprunt.findAll", query="SELECT d FROM DemandeEmprunt d")
public class DemandeEmprunt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iddemandeemprunt;

	@Temporal(TemporalType.DATE)
	private Date dateemprunt;

	private String statut;

	//bi-directional many-to-one association to Compte
	@ManyToOne
	@JoinColumn(name="idemprunteur")
	private Compte compte1;

	//bi-directional many-to-one association to Compte
	@ManyToOne
	@JoinColumn(name="idproprietaire")
	private Compte compte2;

	//bi-directional many-to-one association to Ouvrage
	@ManyToOne
	@JoinColumn(name="idouvrage")
	private Ouvrage ouvrage;

	public DemandeEmprunt() {
	}

	public Integer getIddemandeemprunt() {
		return this.iddemandeemprunt;
	}

	public void setIddemandeemprunt(Integer iddemandeemprunt) {
		this.iddemandeemprunt = iddemandeemprunt;
	}

	public Date getDateemprunt() {
		return this.dateemprunt;
	}

	public void setDateemprunt(Date dateemprunt) {
		this.dateemprunt = dateemprunt;
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

	public Ouvrage getOuvrage() {
		return this.ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

}