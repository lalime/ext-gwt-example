/**
 * 
 */
package com.ozone.gapp.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.DatePicker;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.Form;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.VType;
import com.ozone.gapp.client.presenter.CandidateEditPresenter.Display;

/**
 * @author leunkeu
 * 
 */
public class CandidatesEditView extends Composite implements Display {

	private FormPanel formPanel;
	private FieldSet fieldSet;
	private TextField email;
	private ComboBox cb;
	private DatePicker dob;
	private NumberField tel;
	private TextField name;
	private TextField fname;
	private ComboBox sex;
	private TextField prof;
	private TextField ville;
	private Button saveButton;
	private Button cancelButton;

	/**
	 * 
	 */
	public CandidatesEditView() {

		// Fields initialization
		name = new TextField("First Name", "first", 190);
		fname = new TextField("Last Name", "last", 190);
		sex = new ComboBox("Sex", "sex", 190);
		email = new TextField("Email", "email", 190);
		prof = new TextField("Profession", "prof", 190);
		ville = new TextField("Ville", "city", 190);
		tel = new NumberField("Telephone", "tel", 190);
		saveButton = new Button("Save");
		cancelButton = new Button("Cancel");
		
		Store sexstore = new SimpleStore(new String[]{"theme", "label"}, new Object[][]{
                new Object[]{"xtheme-aero.css", "Aero Glass Theme"},
                new Object[]{"xtheme-gray.css", "Gray Theme"},
                new Object[]{"xtheme-vista.css", "Vista Dark Theme"}});;
		sexstore.load();
		sexstore.setAutoLoad(true);
		
		String regex = "^[a-zA-Z]*$";
		String regexText = "Only alphabets allowed";
		name.setAllowBlank(false);
		name.setEmptyText("Your name ...");
		email.setAllowBlank(false);
		ville.setAllowBlank(false);
		tel.setAllowBlank(false);
		fname.setRegex(regex);
		fname.setAllowBlank(false);
		fname.setRegexText(regexText);
		sex.setStore(sexstore);
		sex.setSelectOnFocus(true);
		sex.setMode(ComboBox.LOCAL);
		sex.setTriggerAction(ComboBox.ALL);
		prof.setRegex(regex );
		prof.setRegexText(regexText);
		prof.setAllowBlank(false);
		tel.setRegexText("Only digits allowed");


		email.setVtype(VType.EMAIL);
		
		formPanel = new FormPanel(Position.RIGHT);
		formPanel.setFrame(true);
		formPanel.setTitle("XML Form");
		formPanel.setWidth(400);
		formPanel.setLabelWidth(75);
		

		// add some fields
		fieldSet = new FieldSet("Contact Information");
		fieldSet.add(name);
		fieldSet.add(fname);
		fieldSet.add(sex);
		fieldSet.add(ville);
		fieldSet.add(tel);
		fieldSet.add(email);
		fieldSet.add(prof);
		fieldSet.add(sex);
/*
		saveButton.addListener(new ButtonListenerAdapter(){
			public void onClick( Button button, EventObject e){
		 if (formPanel.getForm().isValid()){
			 MessageBox.alert("That's good, all's right");
		 }else{
			 MessageBox.alert("Wrong, Look at your mistakes");
		 }
			}
		
		});
		
		cancelButton.addListener(new ButtonListenerAdapter(){
			public void onClick( Button button, EventObject e){
		 formPanel.getForm().reset();
			
			}
		
		});*/

		// add a ComboBox field
		Store store = new SimpleStore(new String[] { "abbr", "state" },
				getStates());
		store.load();

		cb = new ComboBox();
		cb.setFieldLabel("State");
		cb.setHiddenName("state");
		cb.setStore(store);
		cb.setDisplayField("abbr");
		//cb.setTypeAhead(true);
		cb.setMode(ComboBox.LOCAL);
		cb.setTriggerAction(ComboBox.ALL);
		cb.setEmptyText("Select a state...");
		cb.setSelectOnFocus(true);
		cb.setWidth(190);
		fieldSet.add(cb);

		dob = new DatePicker();

	    fieldSet.add(dob);
		formPanel.add(fieldSet);
		formPanel.addButton(saveButton);
		formPanel.addButton(cancelButton);
		initWidget(formPanel);
		dob.setWidth("190");
		dob.setVisible(false);
	}

	public Widget asWidget() {
		return this;
	}

	private String[][] getStates() {
		return new String[][] {
				new String[] { "AL", "Alabama", "The Heart of Dixie" },
				new String[] { "AK", "Alaska", "The Land of the Midnight Sun" },
				new String[] { "AZ", "Arizona", "The Grand Canyon State" },
				new String[] { "AR", "Arkansas", "The Natural State" },
				new String[] { "CA", "California", "The Golden State" },
				new String[] { "CO", "Colorado", "The Mountain State" },
				new String[] { "CN", "Connecticut", "The Constitution State" },
				new String[] { "DE", "Delaware", "The First State" },
				new String[] { "DC", "District of Columbia",
						"The Nation's Capital" },
				new String[] { "FL", "Florida", "The Sunshine State" },
				new String[] { "GA", "Georgia", "The Peach State" },
				new String[] { "HW", "Hawaii", "The Aloha State" },
				new String[] { "ID", "Idaho", "Famous Potatoes" },
				new String[] { "IL", "Illinois", "The Prairie State" },
				new String[] { "IN", "Indiana", "The Hospitality State" },
				new String[] { "IA", "Iowa", "The Corn State" },
				new String[] { "KS", "Kansas", "The Sunflower State" },
				new String[] { "KY", "Kentucky", "The Bluegrass State" },
				new String[] { "LA", "Louisiana", "The Bayou State" },
				new String[] { "ME", "Maine", "The Pine Tree State" },
				new String[] { "MA", "Massachusetts", "The Spirit of America" },
				new String[] { "MD", "Maryland", "Chesapeake State" },
				new String[] { "MI", "Michigan", "Great Lakes State" },
				new String[] { "MN", "Minnesota", "North Star State" },
				new String[] { "MS", "Mississippi", "Magnolia State" },
				new String[] { "MO", "Missouri", "Show Me State" },
				new String[] { "MT", "Montana", "Big Sky Country" },
				new String[] { "NE", "Nebraska", "Beef State" },
				new String[] { "NV", "Nevada", "Silver State" },
				new String[] { "NH", "New Hampshire", "Granite State" },
				new String[] { "NJ", "New Jersey", "Garden State" },
				new String[] { "NM", "New Mexico", "Land of Enchantment" },
				new String[] { "NY", "New York", "Empire State" },
				new String[] { "NC", "North Carolina", "First in Freedom" },
				new String[] { "ND", "North Dakota", "Peace Garden State" },
				new String[] { "OH", "Ohio", "The Heart of it All" },
				new String[] { "OK", "Oklahoma", "Oklahoma is OK" },
				new String[] { "OR", "Oregon", "Pacific Wonderland" },
				new String[] { "PA", "Pennsylvania", "Keystone State" },
				new String[] { "RH", "Rhode Island", "Ocean State" },
				new String[] { "SC", "South Carolina", "Nothing Could be Finer" },
				new String[] { "SD", "South Dakota",
						"Great Faces, Great Places" },
				new String[] { "TE", "Tennessee", "Volunteer State" },
				new String[] { "TX", "Texas", "Lone Star State" },
				new String[] { "UT", "Utah", "Salt Lake State" },
				new String[] { "VE", "Vermont", "Green Mountain State" },
				new String[] { "VA", "Virginia", "Mother of States" },
				new String[] { "WA", "Washington", "Green Tree State" },
				new String[] { "WV", "West Virginia", "Mountain State" },
				new String[] { "WI", "Wisconsin", "America's Dairyland" },
				new String[] { "WY", "Wyoming", "Like No Place on Earth" } };
	}

	@Override
	public Button getSaveButton() {
		return saveButton;
	}

	@Override
	public Button getCancelButton() {
		return cancelButton;
	}

	@Override
	public Field getFirstName() {
		return fname;
	}

	@Override
	public Field getLastName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Field getEmailAddress() {
		return email;
	}

	@Override
	public Field getPhoneNumber() {
		return tel;
	}

	@Override
	public Field getSex() {
		return sex;
	}

	@Override
	public Field getProfession() {
		return prof;
	}

	@Override
	public Field getCity() {
		return ville;
	}

	@Override
	public Form getForm() {
		return formPanel.getForm();
	}

}
