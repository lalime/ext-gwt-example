package com.ozone.gapp.client;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.RowLayout;
import com.gwtext.client.widgets.layout.RowLayoutData;

/**
 * 
 */

/**
 * @author leunkeu
 *
 */
public class PanelWithRowLayout extends Panel {

	/**
	 * 
	 */
	public PanelWithRowLayout() {
		 this.setLayout(new RowLayout());

		/* Panel first = new Panel();
		 first.setTitle("Height in pixels");
		 first.setHtml("panel height = 100px");
		 this.add(first, new RowLayoutData("100%"));

		 Panel second = new Panel();
		 second.setTitle("1/2");
		 second.setHtml("Will take half of remaining height");
		 this.add(second, new RowLayoutData("50%"));

		 Panel third = new Panel();
		 third.setTitle("No height 1");
		 third.setHtml("Panel without given height");
		 this.add(third);

		 Panel fourth = new Panel();
		 fourth.setTitle("No height 2");
		 fourth.setHtml("Another Panel");
		 this.add(fourth);*/
		 
		/* this.setAutoHeight(true);*/
		 this.setBottomToolbar(new Button("Lalime Inc"));

	}

public void addMenu(Panel panel){
	this.add(panel, new RowLayoutData("15%"));
}

public void addContent(Panel panel){
	this.add(panel, new RowLayoutData("75%"));
}

public void addFooter(Panel panel){
	this.add(panel, new RowLayoutData("10%"));
}
}
