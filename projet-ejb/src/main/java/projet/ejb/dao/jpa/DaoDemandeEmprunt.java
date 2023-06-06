package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoDemandeEmprunt;
import projet.ejb.data.DemandeEmprunt;

@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoDemandeEmprunt implements IDaoDemandeEmprunt{
	
	@PersistenceContext
	private EntityManager	em;

	@Override
	public int inserer(DemandeEmprunt demandeEmprunt) {
		em.persist(demandeEmprunt);
		em.flush();
		return demandeEmprunt.getId();
	}

	@Override
	public void modifier(DemandeEmprunt demandeEmprunt) {
		em.merge(demandeEmprunt);
	}

	@Override
	public void supprimer(int idDemandeEmprunt) {
		em.remove(retrouver(idDemandeEmprunt));
	}

	@Override
	public DemandeEmprunt retrouver(int idDemandeEmprunt) {
		return em.find(DemandeEmprunt.class, idDemandeEmprunt);
	}

	@Override
	public List<DemandeEmprunt> listerTout() {
		em.clear();
		var jpql = "SELECT o FROM DemandeEmprunt";
		var query = em.createQuery(jpql,DemandeEmprunt.class);
		return query.getResultList();
	}

}
