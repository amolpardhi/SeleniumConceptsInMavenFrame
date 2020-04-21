package realTimeExercise;

import java.util.Iterator;
import java.util.Set;

//1. Print the link count in the page
// link has the tag ankle "a"

//2. get count only from the footer in the page

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// 1. Print the link count in the page
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());

		// 2. get count only from the footer in the page
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());

		// 3.
		WebElement columnfooter = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnfooter.findElements(By.tagName("a")).size());

		// 4. click on each link in the column and check if the pages are opening.
		for (int i = 1; i < columnfooter.findElements(By.tagName("a")).size(); i++) {
			String clickOnlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnfooter.findElements(By.tagName("a")).get(i).sendKeys(clickOnlinkTab);
			Thread.sleep(3000L);
		} //open all the links
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
}
