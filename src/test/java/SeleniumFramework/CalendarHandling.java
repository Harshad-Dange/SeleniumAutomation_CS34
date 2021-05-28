package SeleniumFramework;

import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import OrangeHrmPages.LeavePage;
import OrangeHrmPages.LoginPage;

public class CalendarHandling extends baseClass {
	
	PageObjectManager pageObjectManager;
	LoginPage loginPage;
	LeavePage leavePage;
	Util util;
	@BeforeClass
	public void beforeClass() {
		
		driver=launchBrowser("Chrome");
				
	}
	
	@Test(priority=1)
	public void login() {
		
		pageObjectManager=new PageObjectManager();
		
		loginPage =pageObjectManager.getLoginpageInstance();

		ConfigProperties config = new ConfigProperties();

//		driver.navigate().to(config.getProperty("orangeHrmUrl"));

		String username = config.getProperty("orangeHrmUN");

		String password = config.getProperty("orangeHrmPW");

		driver.navigate().to(config.getProperty("orangeHrmUrl"));

		loginPage.loginToOrangeHrm(username, password);
	}
	

  @Test(priority=2)
  public void applyLeave() {
	  
	  leavePage=pageObjectManager.getLeavePageInstance();
	  
	  leavePage.leaveMenu.click();
	  
	  leavePage.applyModule.click();
	  
	  Assert.assertTrue(leavePage.fromDate.isDisplayed());
	  
	  leavePage.fromDate.click();
	  
	  Assert.assertTrue(leavePage.calendar.isDisplayed());
	  
	  util=pageObjectManager.getUtilInstance();
	  
	  String month= String.valueOf(LocalDateTime.now().getMonthValue()-1);
	  
	  String year= String.valueOf(LocalDateTime.now().getYear());
	  
	  String day=String.valueOf(LocalDateTime.now().getDayOfMonth()+1);
	  
	  util.selectMonthInCalendar(leavePage.calendarMonth, month);
	  
	  util.selectYearInCalendar(leavePage.calendarYear, year);
	  
	  leavePage.calendarDays.forEach(d->{
		  
		  if(d.getText().equals(day)) {
			  
			  d.click();
		  }
		  
		  
	  });
	  
	  
	  
  }
}
