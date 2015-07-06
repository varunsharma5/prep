package com.interview.xml;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class MyXmlHandler extends DefaultHandler {
	boolean isfirstname = false;
	boolean islastname = false;
	boolean isnickname = false;
	boolean issalary = false;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//		System.out.println("Start Element :" + qName);
		
		if(qName.equals("firstname")) {
			isfirstname = true;
		}
		
		if(qName.equals("lastname")) {
			islastname = true;
		}
		
		if(qName.equals("nickname")) {
			isnickname = true;
		}
		
		if(qName.equals("salary")) {
			issalary = true;
		}
		ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(10);
		try {
			arrayBlockingQueue.take();
			arrayBlockingQueue.put(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		if(isfirstname) {
			System.out.println("First Name: " + new String(ch,start,length));
			isfirstname = false;
		}
		
		if(islastname) {
			System.out.println("Last Name: " + new String(ch,start,length));
			islastname = false;
		}
		
		if(isnickname) {
			System.out.println("Nick Name: " + new String(ch,start,length));
			isnickname = false;
		}
		
		if(issalary) {
			System.out.println("Salary: " + new String(ch,start,length));
			issalary = false;
		}
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
//		System.out.println("End Element :" + qName);
	}
}

public class SAXParserExample {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();
		
		
		parser.parse(new File("sample.xml"), new MyXmlHandler());
	}
}
