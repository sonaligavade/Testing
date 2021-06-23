package utilities;
 

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
//this is a demo for a git hub
public class ExtentReport<report> {
	
	public static ExtentHtmlReporter htmlreport;
    public static ExtentReports report;
    public static ExtentTest logger;
    @BeforeSuite
    
    public static ExtentReports getReportInstance()

    {
	                ExtentHtmlReporter htmlReporter =new ExtentHtmlReporter(".\\HTML Report\\extentreport.html");
                    report = new ExtentReports();
                    report.attachReporter(htmlReporter);
		        	  
		        	//System.out.println("searching the Identifycourses");
                    report.setSystemInfo("OS","Windows 10 Home");
		            report.setSystemInfo("Environment", "UAT");
		            report.setSystemInfo("Build Number", "10.8.1");
		            report.setSystemInfo("Browser", "chrome");
		           
		            
		            //Stating some of the project info in the report
		            htmlReporter.config().setDocumentTitle("Coursera Automation Results");
		            htmlReporter.config().setReportName("All Headlines of coursera Automation");
		            htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		            htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
					return report;
		          
		         }
    @AfterMethod
    public void getResult(ITestResult result)
    {
    	if(result.getStatus()==ITestResult.FAILURE)
    	{
    		logger.fail(MarkupHelper.createLabel(result.getName()+"Test case failes", ExtentColor.RED));
    		logger.fail(result.getThrowable());
    	}
    	else if(result.getStatus()==ITestResult.SUCCESS)
    	{
    		logger.pass(MarkupHelper.createLabel(result.getName()+"Test case pass", ExtentColor.GREEN));
    	}
    	else if(result.getStatus()==ITestResult.SKIP)
    	{
    		logger.skip(MarkupHelper.createLabel(result.getName()+"Test case skips", ExtentColor.YELLOW));
    		logger.skip(result.getThrowable());
        }

    }
    @AfterSuite	
    public void tearDown(){
	report.flush();
    }
	
}
