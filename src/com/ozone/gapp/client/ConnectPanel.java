/**
 * 
 */
package com.ozone.gapp.client;



import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;

/**
 * @author leunkeu
 *
 */
public class ConnectPanel extends FormPanel {

	private TextField login;
	private TextField passwd;
	private Button enter;

	/**
	 * 
	 */
	public ConnectPanel() {
		login = new TextField("Login", "uname", 160);
		passwd = new TextField("Password", "pswd", 160);
		enter = new Button("Connecter");
		
		passwd.setPassword(true);
		login.setAllowBlank(false);
		passwd.setAllowBlank(false);
		
		
		setWidth(300);
		setPaddings(10);
		setDraggable(true);
		setLayout(new VerticalLayout(7));
		setCls("lalime");
		add(login);
		add(passwd);
		
		Panel panel = new Panel();
		panel.setLayout(new HorizontalLayout(10));
		panel.add(enter);
		panel.add(new Button("Annuler"));
		add(panel);
		enter.addListener(new ButtonListenerAdapter() {
			
			@Override
			public void onClick(Button button, EventObject e) {
				if (getForm().isValid()){
					MessageBox.alert("Utilisateur connecté");
				}else{
					MessageBox.alert("Verifiez les champs svp !!");
				}
				
			}
		});
	}
	/**
	 * @return the login
	 */
	public TextField getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(TextField login) {
		this.login = login;
	}
	/**
	 * @return the passwd
	 */
	public TextField getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(TextField passwd) {
		this.passwd = passwd;
	}
	
	
	
}
