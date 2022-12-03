package data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.SalaryModel;

public class SalaryData {

	public static ObservableList<SalaryModel> salaryData;

	public static void loadData() throws IOException {


		Collection<SalaryModel> salaryList = Files.readAllLines(new File("SalaryData.txt").toPath())
				.stream()
				.map(line -> {
					String[] details = line.split(",");
					SalaryModel salaryModel = new SalaryModel();
					salaryModel.setId(Integer.parseInt(details[0]));
					salaryModel.setName(details[1]);
					salaryModel.setSalaryPerAnnum(details[2]);
					salaryModel.setSalaryRevision(details[3]);
					salaryModel.setEmployeeType(details[4]);
					return salaryModel;
				}).collect(Collectors.toList());

		salaryData = FXCollections.observableArrayList(salaryList);

	}

}
