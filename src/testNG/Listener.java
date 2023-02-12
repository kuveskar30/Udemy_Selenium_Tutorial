package testNG;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Listener implements ITestListener {
	//Listner class not showing error after implementing ITestListener interface and not defining
	//methods of interface, because of below reason
	
	//generally we must implement all methods of an interface but if method of
	//interface is defined with default keyword then it is not compulsory to implement that method
	//it is new feature of java earlier we use to define method name in interface and not block
	//but with default keyword we also define block in interface itself
	
	
	
	//also read this:->
	//TestNG 7.0.0 uses JDK8 and with it default methods within interfaces. What this means 
	//is that every listener would now have a default implementation (which doesn't do 
	//anything ) for all methods defined within the interface.
	//So now you won't see those indications from the IDE. The biggest benefit of default 
	//methods in interfaces is that let's say you are implementing an interface that has 10 
	//methods defined in it, you can just implement whatever you need and the rest of the 
	//behavior comes via the default methods in the interface.
	
	public void onTestFailure(ITestResult result) {
		System.out.println("test failed listener testName= " + result.getName());
		
	}
	
//	
}
