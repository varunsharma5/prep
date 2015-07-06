package com.interview.designpatterns;
//Abstract Product
interface Window {
	public void setTitle(String title);
	public void repaint();
}

//Concrete Product1
class MSWindow implements Window {

	public void setTitle(String title) {
		System.out.println("MSWindow.setTitle()");
	}

	public void repaint() {
		System.out.println("MSWindow.repaint()");
	}
}

//Concrete Product2
class MacOSWindow implements Window {

	public void setTitle(String title) {
		System.out.println("MacOSWindow.setTitle()");
	}

	public void repaint() {
		System.out.println("MacOSWindow.repaint()");
	}
	
}

//Abstract Factory
interface AbstractWidgetFactory {
	public Window createWindow();
}

//Concrete factory1
class MSWidgetFactory implements AbstractWidgetFactory {

	public Window createWindow() {
		Window msWindow = new MSWindow();
		return msWindow;
	}
}

//Concrete factory2
class MacOSWidgetFactory implements  AbstractWidgetFactory {

	public Window createWindow() {
		Window macWindow = new MacOSWindow();
		return macWindow;
	}
}

//Client
class GUIBuilder {
	public void buildWindow(AbstractWidgetFactory widgetFactory) {
		widgetFactory.createWindow().setTitle("This is new window");
	}
}

public class AbstractFactoryPattern {

}