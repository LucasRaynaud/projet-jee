package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoDemandeAmi;
import projet.ejb.data.Compte;
import projet.ejb.data.DemandeAmi;

@Stateless
@Local
@TransactionAttribute(MANDATORY)
public class DaoDemandeAmi implements IDaoDemandeAmi {

	// Champs

	@PersistenceContext
	private EntityManager em;

	// Actions

	@Override
	public int inserer(DemandeAmi demandeAmi) {
		em.merge(demandeAmi);
		em.flush();
		return demandeAmi.getId();
	}

	@Override
	public void modifier(DemandeAmi demandeAmi) {
		em.merge(demandeAmi);

	}

	@Override
	public void supprimer(int idDemandeAmi) {
		em.remove(retrouver(idDemandeAmi));

	}

	@Override
	public DemandeAmi retrouver(int idDemandeAmi) {
		return em.find(DemandeAmi.class, idDemandeAmi);
	}

	@Override
	public List<DemandeAmi> listerTout() {
		em.clear();
		var jpql = "SELECT d FROM DemandeAmi d";
		var query = em.createQuery(jpql, DemandeAmi.class);
		return query.getResultList();
	}

	@Override
	public List<DemandeAmi> listerDemandeAmiRecu(Compte idCompte) {
		em.clear();
		var jpql = "SELECT d FROM DemandeAmi d WHERE receveur=:idCompte AND statut='EN ATTENTE'";
		var query = em.createQuery(jpql, DemandeAmi.class);
		query.setParameter("idCompte", idCompte);
		return query.getResultList();
	}
	
	@Override
	public List<DemandeAmi> listerDemandeAmiEnvoye(Compte idCompte) {
		em.clear();
		var jpql = "SELECT d FROM DemandeAmi d WHERE envoyeur=:idCompte AND statut='EN ATTENTE'";
		var query = em.createQuery(jpql, DemandeAmi.class);
		query.setParameter("idCompte", idCompte);
		return query.getResultList();
	}

	@Override
	public boolean verifierUniciteDemandeAmis(DemandeAmi DemandeAmi) {
		em.clear();
		var jpql = "SELECT COUNT(d) FROM DemandeAmi d WHERE (receveur=:idReceveur1 AND envoyeur=:idEnvoyeur1) OR (receveur=:idReceveur2 AND envoyeur=:idEnvoyeur2)";
		var query = em.createQuery(jpql, Long.class);
		query.setParameter("idReceveur1", DemandeAmi.getEnvoyeur());
		query.setParameter("idEnvoyeur1", DemandeAmi.getReceveur());
		query.setParameter("idReceveur2", DemandeAmi.getReceveur());
		query.setParameter("idEnvoyeur2", DemandeAmi.getEnvoyeur());
		return query.getSingleResult() == 0;
	}

	@Override
	public List<DemandeAmi> listerAmis(Compte compte) {
		em.clear();
		var jpql = "SELECT d FROM DemandeAmi d WHERE statut='ACCEPTEE' AND (receveur=:idReceveur OR envoyeur=:idEnvoyeur)";
		var query = em.createQuery(jpql, DemandeAmi.class);
		query.setParameter("idReceveur", compte);
		query.setParameter("idEnvoyeur", compte);
		return query.getResultList();
	}
}
