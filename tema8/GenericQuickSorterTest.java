package tema8;

import org.junit.Assert;
import org.junit.Test;

public class GenericQuickSorterTest {


	@Test
	public void testInteger() {
		Integer[] unsortedInteger = { 9, 11, 41, 8, 2, 5, 23, 7 };

		GenericQuickSorter bsa = new GenericQuickSorter();

		bsa.sort(unsortedInteger, 0, unsortedInteger.length - 1);

		Integer[] sortedInteger = { 2, 5, 7, 8, 9, 11, 23, 41 };

		Assert.assertArrayEquals(sortedInteger, unsortedInteger);
	}

	@Test
	public void testString() {
		String[] unsortedString = { "Ana", "Anemona", "Aria", "Ariana",
				"Amanda", "Andreea" };

		GenericQuickSorter bss = new GenericQuickSorter();

		bss.sort(unsortedString, 0, unsortedString.length - 1);

		String[] sortedString = { "Amanda", "Ana", "Andreea", "Anemona",
				"Aria", "Ariana" };

		Assert.assertArrayEquals(sortedString, unsortedString);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testObject() {

		Car[] car = new Car[4];
		car[0] = new Car<Object>("BMW", 6);
		car[1] = new Car<Object>("Audi", 2);
		car[2] = new Car<Object>("VW", 4);
		car[3] = new Car<Object>("Mercedes", 1);

		GenericQuickSorter obj = new GenericQuickSorter();

		obj.sort(car, 0, car.length - 1);

		Car[] car1 = new Car[4];
		car1[0] = new Car<Object>("Mercedes", 1);
		car1[1] = new Car<Object>("Audi", 2);
		car1[2] = new Car<Object>("VW", 4);
		car1[3] = new Car<Object>("BMW", 6);

		Assert.assertArrayEquals(car1, car);
	}
}
