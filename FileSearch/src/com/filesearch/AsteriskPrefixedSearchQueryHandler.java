package com.filesearch;

public class AsteriskPrefixedSearchQueryHandler extends SearchQueryHandler{


	@Override
	public boolean handleRequest(File file, SearchQuery searchQuery) {
		
		
		if(searchQuery.isPrefixedWithAsterisk() && file.getFileName().toLowerCase().contains(searchQuery.getSearchString())){
			return true;
		}else if(nextHandler!=null){
			return nextHandler.handleRequest(file, searchQuery);
		}
		return false;
	}

}
