package com.filesearch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class File {

	private String fileName;
	private String fileExtension;
	private Float fileSize;

	public File(String fileName, String fileSize) {
		this.fileName = fileName;

		//extract File extension
		fileExtension = extractFileExtension(fileName);
		
		//file size
		this.fileSize = setFileSizeInKB(fileSize);
		
	}

	private Float setFileSizeInKB(String fileSize) {
		if(fileSize.contains("KB")){
			return Float.parseFloat(fileSize.replace("KB", ""));
		}else if(fileSize.contains("MB")){
			return Float.parseFloat(fileSize.replace("MB", ""))*1024;
		}
		return null;
	}

	public File(String fileName) {
		this.fileName = fileName;

		//extract File extension
		fileExtension = extractFileExtension(fileName);
		
	}

	private String extractFileExtension(String fileName) {
		Pattern fileExtensionPattern = Pattern.compile("(\\w+)(\\.\\w+)$");
		Matcher matcher = fileExtensionPattern.matcher(fileName);
		if(matcher.find()){
			return matcher.group(2);
		}
		return null;
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

	public Float getFileSize() {
		return fileSize;
	}

}
