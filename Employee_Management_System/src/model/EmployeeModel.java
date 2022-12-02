package model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmployeeModel {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty designation;
	private SimpleStringProperty department;
	private SimpleStringProperty reportsTo;
	
	public EmployeeModel() {
		super();
	}
	
	public EmployeeModel(Integer id, String name, String designation, String department, String reportsTo) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.designation = new SimpleStringProperty(designation);
		this.department = new SimpleStringProperty(department);
		this.reportsTo = new SimpleStringProperty(reportsTo);
	}
	
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}
	public int getId() {
		return id.get();
	}
	public void setId(int id) {
		this.id = new SimpleIntegerProperty(id);
	}
	public String getDesignation() {
		return designation.get();
	}
	public void setDesignation(String designation) {
		this.designation = new SimpleStringProperty(designation);
	}
	public String getDepartment() {
		return department.get();
	}
	public void setDepartment(String department) {
		this.department = new SimpleStringProperty(department);
	}
	public String getReportsTo() {
		return reportsTo.get();
	}
	public void setReportsTo(String reportsTo) {
		this.reportsTo = new SimpleStringProperty(reportsTo);
	}
	
}
