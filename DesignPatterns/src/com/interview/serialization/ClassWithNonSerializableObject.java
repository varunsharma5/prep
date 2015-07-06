package com.interview.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NormalClass {
	private int val;
	private String name;
	
	public NormalClass(int val, String name) {
		super();
		this.val = val;
		this.name = name;
	}

	public int getVal() {
		return val;
	}
	
	public String getName() {
		return name;
	}
}

class SerializableClass implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private NormalClass obj;
	private String name;
	
	public SerializableClass(NormalClass obj, String name) {
		this.obj = obj;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public NormalClass getObj() {
		return obj;
	}
	
	private void writeObject(final ObjectOutputStream out) throws IOException {
		System.out.println("SerializableClass.writeObject()");
		out.writeUTF(getName());
		out.writeInt(obj.getVal());
		out.writeUTF(obj.getName());
	}
	
	private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
		System.out.println("SerializableClass.readObject()");
		name = in.readUTF();
		obj = new NormalClass(in.readInt(), in.readUTF());
	}
}


public class ClassWithNonSerializableObject {
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			String file = "C:\\myObjects.txt";
			oos = new ObjectOutputStream(new FileOutputStream(file));
			NormalClass normalClass = new NormalClass(10, "normal class");
			SerializableClass serializableClass = new SerializableClass(normalClass, "SerializableClass");

			oos.writeObject(serializableClass);

			ois = new ObjectInputStream(new FileInputStream(file));
			SerializableClass returnedObj = (SerializableClass) ois.readObject();
			System.out.println(returnedObj.getName());
			System.out.println(returnedObj.getObj().getName());
			System.out.println(returnedObj.getObj().getVal());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				if(ois!=null)
					ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}