import java.util.ArrayList;

public class Company_ {
	private String name;
	private String location;
	public ArrayList<Employee> employees = new ArrayList<Employee>();

	public void payEmployees() {
		throw new UnsupportedOperationException();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Company_(String name, String location, ArrayList<Employee> employees) {
		super();
		this.name = name;
		this.location = location;
		this.employees = employees;
	}
}