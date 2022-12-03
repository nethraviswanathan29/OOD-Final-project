package data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import model.SalaryModel;

public class SalaryData {

	public static ObservableList<SalaryModel> salaryData;

	public static ObservableList<PieChart.Data> salaryPieChartData;

	public static void loadData() throws IOException {

		HashMap<String, Integer> salaryByDepartment = new HashMap<String, Integer>();

		salaryByDepartment.put("HR", 0);
		salaryByDepartment.put("Back-End", 0);
		salaryByDepartment.put("Front-End", 0);
		salaryByDepartment.put("Testing", 0);


		Collection<SalaryModel> salaryList = Files.readAllLines(new File("SalaryData.txt").toPath())
				.stream()
				.map(line -> {
					String[] details = line.split(",");
					SalaryModel salaryModel = new SalaryModel();
					salaryModel.setId(Integer.parseInt(details[0]));
					salaryModel.setName(details[1]);
					salaryModel.setSalaryPerAnnum(details[2]);
					salaryModel.setSalaryRevision(details[3]);
					salaryModel.setDepartment(details[4]);
					salaryByDepartment.put(details[4], salaryByDepartment.get(details[4]) + Integer.parseInt(details[0]));
					return salaryModel;
				}).collect(Collectors.toList());

		salaryData = FXCollections.observableArrayList(salaryList);

		salaryPieChartData = FXCollections.observableArrayList(
				new PieChart.Data("HR", salaryByDepartment.get("HR")),
				new PieChart.Data("Back-End", salaryByDepartment.get("Back-End")),
				new PieChart.Data("Front-End", salaryByDepartment.get("Front-End")),
				new PieChart.Data("Testing", salaryByDepartment.get("Testing")));

	}

}
