package data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.stream.Collectors;

import model.EmployeeModel;
import model.WorkshopModel;

public class WorkshopsData {
	
	public static Collection<WorkshopModel> workshopsList;
	
	public static void loadData() throws IOException {
		
		workshopsList = Files.readAllLines(new File("WorkshopsData.txt").toPath())
				.stream()
				.map(line -> {
					String[] details = line.split(",");
					WorkshopModel workshopModel = new WorkshopModel();
					workshopModel.setTitle(details[0]);
					workshopModel.setDescription(details[1]);
					return workshopModel;
				}).collect(Collectors.toList());
		
	}
	
	public static void addWorkshop(String title, String description) throws IOException {
		Files.write(Paths.get("WorkshopsData.txt"), ("\n" + title + "," + description).getBytes(), StandardOpenOption.APPEND);
		workshopsList.add(new WorkshopModel(title, description));
	}

}
