package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.EmployeeData;
import data.SalaryData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.EmployeeModel;
import model.SalaryModel;

public class SalaryController implements Initializable {
	

	
	@FXML
	private AnchorPane salaryPane;
	
	@FXML
	private ImageView salaryHomeButton;
	
	@FXML
    private TableView<SalaryModel> salaryTable;
	
	@FXML
    public TableColumn<SalaryModel, String> employeeId;
	
	@FXML
    public TableColumn<SalaryModel, String> employeeName;

    @FXML
    public TableColumn<SalaryModel, String> salaryPerAnnum;
    
    @FXML
    public TableColumn<SalaryModel, String> salaryRevision;
    
    @FXML
    public TableColumn<SalaryModel, String> department;
    
    @FXML
    public Button addNewEmployee;
    
    @FXML
    private PieChart salaryPieChart;
    
    @FXML
	private ImageView logout;
	
	public void logOut() {
    	loadStage("/fxml/Login.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	try {
			loadEmployeeSalaries();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void loadEmployeeSalaries() throws IOException
    {
    	employeeId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	employeeName.setCellValueFactory(new PropertyValueFactory<>("Name"));
    	salaryPerAnnum.setCellValueFactory(new PropertyValueFactory<>("SalaryPerAnnum"));
    	salaryRevision.setCellValueFactory(new PropertyValueFactory<>("SalaryRevision"));
    	department.setCellValueFactory(new PropertyValueFactory<>("Department"));
    	SalaryData.loadData();
    	salaryTable.setItems(SalaryData.salaryData);
    	salaryPieChart.setData(SalaryData.salaryPieChartData);
    }
    
    private void loadStage(String fxml) {
        try {
        	AnchorPane pane = FXMLLoader.load(getClass().getResource(fxml));
        	salaryPane.getChildren().setAll(pane);
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
	
    public void redirectHome() {
        	loadStage("/fxml/Home.fxml");
        
    }

}
