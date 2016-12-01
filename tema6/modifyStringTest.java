package tema6;

import org.junit.Assert;
import org.junit.Test;

public class modifyStringTest {

	@Test
	public void modifyStringTestWithLowerCase() {
		// given
		String string = "I have four apples";
		StringUtility util = new StringUtility();
		// when
		String modifiedString = util.modifyString(string);
		// then
		String correctString = "I have 4 apples";
		Assert.assertEquals(correctString, modifiedString);

	}

	@Test
	public void modifyStringTestWithRandomeCase() {
		// given
		String string = "Five six SEVEN eiGHt !!";
		StringUtility util = new StringUtility();
		// when
		String modifiedString = util.modifyString(string);
		// then
		String correctString = "5 6 7 8 !!";
		Assert.assertEquals(correctString, modifiedString);

	}

	@Test
	public void modifyStringTestAsPartOfLargerWord() {
		// given
		String string = "I want twenty-nine dollars";
		StringUtility util = new StringUtility();
		// when
		String modifiedString = util.modifyString(string);
		// then
		String correctString = "I want twenty-nine dollars";
		Assert.assertEquals(correctString, modifiedString);

	}

	@Test
	public void modifyStringTestEqualToSummOfStrings() {
		// given
		String string1 = "two +";
		String string2 = " three";
		String string3 = " =";
		String string4 = " five";
		String string = string1 + string2 + string3 + string4;
		StringUtility util = new StringUtility();
		// when
		String modifiedString = util.modifyString(string);
		// then
		String correctString = "2 + 3 = 5";
		Assert.assertEquals(correctString, modifiedString);

	}
}
