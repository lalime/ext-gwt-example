/**
 * 
 */
package com.ozone.gapp.client;

import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.layout.VerticalLayout;

/**
 * @author leunkeu
 * 
 */
public class MenuLeft extends Panel {
	

	/**
 * 
 */
	public MenuLeft() {
		Label accueil = new Label("Accueil");
		Label offres = new Label("Entreprises");
		Label entreprises = new Label("Offres");
		Label contact = new Label("Contacts");
		Label aboutus = new Label("A Propos de nous");
		
		
		
		setLayout(new VerticalLayout(15));
		setMargins(15, 10, 0, 0);
		add(accueil);
		add(offres);
		add(entreprises);
		add(contact);
		add(aboutus);
	}

}
