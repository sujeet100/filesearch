package com.filesearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FileTest {

	@Test
	public void itSetsCorrectFileExtension() {

		File file = new File("somefile.someExt");
		assertEquals(".someExt",file.getExtension());
	}
	

	@Test
	public void itSetsCorrectFileExtensionWhenTwoDots() {

		File file = new File("somefile.someOtherText.someExt");
		assertEquals(".someExt",file.getExtension());
	}

	@Test
	public void itSetsCorrectFileExtensionWhenMultipleDots() {

		File file = new File("somefile.someOtherText.anotherText.someExt");
		assertEquals(".someExt",file.getExtension());
	}

}
