package OrangeHrmPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.baseClass;

public class BuzzPage extends baseClass {

	public BuzzPage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "menu_buzz_viewBuzz")
	public WebElement buzzMenu;

	@FindBy(id = "status-tab-label")
	public WebElement updateStatus;

	@FindBy(id = "images-tab-label")
	public WebElement uploadImage;

	@FindBy(id = "image-upload-button")
	public WebElement uploadImageButton;

	@FindBy(id = "postSubmitBtn")
	public WebElement postButton;
	

	@FindBy(id = "imageThumbnails")
	public WebElement uploadedImage;
}
