package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import Framework.Framework;
import Framework.Log;
import Framework.Wait;
import Items.ItemDecorator;


public class PageBase {
	
	WebDriver driver = Framework.getDriver();
		
	public void InitPage(Object page)
	{		
		try
			{
				PageFactory.initElements(new ItemDecorator(driver), page);
					}
		catch (Exception e)
		{			
			Log.error("Unable to init page factory elements " + e.getMessage());
			
		}
	}
	
	public void Open(String url)
	{
		Framework.OpenUrl(url);
		Wait.waitForAjax(10);
	}
	
	
	
}
