package projet.commun.dto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class CategorieOuvrage {

	// Champs statiques
	
	public static final String LIVRE	= "LIVRE";
	public static final String MAGAZINE 	= "MAGAZINE";
	public static final String BD 	= "BD";
	
	
	private static final List<String>	categories = Collections.unmodifiableList( Arrays.asList( 
			LIVRE,			
			MAGAZINE,
			BD
	) );

	private static final String[]	 	libellés = new String[] {
			"Livre",
			"Magazine",
			"BD"
	};
	
	
	// Constructeur privé qui empêche l'instanciation de la classe
	private CategorieOuvrage() {
	}
	
	
	// Actions

	public static List<String> getCategorieOuvrage() {
		return categories;
	}
	
	public static String getLibellé( String categorie ) {
		int index = categories.indexOf( categorie );
		if ( index == -1 ) {
			throw new IllegalArgumentException();
		} 
		return libellés[index];
	}
	
}
