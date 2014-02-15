package com.filesearch;

public class SimpleSearchQueryHandler extends SearchQueryHandler {


	@Override
	public boolean handleRequest(File file, SearchQuery searchQuery) {
		if(file.getFileName().toLowerCase().startsWith(searchQuery.getSearchString().toLowerCase())){
			return true;
		}else if(nextHandler!=null){
			return nextHandler.handleRequest(file, searchQuery);
		}
		return false;
	}

}
