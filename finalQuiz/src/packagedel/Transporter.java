package packagedel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/*
 * This class extends the thread class, calculates the profit, and travels the distance to each destination.
 */
public class Transporter extends Thread {

	private final static int COST_PER_KM = 10;
	private List<Package> pcg = Collections
			.synchronizedList(new ArrayList<Package>());

	public Transporter(List<Package> pcg) {
		this.pcg = pcg;
	}

	public List<Package> getPcg() {
		return pcg;
	}

	public void setPcg(List<Package> pcg) {
		this.pcg = pcg;
	}

	// this method calculates the profit
	public int calculateProfit() {
		int venit = 0;
		for (Package item : pcg) {

			venit += item.getMerchendiseValue();
		}

		int cost = Transporter.COST_PER_KM * this.getDistance();
		return venit - cost;

	}

	// this method travels the distance
	@Override
	public void run() {

		try {
			synchronized (pcg) {
				Thread.sleep(1000 * this.getDistance());
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Destinatie: " + this.getDestination() + " "
				+ " Data livrare: " + this.getDate() + " "
				+ " Merchendise Value: " + this.getMerchendiseValue()
				+ " Profit: " + this.calculateProfit() + " lei.");
	}

	private int getDistance() {
		int dist = 0;
		for (Package item : pcg) {
			dist = item.getKm();
		}
		return dist;
	}

	private String getDestination() {
		String destination = null;
		for (Package item : pcg) {
			destination = item.getLocation();
		}
		return destination;
	}

	private String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		for (Package item : pcg) {
			date = item.getDeliveryDate();
		}
		String format = sdf.format(date);
		return format;
	}

	private int getMerchendiseValue() {
		int value = 0;
		for (Package item : pcg) {
			value += item.getMerchendiseValue();
		}
		return value;
	}

}
