package com.interview.file;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileOperations {
	private static final String file = "C:\\Users\\IBM_ADMIN\\Documents\\all_dir_operations.txt";
	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(new File(file));
		BufferedInputStream bis = new BufferedInputStream(fileInputStream);
		DataInputStream dataInputStream = new DataInputStream(bis);
		
		while(dataInputStream.available()!=0) {
			System.out.println(dataInputStream.readLine());
		}
	}
}
