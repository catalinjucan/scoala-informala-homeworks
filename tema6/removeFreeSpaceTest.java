package tema6;

import org.junit.Assert;
import org.junit.Test;

public class removeFreeSpaceTest {

	@Test
	public void removeFreeSpaceFromSentence() {
		// given
		String stri = "Jen 01 Adam";
		StringUtility util = new StringUtility();
		// when
		String noSpaceString = util.removeFreeSpace(stri);
		// then
		String correctString = "Jen01Adam";
		Assert.assertEquals(correctString, noSpaceString);

	}

}
