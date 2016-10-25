package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProfile {
	
	String url;
	
	public ReadProfile(String url) {
		this.url=url;
	}
	public String getProperty(String key)
	{
		File file = new File(url);
		  
		//FileInputStream fileInput = null;
		InputStream fileInput;
			//fileInput = new FileInputStream(file.getPath());
			fileInput =ReadProfile.class.getClassLoader().getResourceAsStream("config.properties");
		
		Properties prop = new Properties();
		
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop.getProperty(key);
	}
	
	
	
}

