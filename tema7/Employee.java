package tema7;

/*
 * The Employee class contains all the informations regarding the the personeel
 */

public class Employee {



	private final String name;
	private final int seniority;
	private final boolean parkingSpace;
	private final Role role;


	public Employee(String string, int seniority,
			boolean parkingSpace,
			Role role) {
		this.name = string;
		this.seniority = seniority;
		this.parkingSpace = parkingSpace;
		this.role = role;
	}


	public String getName() {
		return name;
	}

	public int getSeniority() {
		return seniority;
	}

	public boolean isParkingSpace() {
		return parkingSpace;
	}

	public Role getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "Employee " + name + ", seniority " + seniority + " year/s";
	}

}
