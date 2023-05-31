package projet.ejb.dao.jpa;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.data.CategorieOuvrage;

@Stateless
@LocalBean
public class DaoCategorie {
	
	@PersistenceContext
	private EntityManager em;
	
	public int inserer(CategorieOuvrage categorie) {
		em.persist(categorie);
		em.flush();
		return categorie.getIdouvrage();
	}

	public void modifier(CategorieOuvrage categorie) {
		em.merge(categorie);
	}

	public void supprimer(int idCategorie) {
		em.remove(em.getReference(CategorieOuvrage.class, idCategorie));
	}

	public CategorieOuvrage retrouver(int idCategorie) {
		return em.find(CategorieOuvrage.class, idCategorie);
	}

	public List<CategorieOuvrage> listerTout() {
		var jpql = "SELECT u FROM Categorie_Ouvrage u ORDER BY U.categorie";
		var query = em.createQuery(jpql, CategorieOuvrage.class);
		return query.getResultList();
	}

}
