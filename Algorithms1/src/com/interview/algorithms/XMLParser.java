package com.interview.algorithms;

import com.example.datastructures.Stack;

/**
 * 
 * @author ajitkoti
 *
 */
public class XMLParser {
	private String xmlString = "<CATALOG><CD><TITLE>Empire Burlesque</TITLE><ARTIST>Bob Dylan</ARTIST><COUNTRY>USA</COUNTRY><COMPANY>Columbia</COMPANY><PRICE>10.90</PRICE><YEAR>1985</YEAR></CD></CATALOG>";

	public void parse(XmlEventType xpp){
		xpp.setInput(xmlString );
		Stack<String> tagStack = new Stack<String>(100);
        int eventType = xpp.getEventType();
        while (eventType != xpp.END_DOCUMENT) {
            if (eventType == xpp.START_TAG) {
                tagStack.push(xpp.getName());

            } else if (eventType == xpp.END_TAG) {
                tagStack.pop();
                if (xpp.getName().equalsIgnoreCase("")) {
                   
                }

            } else if (eventType == xpp.TEXT) {
                String tagName = (String) tagStack.peek();
                String tagValue = xpp.getText();
                
            }
            eventType = xpp.next();
        }
	}

	
}

class XmlEventType{

	public static final int TEXT = 0;
	public static final int END_TAG = 0;
	public static final int START_TAG = 0;
	public static final int END_DOCUMENT = 0;

	public int getEventType() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setInput(String xmlString) {
		// TODO Auto-generated method stub
		
	}

	public int next() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
