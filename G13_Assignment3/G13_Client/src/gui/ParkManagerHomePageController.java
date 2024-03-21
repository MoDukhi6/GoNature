
package gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import client.ChatClient;
import client.ClientController;
import client.ClientUI;
import common.ChatIF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Message;
import logic.Park;
import logic.User;
import ocsf.server.ConnectionToClient;




public  class ParkManagerHomePageController implements Initializable  {
	public static ClientController chat;
	private static int itemIndex = 3;
	public static User user;


	@FXML
	private Label lblError;
	
	
	@FXML
	private ComboBox cmbReportType,cmbChooseMonth,cmbChooseYear,cmbTime;
	
	
	/**
	   * This method runs the order form fx 
	   * and adds the client info into the database when "open order manager" button pressed
	   *@param event , the "open order manager" button
	   
	   */
	public void goChangeCapacity(ActionEvent event) throws Exception {
		/* Send a message to server to check username and password then check Role and open next window 
		 * according to the role
		 */
		Message msg = new Message (Message.ActionType.PARKINFO,user.getParkName());
		ClientUI.chat.accept(msg);
		ChatClient.openGUI.goToGUI(event, "/gui/ParkManagerChangeCapacity.fxml","","Change capacity Tool");
		


        

		
	}
	
	public void createReportPage(ActionEvent event) throws Exception {
		/*FXMLLoader loader = new FXMLLoader();
		((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		Stage primaryStage = new Stage();
		Pane root = loader.load(getClass().getResource("/gui/SignUp.fxml").openStream());		
		
	
		Scene scene = new Scene(root);			
		scene.getStylesheets().add(getClass().getResource("/gui/SignUp.css").toExternalForm());
		primaryStage.setTitle("Signup page");

		primaryStage.setScene(scene);		
		primaryStage.show();*/
	}
	

	public void Logout(ActionEvent event) throws Exception {
		Message msg = new Message (Message.ActionType.LOGOUT,user);
		ClientUI.chat.accept(msg);
		ChatClient.openGUI.goToGUI(event, "/gui/LoginWithoutPassword.fxml","/gui/LoginWithoutPassword.css","Visitor login page");

		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		user=ChatClient.user;
		
		
	}

	
}
