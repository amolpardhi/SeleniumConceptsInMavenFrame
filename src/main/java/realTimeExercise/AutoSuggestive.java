package realTimeExercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.ARROW_DOWN);



		
		
	}
}
