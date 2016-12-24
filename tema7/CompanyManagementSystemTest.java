package tema7;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class CompanyManagementSystemTest {



	@Test
	public void printNoParkingTest() {
		// given
		ArrayList<Employee> colleagues = new ArrayList<>();
		colleagues.add(new Employee("John", 10, true, Role.MANAGEMENT));
		colleagues.add(new Employee("Tim", 3, true, Role.HR_EMPLOYEES));
		colleagues.add(new Employee("Dana", 5, false, Role.HR_EMPLOYEES));
		colleagues.add(new Employee("Stevie", 1, false, Role.IT_EMPLOYEES));
		colleagues.add(new Employee("Paul", 7, false, Role.MANAGEMENT));
		CompanyManagementSystem com = new CompanyManagementSystem();
		// when
		com.readEmployees(colleagues);
		com.printNoParking();
		// then
		ArrayList<Employee> correctList = new ArrayList<>();
		correctList.add(new Employee("Dana", 5, false, Role.HR_EMPLOYEES));
		correctList.add(new Employee("Paul", 7, false, Role.MANAGEMENT));
		correctList.add(new Employee("Stevie", 1, false, Role.IT_EMPLOYEES));
		Collections.sort(correctList, CompanyManagementSystem.SENIORITY);
		for (Employee f : correctList) {
			System.out.println(f.toString());
		}
		colleagues.equals(correctList);

	}

	@Test
	public void allEmployeesTest() {
		// given
		ArrayList<Employee> colleagues = new ArrayList<>();
		colleagues.add(new Employee("John", 10, true, Role.MANAGEMENT));
		colleagues.add(new Employee("Tim", 3, true, Role.HR_EMPLOYEES));
		colleagues.add(new Employee("Dana", 5, false, Role.HR_EMPLOYEES));
		colleagues.add(new Employee("Stevie", 1, false, Role.IT_EMPLOYEES));
		colleagues.add(new Employee("Paul", 7, false, Role.MANAGEMENT));
		CompanyManagementSystem com = new CompanyManagementSystem();
		// when
		com.readEmployees(colleagues);
		com.allEmployees();
		// then
		ArrayList<Employee> correctList = new ArrayList<>();
		correctList.add(new Employee("John", 10, true, Role.MANAGEMENT));
		correctList.add(new Employee("Tim", 3, true, Role.HR_EMPLOYEES));
		correctList.add(new Employee("Dana", 5, false, Role.HR_EMPLOYEES));
		correctList.add(new Employee("Stevie", 1, false, Role.IT_EMPLOYEES));
		correctList.add(new Employee("Paul", 7, false, Role.MANAGEMENT));

		Collections.sort(correctList, CompanyManagementSystem.SENIORITY);
		for (Employee f : correctList) {
			System.out.println(f.toString());
		}
		colleagues.equals(correctList);
	}
}
