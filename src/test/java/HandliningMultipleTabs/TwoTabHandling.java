package HandliningMultipleTabs;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TwoTabHandling {
	

	@Test
	void handlingtab() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("excluseSwitches", new String[] {"enable-automation"});
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
				 
		System.setProperty("webdriver.chrome.driver","C:/Users/hp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		
		WebDriver driver =new ChromeDriver(options);
		
        driver.get("https://www.yatra.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		//--------------------------------- Searching Bus with scrolling to end of the page--------------------------------------------
		
		driver.findElement(By.xpath("//a[@id='booking_engine_buses']")).click();
		
		Thread.sleep(1000);
		
        driver.findElement(By.xpath("//input[@id='BE_bus_from_station']")).click();
		
		WebElement busdep =driver.findElement(By.xpath("//input[@id='BE_bus_from_station']"));
		busdep.sendKeys("Madurai");
		Thread.sleep(2000);
		busdep.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		WebElement busarrive =driver.findElement(By.xpath("//input[@id='BE_bus_to_station']"));
		Thread.sleep(1000);
		busarrive.sendKeys("Chennai");
		Thread.sleep(1000);
		busarrive.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		WebElement selectdateforbus =driver.findElement(By.xpath("//input[@id='BE_bus_depart_date']"));
		selectdateforbus.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[@id='27/08/2023']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='BE_bus_search_btn']")).click();
		
		Thread.sleep(10000);
		
		WebElement prizearrange =driver.findElement(By.xpath("//*[@id=\'rowHeading\']/div[5]/i"));
		
		Actions action =new Actions(driver);
		
		action.doubleClick(prizearrange).build().perform();
		
		Thread.sleep(5000);
		
		
		
		//-------------------------Click Hotel and Search the hotels in another tab--------------------------------
		
        ((JavascriptExecutor)driver).executeScript("window.open()");
		
		ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		driver.get("https://www.yatra.com/");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@id='booking_engine_hotels']")).click();
		
		WebElement searchstate =driver.findElement(By.xpath("//input[@id='BE_hotel_destination_city']"));
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(200));
		
		WebElement waittoclick =wait.until(ExpectedConditions.elementToBeClickable(searchstate));
		
		waittoclick.click();
		
		Thread.sleep(2000);
		
		searchstate.sendKeys("Chennai");
		Thread.sleep(2000);
		searchstate.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		//--------------------------Switch to Bus search tab and Filter the bus---------------------------
		
		driver.switchTo().window(tabs.get(0));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//i[@class='fi-filter fs18']")).click();
		
		Thread.sleep(2000);
		
		//--------------------------Refresh the page-------------------------------------------------------
		
		driver.navigate().refresh();
	}
	
	
}
