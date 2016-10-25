package Items;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Stopwatch;

import Framework.Framework;
import Framework.Log;


public class WebItem implements IElement{
	protected WebElement webElement;
	protected WebDriver driver = Framework.getDriver();
	
	public WebItem(WebElement element)
	{	
		this.webElement=element;
	}
		
	public void Click()

	{   
		try {	
			Log.info("Clicking on "+elementDescription(this.webElement));
			webElement.click();
			}
		catch(NoSuchElementException ex){
			Log.info("Fail with clicking on "+elementDescription(this.webElement));
			}
		
	}
	
	public boolean isPresent()
    {  
		boolean flag=true;
        try 
        {
           this.webElement.getTagName();
        } 
        catch (NoSuchElementException e) 
        {
            flag = false;  
            Log.error("is not present: "+this.webElement);
        }   
       
        return flag;  
       
    }
	
	public void  AssertPresent()
    {  
        try 
        {
           this.webElement.getTagName();
        } 
        catch (NoSuchElementException e) 
        {
           Assert.fail(elementDescription(webElement)+" should be present but NOT");
        }   
            
    }
	
	public void  AssertNotPresent()
    {  
		String el = null;
        try 
        {
          el= this.webElement.getTagName();
        } 
        catch (NoSuchElementException e) 
        {
        } 
        if (el!=null)
        {
        	 Assert.fail(elementDescription(webElement)+" should NOT be present but it is");
        }
        
            
    }
		
 	public String GetText()
	{
		Log.info("Getting text from "+elementDescription(webElement));
		return webElement.getText();		
	}
 	
 	public WebItem Focus()

	{
 		Log.info("Set focus to"+elementDescription(webElement));
 		new Actions(driver).moveToElement(webElement).perform();
 		
 		return this;
		
	}
 	
 	public void SetValue(String value)
	{
 		JavascriptExecutor executor = (JavascriptExecutor)driver;
 		executor.executeScript("arguments[0].value = '"+value+"';", webElement);
		
	}
 	
 	public void InputText(String text)
	{
		try {
				webElement.sendKeys(text);
				Log.info("Set text --"+text+"-- to "+ elementDescription(this.webElement));
	}
		catch(NoSuchElementException ex)
		{
			Log.error("Element isn't present" + ex.getMessage());
			Assert.fail(elementDescription(this.webElement) +" is not present");
		}
	}
		
	public void SendKeys(Keys key)
	{
		Log.info("Sending keys"+key);
		webElement.sendKeys(key);	
	}

	public String elementDescription(WebElement element) {
		 
		 	String tag = element.getTagName();
		 	String name = element.getAttribute("name");
		 	String id = element.getAttribute("id");
		 	String text = element.getText();
		 	
	        String description = "element <"+tag+">";
	       
	        if ((name != null) && (name.length()>0)) {
	            description += " with name: " + element.getAttribute("name");
	        }
	        else if ((id != null) && (id.length()>0)){
	            description += " with id: " + id;
	        }
	         if ((text!=null) && (text.length()>0))
	         { description += " and text: "+ text;}
	         
	        return description;
	    }


}

