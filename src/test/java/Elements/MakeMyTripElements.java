package Elements;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTripElements
{
	
	public static void BrowserBackClick(WebDriver driver)//clicks back of window
	{
		driver.navigate().back();
	}
	
	public static void Clicking(WebElement Element)
	{
		if(Element.isDisplayed())
		{
			Element.click();
		}
	}
	
	public static String getText(WebElement gettext)
	{
		if(gettext.isDisplayed())
		{
			String text= gettext.getText();	
			return text;
		}
		return null;
	}
	
	public static void WaitUntilVisible(WebDriver driver,By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public static void WaitUntilClick(WebDriver driver,By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static String TakeScreenshot(WebDriver driver,String Filename) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File GetSS = screenshot.getScreenshotAs(OutputType.FILE);
		File DestSS = new File(System.getProperty("user.dir")+"\\ScreenShot\\"+Filename+".png");
		FileUtils.copyFile(GetSS, DestSS);
		return DestSS.toString();
	}
	
	public static void ImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
}
