/**
 * 
 */
package com.ozone.gapp.client;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.DateFieldDef;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.data.XmlReader;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.HtmlEditor;
import com.gwtext.client.widgets.form.MultiFieldPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.AnchorLayoutData;

/**
 * @author leunkeu
 * 
 */
public class AnotherForm extends FormPanel {

	private FieldDef[] formFieldDef;
	private TextField titleField;
	private DateField startDateField;
	private DateField endDateField;
	private HtmlEditor storyEditor;
	private MultiFieldPanel oneRowPanel;
	private Button saveButton;
	private Button resetButton;

	/**
	 * 
	 */
	public AnotherForm() {

		// Components initialization
		titleField = new TextField("Title", "title");
		titleField.setAllowBlank(false);

		startDateField = new DateField("Start Date", "startDate", 150);
		startDateField.setFormat("d/m/Y");
		startDateField.setAllowBlank(false);

		endDateField = new DateField("End Date", "endDate", 150);
		endDateField.setFormat("d/m/Y");

		formFieldDef = new FieldDef[] { new StringFieldDef("title"),
				new DateFieldDef("startDate", "startDate", "d/m/Y"),
				new DateFieldDef("endDate", "endDate", "d/m/Y"),
				new StringFieldDef("story") };
		RecordDef formDef = new RecordDef(formFieldDef);
		XmlReader formReader = new XmlReader("trip", formDef);
		formReader.setSuccess("@success");

		storyEditor = new HtmlEditor("Story", "story");
		storyEditor.setWidth(600);
		storyEditor.setHeight(400);

	    oneRowPanel = new MultiFieldPanel();
		oneRowPanel.setBorder(false);
		oneRowPanel.setAutoHeight(true);
		oneRowPanel.addToRow(startDateField, 200);
		oneRowPanel.addToRow(endDateField, 200);
		
		 saveButton = new Button("Save");
	     resetButton = new Button("Reset", new ButtonListenerAdapter(){
	     public void onClick(Button button, EventObject event) {
	     getForm().reset();
	     }
	     });

		// Container config
		this.setFrame(false);
		this.setLabelAlign(Position.TOP);
		this.setBorder(false);
		this.setWidth(700);
		this.setAutoHeight(true);
		this.setReader(formReader);

		// Components adding
		this.add(titleField, new AnchorLayoutData("90%"));
		this.add(oneRowPanel);
		this.add(storyEditor, new AnchorLayoutData("90%"));
		this.add(saveButton);
		this.add(resetButton);

	}

	/**
	 * @return the storyEditor
	 */
	public HtmlEditor getStoryEditor() {
		return storyEditor;
	}

	/**
	 * @param storyEditor the storyEditor to set
	 */
	public void setStoryEditor(HtmlEditor storyEditor) {
		this.storyEditor = storyEditor;
	}

	/**
	 * @return the formFieldDef
	 */
	public FieldDef[] getFormFieldDef() {
		return formFieldDef;
	}

	/**
	 * @param formFieldDef
	 *            the formFieldDef to set
	 */
	public void setFormFieldDef(FieldDef[] formFieldDef) {
		this.formFieldDef = formFieldDef;
	}

	/**
	 * @return the titleField
	 */
	public TextField getTitleField() {
		return titleField;
	}

	/**
	 * @param titleField
	 *            the titleField to set
	 */
	public void setTitleField(TextField titleField) {
		this.titleField = titleField;
	}

	/**
	 * @return the startDateField
	 */
	public DateField getStartDateField() {
		return startDateField;
	}

	/**
	 * @param startDateField
	 *            the startDateField to set
	 */
	public void setStartDateField(DateField startDateField) {
		this.startDateField = startDateField;
	}

	/**
	 * @return the endDateField
	 */
	public DateField getEndDateField() {
		return endDateField;
	}

	/**
	 * @param endDateField
	 *            the endDateField to set
	 */
	public void setEndDateField(DateField endDateField) {
		this.endDateField = endDateField;
	}

}
