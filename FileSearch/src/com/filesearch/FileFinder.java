package com.filesearch;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class FileFinder {

	private List<File> fileList;
	SearchQueryHandler simpleSearchQueryHandler = new SimpleSearchQueryHandler();
	SearchQueryHandler asteriskSearchQueryHandler = new AsteriskPrefixedSearchQueryHandler();
	
	public FileFinder(List<File> fileList) {
		this.fileList = fileList;
		
		simpleSearchQueryHandler.setNextHandler(asteriskSearchQueryHandler);
	}
	

	public ArrayList<File> searchFile(SearchQuery searchQuery) {
		Set<File> filteredFilesSet = new LinkedHashSet<File>();
		for (File file : fileList) {
			if(searchQuery.matchesFileFilterExtensions(file.getFileExtension()) && simpleSearchQueryHandler.handleRequest(file, searchQuery)){
				filteredFilesSet.add(file);
			}
		}
		return new ArrayList<File>(filteredFilesSet);
	}
}
