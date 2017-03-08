package packagedel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * The Distributor class sorts the Package Objects by date and location, and ties each bunch with a thread.
 */
public class Distributor {

	Map<String, List<Package>> map = new HashMap<>();

	// this method separates the packages by destination and delivery date
	public void setPackageList(List<Package> packageList) {

		for (Package package1 : packageList) {
			List<Package> list = map.get(package1.getLocation()
					+ package1.getDeliveryDate().toString());
			if (list == null) {
				list = new ArrayList<Package>();
				map.put(package1.getLocation() + package1.getDeliveryDate(),
						list);
			}
			list.add(package1);
		}

	}

	// this method assigns each package bunch to a thread
	public void startDelivery() {
		Map<String, List<Package>> internal = this.map;
		ExecutorService executor = Executors.newFixedThreadPool(internal
				.keySet().hashCode());
		for (Map.Entry<String, List<Package>> entry : internal.entrySet()) {
			Transporter tr = new Transporter(entry.getValue());
			executor.execute(tr);
		}
		executor.shutdown();

	}
}
