package Framework;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;

public class Framework {
	
private static WebDriver _driver;

public static  WebDriver getDriver ()
{
	if (_driver == null)
	{
		_driver = CreateDriver();
	}
	return _driver;

}

private static WebDriver CreateDriver()
{  

  WebDriver driver=new ChromeDriver();
  driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  //EventFiringWebDriver drv = new EventFiringWebDriver(driver);
  //EventListener evtLst = new EventListener();
  //drv.register(evtLst);
  return driver;
}

public static void QuitDriver()
{
	_driver.quit();
	
}
public static void CloseDriver()
{
	_driver.close();
	
}
	
public static void OpenUrl(String url) {
	try
	{   Log.info("Navigate to : "+url);
		_driver.navigate().to(url);
		}
	catch(Exception ex)
	{
		Log.error("Failed with navigate to URL: "+url);
	}
 }

public static String GetPageUrl()
	{
		return _driver.getCurrentUrl();
	}


}