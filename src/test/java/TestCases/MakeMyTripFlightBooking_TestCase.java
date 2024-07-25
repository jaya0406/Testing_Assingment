
package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BrowserDriver.Browser;
import Elements.MakeMyTripElements;
import Pages.MakeMyTripFlightBookingPage;
import Utils.PropertyRead;

public class MakeMyTripFlightBooking_TestCase extends Browser
{
	
	String ExcepectedFlightBookingPageResult ="NETWORK PROBLEM";
	String SameCityResult="From & To airports cannot be the same";
	
	@BeforeSuite
	public void OpenBrowser() throws IOException
	{
		LaunchBrowser();
	}
	
	@BeforeTest
	public void SetUrl() throws IOException
	{
		String GetUrl = PropertyRead.ReadProperty().getProperty("url");
		driver.get(GetUrl);
	}
	
	@Test
	public void MakeMyTripFlight_Test_with_ValidValues()
	{	
		test=extents.createTest("MakeMyTripFlight_Test_with_ValidValues");
		
		MakeMyTripFlightBookingPage mtfp = new MakeMyTripFlightBookingPage(driver);
		
		mtfp.closePopUP();
		mtfp.ClickFromLocation();
		mtfp.SelectFromLocation("pnq");
		test.log(Status.INFO, "Click and Select From Location");
		
		mtfp.ClickToLocation();
		mtfp.SelectToLocation("maa");
		test.log(Status.INFO, "Click and Select To Location");
		
		mtfp.SelectDepatureDate("August 2024", "25");
		test.log(Status.INFO, "Select Depature Date");
		
		mtfp.SelectTravellersAndClass(15, 1, "2", "1");
		test.log(Status.INFO, "Select Treavellers and Class");
		
		mtfp.ClickRadioButton("Regular");
		test.log(Status.INFO, "Select Fare Type as Regular.");
		
		mtfp.ClickSearch();
		test.log(Status.INFO, "Then Search with Valid Values.");
		
		Assert.assertEquals(mtfp.GetSearchPageText(), ExcepectedFlightBookingPageResult);
		driver.navigate().back();
		
	}
	
	@Test(priority=1)
	public void MakeMyTripFlight_Test_with_ValidValues_Student()
	{	
		test=extents.createTest("MakeMyTripFlight_Test_with_ValidValues");
		
		MakeMyTripFlightBookingPage mtfp = new MakeMyTripFlightBookingPage(driver);
		
		mtfp.ClickFromLocation();
		mtfp.SelectFromLocation("pnq");
		test.log(Status.INFO, "Click and Select From Location");
		
		mtfp.ClickToLocation();
		mtfp.SelectToLocation("maa");
		test.log(Status.INFO, "Click and Select To Location");
		
		mtfp.SelectDepatureDate("August 2024", "25");
		test.log(Status.INFO, "Select Depature Date");
		
		mtfp.SelectTravellersAndClass(25, 0 ,"2", "0" );
		test.log(Status.INFO, "Select Treavellers and Class");
		
		mtfp.ClickRadioButton("Student");
		test.log(Status.INFO, "Select Fare Type as Student.");

		mtfp.ClickSearch();
		test.log(Status.INFO, "Then Search with Valid Values.");
		
		Assert.assertEquals(mtfp.GetSearchPageText(), ExcepectedFlightBookingPageResult);
		driver.navigate().back();
		
	}
	
	@Test(priority=2)
	public void MakeMyTripRoundTripFlight_Test_with_ValidValues()
	{	
		test=extents.createTest("MakeMyTripRoundTripFlight_Test_with_ValidValues");
		
		MakeMyTripFlightBookingPage mtfp = new MakeMyTripFlightBookingPage(driver);
		
		mtfp.ClickFromLocation();
		mtfp.SelectFromLocation("pnq");
		test.log(Status.INFO, "Click and Select From Location");
		
		mtfp.ClickToLocation();
		mtfp.SelectToLocation("DEL");
		test.log(Status.INFO, "Click and Select To Location");
		
		mtfp.SelectDepatureDate("August 2024", "25");
		test.log(Status.INFO, "Select Depature Date");
		
		mtfp.SelectReturnDate("September 2024", "1");
		test.log(Status.INFO, "Select Return Date");
		
		mtfp.SelectTravellersAndClass(30, 0, "2", "0");
		test.log(Status.INFO, "Select Treavellers and Class");
		
		mtfp.ClickRadioButton("Doctor and Nurses");
		test.log(Status.INFO, "Select Fare Type as Doctor and Nurses.");

		mtfp.ClickSearch();
		test.log(Status.INFO, "Then Search with Valid Values.");
		Assert.assertEquals(mtfp.GetSearchPageText(), ExcepectedFlightBookingPageResult);
		driver.navigate().back();
		
	}
	@Test(priority=3)
	public void MakeMyTripFlight_Test_with_InValidValues()
	{	
		test=extents.createTest("MakeMyTripFlight_Test_with_InValidValues");
		
		MakeMyTripFlightBookingPage mtfp = new MakeMyTripFlightBookingPage(driver);
		
		//mtfp.closePopUP();
		mtfp.ClickFromLocation();
		mtfp.SelectFromLocation("pnq");
		test.log(Status.INFO, "Click and Select From Location");
		
		mtfp.ClickToLocation();
		mtfp.SelectToLocation("pnq");
		test.log(Status.INFO, "Click and Select To Location");

		Assert.assertEquals(mtfp.SameCityText(), SameCityResult);
		test.log(Status.INFO, "Then Same City Error Thrown.");
		
	}
	
	@AfterMethod
	public void WriteReport(ITestResult testresult) throws IOException
	{
		if(testresult.getStatus()==ITestResult.SUCCESS)
		{
			String Filename = MakeMyTripElements.TakeScreenshot(driver, testresult.getName());
			test.log(Status.INFO,test.addScreenCaptureFromPath(Filename).toString());
			test.log(Status.PASS, "Test Method Name as : "+Filename+testresult.getName()+" is Passed.");
		}
		else if(testresult.getStatus()==ITestResult.FAILURE)
			{
				String Filename = MakeMyTripElements.TakeScreenshot(driver, testresult.getName());
				test.log(Status.INFO,test.addScreenCaptureFromPath(Filename).toString());
				test.log(Status.FAIL, "Test Method Name as : "+Filename+testresult.getName()+" is Failed.");
			}
		
		else if(testresult.getStatus()==ITestResult.SKIP)
			{
				test.log(Status.SKIP, "Test Method Name as : "+testresult.getName()+" is Skipped.");
			}
		
	}
	
	@AfterSuite
	public void TearDown()
	{
		CloseBrowser();
	}
}
