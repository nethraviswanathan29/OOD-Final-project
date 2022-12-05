package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.DashboardData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.DashboardModel;

public class DashboardController implements Initializable {
	
	@FXML
	private AnchorPane dashboardPane;
	
	@FXML
	private ImageView dashboardHome;
	
	@FXML
	private ImageView logout;
	
	@FXML
    private Label billHours;
	
	@FXML
	private TableView<DashboardModel> dashboardTable;
	 
	@FXML
    private Label noOfEmployees;
	
	@FXML
    private TableColumn<DashboardModel, String> date;

    @FXML
    private TableColumn<DashboardModel, String> id;
    
    @FXML
    private TableColumn<DashboardModel, String> name;

    @FXML
    private TableColumn<DashboardModel, String> hours;
	
	public void logOut() {
    	loadStage("/fxml/Login.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			loadDashboard();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void redirectHome() {
    	loadStage("/fxml/Home.fxml");
	}
	
	public void handleButtonClicks(ActionEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() == dashboardHome) {
        	loadStage("/fxml/Home.fxml");
        }
    }
	
	private void loadStage(String fxml) {
        try {
        	AnchorPane pane = FXMLLoader.load(getClass().getResource(fxml));
        	dashboardPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	private void loadDashboard() throws IOException {
		DashboardData.loadData();
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
    	name.setCellValueFactory(new PropertyValueFactory<>("Name"));
    	date.setCellValueFactory(new PropertyValueFactory<>("Date"));
    	hours.setCellValueFactory(new PropertyValueFactory<>("Hours"));
    	Integer totalhours = 0;
    	for(DashboardModel dm : DashboardData.dashboardData) {
    		totalhours += dm.getHours();
    	}
    	billHours.setText("" + totalhours);
    	dashboardTable.setItems(DashboardData.dashboardData);
	}

}
