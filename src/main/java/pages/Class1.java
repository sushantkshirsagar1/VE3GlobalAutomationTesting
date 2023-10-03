package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Class1 extends Base{

	WebDriver driver;
	
	@FindBy(xpath="//*[@data-id='3da11ad']")
	WebElement HomePage;
	
	public void clickOnHomepageButton() {
		HomePage.click();
	}
	
	public String getPageTitle1() {
		
		String actualtitle = driver.getTitle();
		
		System.out.println("Homepage title is:"+actualtitle);
		
		String expectedtitle = "VE3 - Digital Solutions for the Future";
		if(expectedtitle.contains(actualtitle)) {
			
			System.out.println("Title Fetched Successfully");
			
		}
		else
		{
			System.out.println("Error in fetching the Title kindly file a bug");
		}
		
		return actualtitle;
	}
	
	@FindBy(xpath="//li[@id='menu-item-3576']")
	WebElement ContactTab;
	
	public void clickOnContactTab() {
		ContactTab.click();
	}
	
	@FindBy(xpath="//*[@name='name-1']")
	WebElement FirstName;
	
	public void enterOnFirstName(String fname) {
		FirstName.sendKeys(fname);
		
	}
	
	@FindBy(xpath="//*[@name='email-1']")
	WebElement Email;
	public void enterMailID(String mail) {
		Email.sendKeys(mail);
	}
	
	@FindBy(xpath="//*[@id='forminator-field-text-1_6516f6d813a64']")
	WebElement Subject;
	public void enterSubject() {
		Email.sendKeys("Subject Entered");
	}
	
	@FindBy(xpath="//*[@name='textarea-1']")
	WebElement Message;
	public void enterMessage() {
		Email.sendKeys("Message: Testing Contact Form");
	}
	
	@FindBy(xpath="//*[text()='Send']")
	WebElement Send;
	public void clickOnSend() {
		Send.click();
	}
	
	public Class1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
		
}
