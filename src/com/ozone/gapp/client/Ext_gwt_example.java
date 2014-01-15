package com.ozone.gapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.ozone.gapp.client.presenter.CandidateEditPresenter;
import com.ozone.gapp.client.presenter.Presenter;
import com.ozone.gapp.client.view.CandidatesEditView;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Ext_gwt_example implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Presenter present = new CandidateEditPresenter(new CandidatesEditView());
		present.go(RootPanel.get());
	}
	
	
		
	}


