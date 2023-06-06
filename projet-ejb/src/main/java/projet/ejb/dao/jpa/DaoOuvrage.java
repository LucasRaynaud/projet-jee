package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.commun.dto.DtoCompte;
import projet.ejb.dao.IDaoOuvrage;
import projet.ejb.data.Ouvrage;

@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoOuvrage implements IDaoOuvrage{
	
	@PersistenceContext
	private EntityManager	em;

	@Override
	public int inserer(Ouvrage ouvrage) {
		em.merge(ouvrage);
		em.flush();
		return ouvrage.getId();
	}

	@Override
	public void modifier(Ouvrage ouvrage) {
		em.merge(ouvrage);
	}

	@Override
	public void supprimer(int idOuvrage) {
		em.remove(retrouver(idOuvrage));
	}

	@Override
	public Ouvrage retrouver(int idOuvrage) {
		return em.find(Ouvrage.class, idOuvrage);
	}

	@Override
	public List<Ouvrage> listerTout() {
		em.clear();
		var jpql = "SELECT o FROM Ouvrage o ORDER BY o.titre";
		var query = em.createQuery(jpql,Ouvrage.class);
		return query.getResultList();
	}

	@Override
	public List<Ouvrage> listerOuvragesEmpruntes(DtoCompte map) {
		em.clear();
		var jpql = "SELECT e FROM DemandeEmprunt WHERE emprunteur=:emprunteur";
		var query = em.createQuery(jpql,Ouvrage.class);
		query.setParameter("emprunteur", map);
		return query.getResultList();
	}

}
