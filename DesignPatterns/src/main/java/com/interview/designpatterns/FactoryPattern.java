package com.interview.designpatterns;
//Abstract Product
abstract class Logger {
	public abstract void log(String message);
}

//Concrete Product
class XMLLogger extends Logger {

	@Override
	public void log(String message) {
		System.out.println("XMLLogger.log() called");
	}
}

//Abstract Creator
abstract class AbstractLoggerCreator {
	protected abstract Logger createLogger();

	public Logger getLogger() {
		Logger logger = createLogger();
		return logger;
	}
}

//Concrete Creator
class XMLLoggerCreator extends AbstractLoggerCreator {

	@Override
	protected Logger createLogger() {
		XMLLogger logger = new XMLLogger();
		return logger;
	}
}

class Client {
	public void someMethodThatLog(AbstractLoggerCreator logCreator, String message) {
		Logger logger = logCreator.getLogger();
		logger.log(message);
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		AbstractLoggerCreator creator = new XMLLoggerCreator();
		Client client = new Client();
		client.someMethodThatLog(creator, "This is test log");
	}
}



