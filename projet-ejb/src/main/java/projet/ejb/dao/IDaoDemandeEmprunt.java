package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.DemandeEmprunt;

public interface IDaoDemandeEmprunt {
	int			inserer( DemandeEmprunt demandeEmprunt );

	void 		modifier( DemandeEmprunt demandeEmprunt );

	void 		supprimer( int idDemandeEmprunt );

	DemandeEmprunt		retrouver( int idDemandeEmprunt );

	List<DemandeEmprunt> listerTout();
}
