package com.filesearch;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FileSearchTest {

	List<File> fileList;
	FileFinder fileFinder;
	
	@Before
	public void init(){
		
		fileList = new ArrayList<File>() {
			{
				add(new File("nature.jpg"));
				add(new File("NaturalNumber.java"));
				add(new File("Beauty of Nature.pdf"));
				add(new File("NaturalNumber.java.txt"));
				add(new File("car.jpg"));
				add(new File("cartoon.png"));
				add(new File("MyCart.java"));
				add(new File("Encarta.pdf"));
				add(new File("bullockCart.jpg.pdf"));
				add(new File("car of the year.html"));
				add(new File("Star of the year.jpg"));
				add(new File("car_of_the_day.html"));
				add(new File("NN.java"));
				add(new File("nn.class"));
				add(new File("nn_complex_filename.c"));
				
				
							
			}
		};
		
		fileFinder = new FileFinder(fileList);
	}

	@Test
	public void itGivesCorrectResultWhenSearchedForFullFileName() {

		
		assertEquals(Arrays.asList(new File("nature.jpg")), fileFinder.searchFile(new SearchQuery("nature.jpg")));
		assertEquals(Arrays.asList(new File("nature.jpg")), fileFinder.searchFile(new SearchQuery("Nature.jpg")));

	}
	
	@Test
	public void itGivesCorrectResultWhenSearchedWithStartingCharacters(){
		assertEquals(Arrays.asList(
				new File("nature.jpg"), 
				new File("NaturalNumber.java"), 
				new File("NaturalNumber.java.txt")),
				fileFinder.searchFile(new SearchQuery("nat")));
		
		assertEquals(Arrays.asList(
				new File("nature.jpg"), 
				new File("NaturalNumber.java"), 
				new File("NaturalNumber.java.txt")),
				fileFinder.searchFile(new SearchQuery("Nat")));
		
		assertEquals(Arrays.asList(
				new File("car.jpg"),
				new File("cartoon.png"),
				new File("car of the year.html"),
				new File("car_of_the_day.html")),
				fileFinder.searchFile(new SearchQuery("car")));
		
	}

	@Test
	public void itGivesCorrectResultWhenSearchedWithAsteriskPrefixed(){
		assertEquals(Arrays.asList(
				new File("nature.jpg"),
				new File("NaturalNumber.java"),
				new File("Beauty of Nature.pdf"),
				new File("NaturalNumber.java.txt")),
				fileFinder.searchFile(new SearchQuery("*nat")));
		
		assertEquals(Arrays.asList(
				new File("car.jpg"),
				new File("cartoon.png"),
				new File("MyCart.java"),
				new File("Encarta.pdf"),
				new File("bullockCart.jpg.pdf"),
				new File("car of the year.html"),
				new File("car_of_the_day.html")),
				fileFinder.searchFile(new SearchQuery("*car")));
		
		assertEquals(Arrays.asList(
				new File("Beauty of Nature.pdf"),
				new File("car of the year.html"),
				new File("Star of the year.jpg"),
				new File("car_of_the_day.html")),
				fileFinder.searchFile(new SearchQuery("*of")));
		
	}
	
	@Test
	public void itGivesCorrectResultWhenSingleFileFilterExtensionisSpecified(){
		assertEquals(Arrays.asList(new File("NaturalNumber.java")), fileFinder.searchFile(new SearchQuery("*nat",".java")));
		
	}
	
	@Test
	public void itGivesCorrectResultWhenMultipleFileFilterExtensionsAreSpecified(){
		assertEquals(Arrays.asList(
				new File("nature.jpg"), 
				new File("NaturalNumber.java")), 
				fileFinder.searchFile(new SearchQuery("*nat",".java",".jpg")));
		
	}

}
