package projet.ejb.dao;

import java.util.List;

import projet.commun.dto.DtoDemandeEmprunt;
import projet.ejb.data.Compte;
import projet.ejb.data.DemandeEmprunt;
import projet.ejb.data.Ouvrage;

public interface IDaoDemandeEmprunt {
	int			inserer( DemandeEmprunt demandeEmprunt );

	void 		modifier( DemandeEmprunt demandeEmprunt );

	void 		supprimer( int idDemandeEmprunt );

	DemandeEmprunt		retrouver( int idDemandeEmprunt );

	List<DemandeEmprunt> listerTout();

	DtoDemandeEmprunt getEmpruntFromOuvrage(Ouvrage ouvrage, Compte compteActif);
}
