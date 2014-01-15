package com.ozone.gapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.gwtext.client.core.Margins;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.PaddedPanel;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Viewport;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;

public class TpltePage implements EntryPoint {

	@Override
	public void onModuleLoad() {
		  Panel panel = new Panel();  
          panel.setBorder(false);  
          panel.setPaddings(5);  
          panel.setLayout(new FitLayout());  
    
          Panel borderPanel = new Panel();  
          borderPanel.setLayout(new BorderLayout());  
    
          //add north panel  
          Panel northPanel = new Panel();    
          northPanel.setHeight(100); 
          northPanel.setLayout(new ColumnLayout());
          ColumnLayoutData layoutData = new ColumnLayoutData(200);
		northPanel.add(new Panel() );
         /* northPanel.setHtml("<p>north panel</p>"); 
          northPanel.setBodyStyle("background-color:#FFFF88");*/  
          northPanel.add(new ConnectPanel(), layoutData);
          borderPanel.add(northPanel, new BorderLayoutData(RegionPosition.NORTH));  
    
          //add south panel  
          Panel southPanel = new Panel();  
          southPanel.setHtml("<p>south panel</p>");  
          southPanel.setHeight(100);  
          southPanel.setBodyStyle("background-color:#CDEB8B");  
         // southPanel.setCollapsible(true);  
          southPanel.setTitle("South");  
    
          BorderLayoutData southData = new BorderLayoutData(RegionPosition.SOUTH);  
          southData.setMinSize(100);  
          southData.setMaxSize(200);  
          southData.setMargins(new Margins(0, 0, 0, 0));  
          southData.setSplit(true);  
          borderPanel.add(southPanel, southData);  
    
          //add east panel  
          Panel eastPanel = new Panel();  
          eastPanel.setHtml("<p>east panel</p>");  
          eastPanel.setTitle("East Side");  
          eastPanel.setCollapsible(true);  
          eastPanel.setWidth(225);  
    
          BorderLayoutData eastData = new BorderLayoutData(RegionPosition.EAST);  
          eastData.setSplit(true);  
          eastData.setMinSize(175);  
          eastData.setMaxSize(400);  
          eastData.setMargins(new Margins(0, 0, 5, 0));  
    
          //borderPanel.add(eastPanel, eastData);  
          
          Panel cenPanel = new Panel();  
          cenPanel.setAutoScroll(true);  
          cenPanel.setLayout(new VerticalLayout()); 
          cenPanel.setWidth(225);  
    
          Panel firstPanel = new PaddedPanel(new Panel("A panel",getShortBogusMarkup()), 5, 5, 0, 5);  
          Panel secondPanel = new PaddedPanel(new Panel("A Panel", getShortBogusMarkup()), 5, 5, 0, 5);  
          Panel thirdPanel = new PaddedPanel(new Panel("A Panel", getShortBogusMarkup()), 5, 5, 0, 5);  
          thirdPanel.add(new PaddedPanel(new Panel("Another Panel", getShortBogusMarkup()), 5, 0, 0, 5));  
    
          cenPanel.add(firstPanel, new ColumnLayoutData(0.33));  
          cenPanel.add(secondPanel, new ColumnLayoutData(0.33));  
          cenPanel.add(thirdPanel, new ColumnLayoutData(0.333)); 
          
          borderPanel.add(cenPanel, eastData); 
          
          Panel westPanel = new Panel();  
          /*westPanel.setHtml("<p>west panel</p>");  
          westPanel.setTitle("West");  
          westPanel.setBodyStyle("background-color:#EEEEEE");  
          westPanel.setCollapsible(true);  */
          westPanel.setWidth(200);  
          westPanel.setPaddings(15);
          westPanel.add(new MenuLeft());
    
          BorderLayoutData westData = new BorderLayoutData(RegionPosition.WEST);  
          westData.setSplit(true);  
          westData.setMinSize(175);  
          westData.setMaxSize(400);  
          westData.setMargins(new Margins(0, 5, 0, 0));  
    
          borderPanel.add(westPanel, westData);  
    
          Panel centerPanel = new Panel();  
          centerPanel.setAutoScroll(true);
         /* centerPanel.setHtml("<p>center panel</p>");  
          centerPanel.setBodyStyle("background-color:#C3D9FF");*/
          centerPanel.setLayout(new VerticalLayout());
          centerPanel.add(new LoginPanel());
          centerPanel.add(new DataViewSample());
          
          borderPanel.add(centerPanel, new BorderLayoutData(RegionPosition.CENTER));  
    
          panel.add(borderPanel);  
    
          Viewport viewport = new Viewport(panel);  
          viewport.doLayout();
	}

	private static String getShortBogusMarkup() {  
        return "<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. " +  
                "Sed metus nibh, sodales a, porta at, vulputate eget, dui.  " +  
                "In pellentesque nisl non sem. Suspendisse nunc sem, pretium eget, " +  
                "cursus a, fringilla vel, urna.";  
    }
}
