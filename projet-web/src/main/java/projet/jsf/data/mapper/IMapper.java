package projet.jsf.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoDemandeEmprunt;
import projet.commun.dto.DtoOuvrage;
import projet.jsf.data.Compte;
import projet.jsf.data.DemandeEmprunt;
import projet.jsf.data.Ouvrage;


@Mapper( componentModel = "cdi" )
public interface IMapper {
  

	// Compte
	
	Compte    map( DtoCompte source );
	
	DtoCompte map( Compte source );
	
	Compte duplicate( Compte source );

	Compte update( @MappingTarget Compte target, Compte source );

	Ouvrage map(DtoOuvrage dtoOuvrage);

	DtoOuvrage map(Ouvrage courant);

	DemandeEmprunt map(DtoDemandeEmprunt dtoDemandeEmprunt);

	DtoDemandeEmprunt map(DemandeEmprunt courant);

}
