package packagedel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/*
 * This is the main class.
 */
public class Main {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Distributor dst = new Distributor();

		List<Package> packageList = new ArrayList<>();

		packageList.add(new Package("Cluj", 25, 120, sdf.parse("02/27/2017")));
		packageList.add(new Package("Dej", 30, 55, sdf.parse("02/27/2017")));
		packageList.add(new Package("Turda", 28, 78, sdf.parse("02/27/2017")));
		packageList.add(new Package("Cluj", 25, 150, sdf.parse("02/27/2017")));
		packageList.add(new Package("Turda", 28, 92, sdf.parse("02/27/2017")));
		packageList.add(new Package("Cluj", 25, 22, sdf.parse("02/27/2017")));
		packageList.add(new Package("Cluj", 25, 43, sdf.parse("02/27/2017")));
		packageList.add(new Package("Dej", 30, 254, sdf.parse("02/27/2017")));
		packageList.add(new Package("Dej", 30, 134, sdf.parse("02/27/2017")));
		packageList.add(new Package("Turda", 28, 26, sdf.parse("02/27/2017")));
		packageList.add(new Package("Turda", 28, 144, sdf.parse("02/27/2017")));
		packageList.add(new Package("Cluj", 25, 154, sdf.parse("02/27/2017")));

		dst.setPackageList(packageList);
		dst.startDelivery();

	}

}
