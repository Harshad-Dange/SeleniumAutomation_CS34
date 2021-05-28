package SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util extends baseClass {
	
	PageObjectManager pageObjectManager;
	ConfigProperties properties;
	Wait<WebDriver> wait;
	
	public Util(){
		 properties= new ConfigProperties();
		 wait = new WebDriverWait(driver, Long.valueOf(properties.getProperty("timeout")));
	}
	
	/**
	 * This method will wait for 10 sec until the element is clickable
	 */
	public void WaitElementToBeClickable(By by) {		
		
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	/**
	 * This method will wait for 10 sec until the element is visible
	 */
	public void WaitElementToBeVisible(By by) {

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
	}
	
	/**
	 * This method will wait for 10 sec until the element is visible
	 */
	public void WaitElementToBeVisible(WebElement element) {
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for 10 sec until the element is visible
	 */
	public void WaitElementToBeClickable(WebElement element) {
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method helps to select the month from the calendar based on the provided parementers
	 * @param WebElement, String value
	 */	
	public void selectMonthInCalendar(WebElement element, String value) {
		
		pageObjectManager= new PageObjectManager();
		
		Util util= pageObjectManager.getUtilInstance();
		
		util.selectByValue(element, value);
	}
	
	/**
	 * This method helps to select the year from the calendar based on the provided parementers
	 * @param WebElement, String value
	 */	
	public void selectYearInCalendar(WebElement element, String value) {
		
		pageObjectManager= new PageObjectManager();
		
		Util util= pageObjectManager.getUtilInstance();
		
		util.selectByValue(element, value);
	}
	
}
