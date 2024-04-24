package org.arya.interview;

public class Employee {

	private long id;
	private String name;
	private int salary;
	private Department department;

	public Employee(long id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public Employee(long id, String name, int salary, Department department) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ","
				+ " name=" + name + ","
				+ " salary=" + salary + ","
				+ " department=" + department + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


}