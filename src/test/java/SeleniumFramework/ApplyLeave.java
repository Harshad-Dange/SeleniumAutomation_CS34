package SeleniumFramework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import OrangeHrmPages.LeavePage;
import OrangeHrmPages.LoginPage;

public class ApplyLeave extends baseClass {
	
	LoginPage loginPage;
	ConfigProperties config;
	LeavePage leavePage;
	Util util;
	PageObjectManager pageObjectManager=new PageObjectManager();

	@BeforeClass
	public void beforeClass() {
		config = new ConfigProperties();

		driver = launchBrowser(config.getProperty("browser"));
		
		driver.get(config.getProperty("orangeHrmUrl"));

	}

	@Test
	public void login() {
		
		
		loginPage=pageObjectManager.getLoginpageInstance();
		
		loginPage.loginToOrangeHrm(config.getProperty("orangeHrmUN"), config.getProperty("orangeHrmPW"));
		
//		logger.log(Status.INFO, "Successfully Logged in to Orange HRM");

	}
	
	@Test
	public void applyLeave() {
		
		
		  leavePage=pageObjectManager.getLeavePageInstance();
		  
		  util=pageObjectManager.getUtilInstance();
		  
		  util.WaitElementToBeClickable(leavePage.leaveMenu);
		  
		  leavePage.leaveMenu.click();
		  
		  leavePage.assignLeave.click();
		  
		  System.out.println(leavePage.applyLeaveText.getText());
		 
			/*
			 * LeavePage obj=new LeavePage();
			 * 
			 * obj.leaveMenu.click();
			 * 
			 * obj.assignLeave.click();
			 */

	}
	
	@AfterClass
	public void afterClass() {
		
		closeBrowserInstance();
	}
	
}
