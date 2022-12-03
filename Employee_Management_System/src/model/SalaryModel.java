package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SalaryModel {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty salaryPerAnnum;
	private SimpleStringProperty salaryRevision;
	private SimpleStringProperty department;

	public SalaryModel() {
		super();
	}

	public SalaryModel(Integer id, String name, String salaryPerAnnum, String salaryRevision, String department) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.salaryPerAnnum = new SimpleStringProperty(salaryPerAnnum);
		this.salaryRevision = new SimpleStringProperty(salaryRevision);
		this.department = new SimpleStringProperty(department);
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
	public String getSalaryPerAnnum() {
		return salaryPerAnnum.get();
	}
	public void setSalaryPerAnnum(String salaryPerAnnum) {
		this.salaryPerAnnum = new SimpleStringProperty(salaryPerAnnum);
	}
	public String getSalaryRevision() {
		return salaryRevision.get();
	}
	public void setSalaryRevision(String salaryRevision) {
		this.salaryRevision = new SimpleStringProperty(salaryRevision);
	}
	public String getDepartment() {
		return department.get();
	}
	public void setDepartment(String department) {
		this.department = new SimpleStringProperty(department);
	}

}

