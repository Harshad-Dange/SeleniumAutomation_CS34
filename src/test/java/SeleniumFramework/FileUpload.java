package SeleniumFramework;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import OrangeHrmPages.AddEmployeePage;
import OrangeHrmPages.BuzzPage;
import OrangeHrmPages.LeavePage;
import OrangeHrmPages.LoginPage;

public class FileUpload extends baseClass {

	PageObjectManager pageObjectManager;
	LoginPage loginPage;
	BuzzPage buzzPage;
	LeavePage leavePage;
	AddEmployeePage addEmpPage;

	@BeforeTest
	@Parameters({ "Browser" })
	public void beforeTest(@Optional("Chrome") String Browser) {
		driver = launchBrowser(Browser);

		System.out.println(Browser);

	}

	@Test(priority = 1)
	public void login() {

		pageObjectManager = new PageObjectManager();

		loginPage = pageObjectManager.getLoginpageInstance();

		ConfigProperties config = new ConfigProperties();

//		driver.navigate().to(config.getProperty("orangeHrmUrl"));

		String username = config.getProperty("orangeHrmUN");

		String password = config.getProperty("orangeHrmPW");

		driver.navigate().to(config.getProperty("orangeHrmUrl"));

		loginPage.loginToOrangeHrm(username, password);

	}

	@Test(priority = 2)
	public void uploadImage() throws IOException {
		
		buzzPage=pageObjectManager.getBuzzPageInstance();
		
		buzzPage.buzzMenu.click();
		
		buzzPage.uploadImage.click();
		
		buzzPage.uploadImageButton.click();
		
		Runtime.getRuntime().exec("E:\\Git Repo\\SeleniumAutomation_CS34\\FileUpload.exe"+" "+"C:\\Users\\Harshad\\Pictures\\Capture.png");
		
	}
	

}
