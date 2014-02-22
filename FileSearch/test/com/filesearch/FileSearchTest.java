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
	
	@SuppressWarnings("serial")
	@Before
	public void init(){
		
		fileList = new ArrayList<File>() {
			{
				add(new File("nature.jpg", "1024KB"));
				add(new File("NaturalNumber.java", "1.1MB"));
				add(new File("Beauty of Nature.pdf","2MB"));
				add(new File("NaturalNumber.java.txt","500KB"));
				add(new File("car.jpg","145KB"));
				add(new File("cartoon.png", "422KB"));
				add(new File("MyCart.java", "2.2MB"));
				add(new File("Encarta.pdf", "10MB"));
				add(new File("bullockCart.jpg.pdf", "122MB"));
				add(new File("car of the year.html", "3MB"));
				add(new File("Star of the year.jpg", "800KB"));
				add(new File("car_of_the_day.html", "1025KB"));
				add(new File("NN.java", "5MB"));
				add(new File("nn.class", "6MB"));
				add(new File("nn_complex_filename.c", "100KB"));
				
				
							
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

	
	@Test
	public void itSortsTheSearchResultAccordingToFileName(){
		assertEquals(Arrays.asList(
				new File("Beauty of Nature.pdf"),
				new File("NaturalNumber.java"),
				new File("NaturalNumber.java.txt"),
				new File("nature.jpg")),
				fileFinder.searchFile(new SearchQuery("*nat", SortOn.FILENAME)));
		
		assertEquals(Arrays.asList(
				new File("bullockCart.jpg.pdf"),
				new File("car of the year.html"),
				new File("car.jpg"),
				new File("car_of_the_day.html"),
				new File("cartoon.png"),
				new File("Encarta.pdf"),
				new File("MyCart.java")),
				fileFinder.searchFile(new SearchQuery("*car", SortOn.FILENAME)));
		
		assertEquals(Arrays.asList(
				new File("Beauty of Nature.pdf"),
				new File("car of the year.html"),
				new File("car_of_the_day.html"),
				new File("Star of the year.jpg")),
				fileFinder.searchFile(new SearchQuery("*of", SortOn.FILENAME)));
		
	}
	
	@Test
	public void itSortsTheSearchResultAccordingToFileSize(){
		assertEquals(Arrays.asList(
				new File("NaturalNumber.java.txt"),
				new File("nature.jpg"),
				new File("NaturalNumber.java"),
				new File("Beauty of Nature.pdf")),
				fileFinder.searchFile(new SearchQuery("*nat", SortOn.FILESIZE)));
		
		assertEquals(Arrays.asList(
				new File("car.jpg"),
				new File("cartoon.png"),
				new File("car_of_the_day.html"),
				new File("MyCart.java"),
				new File("car of the year.html"),
				new File("Encarta.pdf"),
				new File("bullockCart.jpg.pdf")),
				fileFinder.searchFile(new SearchQuery("*car", SortOn.FILESIZE)));
		
		
	}
}
