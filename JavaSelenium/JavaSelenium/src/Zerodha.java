import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Zerodha {
	public static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Create a instance of ChromeOptions class
		try {
		  FileReader reader=new FileReader("Cred.properties");  
	      
		  Properties props=new Properties();  
		  props.load(reader);  
		    
		ChromeOptions options = new ChromeOptions();

		//Add chrome switch to disable notification - "**--disable-notifications**"
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://kite.zerodha.com/dashboard");
		driver.findElement(By.id("userid")).sendKeys(props.getProperty("username"));
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys(props.getProperty("password"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(), 'Login')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("pin")).sendKeys(props.getProperty("pin"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(), 'Continue')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-balloon='MW 7']")).click();
		
		List<WebElement> findElements = driver.findElements(By.xpath("//span[@class='symbol']"));
		if (findElements.size() != 0) {
			for (WebElement webElement : findElements) {
				Actions action = new Actions(driver);
				action.moveToElement(webElement).perform();
				webElement.findElement(By.xpath("//span[@class='icon icon-trash']")).click();
			}
		}

		driver.findElement(By.xpath("//input[@icon='search']")).sendKeys("Nifty 21 apr 17100 ce");
		driver.findElement(By.xpath("//span[@class='tradingsymbol']")).click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
}
