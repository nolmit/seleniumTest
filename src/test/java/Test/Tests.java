package Test;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import Models.MailModel;
import Pages.ComposeMailPage;
import Pages.MailBoxPage;
import Pages.MailDetailsFrame;
import Pages.MailListFrame;
import Pages.MailNavigateFrame;
import Pages.MainPage;
import Utils.ReadProfile;


public final class Tests extends TestBase {
	ReadProfile p = new ReadProfile("src/test/resources/config.properties");
	
	MailBoxPage mailBoxPage;
	ComposeMailPage composeMail;
	MailListFrame mailList;
	MailDetailsFrame mailDetails;
	
	@Test
	public void CheckMailTest()
	{		
		String subj = UUID.randomUUID().toString();
	
		MailModel email = new MailModel(p.getProperty("user2")+p.getProperty("domain"),subj,"test"); 		
		
		new MainPage()
			.loginMailBox(p.getProperty("user1"),p.getProperty("pass1"))
			.openComposeMailForm()
			.inputMailData(email)
			.SendMail()
			.logoutMailBox();
		
		new MainPage()
			.loginMailBox(p.getProperty("user2"),p.getProperty("pass2"));
					
		mailList = MailNavigateFrame.GoToInbox();
		mailDetails = mailList.openLastMailBySubject(email.subj);
		
		Assert.assertTrue("Emails aren't equal", mailDetails.getMail().compareTo(email));
		
	}
	

}
