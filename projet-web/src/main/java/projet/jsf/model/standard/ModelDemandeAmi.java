package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoDemandeAmi;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceDemandeAmi;
import projet.jsf.data.DemandeAmi;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.CompteActif;
import projet.jsf.util.UtilJsf;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelDemandeAmi implements Serializable {

	private List<DemandeAmi> liste;

	private DemandeAmi courant;

	@Inject
	private CompteActif compteActif;

	@EJB
	private IServiceDemandeAmi serviceDemandeAmi;

	@Inject
	private IMapper mapper;

	public List<DemandeAmi> getListe() {
		if (liste == null) {
			liste = new ArrayList<>();
			for (DtoDemandeAmi dtoDemandeAmi : serviceDemandeAmi.listerTout()) {
				liste.add(mapper.map(dtoDemandeAmi));
			}
		}
		return liste;
	}

	public DemandeAmi getCourant() {
		if (courant == null) {
			courant = new DemandeAmi();
		}
		return courant;
	}

	public String actualiserCourant() {
		if (courant != null) {
			DtoDemandeAmi dto = serviceDemandeAmi.retrouver(courant.getId());
			if (dto == null) {
				UtilJsf.messageError("La demande d'ami demandée n'existe pas");
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
				courant.setEnvoyeur(compteActif);
				serviceDemandeAmi.inserer(mapper.map(courant));
			} else {
				serviceDemandeAmi.modifier(mapper.map(courant));
			}
			UtilJsf.messageInfo("Mise à jour effectuée avec succès.");
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}

	public String supprimer(DemandeAmi item) {
		try {
			serviceDemandeAmi.supprimer(item.getId());
			liste.remove(item);
			UtilJsf.messageInfo("Suppression effectuée avec succès.");
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
		}
		return null;
	}
}
