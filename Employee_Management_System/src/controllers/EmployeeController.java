package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.EmployeeData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.EmployeeModel;

public class EmployeeController implements Initializable {
	
	@FXML
	private AnchorPane employeesPane;
	
	@FXML
    private Button home;
	
	@FXML
    private TableView<EmployeeModel> employeesTable;
	
	@FXML
    public TableColumn<EmployeeModel, String> employeeId;
	
	@FXML
    public TableColumn<EmployeeModel, String> employeeName;

    @FXML
    public TableColumn<EmployeeModel, String> designation;
    
    @FXML
    public TableColumn<EmployeeModel, String> department;
    
    @FXML
    public TableColumn<EmployeeModel, String> reportsTo;
    
    @FXML
    public Button addNewEmployee;
    
    public void handleButtonClicks(ActionEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() == home) {
        	loadStage("/fxml/Home.fxml");
        }
        
        else if (mouseEvent.getSource() == addNewEmployee) {
        	loadNewStage("/fxml/NewEmployee.fxml");
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	try {
			loadEmployees();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void loadEmployees() throws IOException
    {
    	employeeId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	employeeName.setCellValueFactory(new PropertyValueFactory<>("Name"));
    	designation.setCellValueFactory(new PropertyValueFactory<>("Designation"));
    	department.setCellValueFactory(new PropertyValueFactory<>("Department"));
    	reportsTo.setCellValueFactory(new PropertyValueFactory<>("ReportsTo"));
    	EmployeeData.loadData();
    	employeesTable.setItems(EmployeeData.employeeData);
    }

    private void loadStage(String fxml) {
        try {
        	AnchorPane pane = FXMLLoader.load(getClass().getResource(fxml));
        	employeesPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void loadNewStage(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}