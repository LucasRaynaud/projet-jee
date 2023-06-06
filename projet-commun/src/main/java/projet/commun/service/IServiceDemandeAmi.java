package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoDemandeAmi;
import projet.commun.exception.ExceptionValidation;

public interface IServiceDemandeAmi {
	
	int				inserer( DtoDemandeAmi dtoDemandeAmi ) throws ExceptionValidation;

	void			modifier( DtoDemandeAmi dtoDemandeAmi ) throws ExceptionValidation; 

	void			supprimer( int idDemandeAmi ) throws ExceptionValidation;

	DtoDemandeAmi 		retrouver( int idDemandeAmi ) ;

	List<DtoDemandeAmi>	listerTout() ;
	
	List<DtoDemandeAmi> listerDemandeAmiRecu(DtoCompte idCompte);

	List<DtoDemandeAmi> listerAmis(DtoCompte map);

	List<DtoDemandeAmi> listerDemandeEnvoye(DtoCompte map);
}
