package tema6;


public class Main {

	public static void main(String[] args) {

		StringUtility util = new StringUtility();
		String string1 = "two +";
		String string2 = " three";
		String string3 = " =";
		String string4 = " five";
		String string = string1 + string2 + string3 + string4;
		// String string = "NINE boys and seVen girls, three!!";
		System.out.println(string);
		System.out.println(util
				.modifyString(string));
		System.out.println(util.removeFreeSpace(string));
	}
}
