package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoDemandeAmi;
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
	public List<DemandeAmi> listerDemandeAmiCompte(int idCompte) {
		em.clear();
		var jpql = "SELECT d FROM DemandeAmi d WHERE idreceveur:=idCompte ";
		var query = em.createQuery(jpql, DemandeAmi.class);
		query.setParameter("idCompte", idCompte);
		return query.getResultList();
	}

}
