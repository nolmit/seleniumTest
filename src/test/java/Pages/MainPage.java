package Pages;

import org.openqa.selenium.support.FindBy;
import Framework.Wait;
import Items.WebItem;
import Utils.ReadProfile;

public class MainPage extends PageBase {
	
	ReadProfile p = new ReadProfile("src/test/resources/config.properties");
	
	
	public MainPage() {
		
		InitPage(this);
	}
	
	@FindBy(name="login")
	private WebItem mailField;
	@FindBy(name="passwd")
	private WebItem passField;
	@FindBy(css="button[type='submit']")
	private WebItem submitButton;
	@FindBy(css="div[class*='js-user-picture']")
	private WebItem UserIcon;
	@FindBy(css="a[href*='action=logout']")
	private WebItem ExitButton;
	
	
	public MailBoxPage loginMailBox(String email, String pass)
	{
		
		Open(p.getProperty("url"));
		if (submitButton.isPresent())
		{
			mailField.InputText(email);
			passField.InputText(pass);
			submitButton.Click();
		}
		
		return new MailBoxPage();
	}
	
	public MainPage logoutMailBox()
	{		
		UserIcon.Click();
		ExitButton.Click();
		Wait.WaitForRequestComplete();
		
		return this;
	}

}
