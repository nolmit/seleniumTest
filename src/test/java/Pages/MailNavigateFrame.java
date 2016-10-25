package Pages;

import org.openqa.selenium.support.FindBy;

import Items.Button;

public class MailNavigateFrame extends PageBase {

	public MailNavigateFrame() {
		InitPage(this);
	}
	
	@FindBy(css="a[href='#sent']")
	private static Button SentMails;
	
	@FindBy(css="a[href='#inbox']")
	private static Button InboxMails;
	
	public static MailListFrame GoToOutbox()
	{
		SentMails.Click();
		
		return new MailListFrame();
	}
	
	public static MailListFrame GoToInbox()
	{
		InboxMails.Click();
		
		return new MailListFrame();
	}
	
	
}
