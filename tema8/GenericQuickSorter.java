package tema8;

/*
 * The class below helps in sorting all types of objects.
 */

public class GenericQuickSorter {

	// This method uses the quicksort algorithm
	public <T extends Comparable<T>> void sort(T[] arr, int a, int b) {

		if (a < b) {
			int i = a, j = b;
			T x = arr[(i + j) / 2];

			do {
				while (arr[i].compareTo(x) < 0)
					i++;
				while (x.compareTo(arr[j]) < 0)
					j--;

				if (i <= j) {
					T tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
					i++;
					j--;
				}

			} while (i <= j);

			sort(arr, a, j);
			sort(arr, i, b);
		}

	}

}
