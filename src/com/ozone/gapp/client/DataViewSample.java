package com.ozone.gapp.client;

import com.google.gwt.user.client.Element;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.XTemplate;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.DateFieldDef;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.IntegerFieldDef;
import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.DataView;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.DataViewListenerAdapter;
import com.gwtext.client.widgets.layout.FitLayout;

public class DataViewSample extends Panel {  
    
    public DataViewSample() {    
    	
        this.setBorder(false);  
        this.setPaddings(15);  
  
        MemoryProxy dataProxy = new MemoryProxy(getData());  
        RecordDef recordDef = new RecordDef(new FieldDef[]{  
                new StringFieldDef("name"),  
                new IntegerFieldDef("size"),  
                new DateFieldDef("lastmod", "timestamp"),  
                new StringFieldDef("url")  
        });  
  
        ArrayReader reader = new ArrayReader(recordDef);  
  
        //for loading from json data  
        //JsonStore store = new JsonStore("data/images.json", "images", recordDef);  
        //store.load();  
  
        //or  
  
        //HttpProxy dataProxy = new HttpProxy("data/images.json");  
        //JsonReader reader = new JsonReader("images", recordDef);  
  
        final Store store = new Store(dataProxy, reader, true);  
        store.load();  
  
        XTemplate template = new XTemplate(new String[]{  
                "<tpl for='.'>",  
                "<div class='thumb-wrap'>",  
                "<div class='thumb'><img src='{url}' ext:qtip='{name}'></div>",  
                "<span class='x-editable' ext:qtip='{name}'>{shortName}</span></div>",  
                "</tpl>",  
                "<div class='x-clear'></div>"  
        });  
  
        Panel inner = new Panel();  
        inner.setWidth(535);  
        inner.setId("images-view");  
        inner.setFrame(true);  
        inner.setAutoHeight(true);  
        inner.setCollapsible(true);  
        inner.setLayout(new FitLayout());  
        inner.setTitle("Simple DataView");  
  
        DataView dataView = new DataView("div.thumb-wrap") {  
            public void prepareData(Data data) {  
                data.setProperty("shortName", Format.ellipsis(data.getProperty("name"), 15));  
            }  
        };  
        dataView.setWidth(535);  
  
        dataView.addListener(new DataViewListenerAdapter() {  
            public boolean doBeforeClick(DataView source, int index, Element node, EventObject e) {  
  
                System.out.println("doBeforeClick::" + getSelectedMovies(source));  
                return true;  
            }  
  
            public boolean doBeforeSelect(DataView source, Element node, Element[] selections) {  
                System.out.println("doBeforeSelect::" + getSelectedMovies(source));  
                return super.doBeforeSelect(source, node, selections);  
            }  
  
            public void onClick(DataView source, int index, Element node, EventObject e) {  
                System.out.println("onClick::" + getSelectedMovies(source));  
                super.onClick(source, index, node, e);  
            }  
  
            public void onContainerClick(DataView source, EventObject e) {  
                System.out.println("onContainerClick");  
                super.onContainerClick(source, e);  
            }  
  
            public void onContextMenu(DataView source, int index, Element node, EventObject e) {  
                System.out.println("onContextMenu");  
                super.onContextMenu(source, index, node, e);  
            }  
  
            public void onDblClick(DataView source, int index, Element node, EventObject e) {  
                System.out.println("onDblClick");  
                super.onDblClick(source, index, node, e);  
            }  
  
            public void onSelectionChange(DataView view, Element[] selections) {  
                System.out.println("onSelectionChange");  
                super.onSelectionChange(view, selections);  
            }  
        });  
  
        dataView.setStore(store);  
        dataView.setTpl(template);  
        dataView.setAutoHeight(true);  
        dataView.setMultiSelect(true);  
        dataView.setOverCls("x-view-over");  
        dataView.setEmptyText("No Images to display");  
  
        inner.add(dataView);  
  
        this.add(inner);  
  
       // RootPanel.get().add(this);  
    }  
  
    private String getSelectedMovies(DataView view) {  
        Record[] records = view.getSelectedRecords();  
        String msg = "";  
        for (int i = 0; i < records.length; i++) {  
            Record record = records[i];  
            msg += record.getAsString("name") + " ";  
        }  
        return msg;  
    }  
  
    private Object[][] getData() {  
        return new Object[][]{  
                new Object[]{"Pirates of the Caribbean", new Integer(2120),  
                        new Long(1180231870000l), "images/view/carribean.jpg"},  
                new Object[]{"Resident Evil", new Integer(2120),  
                        new Long(1180231870000l), "images/view/resident_evil.jpg"},  
                new Object[]{"Blood Diamond", new Integer(2120),  
                        new Long(1180231870000l), "images/view/blood_diamond.jpg"},  
                new Object[]{"No Reservations", new Integer(2120),  
                        new Long(1180231870000l), "images/view/no_reservations.jpg"},  
                new Object[]{"Casino Royale", new Integer(2120),  
                        new Long(1180231870000l), "images/view/casino_royale.jpg"},  
                new Object[]{"Good Shepherd", new Integer(2120),  
                        new Long(1180231870000l), "images/view/good_shepherd.jpg"},  
                new Object[]{"Ghost Rider", new Integer(2120),  
                        new Long(1180231870000l), "images/view/ghost_rider.jpg"},  
                new Object[]{"Batman Begins", new Integer(2120),  
                        new Long(1180231870000l), "images/view/batman_begins.jpg"},  
                new Object[]{"Last Samurai", new Integer(2120),  
                        new Long(1180231870000l), "images/view/last_samurai.jpg"},  
                new Object[]{"Italian Job", new Integer(2120),  
                        new Long(1180231870000l), "images/view/italian_job.jpg"},  
                new Object[]{"Missioncomponent Impossible III", new Integer(2120),  
                        new Long(1180231870000l), "images/view/mi3.jpg"},  
                new Object[]{"Mr & Mrs Smith", new Integer(2120),  
                        new Long(1180231870000l), "images/view/smith.jpg"},  
                new Object[]{"Inside Man", new Integer(2120),  
                        new Long(1180231870000l), "images/view/inside_man.jpg"},  
                new Object[]{"The Island", new Integer(2120),  
                        new Long(1180231870000l), "images/view/island.jpg"}  
        };  
    }  
}  




