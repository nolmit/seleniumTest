package Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Mail extends WebItem
{

	public Mail(WebElement element) {
		super(element);
		
	}
	
	
	public String getSubject()
	{
		String s = ReturnTextFiledItems(By.cssSelector("span[class*='mail-MessageSnippet-Item_subject']"));
		
		return s;
	}
	
	 public String ReturnTextFiledItems(By by)
	 {
	  
		 return this.webElement.findElement(by).getText();	    			      	
	 }

}
