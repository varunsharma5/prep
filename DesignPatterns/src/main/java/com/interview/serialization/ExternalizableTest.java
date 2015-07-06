package com.interview.serialization;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class TestClass implements Externalizable {

	private int i;

	public TestClass() {
	}
	
	public TestClass(int i) {
		this.i = i;
	}
	
	public int getI() {
		return i;
	}
	
	public void setI(int i) {
		this.i = i;
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//		System.out.println("TestClass.readExternal(): " + in.readInt());
		setI(in.readInt());
		
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(getI());
	}
	
}

public class ExternalizableTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String file_name = "C:\\object.txt";
		
		TestClass class1 = new TestClass(10);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(file_name)));
		objectOutputStream.writeObject(class1);
		
		
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(file_name)));
		TestClass returnedClass = (TestClass) objectInputStream.readObject();
		System.out.println(returnedClass.getI());
		
	}
}
