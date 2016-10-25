package Pages;

import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import Framework.Log;
import Framework.Wait;
import Items.Mail;


public class MailListFrame extends PageBase {

	public MailListFrame() {
		Wait.waitForAjax(5);
		InitPage(this);
	}
	
	
	@FindBy(css="div[class='mail-MessageSnippet-Wrapper']")
	private List<Mail> MailRows;
	
	
	
	public MailDetailsFrame openLastMailBySubject(String subj)
	{
		try {			
			Mail mail = MailRows.stream().filter(m->m.getSubject().equals(subj)).findFirst().get();
			mail.Click();
			Wait.waitForAjax(10);
			}
		catch (java.util.NoSuchElementException e)
			{
				Log.error("Mail isn't present");
				throw new NoSuchElementException(null);
			}
	   
		return new MailDetailsFrame();
	}
}
