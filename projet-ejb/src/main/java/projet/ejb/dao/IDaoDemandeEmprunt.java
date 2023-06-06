package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Compte;
import projet.ejb.data.DemandeAmi;
import projet.ejb.data.DemandeEmprunt;

public interface IDaoDemandeEmprunt {
	int			inserer( DemandeEmprunt demandeEmprunt );

	void 		modifier( DemandeEmprunt demandeEmprunt );

	void 		supprimer( int idDemandeEmprunt );

	DemandeEmprunt		retrouver( int idDemandeEmprunt );

	List<DemandeEmprunt> listerTout();
	
	List<DemandeEmprunt> listerDemandeEmpruntRecu(Compte idCompte);

	boolean verifierUniciteDemandeEmprunt(DemandeEmprunt demandeEmprunt);

	List<DemandeEmprunt> listerEmpruntes(Compte map);
	
	List<DemandeEmprunt> listerDemandeEnvoye(Compte idCompte);
}
