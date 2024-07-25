package BrowserDriver;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utils.PropertyRead;

public class Browser
{
	public static WebDriver driver;
	public static ExtentSparkReporter htmlreporter;
	public static ExtentReports extents;
	public static ExtentTest test;
	
	static String ReportPath = System.getProperty("user.dir")+"\\Report\\Automation.html";
	
	public static void LaunchBrowser() throws IOException    //launching browser
	{
		String Browsername = PropertyRead.ReadProperty().getProperty("browser");
		
		if(Browsername.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		GenerateReport();
	}
	
	
	public static void GenerateReport()
	{
		htmlreporter = new ExtentSparkReporter(ReportPath);
		extents = new ExtentReports();
		extents.attachReporter(htmlreporter);
	}
	
	
	public static void closeReport()
	{
		extents.flush();
	}
	
	
	public static void CloseBrowser()   //closing browser
	{
		closeReport();
		driver.quit();
	}
}
