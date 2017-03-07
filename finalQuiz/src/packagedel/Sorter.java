package packagedel;

import java.util.Comparator;

public class Sorter implements Comparator<Package> {

	@Override
	public int compare(Package packageList, Package packageList2) {
		if (packageList.getLocation() == packageList2.getLocation()
				&& packageList.getDeliveryDate() == packageList2
						.getDeliveryDate()) {
			return 0;
		} else
			return 1;
	}

}
