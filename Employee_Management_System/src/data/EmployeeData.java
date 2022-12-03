package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.EmployeeModel;

public class EmployeeData {

	private static int idGenerator;

	public static ObservableList<EmployeeModel> employeeData;

	public static void loadData() throws IOException {

		BufferedReader br = null;
		String sCurrentLine;
		String lastLine = "";

		br = new BufferedReader(new FileReader("EmployeeData.txt"));

		while ((sCurrentLine = br.readLine()) != null) {
			//System.out.println(sCurrentLine);
			lastLine = sCurrentLine;
		}
		String[] lastLineArr = lastLine.split(",");
		idGenerator = Integer.parseInt(lastLineArr[0]) + 1;
		if (br != null)br.close();


		Collection<EmployeeModel> employeeList = Files.readAllLines(new File("EmployeeData.txt").toPath())
				.stream()
				.map(line -> {
					String[] details = line.split(",");
					EmployeeModel emp = new EmployeeModel();
					emp.setId(Integer.parseInt(details[0]));
					emp.setName(details[1]);
					emp.setDesignation(details[2]);
					emp.setDepartment(details[3]);
					emp.setReportsTo(details[4]);
					return emp;
				}).collect(Collectors.toList());

		employeeData = FXCollections.observableArrayList(employeeList);

	}

	public static void addEmployee(String name, String designation, String business, String manager) throws IOException {
		Files.write(Paths.get("EmployeeData.txt"), ("\n" + idGenerator + "," + name + "," + designation + "," + business  + "," + manager).getBytes(), StandardOpenOption.APPEND);
		employeeData.add(new EmployeeModel(idGenerator, name, designation, business, manager));
		idGenerator++;
	}

}
