package OrangeHrmPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFramework.Util;
import SeleniumFramework.baseClass;

public class LogoutPage  extends baseClass{
	
	
	By welcomeIcon= By.id("welcome");
	
	
	By logout=By.xpath("//div[@id='welcome-menu']/descendant::a[4]");
	
	
	public void LogoutFromOrangeHrm() {
		Util util=new Util();
		
		util.WaitElementToBeClickable(welcomeIcon);
		
		driver.findElement(welcomeIcon).click();
		
		util.WaitElementToBeClickable(logout);
		
		driver.findElement(logout).click();
		
	}
	
	

}
