package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Elements.MakeMyTripElements;

public class MakeMyTripFlightBookingPage
{
	WebDriver driver;
	
	public MakeMyTripFlightBookingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void closePopUP()
	{
		MakeMyTripElements.WaitUntilClick(driver, By.xpath("//span[@data-cy='closeModal']"));
		MakeMyTripElements.Clicking(driver.findElement(By.xpath("//span[@data-cy='closeModal']")));
	}
	
	
	public void ClickFromLocation()
	{
		MakeMyTripElements.WaitUntilClick(driver,By.xpath("//label[@for='fromCity']"));
		MakeMyTripElements.Clicking(driver.findElement(By.xpath("//label[@for='fromCity']")));
	}
	
	
	public void SelectFromLocation(String FromValue)
	{
		MakeMyTripElements.WaitUntilClick(driver, By.xpath("(//*[@id='react-autowhatever-1']//li)[last()]"));
		List<WebElement> getallFromLoc = driver.findElements(By.xpath("//*[@id='react-autowhatever-1']//li"));
		
		for(WebElement eachfromLoc : getallFromLoc)
		{
			String getText = eachfromLoc.findElement(By.cssSelector("div[class^='font14']")).getText();
		
			if(getText.equalsIgnoreCase(FromValue))
			{
				eachfromLoc.click();
				break;
			}
		}
	}
	
	
	
	public void SelectToLocation(String ToValue)
	{
		MakeMyTripElements.WaitUntilClick(driver, By.xpath("(//ul[@class='react-autosuggest__suggestions-list']//li)[last()]"));
		List<WebElement> getallToLoc = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']//li"));
		
		for(WebElement eachToLoc : getallToLoc)
		{
			String getText = eachToLoc.findElement(By.cssSelector("div[class^='font14']")).getText();
		
			if(getText.equalsIgnoreCase(ToValue))
			{
				eachToLoc.click();
				break;
			}
		}
	}

	
	public void ClickToLocation()
	{
		MakeMyTripElements.WaitUntilClick(driver,By.xpath("//label[@for='toCity']"));
		MakeMyTripElements.Clicking(driver.findElement(By.xpath("//label[@for='toCity']")));
	}
	
	
	public void SelectDepatureDate(String GetMonth,String getDate)
	{
		//MakeMyTripElements.Clicking(driver.findElement(By.cssSelector("label[for='departure']")));
		
		 List<WebElement> GetMonths = driver.findElements(By.xpath("//div[contains(@class,'inactiveWidget')]//div[@class='datePickerContainer']//div[@class='DayPicker-Month']"));
			
		 for(WebElement EachMonth : GetMonths)
			{
				String GetText = MakeMyTripElements.getText(EachMonth.	findElement(By.cssSelector("div[class*='DayPicker-Caption']")));
					

				if(GetText.equalsIgnoreCase(GetMonth))
				{
					String getThree = GetMonth.substring(0, 3);
					//System.out.println(getThree);
					List<WebElement> GETActiveDates = EachMonth.findElements(By.xpath("//div[@class='DayPicker-Body']//div[contains(@class,'DayPicker-Day') and @aria-disabled='false']"));
				
					for(WebElement EachDate :GETActiveDates )
					{
						String GetAccurate = EachDate.getAttribute("aria-label");
						
						String GetTextDate = EachDate.findElement(By.tagName("p")).getText();
		
						//System.out.println(GetTextDate+" "+GetAccurate);
						
						if(GetAccurate.contains(getThree) && GetTextDate.equalsIgnoreCase(getDate) )
						{
							MakeMyTripElements.Clicking(EachDate);
							break;
						}
					}
				}
				
				else
				{
					MakeMyTripElements.Clicking(driver.findElement(By.xpath("//div[contains(@class,'NavBar')]//span[contains(@class,'next')]")));

					String getThree = GetMonth.substring(0, 3);

					List<WebElement> GETActiveDates = EachMonth.findElements(By.xpath("//div[@class='DayPicker-Body']//div[contains(@class,'DayPicker-Day') and @aria-disabled='false']"));
				
					for(WebElement EachDate :GETActiveDates )
					{
						String GetAccurate = EachDate.getAttribute("aria-label");
						String GetTextDate = EachDate.findElement(By.tagName("p")).getText();
						
						if(GetAccurate.contains(getThree) && GetTextDate.equalsIgnoreCase(getDate) )
						{
							MakeMyTripElements.Clicking(EachDate);
							break;
						}
					}
				}
				break;
			}
	}
	
	public void SelectReturnDate(String GetMonth1,String getDate)
	{	
		MakeMyTripElements.Clicking(driver.findElement(By.className("fsw")));
		
		MakeMyTripElements.Clicking(driver.findElement (By.xpath("//label[@for='return']")));
		
		 List<WebElement> GetMonths1 = driver.findElements(By.xpath("//div[@class='datePickerContainer']//div[@class='DayPicker-Month']"));
			
		 for(WebElement EachMonth : GetMonths1)
			{
				String GetText = MakeMyTripElements.getText(EachMonth.	findElement(By.cssSelector("div[class*='DayPicker-Caption']")));
					

				if(GetText.equalsIgnoreCase(GetMonth1))
				{
					String getThree = GetMonth1.substring(0, 3);
					//System.out.println(getThree);
					List<WebElement> GETActiveDates = EachMonth.findElements(By.xpath("//div[@class='DayPicker-Body']//div[contains(@class,'DayPicker-Day') and @aria-disabled='false']"));
				
					for(WebElement EachDate :GETActiveDates )
					{
						String GetAccurate = EachDate.getAttribute("aria-label");
						
						String GetTextDate = EachDate.findElement(By.tagName("p")).getText();
		
						//System.out.println(GetTextDate+" "+GetAccurate);
						
						if(GetAccurate.contains(getThree) && GetTextDate.equalsIgnoreCase(getDate) )
						{
							EachDate.click();
							break;
						}
					}
				}
				
				else
				{
					MakeMyTripElements.Clicking(driver.findElement(By.xpath("//div[contains(@class,'NavBar')]//span[contains(@class,'next')]")));

					String getThree = GetMonth1.substring(0, 3);

					List<WebElement> GETActiveDates = EachMonth.findElements(By.xpath("//div[@class='DayPicker-Body']//div[contains(@class,'DayPicker-Day') and @aria-disabled='false']"));
				
					for(WebElement EachDate :GETActiveDates )
					{
						String GetAccurate = EachDate.getAttribute("aria-label");
						String GetTextDate = EachDate.findElement(By.tagName("p")).getText();
						
						if(GetAccurate.contains(getThree) && GetTextDate.equalsIgnoreCase(getDate) )
						{
							EachDate.click();
							break;
						}
					}
				}
				break;
			}
	}
	
	public void SelectTravellersAndClass(int getAdAge ,int getChildAge, String AdCount,String ChildCount )
	{
		MakeMyTripElements.Clicking( driver.findElement(By.cssSelector("label[for='travellers']")));
	
			List<WebElement>GetAdultTravellers =driver.findElements(By.xpath("//div[@class='appendBottom20']//ul//li[contains(@data-cy,'adults-')]"));
		
			for(WebElement EachGetAdultTravellers : GetAdultTravellers)
			{
				//List<WebElement> Getcount = driver.findElements(By.xpath("//div[@class='appendBottom20']//ul//li[contains(@data-cy,'adults-')]"));
				String GetText = EachGetAdultTravellers.getText();
				
				if(AdCount.equalsIgnoreCase(GetText))
				{
					EachGetAdultTravellers.click();
					break;
				}
			}
		 
		
		if(getChildAge>=2 && getChildAge<=12)
		 {
			 List<WebElement> GetChildTravellers = driver.findElements(By.xpath("//div[contains(@class,'appendBottom25')]//div[contains(@class,'childCounter')]//ul//li[contains(@data-cy,'children')]"));
			 
			 for(WebElement EachGetChildTravellers: GetChildTravellers )
			 {
				 String GetTextchild = EachGetChildTravellers.getText();
				 //System.out.println(GetTextchild);
				 if(GetTextchild.equalsIgnoreCase(ChildCount))
				 {
					 EachGetChildTravellers.click();
					 break;
				 }
			 }
		 }
		else
		{
					List<WebElement> GetInfantTravellers = driver.findElements(By.xpath("//div[contains(@class,'appendBottom25')]//div[contains(@class,'infantCounter')]//ul//li[contains(@data-cy,'infants')]"));
			 
					for(WebElement EachGetInfantTravellers: GetInfantTravellers )
					{
						String GetTextchild = EachGetInfantTravellers.getText();
						//System.out.println(GetTextchild);
						if(GetTextchild.equalsIgnoreCase(ChildCount))
						{
							EachGetInfantTravellers.click();
							break;
						}
					} 
		}
		
		MakeMyTripElements.Clicking(driver.findElement(By.cssSelector("button[class*='btnApply']")));
	}
	
	public void ClickRadioButton(String GetFare)
	{
		List<WebElement> Fares = driver.findElements(By.xpath("//div[contains(@class,'specialFareContainer')]//div[contains(@class,'fareCardItem')]"));
		
		for(WebElement EachFare : Fares)
			{
				String GetText = EachFare.findElement(By.cssSelector("div[class*='lineHeight18']")).getText();
				//System.out.println(GetText);
				
				if(GetFare.equalsIgnoreCase(GetText))
				{
					EachFare.click();
					break;
				}
			}
		MakeMyTripElements.Clicking(driver.findElement(By.className("fsw")));
	}
	
	public void ClickSearch()
	{
		WebElement SearchBtn = driver.findElement(By.xpath("//a[contains(@class,'widgetSearchBtn')]"));
		MakeMyTripElements.WaitUntilClick(driver, By.xpath("//a[contains(@class,'widgetSearchBtn')]"));
		MakeMyTripElements.Clicking(SearchBtn);;
	}
	
	
	public String GetSearchPageText()
	{
		MakeMyTripElements.WaitUntilVisible(driver,  By.xpath("//*[@class='error-title']"));
		WebElement getSearchText = driver.findElement( By.xpath("//*[@class='error-title']"));
		return MakeMyTripElements.getText(getSearchText);
	}
	
	public String SameCityText()
	{
		MakeMyTripElements.WaitUntilVisible(driver,  By.cssSelector("span[data-cy='sameCityError']"));
		WebElement getSameCityText = driver.findElement(   By.cssSelector("span[data-cy='sameCityError']"));
		return MakeMyTripElements.getText(getSameCityText);
	}
}
