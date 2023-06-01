package projet.ejb.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoDemandeEmprunt;
import projet.commun.dto.DtoOuvrage;
import projet.ejb.data.Compte;
import projet.ejb.data.DemandeEmprunt;
import projet.ejb.data.Ouvrage;

 
@Mapper( componentModel = "cdi" )
public interface IMapperEjb {  
	
	static final IMapperEjb INSTANCE = Mappers.getMapper( IMapperEjb.class );
	
	
	// Compte
	
	Compte map( DtoCompte source );
	
	DtoCompte map( Compte source );

	Ouvrage map(DtoOuvrage dtoOuvrage);

	DtoOuvrage map(Ouvrage ouvrage);

	DemandeEmprunt map(DtoDemandeEmprunt dtoDemandeEmprunt);

	DtoDemandeEmprunt map(DemandeEmprunt retrouver);
	
	
	
}
