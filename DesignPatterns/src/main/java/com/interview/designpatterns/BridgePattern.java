package com.interview.designpatterns;


/**
 * Structural Pattern
 * Def: Decouple an abstraction from its implementation so that the two can vary independently
 * 
 * The Abstraction defines the abstraction, and maintains the reference to the implementor.  
 * RefinedAbstraction provides an extension to the Abstraction, usually adding extra methods 
 * that provide different ways of getting at the same functionality. The Implementor interface 
 * defines an interface for the implementation classes (the ConcreateImplementor classes). 
 * RefinedAbstractions are implemented in terms of the abstraction, and not that implementation 
 * interface.This means that the implementation details are hidden from the client. The pattern 
 * is similar to the Adapter pattern, except the Bridge pattern separates the interface from implementation.
 * 
 * When It should be used ?
 * 
 * The Bridge pattern should be used when both the class as well as what it does vary often. 
 * The bridge pattern can also be thought of as two layers of abstraction. When the abstractions and 
 * implementations should not be bound at compile time, and should be independently extensible the pattern should be used. 
 * In particular this pattern is useful in graphic toolkits that need to run on multiple platforms. 
 * You'll  see this in AWT, where a component has a component peer which does the OS specific operations. 
 * Also the Collections framework has examples of the bridge interface: ArrayList and LinkedList are implement 
 * List. And List provides common methods to add, remove or check size. 
 * 
 * @author varun
 *
 */
public class BridgePattern {

}
