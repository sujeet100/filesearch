package com.filesearch;

import java.util.Arrays;
import java.util.List;

public class SearchQuery{

	private String searchString;
	private List<String> fileFilterExtensions;
	private SortOn sortCriteria;

	public SearchQuery(String searchString, String... fileFilterExtensions) {
		this.searchString = searchString;
		this.fileFilterExtensions = Arrays.asList(fileFilterExtensions);

	}

	public SearchQuery(String searchString, SortOn sortCriteria, String... fileFilterExtensions) {
		this.searchString = searchString;
		this.sortCriteria = sortCriteria;
		this.fileFilterExtensions = Arrays.asList(fileFilterExtensions);

	}

	public String getSearchString() {
		
		return isPrefixedWithAsterisk()? searchString.replace("*", "") : searchString;
	}

	public boolean matchesFileFilterExtensions(String fileExtension) {
		if(fileFilterExtensions.size() == 0 || fileFilterExtensions.contains("*")){
			return true;
		}
		return fileFilterExtensions.contains(fileExtension);
	}

	public boolean isPrefixedWithAsterisk(){
		return searchString.startsWith("*");
		
	}

	public SortOn getSortCriteria() {
		return sortCriteria;
	}
}
