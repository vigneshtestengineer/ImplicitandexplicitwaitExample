package ImplicitandexplicitwaitExample;

import java.time.Duration;

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

public class ExplicitWait {
	
	

//	public static void main(String[] args) throws InterruptedException {
		
		@Test
		void explicitwaittest() throws InterruptedException {

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
				
				WebElement selectdateforbus =driver.findElement(By.xpath("//input[@id='BE_bus_depart_date']"));
				selectdateforbus.click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//td[@id='11/11/2023']")).click();
				
				driver.findElement(By.xpath("//input[@id='BE_bus_search_btn']")).click();
				
				Thread.sleep(10000);
				
				WebElement prizearrange =driver.findElement(By.xpath("//*[@id=\'rowHeading\']/div[5]/i"));
				
				Actions action =new Actions(driver);
				
				action.doubleClick(prizearrange).build().perform();
				
				Thread.sleep(5000);
				
				// Scroll the page to some length down
				
				JavascriptExecutor scroll =(JavascriptExecutor) driver;
//				scroll.executeScript("window.scrollBy(0,50000)");
				
				// Scroll page to end of the page
				
				scroll.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				
				WebElement findbus =driver.findElement(By.xpath("//div[@class='flex txt-c txt-r xs6']"));
				
				WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(200));
				
				WebElement waittoselect =wait.until(ExpectedConditions.elementToBeClickable(findbus));
				
				waittoselect.click();
		
		
	}

}
