package controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;


public class LoginController {
	
	public static String user = "";

    public LoginController() {

    }

    @FXML
    private Button button;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;



    public void userLogIn() throws Exception  {
    	
    if(username.getText().toString().equals("admin") && password.getText().toString().equals("123")) {
    	Parent root = FXMLLoader.load(getClass().getResource("../fxml/Home.fxml"));
    	
    	Stage window = (Stage) button.getScene().getWindow();
    	window.setScene(new Scene (root,2000,1000));
    	
    }
    else if(username.getText().toString().equals("Nethra") && password.getText().toString().equals("123")) {
    	user = "Nethra";
    	Parent root = FXMLLoader.load(getClass().getResource("../fxml/UserDashboard.fxml"));
    	
    	Stage window = (Stage) button.getScene().getWindow();
    	window.setScene(new Scene (root,2000,1000));
    }
    else if(username.getText().toString().equals("Shobith") && password.getText().toString().equals("123")) {
    	user = "Shobith";
    	Parent root = FXMLLoader.load(getClass().getResource("../fxml/UserDashboard.fxml"));
    	
    	Stage window = (Stage) button.getScene().getWindow();
    	window.setScene(new Scene (root,2000,1000));
    }
    else if(username.getText().toString().equals("Jones") && password.getText().toString().equals("123")) {
    	user = "Jones";
    	Parent root = FXMLLoader.load(getClass().getResource("../fxml/UserDashboard.fxml"));
    	
    	Stage window = (Stage) button.getScene().getWindow();
    	window.setScene(new Scene (root,2000,1000));
    }
    else if(username.getText().toString().equals("Kaushik") && password.getText().toString().equals("123")) {
    	user = "Kaushik";
    	Parent root = FXMLLoader.load(getClass().getResource("../fxml/UserDashboard.fxml"));
    	
    	Stage window = (Stage) button.getScene().getWindow();
    	window.setScene(new Scene (root,2000,1000));
    }
    else if(username.getText().toString().equals("Ruchithra") && password.getText().toString().equals("123")) {
    	user = "Ruchithra";
    	Parent root = FXMLLoader.load(getClass().getResource("../fxml/UserDashboard.fxml"));
    	
    	Stage window = (Stage) button.getScene().getWindow();
    	window.setScene(new Scene (root,2000,1000));
    }
    else if(username.getText().isEmpty() && password.getText().isEmpty()) {
        wrongLogIn.setText("Please enter your data.");
    }


    else {
        wrongLogIn.setText("Wrong username or password!");
    }
    }


}