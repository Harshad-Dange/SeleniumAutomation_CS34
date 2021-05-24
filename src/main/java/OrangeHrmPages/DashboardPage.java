package OrangeHrmPages;

import org.openqa.selenium.By;

import SeleniumFramework.baseClass;

public class DashboardPage extends baseClass {

	//dashboard menu
	public By dashboardMenu = By.id("menu_dashboard_index");

	//assign leave in dashboard module
	public By assignLeave = By.xpath("//span[text()='Assign Leave']");

	//leave list in dashboard module
	public By leaveList = By.xpath("//span[text()='Leave List']");
	
	
}
