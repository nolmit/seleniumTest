package Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import Framework.Framework;
import Framework.Log;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class TestBase {
	
	
	@BeforeClass
	public static void setup() {
	ChromeDriverManager.getInstance().setup();
	}

	@AfterClass
	public static void teardown() {
		
	
	}
	
	@Before
	public void Setup()
	{}
	
	
	@After
	public void TearDown() 
	{
	   Framework.CloseDriver();
	   Log.info("End test");
	}
	
		
	
}
