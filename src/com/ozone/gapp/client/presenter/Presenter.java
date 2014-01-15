/**
 * 
 */
package com.ozone.gapp.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * @author leunkeu
 * 
 */
public interface Presenter {
	public void bind();

	public void go(final HasWidgets container);
}
