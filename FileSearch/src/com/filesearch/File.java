package com.filesearch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class File {

	private String fileName;
	private String fileExtension;

	public File(String fileName) {
		this.fileName = fileName;

		Pattern fileExtensionPattern = Pattern.compile("(\\w+)(\\.\\w+)$");
		Matcher matcher = fileExtensionPattern.matcher(fileName);
		if(matcher.find()){
			fileExtension = matcher.group(2);
		}
	}

	public String getExtension() {
		return fileExtension;
	}

	public String getFileName() {
		return fileName;
	}

	public String getFileExtension() {
		return fileExtension;
	}
	
	@Override
	public boolean equals(Object anotherFile){
		return this.fileName.equals(((File)anotherFile).fileName);
	}
	
	@Override
	public String toString(){
		return fileName;
	}

}
