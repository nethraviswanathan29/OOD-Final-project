package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Controller implements Initializable{
	
	@FXML
	private AnchorPane rootPane;

    @FXML
    private Button Announcements;

    @FXML
    private Button Departments;

    @FXML
    private Button Employees;
    
    @FXML
    private Button Dashboard;

    @FXML
    private Button Salaries;

    @FXML
    private Button Workshops;
    
    @FXML
    private PieChart pieChart;
    
    public void handleButtonClicks(ActionEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() == Dashboard) {
            //Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        	loadStage("/fxml/Dashboard.fxml");
        } 
        else if (mouseEvent.getSource() == Employees) {
            loadStage("/fxml/Employees.fxml");
        } else if (mouseEvent.getSource() == Workshops) {
            loadStage("/fxml/Workshops.fxml");
        }
        else if (mouseEvent.getSource() == Salaries) {
            loadStage("/fxml/Salaries.fxml");
        }
        else if (mouseEvent.getSource() == Departments) {
            loadStage("/fxml/Departments.fxml");
        }
        else if (mouseEvent.getSource() == Announcements) {
            loadStage("/fxml/Annoucements.fxml");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//    	ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
//    			new PieChart.Data("D.VA",13),
//    			new PieChart.Data("Mercy",22),
//    			new PieChart.Data("Tracer",15),
//    			new PieChart.Data("Widowmaker",10));
//    	
//    	pieChart.setData(pieChartData);
    }
    
    private void loadStage(String fxml) {
        try {
        	AnchorPane pane = FXMLLoader.load(getClass().getResource(fxml));
        	rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}

