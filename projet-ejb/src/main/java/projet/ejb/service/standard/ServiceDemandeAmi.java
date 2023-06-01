package projet.ejb.service.standard;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import projet.commun.dto.DtoDemandeAmi;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceDemandeAmi;
import projet.ejb.dao.IDaoDemandeAmi;
import projet.ejb.data.DemandeAmi;
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
		dtoDemandeAmi.setStatut("EN ATTENTE");
		dtoDemandeAmi.setDateDemande(new Date());
		return daoDemandeAmi.inserer(mapper.map(dtoDemandeAmi));
	}

	@Override
	public void modifier(DtoDemandeAmi dtoDemandeAmi) throws ExceptionValidation {
		daoDemandeAmi.modifier(mapper.map(dtoDemandeAmi));
		
	}

	@Override
	public void supprimer(int idDemandeAmi) throws ExceptionValidation {
		daoDemandeAmi.supprimer(idDemandeAmi);
	}

	@Override
	public DtoDemandeAmi retrouver(int idDemandeAmi) {
		 return mapper.map(daoDemandeAmi.retrouver(idDemandeAmi));
	}

	@Override
	public List<DtoDemandeAmi> listerTout() {
		
		List<DtoDemandeAmi> liste = new ArrayList<>();
		for (DemandeAmi compte : daoDemandeAmi.listerTout()) {
			liste.add(mapper.map(compte));
		}
		return liste;
	}
	
	// Méthodes auxiliaires
	
	@Override
	public List<DtoDemandeAmi> listerDemandeAmiCompte(int idCompte) {
		List<DtoDemandeAmi> liste = new ArrayList<>();
		for (DemandeAmi compte : daoDemandeAmi.listerDemandeAmiCompte(idCompte)) {
			liste.add(mapper.map(compte));
		}
		return liste;
	}

}
