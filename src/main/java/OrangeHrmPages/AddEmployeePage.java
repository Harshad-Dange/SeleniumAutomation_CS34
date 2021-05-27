package OrangeHrmPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.baseClass;

public class AddEmployeePage extends baseClass {

	public AddEmployeePage() {

		PageFactory.initElements(driver, this);

	}

	public By chooseFileButton = By.id("photofile");
	
	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement pimMenu;

	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmployeeModule;


	/*
	 * @FindBy(id = "image-upload-button") public WebElement uploadImageButton;
	 * 
	 * @FindBy(id = "postSubmitBtn") public WebElement postButton;
	 */
}
