package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.commun.dto.DtoDemandeEmprunt;
import projet.ejb.dao.IDaoDemandeEmprunt;
import projet.ejb.data.Compte;
import projet.ejb.data.DemandeEmprunt;
import projet.ejb.data.Ouvrage;

@Stateless
@Local
@TransactionAttribute(MANDATORY)
public class DaoDemandeEmprunt implements IDaoDemandeEmprunt {

	@PersistenceContext
	private EntityManager em;

	@Override
	public int inserer(DemandeEmprunt demandeEmprunt) {
		em.merge(demandeEmprunt);
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
		var jpql = "SELECT d FROM DemandeEmprunt d";
		var query = em.createQuery(jpql, DemandeEmprunt.class);
		return query.getResultList();
	}

	@Override
	public List<DemandeEmprunt> listerDemandeEmpruntRecu(Compte idCompte) {
		em.clear();
		var jpql = "SELECT d FROM DemandeEmprunt d JOIN Ouvrage o ON d.ouvrage = o.id WHERE o.proprietaire=:idCompte AND statut='EN ATTENTE'";
		var query = em.createQuery(jpql, DemandeEmprunt.class);
		query.setParameter("idCompte", idCompte);
		return query.getResultList();
	}

	@Override
	public boolean verifierUniciteDemandeEmprunt(DemandeEmprunt demandeEmprunt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DemandeEmprunt> listerEmpruntes(Compte map) {
		em.clear();
		var jpql = "SELECT d FROM DemandeEmprunt d WHERE statut='ACCEPTEE' AND (receveur=:idReceveur OR envoyeur=:idEnvoyeur)";
		var query = em.createQuery(jpql, DemandeEmprunt.class);
		query.setParameter("idReceveur", map);
		query.setParameter("idEnvoyeur", map);
		return query.getResultList();
	}

	@Override
	public List<DemandeEmprunt> listerDemandeEnvoye(Compte idCompte) {
		em.clear();
		var jpql = "SELECT d FROM DemandeEmprunt d WHERE emprunteur=:idCompte AND statut='EN ATTENTE'";
		var query = em.createQuery(jpql, DemandeEmprunt.class);
		query.setParameter("idCompte", idCompte);
		return query.getResultList();
	}

	public DtoDemandeEmprunt getEmpruntFromOuvrage(Ouvrage ouvrage, Compte compteActif) {
		em.clear();
		var jpql = "SELECT o FROM DemandeEmprunt d " + "JOIN Ouvrage o ON d.proprietaire=o.proprietaire "
				+ "WHERE o.proprietaire=:compteActif AND o.id=:ouvrage AND statut='ACCEPTEE'";
		var query = em.createQuery(jpql, DtoDemandeEmprunt.class);
		query.setParameter("compteActif", compteActif);
		query.setParameter("ouvrage", ouvrage);
		return query.getSingleResult();
	}

}
