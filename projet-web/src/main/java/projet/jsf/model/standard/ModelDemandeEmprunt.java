package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoDemandeEmprunt;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceDemandeEmprunt;
import projet.jsf.data.DemandeEmprunt;
import projet.jsf.data.Ouvrage;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.CompteActif;
import projet.jsf.util.UtilJsf;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelDemandeEmprunt implements Serializable {

	private List<DemandeEmprunt> liste;
	private List<DemandeEmprunt> listeEnAttente;
	private List<DemandeEmprunt> listeRecu;

	private DemandeEmprunt courant;

	@Inject
	private CompteActif compteActif;

	@EJB
	private IServiceDemandeEmprunt serviceDemandeEmprunt;

	@Inject
	private IMapper mapper;

	public List<DemandeEmprunt> getListe() {
		if (liste == null) {
			liste = new ArrayList<>();
			for (DtoDemandeEmprunt dtoDemandeEmprunt : serviceDemandeEmprunt.listerTout()) {
				liste.add(mapper.map(dtoDemandeEmprunt));
			}
		}
		return liste;
	}

	public List<DemandeEmprunt> getListeEnAttente() {
		if (listeEnAttente == null) {
			listeEnAttente = new ArrayList<>();
			for (DtoDemandeEmprunt dtoDemandeEmprunt : serviceDemandeEmprunt
					.listerDemandeEmpruntRecu(mapper.map(compteActif))) {
				listeEnAttente.add(mapper.map(dtoDemandeEmprunt));
			}
		}
		return listeEnAttente;
	}

	public List<DemandeEmprunt> getListeDemandee() {
		if (listeRecu == null) {
			listeRecu = new ArrayList<>();
			for (DtoDemandeEmprunt dtoDemandeEmprunt : serviceDemandeEmprunt
					.listerDemandeEnvoye(mapper.map(compteActif))) {
				listeRecu.add(mapper.map(dtoDemandeEmprunt));
			}
		}
		return listeRecu;
	}

	public DemandeEmprunt getCourant() {
		if (courant == null) {
			courant = new DemandeEmprunt();
		}
		return courant;
	}

	public String actualiserCourant() {
		if (courant != null) {
			DtoDemandeEmprunt dto = serviceDemandeEmprunt.retrouver(courant.getId());
			if (dto == null) {
				UtilJsf.messageError("L'ouvrage demandé n'existe pas");
				return "test/liste";
			} else {
				courant = mapper.map(dto);
			}
		}
		return null;
	}

	public String validerMiseAJour() {
		try {
			if (courant.getId() == null) {
				courant.setEmprunteur(compteActif);
				serviceDemandeEmprunt.inserer(mapper.map(courant));
			} else {
				serviceDemandeEmprunt.modifier(mapper.map(courant));
			}
			UtilJsf.messageInfo("Mise à jour effectuée avec succès.");
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}

	public String supprimer(DemandeEmprunt item) {
		try {
			serviceDemandeEmprunt.supprimer(item.getId());
			listeEnAttente.remove(item);
			UtilJsf.messageInfo("Suppression effectuée avec succès.");
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
		}
		return null;
	}

	public String valider(DemandeEmprunt item) {
		try {
			item.setStatut("ACCEPTEE");
			item.setDateemprunt(new Date());
			serviceDemandeEmprunt.modifier(mapper.map(item));
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}

	public void supprimerEmprunt(Ouvrage ouvrage) {
		supprimer(getEmpruntFromOuvrage(ouvrage));
	}

	public DemandeEmprunt getEmpruntFromOuvrage(Ouvrage ouvrage) {
		return mapper.map(serviceDemandeEmprunt.getEmpruntFromOuvrage(mapper.map(ouvrage), mapper.map(compteActif)));
	}
}
