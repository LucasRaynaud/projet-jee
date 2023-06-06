package projet.ejb.service.standard;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoDemandeAmi;
import projet.commun.dto.DtoDemandeEmprunt;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceDemandeAmi;
import projet.commun.service.IServiceDemandeEmprunt;
import projet.ejb.dao.IDaoCompte;
import projet.ejb.dao.IDaoDemandeAmi;
import projet.ejb.dao.IDaoDemandeEmprunt;
import projet.ejb.data.Compte;
import projet.ejb.data.DemandeEmprunt;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceDemandeEmprunt implements IServiceDemandeEmprunt{
	
	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoDemandeEmprunt daoDemandeEmprunt;
	

	// Actions

	
	@Override
	public int inserer(DtoDemandeEmprunt dtoDemandeEmprunt) throws ExceptionValidation {
		int id = daoDemandeEmprunt.inserer(mapper.map(dtoDemandeEmprunt));
		return id;
	}

	@Override
	public void modifier(DtoDemandeEmprunt dtoDemandeEmprunt) throws ExceptionValidation {
		daoDemandeEmprunt.modifier(mapper.map(dtoDemandeEmprunt));
		
	}

	@Override
	public void supprimer(int idDemandeEmprunt) throws ExceptionValidation {
		daoDemandeEmprunt.supprimer(idDemandeEmprunt);
	}

	@Override
	public DtoDemandeEmprunt retrouver(int idDemandeAmi) {
		return mapper.map(daoDemandeEmprunt.retrouver(idDemandeAmi));
	}

	@Override
	public List<DtoDemandeEmprunt> listerTout() {
		
		List<DtoDemandeEmprunt> liste = new ArrayList<>();
		for (DemandeEmprunt compte : daoDemandeEmprunt.listerTout()) {
			liste.add(mapper.map(compte));
		}
		return liste;
	}
	
	// Méthodes auxiliaires

}
