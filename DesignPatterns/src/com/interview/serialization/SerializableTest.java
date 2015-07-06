package com.interview.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class TestClass1 implements Serializable {

	private int i;
	
	public TestClass1(int i) {
		this.i = i;
	}
	
	public int getI() {
		return i;
	}
}

public class SerializableTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String file_name = "C:\\object.txt";
		
		TestClass1 class1 = new TestClass1(10);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(file_name)));
		objectOutputStream.writeObject(class1);
		
		
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(file_name)));
		TestClass1 returnedClass = (TestClass1) objectInputStream.readObject();
		System.out.println(returnedClass.getI());
		
	}
}
