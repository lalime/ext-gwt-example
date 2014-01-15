package com.ozone.gapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.gwtext.client.core.Margins;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.PaddedPanel;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Viewport;
import com.gwtext.client.widgets.layout.AccordionLayout;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;

public class CLayout implements EntryPoint {

	@Override
	public void onModuleLoad() {
        Panel panel = new Panel();  
        panel.setBorder(false);  
        panel.setPaddings(15);  
        panel.setLayout(new FitLayout());  
  
        Panel borderPanel = new Panel();  
        borderPanel.setTitle("Use of BorderLayout, AccordionLayout and ColumnLayout");  
        borderPanel.setLayout(new BorderLayout());  
  
        final AccordionLayout accordion = new AccordionLayout();  
        accordion.setAnimate(true);  
  
        Panel westPanel = new Panel();  
        westPanel.setTitle("West");  
        westPanel.setCollapsible(true);  
        westPanel.setWidth(200);  
        westPanel.setLayout(accordion);  
  
        Panel navigationPanel = new Panel();  
        navigationPanel.setHtml(getShortBogusMarkup());  
        navigationPanel.setTitle("Navigation");  
        navigationPanel.setAutoScroll(true);  
        navigationPanel.setBorder(false);  
        navigationPanel.setIconCls("folder-icon");  
        westPanel.add(navigationPanel);  
  
        Panel settingsPanel = new Panel();  
        settingsPanel.setHtml(getShortBogusMarkup());  
        settingsPanel.setTitle("Settings");  
        settingsPanel.setAutoScroll(true);  
        settingsPanel.setBorder(false);  
        settingsPanel.setIconCls("settings-icon");  
        westPanel.add(settingsPanel);  
  
        BorderLayoutData westData = new BorderLayoutData(RegionPosition.WEST);  
        westData.setSplit(true);  
        westData.setMinSize(175);  
        westData.setMaxSize(400);  
        westData.setMargins(new Margins(35, 5, 0, 5));  
        westData.setCMargins(new Margins(35, 5, 5, 5));  
        borderPanel.add(westPanel, westData);  
  
  
        Panel centerPanel = new Panel();  
        centerPanel.setAutoScroll(true);  
        centerPanel.setLayout(new ColumnLayout());  
  
        Panel firstPanel = new PaddedPanel(new Panel("A Panel", getShortBogusMarkup()), 5, 5, 0, 5);  
        Panel secondPanel = new PaddedPanel(new Panel("A Panel", getShortBogusMarkup()), 5, 5, 0, 5);  
        Panel thirdPanel = new PaddedPanel(new Panel("A Panel", getShortBogusMarkup()), 5, 5, 0, 5);  
        thirdPanel.add(new PaddedPanel(new Panel("Another Panel", getShortBogusMarkup()), 5, 0, 0, 5));  
  
        centerPanel.add(firstPanel, new ColumnLayoutData(0.33));  
        centerPanel.add(secondPanel, new ColumnLayoutData(0.33));  
        centerPanel.add(thirdPanel, new ColumnLayoutData(0.333));  
  
        BorderLayoutData centerData = new BorderLayoutData(RegionPosition.CENTER);  
        centerData.setMargins(35, 0, 5, 5);  
        borderPanel.add(centerPanel, centerData);  
        panel.add(borderPanel);  
  
        new Viewport(panel);  
    }  
  
    private static String getShortBogusMarkup() {  
        return "<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. " +  
                "Sed metus nibh, sodales a, porta at, vulputate eget, dui.  " +  
                "In pellentesque nisl non sem. Suspendisse nunc sem, pretium eget, " +  
                "cursus a, fringilla vel, urna.";  
	}

}
