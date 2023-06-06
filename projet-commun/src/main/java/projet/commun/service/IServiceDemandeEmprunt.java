package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoDemandeEmprunt;
import projet.commun.dto.DtoOuvrage;
import projet.commun.exception.ExceptionValidation;

public interface IServiceDemandeEmprunt {
	
	int				inserer( DtoDemandeEmprunt dtoDemandeEmprunt ) throws ExceptionValidation;

	void			modifier( DtoDemandeEmprunt dtoDemandeEmprunt ) throws ExceptionValidation; 

	void			supprimer( int idDemandeEmprunt ) throws ExceptionValidation;

	DtoDemandeEmprunt 		retrouver( int idDemandeEmprunt ) ;

	List<DtoDemandeEmprunt>	listerTout() ;

	DtoDemandeEmprunt getEmpruntFromOuvrage(DtoOuvrage ouvrage, DtoCompte compteActif);
}
