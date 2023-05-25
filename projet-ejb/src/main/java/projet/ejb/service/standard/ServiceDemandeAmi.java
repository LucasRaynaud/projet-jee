package projet.ejb.service.standard;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoDemandeAmi;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceDemandeAmi;
import projet.ejb.dao.IDaoCompte;
import projet.ejb.dao.IDaoDemandeAmi;
import projet.ejb.data.Compte;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceDemandeAmi implements IServiceDemandeAmi{
	
	// Champs
		@Inject
		private IMapperEjb mapper;
		@Inject
		private IDaoDemandeAmi daoDemandeAmi;
	

	// Actions

	
	@Override
	public int inserer(DtoDemandeAmi dtoDemandeAmi) throws ExceptionValidation {
		//int id = dtoDemandeAmi.inserer(mapper.map(dtoDemandeAmi));
		return 0;
	}

	@Override
	public void modifier(DtoDemandeAmi dtoDemandeAmi) throws ExceptionValidation {
		//dtoDemandeAmi.modifier(mapper.map(dtoDemandeAmi));
		
	}

	@Override
	public void supprimer(int idDemandeAmi) throws ExceptionValidation {
		daoDemandeAmi.supprimer(idDemandeAmi);
	}

	@Override
	public DtoDemandeAmi retrouver(int idDemandeAmi) {
		//return mapper.map(daoDemandeAmi.retrouver(idDemandeAmi));
		return null;
	}

	@Override
	public List<DtoDemandeAmi> listerTout() {
		/*
		List<DtoDemandeAmi> liste = new ArrayList<>();
		for (Compte compte : daoDemandeAmi.listerTout()) {
			liste.add(mapper.map(compte));
		}
		return liste;*/
		return null;
	}
	
	// Méthodes auxiliaires

}
