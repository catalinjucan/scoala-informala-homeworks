package packagedel;

import java.util.Date;

/*
 * This is the Package class, it is a POJO class for the Project. 
 */

public class Package {

	private String location;
	private int km;
	private int merchendiseValue;
	private Date deliveryDate;

	public Package(String location, int km, int merchendiseValue,
			Date deliveryDate) {
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

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getMerchendiseValue() {
		return merchendiseValue;
	}

	public void setMerchendiseValue(int merchendiseValue) {
		this.merchendiseValue = merchendiseValue;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}



}
