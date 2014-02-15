package com.filesearch;

public abstract class SearchQueryHandler {
	
	public SearchQueryHandler nextHandler;
	
	public void setNextHandler(SearchQueryHandler nextHandler) {
		this.nextHandler = nextHandler;
	}
	

	public abstract boolean handleRequest(File file, SearchQuery query);
}
