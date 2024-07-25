package BDDCucumber;

import java.io.IOException;

import org.junit.Assert;

import BrowserDriver.Browser;
import Pages.MakeMyTripFlightBookingPage;
import Utils.PropertyRead;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MakeMyTripStepDefinition extends Browser
{
	
	String ExcepectedFlightBookingPageResult ="NETWORK PROBLEM";
	
	@Given("I Launch The Browser and Enter URL")
	public void i_launch_the_browser_and_enter_url() throws IOException
	{
		LaunchBrowser();
		String GetUrl = PropertyRead.ReadProperty().getProperty("url");
		driver.get(GetUrl);
	}

	@When("I Close the Popup")
	public void i_close_the_popup() 
	{
		MakeMyTripFlightBookingPage mtfp = new MakeMyTripFlightBookingPage(driver);
		
		mtfp.closePopUP();
	}

	@When("I Click the From Location")
	public void i_click_the_from_location()
	{
		MakeMyTripFlightBookingPage mtfp = new MakeMyTripFlightBookingPage(driver);
		mtfp.ClickFromLocation();
		
	}

	@When("I Select the From Location")
	public void i_select_the_from_location() {
		MakeMyTripFlightBookingPage mtfp = new MakeMyTripFlightBookingPage(driver);
		mtfp.SelectFromLocation("pnq");
	}

	@When("I Click the To Location")
	public void i_click_the_to_location() {
		MakeMyTripFlightBookingPage mtfp = new MakeMyTripFlightBookingPage(driver);
		mtfp.ClickToLocation();
	}

	@When("I Select the To Location")
	public void i_select_the_to_location() {
		MakeMyTripFlightBookingPage mtfp = new MakeMyTripFlightBookingPage(driver);
		mtfp.SelectToLocation("maa");
	}

	@When("I Select Depature Date")
	public void i_select_depature_date() {
		MakeMyTripFlightBookingPage mtfp = new MakeMyTripFlightBookingPage(driver);
		mtfp.SelectDepatureDate("August 2024", "25");
	}

	@When("I Select Treavellers and Class")
	public void i_select_treavellers_and_class() {
		MakeMyTripFlightBookingPage mtfp = new MakeMyTripFlightBookingPage(driver);
		mtfp.SelectTravellersAndClass(20, 2, "3", "1");
	}

	@When("I Select Fare Type as Regular")
	public void i_select_fare_type_as_regular() {
		MakeMyTripFlightBookingPage mtfp = new MakeMyTripFlightBookingPage(driver);
		mtfp.ClickRadioButton("Regular");
	}

	@Then("I Search with Valid Values.")
	public void i_search_with_valid_values() {
		MakeMyTripFlightBookingPage mtfp = new MakeMyTripFlightBookingPage(driver);
		mtfp.ClickSearch();
		
		Assert.assertEquals(mtfp.GetSearchPageText(), ExcepectedFlightBookingPageResult);
		driver.navigate().back();
	}
	
}
