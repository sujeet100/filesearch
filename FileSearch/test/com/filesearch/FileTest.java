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

	@Test
	public void itSetsCorrectFileSizeInKBs() {

		File file = new File("myfile.txt", "1024KB");
		assertEquals(new Float(1024),file.getFileSize());
	}

	@Test
	public void itSetsConvertsFileSizeFromMBsToKBs() {

		File file = new File("myfile.txt", "1MB");
		assertEquals(new Float(1024),file.getFileSize());
		
		File file2 = new File("anotherFile.txt", "1.1MB");
		assertEquals(new Float(1126.4),file2.getFileSize());
	}

}
