/**
 * 
 */
package com.ozone.gapp.client;

import com.gwtext.client.core.Connection;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.DateFieldDef;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.data.XmlReader;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.VType;

/**
 * @author leunkeu
 * 
 */
public class LoginPanel extends Panel {

	/**
	 * 
	 */
	public LoginPanel() {
		this.setBorder(false);
		this.setPaddings(15);

		// setup form data reader
		RecordDef recordDef = new RecordDef(new FieldDef[] {
				new StringFieldDef("first", "name/first"),
				new StringFieldDef("last", "name/last"),
				new StringFieldDef("company"), new StringFieldDef("email"),
				new StringFieldDef("state"),
				new DateFieldDef("dob", "dob", "m/d/Y") });

		final XmlReader reader = new XmlReader("contact", recordDef);
		reader.setSuccess("@success");

		// setup Combined Layout reader to process from submit response from
		// server
		RecordDef errorRecordDef = new RecordDef(new FieldDef[] {
				new StringFieldDef("id"), new StringFieldDef("msg") });

		XmlReader errorReader = new XmlReader("field", errorRecordDef);
		errorReader.setSuccess("@success");

		final FormPanel formPanel = new FormPanel(Position.RIGHT);
		formPanel.setFrame(true);
		formPanel.setTitle("XML Form");
		formPanel.setWidth(400);
		formPanel.setLabelWidth(75);
		// set reader and Combined Layout reader
		formPanel.setReader(reader);
		formPanel.setErrorReader(errorReader);

		// add some fields
		FieldSet fieldSet = new FieldSet("Contact Information");
		fieldSet.add(new TextField("First Name", "first", 190));
		fieldSet.add(new TextField("Last Name", "last", 190));
		fieldSet.add(new TextField("Company", "company", 190));

		TextField email = new TextField("Email", "email", 190);
		email.setVtype(VType.EMAIL);
		fieldSet.add(email);

		// add a ComboBox field
		Store store = new SimpleStore(new String[] { "abbr", "state" },
				getStates());
		store.load();

		ComboBox cb = new ComboBox();
		cb.setFieldLabel("State");
		cb.setHiddenName("state");
		cb.setStore(store);
		cb.setDisplayField("abbr");
		cb.setTypeAhead(true);
		cb.setMode(ComboBox.LOCAL);
		cb.setTriggerAction(ComboBox.ALL);
		cb.setEmptyText("Select a state...");
		cb.setSelectOnFocus(true);
		cb.setWidth(190);
		fieldSet.add(cb);

		DateField dob = new DateField("Date of birth", "dob", 190);
		dob.setAllowBlank(false);
		// fieldSet.add(dob);

		formPanel.add(fieldSet);

		final Button submitBtn = new Button("Submit",
				new ButtonListenerAdapter() {
					public void onClick(Button button, EventObject e) {
						formPanel.getForm().submit("data/xml-errors.xml", null,
								Connection.GET, "Saving Data...", false);
					}
				});

		Button loadBtn = new Button("Load", new ButtonListenerAdapter() {
			public void onClick(Button button, EventObject e) {
				formPanel.getForm().load("data/xml-form.xml", null,
						Connection.GET, "Loading...");
				submitBtn.enable();
			}
		});

		formPanel.addButton(loadBtn);
		formPanel.addButton(submitBtn);
		this.add(formPanel);
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
}
