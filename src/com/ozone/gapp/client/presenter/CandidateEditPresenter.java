/**
 * 
 */
package com.ozone.gapp.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.Form;
import com.ozone.gapp.shared.Candidates;

/**
 * @author leunkeu
 * 
 */
public class CandidateEditPresenter implements Presenter {

	@SuppressWarnings("unused")
	private Candidates cand;
	private Display view;
	/*private final GreetingServiceAsync rpcService;
	private final HandlerManager eventBus;*/

	public interface Display {
		Button getSaveButton();
	    Button getCancelButton();
	    Field getFirstName();
	    Field getLastName();
	    Field getEmailAddress();
	    Field getPhoneNumber();
	    Field getSex();
	    Field getProfession();
	    Field getCity();
	    Form getForm();
		Widget asWidget();
	}
	
	
	

	/**
	 * @param view
	 * @param rpcService
	 * @param eventBus
	 * @param display
	 */
	public CandidateEditPresenter(Display view/*, GreetingServiceAsync rpcService,
			HandlerManager eventBus*/) {
		
	/*	this.rpcService = rpcService;
		this.eventBus = eventBus;*/
		this.view = view;
		
		bind();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ozone.gapp.client.presenter.Presenter#bind()
	 */
	@Override
	public void bind() {
		this.view.getSaveButton().addListener(new ButtonListenerAdapter(){
			public void onClick( Button button, EventObject e){
		 if (view.getForm().isValid()){
			 MessageBox.alert("That's good, all's right");
		 }else{
			 MessageBox.alert("Wrong, Look at your mistakes");
		 }
			}
		
		});
		
		this.view.getCancelButton().addListener(new ButtonListenerAdapter(){
			public void onClick( Button button, EventObject e){
		 view.getForm().reset();
			
			}
		
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ozone.gapp.client.presenter.Presenter#go()
	 */
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.asWidget());
	}

}
