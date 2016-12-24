package tema7;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		CompanyManagementSystem comp = new CompanyManagementSystem();

		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Johny Memonic", 10, true, Role.MANAGEMENT));
		employees.add(new Employee("Tim McGraw", 3, true, Role.HR_EMPLOYEES));
		employees.add(new Employee("Martha Stewart", 5, false,
				Role.HR_EMPLOYEES));
		employees.add(new Employee("Stevie B", 1, false, Role.IT_EMPLOYEES));
		employees.add(new Employee("Ion Aglanetasului", 7, true,
				Role.MANAGEMENT));
		employees.add(new Employee("Jimmy Stix", 4, true,
				Role.FINANCE_EMPLOYEES));
		employees.add(new Employee("Kenneth Anderssen", 2, false,
				Role.IT_EMPLOYEES));
		employees.add(new Employee("Trevor Noah", 4, false,
				Role.FINANCE_EMPLOYEES));
		employees.add(new Employee("Andrew Jackson", 8, false,
				Role.IT_EMPLOYEES));
		employees.add(new Employee("Ralph Loyd", 6, true, Role.IT_EMPLOYEES));
		employees.add(new Employee("Tim Dalton", 7, false,
				Role.FINANCE_EMPLOYEES));
		employees.add(new Employee("Evita Peron", 5, true, Role.HR_EMPLOYEES));
		employees.add(new Employee("Johny O", 1, false, Role.IT_EMPLOYEES));

		comp.readEmployees(employees);
		System.out.println("\nRole specific list of employees:");
		comp.internalListing();
		System.out.println("\nEmployees with no parking:");
		comp.printNoParking();
		System.out.println("\nAll employees:");
		comp.allEmployees();

	}
}
