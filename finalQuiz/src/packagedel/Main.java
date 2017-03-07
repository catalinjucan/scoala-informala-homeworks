package packagedel;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Sorter so = new Sorter();

		List<Package> packageList = new ArrayList<>();
		
		packageList.add(new Package("Cluj", 25, 120, "27/02/2017"));
		packageList.add(new Package("Cluj", 25, 300, "27/02/2017"));
		packageList.add(new Package("Bucuresti", 200, 1000, "28/02/2017"));
		packageList.add(new Package("Iasi", 340, 400, "28/02/2017"));
		packageList.add(new Package("Cluj", 25, 50, "25/02/2017"));
		packageList.add(new Package("Iasi", 340, 120, "27/02/2017"));
		packageList.add(new Package("Iasi", 340, 700, "28/02/2017"));
		packageList.add(new Package("Cluj", 25, 70, "25/02/2017"));
		packageList.add(new Package("Bucuresti", 200, 220, "28/02/2017"));
		packageList.add(new Package("Cluj", 25, 140, "25/02/2017"));


	}

}
