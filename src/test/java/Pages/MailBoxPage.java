package Pages;

public class MailBoxPage extends PageBase {

	MailTopNavFrame top = new MailTopNavFrame();
	MailNavigateFrame nav = new MailNavigateFrame();
	
	public MailBoxPage() {
		InitPage(this);
	}
	
	public ComposeMailPage openComposeMailForm()
	{
		top.clickWriteMail();
		return new ComposeMailPage();
	}
}
