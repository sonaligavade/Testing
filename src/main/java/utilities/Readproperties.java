package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Readproperties  {
	// properties object created
	public static Properties prop = new Properties();
	//initialize read file to null
	InputStream readFile = null;
	public Readproperties(){
		//pass the input.properties file location and load in try and catch block
		 try 
		 {
			 readFile = new FileInputStream("Configuration\\config.properties");
			 prop.load(readFile);
		 } 
		 catch(IOException io)
		 {
			io.printStackTrace();
		 }
		 //finally block to close the input.Properties file
		 finally
		  {
			if(readFile!=null)
			{
				try 
				{
					readFile.close();
				} 	
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		 }
	}
	     //getbrowser() to get the Browser in which you want to do, from the input.properties file
	 
		 public String getbrowser()
		 {
			 String browser = prop.getProperty("Browser");
			 return browser;
		 }
		//getUrl() to get the URL from the input.properties file
			
		 public static  String getUrl()
		 {
		 String url = prop.getProperty("url");
		 return url;
		 }
}
