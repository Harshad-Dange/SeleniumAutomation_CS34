package SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FrameHandling extends baseClass{
	
	
	
  @Test
  public void frameHandling() {
	  
	  
	  driver=launchBrowser("Chrome");
	  
	  driver.get("https://sites.google.com/view/how-to-with-new-sites/embeds/embed-with-iframes");
	  
	  driver.manage().window().maximize();
	  
	  JavascriptExecutor js= (JavascriptExecutor)driver;
	  
	  js.executeScript("window.scrollBy(0,3000)");
	  
	  
	  Wait<WebDriver> wait=new WebDriverWait(driver,30);	  
	  
	  driver.switchTo().frame("p_KKVnBOBKZmMU");	  
  
	  driver.switchTo().frame(driver.findElement(By.id("innerFrame")));	  
	  
	  wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//a[@rel='discussion']"))));
	  
	  driver.findElement(By.xpath("//a[@rel='discussion']")).click();
	  
	  driver.switchTo().defaultContent();	  
	  
	  js.executeScript("window.scrollBy(0,-3000)");
	  
	  System.out.println(driver.findElement(By.id("h.p_hRopAlldXmxP")).getText());

  }
}
