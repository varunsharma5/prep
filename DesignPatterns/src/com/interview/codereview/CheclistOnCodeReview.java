package com.interview.codereview;

/**
 * 	1) Does Code meet functional requirement: first and foremost does code meets all requirements 
 * 	which it should met, point out if anything has been left out.
 * 
	2) Is there any Side effect of this change: Some time one change in your system may cause bug 
	in other upstream and downstream system and it’s quite possible that new developer or anyone who 
	is writing code might not be available of that dependency. This often directly related to 
	experience in project and I found that the more you know about system and its environment better 
	you able to figure this out.
	
	3) Concurrency: does code is thread-safe? Does it have properly synchronized if using shared 
	resource? Does it free of any kind of deadlock or live-lock? Concurrency bugs are hard to detect 
	and often surfaces in production. Code review is one place where you can detect this by carefully 
	understand design and its implementation.
	
	4) Readability and maintenance:  does code is readable? Or is it too complicate for some-one 
	complete new. Always give value to readability as code is not just for this time it will remain 
	there for long time and you need to read it many times. Another important aspect is maintenance as 
	most of software spends 90% time in maintenance and only 10% time on development it should be 
	maintainable and flexible in first place. You can verify that whether code is configurable or not, 
	look for any hard coding, find out what is going to be changed in near future etc.
	
	5) Consistency: This is part of point 4 but I have made it another separate point because of its 
	importance. This is the best thing you can have in your code which automatically achieves readability. 
	Since many developer and programmer take part in project and they have there own style of coding, it’s 
	in best interest of everybody to form a coding standard and follow it on letter and spirit. For example 
	it’s not good someone using function initialize() and other is using init() for same kind of operation, 
	keep you code consistent and it will look better, read better.
	
	6) Performance: Another important aspect most important if you are writing high volume low latency 
	electronic trading platform for high frequency trading which strives for micro second latency. Carefully 
	monitor which code is going to execute at start-up and which is going to be executed in loop or multiple 
	times, optimize the code which is going to execute more often.

	7) Exception handling: Ask does code handles bad input and exception? It should and that too with 
	predefined and standard way which must be available and documented for support purpose. I put this 
	point well above on my chart while doing review because failing on this point can lead your application 
	crash and not able to recover from fault on other system or other part of same application.

	8) Simplicity: Always see if there is any simple and elegant alternative available at-least give a 
	thought and try. Many times first solution comes in mind is not best solution so giving another thought is just worth it.

	9) Reuse of existing code: See if the functionality can be achieved by using existing code, advantage 
	of doing this is that you are using tried and tested code which reduce your QA time and also give you 
	more confidence. Introducing new libraries introduce new dependency. I prefer not to try anything fancy 
	until it’s absolutely necessary.


	10) Unit test: Check whether enough JUnit test cases have been written and cover sufficient percentage 
	of new code. never let you pass the code without Junit test because developer often make excuse of time
	but believe me its worth to write it.

 */
public class CheclistOnCodeReview {

}
