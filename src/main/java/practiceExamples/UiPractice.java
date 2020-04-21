package practiceExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UiPractice {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");

		// 1. Dropdowns
		Select adults = new Select(driver.findElement(By.id("Adults")));
		adults.selectByIndex(3);

		Select children = new Select(driver.findElement(By.id("Childrens")));
		children.selectByIndex(2);

		Select infants = new Select(driver.findElement(By.id("Infants")));
		infants.selectByValue("1");

		// 2. Calender UI
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active ']")).click();

		// 3. get text from alert message
		driver.findElement(By.id("MoreOptionsLink")).click();
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("IndiGo");
		Thread.sleep(2000);
		driver.findElement(By.id("SearchBtn")).click();
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

		Thread.sleep(5000);
		driver.quit();
	}
}
