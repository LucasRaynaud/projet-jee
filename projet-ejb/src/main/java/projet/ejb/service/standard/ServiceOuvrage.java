package projet.ejb.service.standard;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import projet.ejb.data.Ouvrage;
import projet.ejb.data.mapper.IMapperEjb;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoOuvrage;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceOuvrage;
import projet.ejb.dao.IDaoOuvrage;

@Stateless
@Remote
public class ServiceOuvrage implements IServiceOuvrage {

	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoOuvrage daoOuvrage;

	@Override
	public int inserer(DtoOuvrage dtoOuvrage) throws ExceptionValidation {
		verifierValiditeDonnees(dtoOuvrage);
		int id = daoOuvrage.inserer(mapper.map(dtoOuvrage));
		return id;
	}

	@Override
	public void modifier(DtoOuvrage dtoOuvrage) throws ExceptionValidation {
		verifierValiditeDonnees(dtoOuvrage);
		daoOuvrage.modifier(mapper.map(dtoOuvrage));
	}

	@Override
	public void supprimer(int idOuvrage) throws ExceptionValidation {
		daoOuvrage.supprimer(idOuvrage);
	}

	@Override
	public DtoOuvrage retrouver(int idOuvrage) {
		Ouvrage ouvrage = daoOuvrage.retrouver(idOuvrage);
		return mapper.map(ouvrage);
	}

	@Override
	public List<DtoOuvrage> listerTout() {
		List<DtoOuvrage> liste = new ArrayList<>();
		for (Ouvrage ouvrage : daoOuvrage.listerTout()) {
			liste.add(mapper.map(ouvrage));
		}
		return liste;
	}
	
	@Override
	public List<DtoOuvrage> listerTout(DtoCompte compte) {
		List<DtoOuvrage> liste = new ArrayList<>();
		for (Ouvrage ouvrage : daoOuvrage.listerTout(mapper.map(compte))) {
			liste.add(mapper.map(ouvrage));
		}
		return liste;
	}
	
	@Override
	public List<DtoOuvrage> listerToutUser(DtoCompte compte) {
		List<DtoOuvrage> liste = new ArrayList<>();
		for (Ouvrage ouvrage : daoOuvrage.listerToutUser(mapper.map(compte))) {
			liste.add(mapper.map(ouvrage));
		}
		return liste;
	}
	
	@Override
	public List<DtoOuvrage> listerOuvragesEmpruntes(DtoCompte map) {
		List<DtoOuvrage> liste = new ArrayList<>();
		for (Ouvrage ouvrage : daoOuvrage.listerOuvragesEmpruntes(mapper.map(map))) {
			liste.add(mapper.map(ouvrage));
		}
		return liste;
	}

	private void verifierValiditeDonnees(DtoOuvrage dtoOuvrage) throws ExceptionValidation {
		StringBuilder message = new StringBuilder();

		if (dtoOuvrage.getAuteur() == null || dtoOuvrage.getAuteur().isEmpty()) {
			message.append("\nLe nom de l'auteur est vide.");
		} else if (dtoOuvrage.getAuteur().length() > 30) {
			message.append("\nLe nom de l'auteur ne doit pas dépasser 30 caractères.");
		}

		if (dtoOuvrage.getTitre() == null || dtoOuvrage.getTitre().isEmpty()) {
			message.append("\nLe titre de l'auteur est vide.");
		} else if (dtoOuvrage.getTitre().length() > 25) {
			message.append("\n Le titre ne doit pas dépasser 25 caractères.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
