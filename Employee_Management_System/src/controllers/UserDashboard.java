package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.ResourceBundle;

import data.WorkshopsData;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import model.HolidayModel;
import model.WorkshopModel;

public class UserDashboard implements Initializable{
	
	@FXML
	private AnchorPane userDashboard;
	
	@FXML
	private ImageView logout;
	
	@FXML
	private Label dateTime;
	
	@FXML
	private Accordion accordion;
	
	@FXML
    private TableColumn<String, String> date;

    @FXML
    private TableColumn<String, String> holiday;

    @FXML
    private TableView<HolidayModel> holidayTable;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		try {
			loadWorkshops();
			loadHolidays();
			initClock();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	private void initClock() {

	    Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        dateTime.setText(LocalDateTime.now().format(formatter));
	    }), new KeyFrame(Duration.seconds(1)));
	    clock.setCycleCount(Animation.INDEFINITE);
	    clock.play();
	}
	
	public void logOut() {
    	loadStage("/fxml/Login.fxml");
    }
	
	private void loadStage(String fxml) {
        try {
        	AnchorPane pane = FXMLLoader.load(getClass().getResource(fxml));
        	userDashboard.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	private void loadWorkshops() throws IOException {
		
		WorkshopsData.loadData();
		Collection<WorkshopModel> workshopsList = WorkshopsData.workshopsList;
		
		for(WorkshopModel workshop : workshopsList) {
			TitledPane tp = new TitledPane();
			tp.setFont(Font.font("System", FontWeight.NORMAL ,FontPosture.REGULAR, 23));
			
			tp.setText(workshop.getTitle());
			AnchorPane ap = new AnchorPane();
			ap.getChildren().add(new Label(workshop.getDescription()));
			tp.setContent(ap);
			accordion.getPanes().add(tp);
		}
		
	}
	
	private void loadHolidays() throws IOException {
		
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        holiday.setCellValueFactory(new PropertyValueFactory<>("holiday"));
        
        holidayTable.setItems(holidayModels);
	}
	
	private ObservableList<HolidayModel> holidayModels = FXCollections.observableArrayList(
            new HolidayModel("Jan. 1", "New Year’s Day"),
            new HolidayModel("Jan. 18", "Martin Luther King’s Birthday"),
            new HolidayModel("Feb. 15", "Washington’s Birthday"),
            new HolidayModel("Mar. 17", "Evacuation Day"),
            new HolidayModel("Apr. 19", "Patriot’s Day"),
            new HolidayModel("May 31", "Memorial Day"),
            new HolidayModel("June 17", "Bunker Hill Day"),
            new HolidayModel("Independence Day", "July 4"),
            new HolidayModel("Labor Day", "Sept. 6"),
            new HolidayModel("Columbus Day", "Oct. 11"),
            new HolidayModel("Veterans’ Day", "Nov. 11"),
            new HolidayModel("Thanksgiving Day", "Nov. 25"),
            new HolidayModel("Christmas Day", "Dec. 25")
    );

}
