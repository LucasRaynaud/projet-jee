package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.DemandeAmi;

public interface IDaoDemandeAmi {
	int			inserer( DemandeAmi demandeAmi );

	void 		modifier( DemandeAmi demandeAmi );

	void 		supprimer( int idDemandeAmi );

	DemandeAmi 		retrouver( int idDemandeAmi );

	List<DemandeAmi> listerTout();

	List<DemandeAmi> listerDemandeAmiCompte(int idCompte);
}
