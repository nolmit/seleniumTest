package Pages;

import org.openqa.selenium.support.FindBy;

import Items.Button;

public class MailTopNavFrame extends PageBase {

	public MailTopNavFrame() {
		InitPage(this);
	}
	
	@FindBy(css="a[href='#compose']" )
	private Button Write;
	
	public void clickWriteMail()
	{
		Write.Click();
	}
	
}
