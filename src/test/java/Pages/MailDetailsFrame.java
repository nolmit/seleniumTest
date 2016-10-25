package Pages;

import org.openqa.selenium.support.FindBy;

import Items.WebItem;
import Models.MailModel;

public class MailDetailsFrame extends PageBase{

	public MailDetailsFrame() {
		InitPage(this);
	}
	
	@FindBy(css="div[class*='mail-Message-Toolbar-Subject ']")
	private WebItem MessageSubject;
	
	@FindBy(css="div[class*='mail-Message-Body-Content']")
	private WebItem MessageBody;
	
	public MailModel getMail()
	{ 	
		String subj = MessageSubject.GetText();
		String body = MessageBody.GetText();
		return new MailModel(null,subj,body); 
	}
}
