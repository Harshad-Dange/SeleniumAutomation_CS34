package OrangeHrmPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.baseClass;

public class LeavePage extends baseClass {
	
	public LeavePage(){
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@id='menu_leave_viewLeaveModule']")
	public WebElement leaveMenu;
	
	@FindBy(id="menu_leave_applyLeave")
	public WebElement applyModule;
	
	@FindBy(id="menu_leave_viewMyLeaveList")
	public WebElement myLeaveModule;
	
	@FindBy(id="menu_leave_Entitlements")
	public WebElement entitlementModule;
	
	@FindBy(id="menu_leave_Reports")
	public WebElement reportsModule;
	
	@FindBy(id="menu_leave_assignLeave")
	public WebElement assignLeave;
	
	@FindBy(xpath="//div[@id='apply-leave']/div[1]/h1")
	public WebElement applyLeaveText;

	
	@FindBy(id="applyleave_txtFromDate")
	public WebElement fromDate;
	
	@FindBy(id="applyleave_txtToDate")
	public WebElement toDate;
	
	@FindBy(id="ui-datepicker-div")
	public WebElement calendar;
	
	@FindBy(className="ui-datepicker-month")
	public WebElement calendarMonth;
	
	@FindBy(className="ui-datepicker-year")
	public WebElement calendarYear;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']/descendant::a")
	public List<WebElement> calendarDays;
	
}
