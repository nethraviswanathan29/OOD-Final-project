package data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.DashboardModel;
import model.EmployeeModel;

public class DashboardData {
	
	public static ObservableList<DashboardModel> dashboardData;
	
	public static void loadData() throws IOException {

		Collection<DashboardModel> salaryList = Files.readAllLines(new File("DashboardData.txt").toPath())
				.stream()
				.map(line -> {
					String[] details = line.split(",");
					DashboardModel dashboardModel = new DashboardModel();
					dashboardModel.setId(Integer.parseInt(details[0]));
					dashboardModel.setName(details[1]);
					dashboardModel.setDate(details[2]);
					dashboardModel.setHours(Integer.parseInt(details[3]));
					return dashboardModel;
				}).collect(Collectors.toList());

		dashboardData = FXCollections.observableArrayList(salaryList);

	}
	
	public static void addDashboardData(Integer id, String name, String date, Integer hours) throws IOException {
		Files.write(Paths.get("DashboardData.txt"), ("\n" + id + "," + name + "," + date + "," + hours).getBytes(), StandardOpenOption.APPEND);
		dashboardData.add(new DashboardModel(id, name, date, hours));
	}
}
