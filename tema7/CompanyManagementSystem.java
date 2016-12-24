package tema7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * the CompanyManagementSystem allows us to see the full list of employees 
 * or only the ones with no parking space 
 * and it diplays the internal list of emploeeys depending on their role
 */
public class CompanyManagementSystem {

	private final Map<Role, List<Employee>> all = new TreeMap<>();

	// the comparator below helps display the list of employees in order of
	// their seniority
	public static final Comparator<Employee> SENIORITY = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			if (o1.getSeniority() == o2.getSeniority()) {
				return 0;
			} else if (o2.getSeniority() > o1.getSeniority()) {
				return 1;
			}
			return -1;
		}
	};

	// fills the map with a value for every key, and completes the list with all
	// the members of the values belonging to a certain key
	public void readEmployees(List<Employee> employees) {
		for (Employee emp : employees) {
			Role role = emp.getRole();
			if (all.get(role) != null) {
				all.get(role).add(emp);
			} else {
				List<Employee> people = new ArrayList<Employee>();
				people.add(emp);
				all.put(role, people);
			}
		}
	}

	// iterates through the map and displays the employees based on the role
	// they have
	public void internalListing() {
		Map<Role, List<Employee>> internal = this.all;
		for (Map.Entry<Role, List<Employee>> entry : internal.entrySet()) {
			System.out.println(entry.getKey() + "/ " + entry.getValue());
		}

	}

	// iterates through the list and and prints only the employees with no
	// parking space public
	public ArrayList<Employee> printNoParking() {
		ArrayList<Employee> employees = new ArrayList<>();
		for (List<Employee> people : all.values()) {
			employees.addAll(people);
			Collections.sort(employees, CompanyManagementSystem.SENIORITY);
		}
		for (Employee f : employees) {
			if (!f.isParkingSpace()) {
				System.out.println(f.toString());
			}
		}
		return employees;
	}

	// iterates through the map and prints all employees
	public ArrayList<Employee> allEmployees() {
		ArrayList<Employee> employees = new ArrayList<>();
		for (List<Employee> people : all.values()) {
			employees.addAll(people);
			Collections.sort(employees, CompanyManagementSystem.SENIORITY);
		}
		for (Employee f : employees) {
			System.out.println(f.toString());
		}
		return employees;

	}

}