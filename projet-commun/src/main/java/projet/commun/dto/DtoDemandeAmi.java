package projet.commun.dto;

import java.io.Serializable;
import java.util.Date;


@SuppressWarnings("serial")
public class DtoDemandeAmi implements Serializable  {

	
	// Champs
	
	private int			id;
	
	private Date 		datedemande;
	
	private DtoCompte 	envoyeur;
	
	private DtoCompte 	receveur;
	
	private String 		statut;
	
	
	
	// Constructeurs
	
	public DtoDemandeAmi() {
	}

	public DtoDemandeAmi(int id, Date datedemande, DtoCompte idenvoyeur, DtoCompte idreceveur, String statut ) {
		this.id = id;
		this.datedemande = datedemande;
		this.envoyeur = idenvoyeur;
		this.receveur = idreceveur;
		this.statut = statut;
	}
	

	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDemande() {
		return datedemande;
	}

	public void setDateDemande(Date datedemande) {
		this.datedemande = datedemande;
	}

	public DtoCompte getEnvoyeur() {
		return envoyeur;
	}

	public void setEnvoyeur(DtoCompte idenvoyeur) {
		this.envoyeur = idenvoyeur;
	}

	public DtoCompte getReceveur() {
		return receveur;
	}

	public void setReceveur(DtoCompte idreceveur) {
		this.receveur = idreceveur;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
}
