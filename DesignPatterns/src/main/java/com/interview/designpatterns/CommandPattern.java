package com.interview.designpatterns;
//Receiver
class Light {
	private boolean on;
	
	public void swicthOn() {
		System.out.println("Light.swicthOn()");
		on = true;
	}
	
	public void switchOff() {
		System.out.println("Light.switchOff()");
		on = false;
	}
}

interface Command {
	public void execute();
}

class LightOnCommand implements Command {
	Light light = null;
	public LightOnCommand(Light light) {
		this.light = light;
	}
	
	public void execute() {
		light.swicthOn();
	}
}

class LightOffCommand implements Command {
	Light light = null;
	public LightOffCommand(Light light) {
		this.light = light;
	}
	
	public void execute() {
		light.switchOff();
	}
}


//Invoker
class RemoteController  {
	private Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void pressButton() {
		command.execute();
	}
}
	

//Client
public class CommandPattern {
	public static void main(String[] args) {
		Light light = new Light();
		
		LightOnCommand onCommand = new LightOnCommand(light);
		LightOffCommand offCommand = new LightOffCommand(light);
		
		RemoteController remoteController = new RemoteController();
		
		
		remoteController.setCommand(onCommand);
		remoteController.pressButton();
		
		remoteController.setCommand(offCommand);
		remoteController.pressButton();
	}
}
