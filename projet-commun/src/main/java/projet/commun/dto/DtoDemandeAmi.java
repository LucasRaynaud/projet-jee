package projet.commun.dto;

import java.io.Serializable;
import java.util.Date;


@SuppressWarnings("serial")
public class DtoDemandeAmi implements Serializable  {

	
	// Champs
	
	private int			id;
	
	private Date 		datedemande;
	
	private DtoCompte 	idenvoyeur;
	
	private DtoCompte 	idreceveur;
	
	private String 		statut;
	
	
	
	// Constructeurs
	
	public DtoDemandeAmi() {
	}

	public DtoDemandeAmi(int id, Date datedemande, DtoCompte idenvoyeur, DtoCompte idreceveur, String statut ) {
		this.id = id;
		this.datedemande = datedemande;
		this.idenvoyeur = idenvoyeur;
		this.idreceveur = idreceveur;
		this.statut = statut;
	}
	

	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatedemande() {
		return datedemande;
	}

	public void setDatedemande(Date datedemande) {
		this.datedemande = datedemande;
	}

	public DtoCompte getIdenvoyeur() {
		return idenvoyeur;
	}

	public void setIdenvoyeur(DtoCompte idenvoyeur) {
		this.idenvoyeur = idenvoyeur;
	}

	public DtoCompte getIdreceveur() {
		return idreceveur;
	}

	public void setIdreceveur(DtoCompte idreceveur) {
		this.idreceveur = idreceveur;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
}
