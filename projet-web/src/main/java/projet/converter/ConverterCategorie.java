package projet.converter;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import projet.jsf.data.CategorieOuvrage;

@Named
@RequestScoped
public class ConverterCategorie implements Converter<CategorieOuvrage> {

	// Actions

	@SuppressWarnings("unchecked")
	@Override
	public CategorieOuvrage getAsObject(FacesContext context, UIComponent uic, String value) {

		if (value == null || value.isEmpty()) {
			return null;
		}

		List<CategorieOuvrage> items = null;
		for (UIComponent c : uic.getChildren()) {
			if (c instanceof UISelectItems) {
				items = (List<CategorieOuvrage>) ((UISelectItems) c).getValue();
				break;
			}
		}

		var id = Integer.valueOf("x"+value);
		for (CategorieOuvrage item : items) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, CategorieOuvrage item) {

		if (item == null) {
			return "";
		}
		return String.valueOf(item.getId());
	}
}