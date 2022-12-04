package controllers;


import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import data.WorkshopsData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.WorkshopModel;

public class WorkshopsController implements Initializable {

	@FXML
	private AnchorPane workshopsPane;

	@FXML
	private Pane pane;

	@FXML
	private Accordion accordion;

	@FXML
	private ImageView workshopsHomeButton;

	@FXML
	private Button newWorkshop;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			loadWorkshops();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void handleButtonClicks(ActionEvent mouseEvent) throws IOException {

		if (mouseEvent.getSource() == newWorkshop) {
			loadNewStage("/fxml/NewWorkshop.fxml");
		}
	}
	
	public void redirectHome() {
    	loadStage("/fxml/Home.fxml");
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

	private void loadStage(String fxml) {
		try {
			AnchorPane pane = FXMLLoader.load(getClass().getResource(fxml));
			workshopsPane.getChildren().setAll(pane);
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

}
