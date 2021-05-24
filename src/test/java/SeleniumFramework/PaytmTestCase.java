package SeleniumFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class PaytmTestCase extends baseClass{ 
	
	String username;
	String password;
	
	@BeforeSuite(groups= {"group1"})
	public void beforeSuit() {
		
		System.out.println("This is paytm before suit method");

		ConfigProperties config=new ConfigProperties();

		username=config.getProperty("username");
		password=config.getProperty("password");

		
	}
	
	@AfterSuite(groups= {"group1"})
	public void afterSuit() {
		
		System.out.println("This is paytm after suit method");
		
	}
	
	@BeforeTest (groups= {"group1"})
	public void beforetest() {
		
		System.out.println("This is before test method from paytm");
	
	}
	
	@AfterTest (groups= {"group1"})
	public void aftertest() {
		System.out.println("This is after test method from paytm");
	}
	
	@Test (groups= {"group1"})
	public void Case1() {
		System.out.println("This is Case1 method from paytm");
	}
	
	@Test (groups= {"group2"}, dependsOnGroups= {"group1"})
	public void Case2() {
		System.out.println("This is Case2 method from paytm");
	}
	
	@Test (groups= {"paytmTest"}, dependsOnMethods= {"Case1","Case2"})
	public void a() {
		System.out.println("This is a method from paytm");
	}
	

	@BeforeClass(groups= {"group1"})
	public void beforeClass() {
		System.out.println("This is Paytm before Class method");
		
		driver=launchBrowser("Chrome");
		driver.get("https://gmail.com");
		System.out.println(username);
		System.out.println(password);
	}

	@AfterClass(groups= {"group1"})
	public void afterClass() {
		
		System.out.println("This is Paytm after Class method");
		closeBrowserInstance();


	}

}
