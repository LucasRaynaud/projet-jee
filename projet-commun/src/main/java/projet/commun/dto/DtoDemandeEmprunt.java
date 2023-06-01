package projet.commun.dto;

import java.io.Serializable;
import java.util.Date;



@SuppressWarnings("serial")
public class DtoDemandeEmprunt implements Serializable  {

	
	// Champs
	
	private int			id;
	
	private Date 		dateemprunt;
	
	private DtoCompte 	emprunteur;
	
	private String 		statut;
	
	private DtoOuvrage ouvrage;
	
	
	
	// Constructeurs
	
	public DtoDemandeEmprunt() {
	}

	public DtoDemandeEmprunt(int id, Date datedemande, DtoCompte emprunteur, String statut ) {
		this.id = id;
		this.dateemprunt = datedemande;
		this.emprunteur = emprunteur;
		this.statut = statut;
	}
	

	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateemprunt() {
		return dateemprunt;
	}

	public void setDateemprunt(Date dateemprunt) {
		this.dateemprunt = dateemprunt;
	}

	public DtoCompte getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(DtoCompte emprunteur) {
		this.emprunteur = emprunteur;
	}

	public DtoOuvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(DtoOuvrage ouvrage) {
		this.ouvrage = ouvrage;
	}
	
	
}
