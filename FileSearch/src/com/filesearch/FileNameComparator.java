package com.filesearch;

import java.util.Comparator;

public class FileNameComparator implements Comparator<File>{


	@Override
	public int compare(File afile, File anotherFile) {
		return afile.getFileName().compareToIgnoreCase(anotherFile.getFileName());
	}

}
