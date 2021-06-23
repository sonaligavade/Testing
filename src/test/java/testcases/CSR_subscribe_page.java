package testcases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import junit.framework.Assert;
import utilities.DriverSetup;
import utilities.ExtentReport;
import utilities.Readproperties;

public class CSR_subscribe_page extends ExtentReport  {
	  
	        static String HomePage = "";
	        static String projectPath = System.getProperty("user.dir");
	        static WebDriver driver = null;
	        static Logger logger1=Logger.getLogger("CSR_subscribe page");
@BeforeSuite

public WebDriver openBrowser() throws MalformedURLException {
            Readproperties rp = new Readproperties();
            logger=report.createTest("Opening browser");
            logger1.info("Opening browser");
            HomePage = rp.getUrl();
	        String browser = rp.getbrowser();
	        DriverSetup ds = new DriverSetup();
	        driver = ds.setupDriver(browser);
	        return driver;

	    }
@Test(priority=1)
	    //Method to handle Simple Alert
public void VerifyCSRLogo() throws Exception {
	        driver.get(HomePage);
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	        logger1.info("Verifying the CSR Logo");
	        driver.get(HomePage);
	        WebElement menu=driver.findElement(By.className("gridlove-logo"));
	        Assert.assertTrue(menu.isDisplayed());
	        Reporter.log("CSR logo is displayed" ,true);
	        logger=report.createTest("Verifying the CSR Logo");
	          
	    }
	    
@Test(priority=2)
	    //Method to handle the Confirmation Alert
public void VerifySubscribeMenu() throws InterruptedException {
	        
	        logger1.info("Verifying Subscribe menu on header of CSR ");

	        WebElement menu1=driver.findElement(By.name("categoryLink"));
	        Assert.assertTrue(menu1.isDisplayed());
	        Reporter.log("Subscribe menu is displayed", true);
	        logger=report.createTest("Verifying Subscribe menu on header of CSR ");
	          
	    }
	    
@Test(priority=3)
	       
public void ClickingSubscribeMenu() throws InterruptedException {
	      
	       logger1.info("Clicking on subscribe menu on the header of CSR");
	       driver.findElement(By.linkText("Subscribe")).click();
	       Reporter.log("Subscribe menu is clicked", true);
	       logger=report.createTest("Clicking on subscribe menu on the header of CSR");
	             
	       }
@Test(priority=4)
	       
public void FillingSubscribeForm() throws InterruptedException  {
	      
	       logger1.info("Filling the subscribe form with verifying options");
	       driver.findElement(By.name("FirstName")).sendKeys("Abc");
	       driver.findElement(By.name("LastName")).sendKeys("xyz");
	       driver.findElement(By.name("Email")).sendKeys("Sonali#gamil.com");
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	       driver.findElement(By.xpath("//form[@id='csrLeadForm']")).click();
	    	 
	       WebElement error=driver.findElement(By.xpath("//span[@class='csr_email_address_error_msg']"));
	       Assert.assertTrue(error.isDisplayed());
	       Reporter.log("Please enter valid email address", true);
	       logger1.info("error message displayed");
	       logger=report.createTest("Filling the subscribe form with verifying options");
	       
	   }
	   
@AfterSuite
public void closeBrowser() {
	
	      logger1.info("closing the browser");
	      driver.quit();
	      logger=report.createTest("closing the browser");
	    
	    }
	}



	
