package com.interview.designpatterns;
import java.io.Serializable;


public class SingletonClassic implements Serializable {
	private static final long serialVersionUID = -3387809098968386410L;
	private static SingletonClassic  instance = null;
	
	private SingletonClassic() {}
	
	public SingletonClassic getInstance() {
		Thread.currentThread().getContextClassLoader();
		if(instance == null) {
			instance = new SingletonClassic();
		}
		return instance;
	}
	
	private Object readResolve() {
        return instance;
	}
	
}
