package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.EmployeeData;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewEmployeeController implements Initializable {
	
	@FXML
	private AnchorPane newEmployeePane;
	
	@FXML
	private Button add;
	
	@FXML
	private Button cancel;
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField designation;
	
//	@FXML
//	private TextField department;
	
	@FXML
	private TextField manager;
	
	@FXML
	private TextField salary;
	
	@FXML
	private TextField salaryRevision;
	
	@FXML
	private ComboBox<String> department;
	
	public void handleButtonClicks(ActionEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() == add) {
        	EmployeeData.addEmployee(name.getText(), designation.getText(), department.getValue(), manager.getText(), Integer.parseInt(salary.getText()), Float.parseFloat(salaryRevision.getText()));
        	Stage stage = (Stage) cancel.getScene().getWindow();
            stage.close();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("New Employee");
            alert.setContentText("Employee added successfully");
            alert.showAndWait();
        }
        else if (mouseEvent.getSource() == cancel) {
        	Stage stage = (Stage) cancel.getScene().getWindow();
            stage.close();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("New Employee");
            alert.setContentText("Employee not added");
            alert.showAndWait();
        }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			loadComboBox();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void loadComboBox() throws IOException
    {
		department.getItems().add("HR");
		department.getItems().add("Back-End");
		department.getItems().add("Front-End");
		department.getItems().add("Testing");
		department.setPromptText("Select Department");
    }
	
	private void loadStage(String fxml) {
        try {
        	AnchorPane pane = FXMLLoader.load(getClass().getResource(fxml));
        	newEmployeePane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	

}
