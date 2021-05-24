package SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;

import OrangeHrmPages.DashboardPage;
import OrangeHrmPages.LoginPage;
import OrangeHrmPages.LogoutPage;

public class PriorityTC extends baseClass {
	
	PageObjectManager pageObjectManager;
	LoginPage loginPage;
	LogoutPage logoutPage;
	DashboardPage dashboardPage;
	
	@BeforeTest
	@Parameters({"Browser"})
	public void beforeTest(@Optional ("Chrome")String Browser) {		
		driver = launchBrowser(Browser);
		
		System.out.println(Browser);
		
	}

	@AfterSuite
	public void afterSuit() {
		
//		closeBrowserInstance();

	}

	@Test(priority=0)
//	@Parameters({"Username", "Password"})
	public void login() throws InterruptedException {
		
		pageObjectManager=new PageObjectManager();
		loginPage=pageObjectManager.getLoginpageInstance();
		
		System.out.println("Login Page instance: " +loginPage);
		
		System.out.println("Login Method");

		ConfigProperties config = new ConfigProperties();
		
		String username= config.getProperty("orangeHrmUN");
		
		String password= config.getProperty("orangeHrmPW");

		driver.navigate().to(config.getProperty("orangeHrmUrl"));

		loginPage.loginToOrangeHrm(username, password);

//		logger.log(LogStatus.INFO, "Successfully able to login to application by username : "+ username + " and pasword :" +password);
		
//		logger.log(Status.INFO,  "Successfully able to login to application by username : "+ username + " and pasword :" +password);

	}

	@Test(dependsOnMethods="verifyLogin")
	public void logout() {
		
		

//		LogoutPage logoutPage=new LogoutPage();		
		
		logoutPage=pageObjectManager.getLogoutpageInstance();

		logoutPage.LogoutFromOrangeHrm();		
//		logger.log(LogStatus.INFO, "Clicking on logout button");		
		
		Assert.assertTrue(driver.findElement(By.id("btnLogin")).isDisplayed(), "Fail to logout from application");
		
		
	}

	@Test(priority=2)
	public void verifyLogin() {
		
		loginPage=pageObjectManager.getLoginpageInstance();
		
		System.out.println("Login Page instance: " +loginPage);
		
		dashboardPage=pageObjectManager.getDashboardpageInstance();
		
//		DashboardPage dashboardPage= new DashboardPage();
//		logger.log(LogStatus.INFO, "Verify Login Method");
		
//		logger.log(Status.INFO, "Starting execution for Verify Login method");
		
		String dashboardText= driver.findElement(dashboardPage.dashboardMenu).getText();
		
		Assert.assertEquals(dashboardText, "Dashboard", "Fail to validate the Dahboard module availibility:");
	
//		Assert.assertTrue(AdminModuleName.equals("Admin"), "Admin module is not visible");
		
//		Assert.assertFalse(AdminModuleName.equals("12345"));
		
	}

}
