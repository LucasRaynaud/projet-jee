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
@TransactionAttribute( MANDATORY )
public class DaoDemandeAmi implements IDaoDemandeAmi {
	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
		
		
	// Actions
		

	@Override
	public int inserer(DemandeAmi demandeAmi) {
		em.persist(demandeAmi);
		em.flush();
		return demandeAmi.getIddemandeamis();
	}

	@Override
	public void modifier(DemandeAmi demandeAmi) {
		em.merge( demandeAmi );
		
	}

	@Override
	public void supprimer(int idDemandeAmi) {
		em.remove( retrouver(idDemandeAmi) );
		
	}

	@Override
	public DemandeAmi retrouver(int idDemandeAmi) {
		return em.find( DemandeAmi.class, idDemandeAmi );
	}

	@Override
	public List<DemandeAmi> listerTout() {
		em.clear();
		var jpql = "SELECT d FROM DemandeAmi d ORDER BY d.idDemandeAmi";
		var query = em.createQuery( jpql, DemandeAmi.class );
		return query.getResultList();
	}

}
