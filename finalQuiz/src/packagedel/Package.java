package packagedel;


public class Package {

	private String location;
	private double km;
	private double merchendiseValue;
	private String deliveryDate;

	public Package(String location, double km, double merchendiseValue,
			String deliveryDate) {
		super();
		this.location = location;
		this.km = km;
		this.merchendiseValue = merchendiseValue;
		this.deliveryDate = deliveryDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public double getMerchendiseValue() {
		return merchendiseValue;
	}

	public void setMerchendiseValue(double merchendiseValue) {
		this.merchendiseValue = merchendiseValue;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}



}
