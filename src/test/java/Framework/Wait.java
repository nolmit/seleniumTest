package Framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class Wait{
	protected static WebDriver driver = Framework.getDriver();
		
	public static void BaseWait(Integer seconds)
	{
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void WaitForRequestComplete()
	{	WebDriverWait wait=	new WebDriverWait(driver,30);
	
		new WebDriverWait(driver,30).until(new ExpectedCondition<Boolean>()
			{
			    public Boolean apply(WebDriver driver) {
			        JavascriptExecutor js = (JavascriptExecutor) driver;
			        return (Boolean)js.executeScript("return jQuery.active == 0");
			}});
			
	}
	
	public static void waitForAjax(int timeoutInSeconds)  {
		    try {
		      if (driver instanceof JavascriptExecutor) {
			JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		 
		        for (int i = 0; i< timeoutInSeconds; i++) 
		        {
			    Object numberOfAjaxConnections = jsDriver.executeScript("return jQuery.active");
			    // return should be a number
			    if (numberOfAjaxConnections instanceof Long) {
			        Long n = (Long)numberOfAjaxConnections;
			        System.out.println("Number of active jquery ajax calls: " + n);
			        if (n.longValue() == 0L)
			       	  break;
			        }
		            Thread.sleep(50);
			    }
			}
			else {
				System.out.println("Web driver: " + driver + " cannot execute javascript");
			}
		}
			catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	
	
}
