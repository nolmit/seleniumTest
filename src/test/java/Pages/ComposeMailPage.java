package Pages;

import org.openqa.selenium.support.FindBy;
import Framework.Wait;
import Items.Button;
import Items.TextInput;
import Models.MailModel;

public class ComposeMailPage extends PageBase {

	public ComposeMailPage() {
		InitPage(this);
	}
	
	@FindBy(css="input[data-nb='suggest'")
	private TextInput Recepient;
	@FindBy(name="subj")
	private TextInput Subject;
	@FindBy(css="div[class*='cke_wysiwyg_div']")
	private TextInput Body;
	
	@FindBy(css="button[class*='js-send-button']")
	private Button SendMailButton;
	
	
	public ComposeMailPage inputMailData(MailModel email)
	{
		Recepient.Focus().SetValue(email.recepient);
		Subject.InputText(email.subj);
		Body.InputText(email.body);
		return this;
	}
	
	public ComposeMailPage inputReceiver(String email)
	{
		Recepient.InputText(email);
		return this;
	}
	public ComposeMailPage inputSubject(String subject)
	{
		Subject.InputText(subject);
		return this;
	}
	public ComposeMailPage inputBody(String body)
	{
		Body.InputText(body);
		return this;
	}
	public MainPage SendMail()
	{
		SendMailButton.Click();
		Wait.WaitForRequestComplete();
		//wait for email receiving
		Wait.BaseWait(5);
		return new MainPage();
	}
}
