package projet.ejb.service.standard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoDemandeEmprunt;
import projet.commun.dto.DtoOuvrage;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceDemandeEmprunt;
import projet.ejb.dao.IDaoDemandeEmprunt;
import projet.ejb.data.DemandeEmprunt;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceDemandeEmprunt implements IServiceDemandeEmprunt {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoDemandeEmprunt daoDemandeEmprunt;

	// Actions

	@Override
	public int inserer(DtoDemandeEmprunt dtoDemandeEmprunt) throws ExceptionValidation {
		dtoDemandeEmprunt.setStatut("EN ATTENTE");
		dtoDemandeEmprunt.setDateemprunt(new Date());

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

	@Override
	public DtoDemandeEmprunt getEmpruntFromOuvrage(DtoOuvrage ouvrage, DtoCompte compteActif) {
		return daoDemandeEmprunt.getEmpruntFromOuvrage(mapper.map(ouvrage), mapper.map(compteActif));
	}

	// Méthodes auxiliaires

	@Override
	public List<DtoDemandeEmprunt> listerDemandeEmpruntRecu(DtoCompte DtoCompte) {
		List<DtoDemandeEmprunt> liste = new ArrayList<>();
		for (DemandeEmprunt compte : daoDemandeEmprunt.listerDemandeEmpruntRecu(mapper.map(DtoCompte))) {
			liste.add(mapper.map(compte));
		}
		return liste;
	}

	@Override
	public List<DtoDemandeEmprunt> listerDemandeEnvoye(DtoCompte DtoCompte) {
		List<DtoDemandeEmprunt> liste = new ArrayList<>();
		for (DemandeEmprunt compte : daoDemandeEmprunt.listerDemandeEnvoye(mapper.map(DtoCompte))) {
			liste.add(mapper.map(compte));
		}
		return liste;
	}

	@Override
	public List<DtoDemandeEmprunt> listerEmpruntes(DtoCompte dtoCompte) {
		List<DtoDemandeEmprunt> liste = new ArrayList<>();
		for (DemandeEmprunt compte : daoDemandeEmprunt.listerEmpruntes(mapper.map(dtoCompte))) {
			liste.add(mapper.map(compte));
		}
		return liste;
	}

	private void verifierUniciteDemandeEmprunt(DtoDemandeEmprunt dtoDemandeEmprunt) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (!daoDemandeEmprunt.verifierUniciteDemandeEmprunt(mapper.map(dtoDemandeEmprunt))) {
			message.append("\nUne demande d'emprunt existe déja");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
