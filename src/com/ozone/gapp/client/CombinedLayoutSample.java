package com.ozone.gapp.client;


    /* 
     * GWT-Ext Widget Library 
     * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated 
     * by the @authors tag. See the copyright.txt in the distribution for a 
     * full listing of individual contributors. 
     * 
     * This is free software; you can redistribute it and/or modify it 
     * under the terms of the GNU Lesser General Public License as 
     * published by the Free Software Foundation; either version 3 of 
     * the License, or (at your option) any later version. 
     * 
     * This software is distributed in the hope that it will be useful, 
     * but WITHOUT ANY WARRANTY; without even the implied warranty of 
     * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
     * Lesser General Public License for more details. 
     * 
     * You should have received a copy of the GNU Lesser General Public 
     * License along with this software; if not, write to the Free 
     * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 
     * 02110-1301 USA, or see the FSF site: http://www.fsf.org. 
     */  
       
      
    import com.google.gwt.core.client.EntryPoint;  
    import com.gwtext.client.core.Margins;  
    import com.gwtext.client.core.RegionPosition;  
    import com.gwtext.client.widgets.PaddedPanel;  
    import com.gwtext.client.widgets.Panel;  
    import com.gwtext.client.widgets.Viewport;  
    import com.gwtext.client.widgets.layout.*;  
      
    public class CombinedLayoutSample implements EntryPoint {  
      
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

