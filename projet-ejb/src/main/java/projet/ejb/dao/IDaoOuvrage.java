package projet.ejb.dao;

import java.util.List;

import projet.commun.dto.DtoCompte;
import projet.ejb.data.Compte;
import projet.ejb.data.Ouvrage;

public interface IDaoOuvrage {

	int			inserer( Ouvrage ouvrage);

	void 		modifier( Ouvrage ouvrage );

	void 		supprimer( int idOuvrage );

	Ouvrage 	retrouver( int idOuvrage );

	List<Ouvrage> listerTout();

	List<Ouvrage> listerOuvragesEmpruntes(Compte map);

	List<Ouvrage> listerTout(Compte compte);

	List<Ouvrage> listerToutUser(Compte compte);
	
}
