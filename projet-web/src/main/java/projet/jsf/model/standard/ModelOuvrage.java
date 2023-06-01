package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoOuvrage;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceOuvrage;
import projet.jsf.data.Ouvrage;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.CompteActif;
import projet.jsf.util.UtilJsf;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelOuvrage implements Serializable {

	private List<Ouvrage> liste;

	private Ouvrage courant;
	
	@Inject
	private CompteActif compteActif;

	@EJB
	private IServiceOuvrage serviceOuvrage;

	@Inject
	private IMapper mapper;

	public List<Ouvrage> getListe() {
		if (liste == null) {
			liste = new ArrayList<>();
			for (DtoOuvrage dtoOuvrage : serviceOuvrage.listerTout()) {
				liste.add(mapper.map(dtoOuvrage));
			}
		}
		return liste;
	}

	public Ouvrage getCourant() {
		if (courant == null) {
			courant = new Ouvrage();
		}
		return courant;
	}

	public String actualiserCourant() {
		if (courant != null) {
			DtoOuvrage dto = serviceOuvrage.retrouver(courant.getId());
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
			if ( courant.getId() == null) {
				courant.setProprietaire(compteActif);
				System.out.println(compteActif);
				serviceOuvrage.inserer( mapper.map(courant) );
			} else {
				serviceOuvrage.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Ouvrage item ) {
		try {
			serviceOuvrage.supprimer( item.getId() );
			liste.remove(item);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
}
