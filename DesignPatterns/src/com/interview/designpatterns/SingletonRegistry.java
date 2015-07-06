package com.interview.designpatterns;
import java.util.HashMap;

public class SingletonRegistry {
   public static SingletonRegistry REGISTRY = new SingletonRegistry();
   private static HashMap map = new HashMap();
   
   protected SingletonRegistry() {}
   
   public static synchronized Object getInstance(String classname) {
      Object singleton = map.get(classname);
      if(singleton != null) {
         return singleton;
      }
      try {
         singleton = Class.forName(classname).newInstance();
         System.out.println("created singleton: " + singleton);
      }
      catch(ClassNotFoundException cnf) {
    	  System.out.println("Couldn't find class " + classname);    
      }
      catch(InstantiationException ie) {
    	  System.out.println("Couldn't instantiate an object of type " + classname);    
      }
      catch(IllegalAccessException ia) {
    	  System.out.println("Couldn't access class " + classname);    
      }
      map.put(classname, singleton);
      return singleton;
   }
}