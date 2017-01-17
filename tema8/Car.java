package tema8;

/*
 * This class creates custom Car objects.
 */

public class Car<T> implements Comparable<T> {
	private final String model;
	private final int age;

	public Car(String model, int age) {
		super();
		this.model = model;
		this.age = age;
	}

	public String getModel() {
		return model;
	}

	public int getAge() {
		return age;
	}

	// This method compares the Cars by the age that they have
	@Override
	public int compareTo(Object otherCar) throws ClassCastException {
		int otherCarAge = ((Car<?>) otherCar).getAge();
		return this.age - otherCarAge;

	}

	// This method implements equals.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car<?> other = (Car<?>) obj;
		if (age != other.age)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

}