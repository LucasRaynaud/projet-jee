package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

	private List<DemandeAmi> listeDemandeEnvoye;

	private List<DemandeAmi> listeDemandeRecu;

	private List<DemandeAmi> listeAmis;

	private DemandeAmi courant;

	@Inject
	private CompteActif compteActif;

	@EJB
	private IServiceDemandeAmi serviceDemandeAmi;

	@Inject
	private IMapper mapper;

	public List<DemandeAmi> getListeDemandeEnvoye() {
		if (listeDemandeEnvoye == null) {
			listeDemandeEnvoye = new ArrayList<>();
			for (DtoDemandeAmi dtoDemandeAmi : serviceDemandeAmi.listerDemandeEnvoye(mapper.map(compteActif))) {
				listeDemandeEnvoye.add(mapper.map(dtoDemandeAmi));
			}
		}
		return listeDemandeEnvoye;
	}

	public List<DemandeAmi> getListeDemandeRecu() {
		if (listeDemandeRecu == null) {
			listeDemandeRecu = new ArrayList<>();
			for (DtoDemandeAmi dtoDemandeAmi : serviceDemandeAmi.listerDemandeAmiRecu(mapper.map(compteActif))) {
				listeDemandeRecu.add(mapper.map(dtoDemandeAmi));
			}
		}
		return listeDemandeRecu;
	}

	public List<DemandeAmi> getListeAmis() {
		if (listeAmis == null) {
			listeAmis = new ArrayList<>();
			for (DtoDemandeAmi dtoDemandeAmi : serviceDemandeAmi.listerAmis(mapper.map(compteActif))) {
				listeAmis.add(mapper.map(dtoDemandeAmi));
			}
		}
		return listeAmis;
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
			UtilJsf.messageError(e.getMessage());
			return null;
		}
	}

	public String supprimer(DemandeAmi item) {
		try {
			serviceDemandeAmi.supprimer(item.getId());
			listeDemandeEnvoye.remove(item);
			UtilJsf.messageInfo("Suppression effectuée avec succès.");
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
		}
		return null;
	}

	public String valider(DemandeAmi item) {
		try {
			item.setStatut("ACCEPTEE");
			item.setDateDemande(new Date());
			serviceDemandeAmi.modifier(mapper.map(item));
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
}
