package com.filesearch;

import java.util.Comparator;

public class FileSizeComparator implements Comparator<File> {

	@Override
	public int compare(File aFile, File anotherFile) {
		if(aFile.getFileSize() > anotherFile.getFileSize()){
			return 1;
		}else if(aFile.getFileSize() < anotherFile.getFileSize()){
			return -1;
		}else{
			return 0;
		}
	}

}
